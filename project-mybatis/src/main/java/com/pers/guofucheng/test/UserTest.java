package com.pers.guofucheng.test;

import com.pers.guofucheng.mapper.UserCardMapper;
import com.pers.guofucheng.mapper.UserMapper;
import com.pers.guofucheng.pojo.User;
import com.pers.guofucheng.pojo.UserCard;
import com.pers.guofucheng.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * 用户测试
 *
 * @author guofucheng
 * @date 2020/08/25
 */
public class UserTest {
    static SqlSession sqlSession=null;
    @BeforeAll
    public static void openSqlSession(){
        sqlSession = SqlSessionFactoryUtil.openSqlSession();
    }
    @Test
    public void userFindByIdTest(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findByUid(1);
        //输出结果
        System.out.println(user);
    }
    @Test
    public void userCardFindByCardIdTest(){
        UserCardMapper userCardMapper = sqlSession.getMapper(UserCardMapper.class);
        UserCard userCard = userCardMapper.findByCardId(1);
        //输出结果
        System.out.println(userCard);
    }
    @AfterAll
    public static void closeSqlSession(){
        sqlSession.close();
    }
}