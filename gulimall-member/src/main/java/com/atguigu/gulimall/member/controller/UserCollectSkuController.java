package com.atguigu.gulimall.member.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.gulimall.member.entity.UserCollectSkuEntity;
import com.atguigu.gulimall.member.service.UserCollectSkuService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.R;



/**
 * 关注商品表
 *
 * @author jachin
 * @email jachin-hu@qq.com
 * @date 2022-03-09 16:29:48
 */
@RestController
@RequestMapping("member/usercollectsku")
public class UserCollectSkuController {
    @Autowired
    private UserCollectSkuService userCollectSkuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("member:usercollectsku:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userCollectSkuService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("member:usercollectsku:info")
    public R info(@PathVariable("id") Long id){
		UserCollectSkuEntity userCollectSku = userCollectSkuService.getById(id);

        return R.ok().put("userCollectSku", userCollectSku);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("member:usercollectsku:save")
    public R save(@RequestBody UserCollectSkuEntity userCollectSku){
		userCollectSkuService.save(userCollectSku);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("member:usercollectsku:update")
    public R update(@RequestBody UserCollectSkuEntity userCollectSku){
		userCollectSkuService.updateById(userCollectSku);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("member:usercollectsku:delete")
    public R delete(@RequestBody Long[] ids){
		userCollectSkuService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
