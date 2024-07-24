package com.example.interestplfm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * @author xiaohongbin
 * @since 2024/07/24
 **/

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").permitAll() // 所有以 /user/ 开头的路径都允许匿名访问
                .antMatchers("/upload/**").permitAll() // 所有以 /upload/ 开头的路径都允许匿名访问
                .antMatchers("/static/**").permitAll() // 允许静态资源访问
                .antMatchers("/css/**", "/js/**", "/image/**").permitAll() // 允许特定静态资源目录访问
                .anyRequest().authenticated()
                .and().formLogin()
                .and().logout()
                .logoutUrl("/logout"); // 配置注销URL
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:8080"); // 允许的前端域
        configuration.addAllowedMethod("*"); // 允许的HTTP方法
        configuration.addAllowedHeader("*"); // 允许的头部信息
        configuration.setAllowCredentials(true); // 允许发送Cookie

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
