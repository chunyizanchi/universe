package com.cyzc.spring.mybatisdev;

import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/07 17:17]
 */
@Configuration
@ComponentScan(basePackages = "com.cyzc.spring.mybatisdev")
@MapperScan(basePackages = "com.cyzc.spring.mybatisdev")
public class MyBatisAutoConfiguration {

    @Bean
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/spring");
        druidDataSource.setUsername("root");
        druidDataSource.setUsername("123456");
        return druidDataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setTypeAliasesPackage("com.cyzc.spring.mybatisdev");
        sqlSessionFactoryBean.setMapperLocations(new ClassPathResource("UserDaoMapper2.xml"));
        return sqlSessionFactoryBean;


    }
}
