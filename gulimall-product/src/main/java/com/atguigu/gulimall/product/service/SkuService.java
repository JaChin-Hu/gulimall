package com.atguigu.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.product.entity.SkuEntity;

import java.util.Map;

/**
 * sku信息
 *
 * @author jachin
 * @email jachin-hu@qq.com
 * @date 2022-03-09 15:24:07
 */
public interface SkuService extends IService<SkuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

