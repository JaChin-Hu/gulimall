package com.atguigu.gulimall.coupon.dao;

import com.atguigu.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author jachin
 * @email jachin-hu@qq.com
 * @date 2022-03-09 16:19:27
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
