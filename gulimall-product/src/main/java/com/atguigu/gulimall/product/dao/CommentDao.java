package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.product.entity.CommentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价
 * 
 * @author jachin
 * @email jachin-hu@qq.com
 * @date 2022-03-09 15:24:07
 */
@Mapper
public interface CommentDao extends BaseMapper<CommentEntity> {
	
}
