package org.learn.boot.datasource.datasource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName: DatasourceTest2
 * @Description:
 * @Author: lin
 * @Date:  2019/3/24 18:15
 * History:
 * @<version> 1.0
 */
@Component
@ConfigurationProperties(prefix = "spring.datasource.test2")
public class DatasourceTest2 {
    /** 数据库连接url */
    private String jdbcUrl;
    /** 用户名 */
    private String username;
    /** 用户密码 */
    private String password;
    /** 数据库驱动 */
    private String driverClassName;



    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
}
