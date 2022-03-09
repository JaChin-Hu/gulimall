package com.atguigu.gulimall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.SpuDescDao;
import com.atguigu.gulimall.product.entity.SpuDescEntity;
import com.atguigu.gulimall.product.service.SpuDescService;


@Service("spuDescService")
public class SpuDescServiceImpl extends ServiceImpl<SpuDescDao, SpuDescEntity> implements SpuDescService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpuDescEntity> page = this.page(
                new Query<SpuDescEntity>().getPage(params),
                new QueryWrapper<SpuDescEntity>()
        );

        return new PageUtils(page);
    }

}