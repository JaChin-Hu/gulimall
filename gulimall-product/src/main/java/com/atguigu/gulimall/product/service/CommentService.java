package com.atguigu.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.product.entity.CommentEntity;

import java.util.Map;

/**
 * 商品评价
 *
 * @author jachin
 * @email jachin-hu@qq.com
 * @date 2022-03-09 15:24:07
 */
public interface CommentService extends IService<CommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

