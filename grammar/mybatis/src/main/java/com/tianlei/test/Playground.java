package com.tianlei.test;

import com.tianlei.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Playground {

    public static void main(String[] args) {

        try {

            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //
            SqlSession session = sqlSessionFactory.openSession();
            UserMapper userMapper = session.getMapper(UserMapper.class);

            session.close();

        } catch (Exception e) {


        }


    }
}
