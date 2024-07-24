package com.example.interestplfm.config;

import io.jsonwebtoken.Jwts;

import java.util.Date;

/**
 * 功能描述：JWT工具类
 **/
public class JwtUtils {

    private static final String SECRET = "USER_JWT_SECRET";

    /**
     * 功能描述：根据用户名生成JWT token
     *
     * @param username 用户名
     * @return {@code String }
     */
    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, SECRET)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 24 hours
                .compact();
    }

    /**
     * 功能描述： 验证JWT token是否有效
     *
     * @param token Jwt Token
     * @return boolean
     */
    public static boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 功能描述： 从JWT token中获取用户名
     *
     * @param token Jwt Token
     * @return {@code String }
     */
    public static String getUsername(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
