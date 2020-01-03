package com.ibranco.mybatis.test;

import com.ibranco.mybatis.domain.User;
import com.ibranco.mybatis.mapper.UserMapper;
import com.ibranco.mybatis.vo.QueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UserTest {
    private Logger logger = Logger.getLogger(UserTest.class);
    private InputStream inputStream;
    private SqlSession sqlSession;
    private UserMapper userDao;

    @Before
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
        userDao = sqlSession.getMapper(UserMapper.class);
    }
    @After
    public void destory() throws IOException {
        sqlSession.close();
        inputStream.close();

    }
    @Test
    public void testFindAll() {
        List<User> userList = userDao.findAll();
        for (User user :userList){
            System.out.println(user);
            logger.info(user);
        }
    }
    @Test
    public void testFindByContent() {
        User queryUser = new User();
        queryUser.setUsername("abc");
        queryUser.setName("boxa");
        List<User> userList = userDao.findByContent(queryUser);
        for (User user :userList){
            System.out.println(user);
            logger.info(user);
        }
    }
    @Test
    public void testFindByContent1() {
        User queryUser = new User();
//        queryUser.setUsername("abc");
        queryUser.setName("box");
        List<User> userList = userDao.findByContent1(queryUser);
        for (User user :userList){
            System.out.println(user);
            logger.info(user);
        }
    }
    @Test
    public void testFindByContent2() {
        QueryVo vo=new QueryVo();
        User queryUser = new User();
        queryUser.setUsername("abc");
        queryUser.setName("box");
        vo.setUser(queryUser);
        List<User> userList = userDao.findByContent2(vo);
        for (User user :userList){
            System.out.println(user);
            logger.info(user);
        }
    }
    @Test
    public void testFindAnyId() {
        QueryVo vo=new QueryVo();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(6);
        ids.add(7);
        vo.setIds(ids);
        List<User> userList = userDao.findByAnyId(vo);
        for (User user :userList){
            System.out.println(user);
            logger.info(user);
        }
    }
}
