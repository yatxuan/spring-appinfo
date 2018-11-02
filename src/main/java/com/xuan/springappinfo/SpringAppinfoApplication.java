package com.xuan.springappinfo;

import com.xuan.springappinfo.utils.http.Crosfilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAppinfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAppinfoApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean registrationBean() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.addUrlPatterns("/*");
        bean.setFilter(new Crosfilter());
        return bean;
    }
}
