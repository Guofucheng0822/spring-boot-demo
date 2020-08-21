package com.pers.guofucheng.test;

import com.pers.guofucheng.mapper.UserMapper;
import com.pers.guofucheng.pojo.User;
import com.pers.guofucheng.util.SqlSessionFactoryUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;

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
        System.out.println(user.getUname());
    }
    @AfterAll
    public static void closeSqlSession(){
        sqlSession.close();
    }
}