package com.atguigu.gulimall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.SpuAttrValueDao;
import com.atguigu.gulimall.product.entity.SpuAttrValueEntity;
import com.atguigu.gulimall.product.service.SpuAttrValueService;


@Service("spuAttrValueService")
public class SpuAttrValueServiceImpl extends ServiceImpl<SpuAttrValueDao, SpuAttrValueEntity> implements SpuAttrValueService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpuAttrValueEntity> page = this.page(
                new Query<SpuAttrValueEntity>().getPage(params),
                new QueryWrapper<SpuAttrValueEntity>()
        );

        return new PageUtils(page);
    }

}