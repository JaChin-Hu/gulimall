package com.atguigu.gulimall.product.service.impl;

import com.atguigu.gulimall.product.dao.AttrGroupDao;
import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.AttrGroupEntity;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;
import com.atguigu.gulimall.product.vo.AttrGroupRelationVo;
import com.atguigu.gulimall.product.vo.AttrRespVo;
import com.atguigu.gulimall.product.vo.AttrVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.AttrDao;
import com.atguigu.gulimall.product.entity.AttrEntity;
import com.atguigu.gulimall.product.service.AttrService;
import org.springframework.util.StringUtils;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {
    private final AttrGroupDao attrGroupDao;
    private final CategoryDao categoryDao;
    private final AttrDao attrDao;
    private final CategoryService categoryService;

    public AttrServiceImpl(AttrGroupDao attrGroupDao, CategoryDao categoryDao, AttrDao attrDao, CategoryService categoryService) {
        this.attrGroupDao = attrGroupDao;
        this.categoryDao = categoryDao;
        this.attrDao = attrDao;
        this.categoryService = categoryService;
    }

    @Override
    public void updateAttr(AttrVo attrVo) {
        AttrEntity attrEntity = new AttrEntity();
        BeanUtils.copyProperties(attrVo, attrEntity);
        this.updateById(attrEntity);
    }


    @Override
    public void saveAttr(AttrVo attrVo) {
        AttrEntity attrEntity = new AttrEntity();
        BeanUtils.copyProperties(attrVo, attrEntity);
        this.save(attrEntity);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                new QueryWrapper<AttrEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryBaseAttrList(Map<String, Object> params, Long categoryId) {
        QueryWrapper<AttrEntity> queryWrapper = new QueryWrapper<>();
        if (categoryId != 0) {
            queryWrapper.eq("category_id", categoryId);
        }
        String key = (String) params.get("key");
        if (!StringUtils.isEmpty(key)){
            queryWrapper.and((wrapper)->{
                wrapper.eq("id", key).or().eq("name", key);
            });
        }
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                queryWrapper
        );
        PageUtils pageUtils = new PageUtils(page);
        System.out.println(pageUtils.getList());
        List<AttrEntity> records = page.getRecords();
        List<AttrRespVo> collect = records.stream().map((attrEntity -> {
            AttrRespVo attrRespVo = new AttrRespVo();
            BeanUtils.copyProperties(attrEntity, attrRespVo);
            CategoryEntity categoryEntity = categoryDao.selectById(attrEntity.getCategoryId());
            if (categoryEntity != null) {
                attrRespVo.setCategoryName(categoryEntity.getName());
            }
            AttrGroupEntity attrGroupEntity = attrGroupDao.selectById(attrEntity.getGroupId());
            if (attrGroupEntity != null) {
                attrRespVo.setGroupName(attrGroupEntity.getName());
            }
            return attrRespVo;
        })).collect(Collectors.toList());
        pageUtils.setList(collect);
        return pageUtils;
    }

    @Override
    public AttrRespVo getAttrInfo(Long attrId) {
        AttrRespVo attrRespVo = new AttrRespVo();
        AttrEntity attrEntity = this.getById(attrId);
        BeanUtils.copyProperties(attrEntity, attrRespVo);
        CategoryEntity categoryEntity = categoryDao.selectById(attrEntity.getCategoryId());
        attrRespVo.setCategoryName(categoryEntity.getName());
        attrRespVo.setGroupName(attrGroupDao.selectById(attrEntity.getGroupId()).getName());
        attrRespVo.setCategoryPath(categoryService.findCategoryPath(categoryEntity.getId()));
        return attrRespVo;
    }

    @Override
    public List<AttrEntity> getRelationAttr(Long attrGroupId) {
        return attrDao.selectList(new QueryWrapper<AttrEntity>().eq("group_id", attrGroupId));
    }

    @Override
    public void deleteRelation(AttrGroupRelationVo[] vos) {
        System.out.println(Arrays.toString(vos));
    }
}