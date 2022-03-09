package com.atguigu.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.ware.entity.WareOrderBillEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author jachin
 * @email jachin-hu@qq.com
 * @date 2022-03-09 16:43:44
 */
public interface WareOrderBillService extends IService<WareOrderBillEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

