package com.atguigu.gulimall.member.feign;

import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("coupon")
@RequestMapping("/coupon/coupon")
public interface CouponService {
    @GetMapping("/member/list")
    R memberCoupons();
}
