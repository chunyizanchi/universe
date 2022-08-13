package com.cyzc.spring.factorybean;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.security.sasl.SaslServer;
import org.springframework.beans.factory.FactoryBean;

/**
 * <p>FactoryBean 为了帮我们创建 connection对象
 *
 * @author Cyzc
 * @since [2022/03/30 16:30]
 */
public class ConnectFactoryBean implements FactoryBean<Connection> {

    private String driverClassName;
    private String url;
    private String userName;
    private String passWord;


    @Override
    public Connection getObject() throws Exception {

        Class.forName(driverClassName);
        Connection connection = DriverManager.getConnection(url,userName,passWord);
        return connection;
    }

    @Override
    public Class<?> getObjectType() {

        return Connection.class;
    }
    /**
     *
     * @author cyzc
     * @return {@link false 每一次都返回一个新的对象
     * true 每次都返回同一个对象
     * }
     * @since 2022/3/30 17:00
     */
    @Override
    public boolean isSingleton() {
        return true;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
