package com.example.interestplfm.tools;

import com.example.interestplfm.config.JwtUtils;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xiaohongbin
 * @since 2024/07/24
 **/
@Aspect
@Component
public class JwtAspect {

    @Before("@annotation(com.example.interestplfm.annotation.TokenListener) || @within(com.example.interestplfm.annotation.TokenListener)")
    public void validateToken() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization");

        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        assert response != null;
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            // 抛出异常，返回401状态码
            if (!JwtUtils.validateToken(token)) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                throw new IllegalArgumentException("用户未成功登录，请先登录！");
            }
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            throw new IllegalArgumentException("用户未成功登录，请先登录！");
        }

    }
}
