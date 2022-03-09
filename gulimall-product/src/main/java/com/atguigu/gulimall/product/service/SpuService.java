package com.atguigu.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.product.entity.SpuEntity;

import java.util.Map;

/**
 * spu信息
 *
 * @author jachin
 * @email jachin-hu@qq.com
 * @date 2022-03-09 15:24:07
 */
public interface SpuService extends IService<SpuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

