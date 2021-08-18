package com.pers.guofucheng.mapper;

import com.pers.guofucheng.pojo.UserCard;

/**
 * 用户身份证(UsersCard)表数据库访问层Mybatis实现
 *
 * @author guofucheng
 * @date 2020/08/21
 */
public interface UserCardMapper {

    UserCard findByCardId(Integer cardId);
}
