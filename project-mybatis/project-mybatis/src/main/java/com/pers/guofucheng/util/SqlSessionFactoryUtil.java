package com.pers.guofucheng.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * SqlSessionFactory工具类
 *
 * @author guofucheng
 * @date 2020/08/21
 */
public class SqlSessionFactoryUtil {
    Logger logger = LoggerFactory.getLogger(SqlSessionFactoryUtil.class);
    /**
     * SqlSessionFactory
     */
    private static SqlSessionFactory sqlSessionFactory=null;
    private static final Class CLASS_LOCK=SqlSessionFactoryUtil.class;

    private SqlSessionFactoryUtil() {
    }

    /**
     * 初始化 SqlSessionFactory
     *
     * @return {@link SqlSessionFactory}
     */
    public static SqlSessionFactory initSqlSessionFactory(){
        String resource="mybatis-config.xml";
        InputStream inputStream=null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            //为保证多线程操作环境下获取到的SqlSessionFactory对于访问的数据源为单例
            synchronized (CLASS_LOCK){
                SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
                sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream !=null){
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sqlSessionFactory;
    }

    /**
     * 获取sqlSession
     *
     * @return {@link SqlSession}
     */
    public static SqlSession openSqlSession(){
        if (sqlSessionFactory==null){
            initSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }
}
