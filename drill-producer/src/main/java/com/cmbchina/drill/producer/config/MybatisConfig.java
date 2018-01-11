package com.cmbchina.drill.producer.config;

import com.alibaba.druid.pool.DruidDataSource;
import java.io.IOException;
import javax.sql.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class MybatisConfig {

    @Configuration
    @MapperScan(basePackages = "com.cmbchina.drill.dao.mapper.drill", sqlSessionFactoryRef = "sqlSessionFactoryDrill")
    static class DrillConfig{

        @Bean
        @Primary
        @ConfigurationProperties(prefix = "spring.datasource.drill")
        public DataSource dataSourceDrill() {
            return new DruidDataSource();
        }

        @Bean
        public SqlSessionFactoryBean sqlSessionFactoryDrill(@Qualifier("dataSourceDrill") DataSource dataSource, ResourcePatternResolver resolver) throws IOException {
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(dataSource);
            sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mybatis/mapper/drill/**/*.xml"));
            sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:mybatis.xml"));
            return sqlSessionFactoryBean;
        }

        @Bean
        public PlatformTransactionManager transactionManagerDrill(@Qualifier("dataSourceDrill")DataSource dataSource) {
            return new DataSourceTransactionManager(dataSource);
        }

    }

}
