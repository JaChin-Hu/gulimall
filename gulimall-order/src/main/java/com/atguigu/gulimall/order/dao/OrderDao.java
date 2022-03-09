package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author jachin
 * @email jachin-hu@qq.com
 * @date 2022-03-09 16:38:35
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
