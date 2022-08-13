package com.cyzc.spring.mybatis;

import com.cyzc.spring.mybatis.dao.UserDao;
import com.cyzc.spring.mybatis.entity.User;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/01 22:06]
 */
public class TestMybatis {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        UserDao userDAO = session.getMapper(UserDao.class);

        User user = new User();
        user.setName("yusael");
        user.setPassword("123456");
        userDAO.save(user);

        session.commit();
    }


}
