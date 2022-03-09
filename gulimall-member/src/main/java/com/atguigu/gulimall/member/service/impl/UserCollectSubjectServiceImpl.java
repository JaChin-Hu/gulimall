package com.atguigu.gulimall.member.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.member.dao.UserCollectSubjectDao;
import com.atguigu.gulimall.member.entity.UserCollectSubjectEntity;
import com.atguigu.gulimall.member.service.UserCollectSubjectService;


@Service("userCollectSubjectService")
public class UserCollectSubjectServiceImpl extends ServiceImpl<UserCollectSubjectDao, UserCollectSubjectEntity> implements UserCollectSubjectService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserCollectSubjectEntity> page = this.page(
                new Query<UserCollectSubjectEntity>().getPage(params),
                new QueryWrapper<UserCollectSubjectEntity>()
        );

        return new PageUtils(page);
    }

}