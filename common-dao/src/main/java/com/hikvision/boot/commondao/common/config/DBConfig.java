package com.hikvision.boot.commondao.common.config;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @description:
 * @author: nibinbin
 * @date: 2020/2/3 18:50
 * @modify by
 */
@Configuration
@PropertySource("db.properties")
public class DBConfig {

    @ConfigurationProperties(prefix = "custom.datasource")
    @Bean("dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource =  new DriverManagerDataSource();
        return  dataSource;
    }

//    @Bean("dataSource")
//    public DataSource dataSource(DbPropertiesOther dbPropertiesOther) {
//        DriverManagerDataSource dataSource =  new DriverManagerDataSource();
//        dataSource.setUrl(dbPropertiesOther.getUrl());
//        return  dataSource;
//    }

    @Bean("sqlSessionFactory")
    public SqlSessionFactory createSqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);//定义数据源
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver()
                        .getResources("classpath:com/hikvision/boot/" +
                                "commondao/**/*.xml"));
        return bean.getObject();
    }

    @Bean
    public MapperScannerConfigurer createMapperScannerConfig() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        configurer.setBasePackage("com.hikvision.boot.commondao");
        configurer.setAnnotationClass(Mapper.class);
        return  configurer;
    }
}
