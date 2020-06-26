package com.hikvision.boot.commondao.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @description:
 * @author: nibinbin
 * @date: 2020/2/3 19:50
 * @modify by
 */
@Component
@PropertySource("db.properties")
public class DbProperties {
    @Value("${custom.datasource.driver-class-name}")
    private String driver;
    @Value("${custom.datasource.url}")
    private String url;
    @Value("${custom.datasource.username}")
    private String userName;
    @Value("${custom.datasource.password}")
    private String password;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
