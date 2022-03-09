package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.product.entity.SkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * sku信息
 * 
 * @author jachin
 * @email jachin-hu@qq.com
 * @date 2022-03-09 15:24:07
 */
@Mapper
public interface SkuDao extends BaseMapper<SkuEntity> {
	
}
