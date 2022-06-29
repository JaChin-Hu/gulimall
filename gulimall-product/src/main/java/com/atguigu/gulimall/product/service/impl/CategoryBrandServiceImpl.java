package com.atguigu.gulimall.product.service.impl;

import com.atguigu.gulimall.product.dao.BrandDao;
import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.CategoryBrandDao;
import com.atguigu.gulimall.product.entity.CategoryBrandEntity;
import com.atguigu.gulimall.product.service.CategoryBrandService;


@Service("categoryBrandService")
public class CategoryBrandServiceImpl extends ServiceImpl<CategoryBrandDao, CategoryBrandEntity> implements CategoryBrandService {
    private final BrandDao brandDao;
    private final CategoryDao categoryDao;

    public CategoryBrandServiceImpl(BrandDao brandDao, CategoryDao categoryDao) {
        this.brandDao = brandDao;
        this.categoryDao = categoryDao;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryBrandEntity> page = this.page(
                new Query<CategoryBrandEntity>().getPage(params),
                new QueryWrapper<CategoryBrandEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveDetail(CategoryBrandEntity categoryBrand) {
        Long categoryId = categoryBrand.getCategoryId();
        Long brandId = categoryBrand.getBrandId();
        CategoryEntity categoryEntity = categoryDao.selectById(categoryId);
        BrandEntity brandEntity = brandDao.selectById(brandId);
        categoryBrand.setCategoryName(categoryEntity.getName());
        categoryBrand.setBrandName(brandEntity.getName());
        this.save(categoryBrand);
    }

    @Override
    public void updateBrand(Long id, String name) {
        CategoryBrandEntity categoryBrand = new CategoryBrandEntity();
        categoryBrand.setBrandId(id);
        categoryBrand.setBrandName(name);
        this.update(categoryBrand, new UpdateWrapper<CategoryBrandEntity>().eq("brand_id", id));
    }

    @Override
    public void updateCategory(Long id, String name) {
        CategoryBrandEntity categoryBrand = new CategoryBrandEntity();
        categoryBrand.setCategoryId(id);
        categoryBrand.setCategoryName(name);
        this.update(categoryBrand, new UpdateWrapper<CategoryBrandEntity>().eq("category8_id", id));
    }



}