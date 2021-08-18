package com.pers.guofucheng.mapper;

import com.pers.guofucheng.pojo.User;

/**
 * 用户(User)表数据库访问层Mybatis实现
 *
 * @author guofucheng
 * @date 2020/08/21
 */
public interface UserMapper {

    User findByUid(Integer uid);
}
