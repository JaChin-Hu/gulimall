package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.member.entity.UserLevelEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员等级表
 * 
 * @author jachin
 * @email jachin-hu@qq.com
 * @date 2022-03-09 16:29:48
 */
@Mapper
public interface UserLevelDao extends BaseMapper<UserLevelEntity> {
	
}
