package org.garen;

import org.garen.mc.swagger.ApiOriginFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;


/**
 * Created by Administrator on 2017/8/23.
 */
@SpringBootApplication
@MapperScan("org.garen.mc.mybatis.mapper")
public class McRun {


    /**
     * 配置过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(apiOriginFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("apiOriginFilter");
        return registration;
    }

    /**
     * 创建一个bean
     * @return
     */
    @Bean(name = "apiOriginFilter")
    public Filter apiOriginFilter() {
        return new ApiOriginFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(McRun.class, args);
    }

}
