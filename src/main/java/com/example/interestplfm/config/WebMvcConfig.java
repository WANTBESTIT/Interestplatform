package com.example.interestplfm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xiaohongbin
 * @since 2024/07/18
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${weibo.profile}")
    private String defaultUrl;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
        resourceHandlerRegistry.addResourceHandler("/image/**")
                .addResourceLocations("file:" + defaultUrl);
    }
}
