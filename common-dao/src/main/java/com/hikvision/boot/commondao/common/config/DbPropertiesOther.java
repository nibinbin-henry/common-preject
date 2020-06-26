package com.hikvision.boot.commondao.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: nibinbin
 * @date: 2020/2/3 21:16
 * @modify by
 */
@Component
@ConfigurationProperties(value = "custom.datasource")
@PropertySource("db.properties")
public class DbPropertiesOther {

    private String url;
    private String username;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
