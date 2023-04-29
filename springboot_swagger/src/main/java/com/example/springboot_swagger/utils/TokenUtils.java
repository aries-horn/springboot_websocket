package com.example.springboot_swagger.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.example.springboot_swagger.model.entity.User;

import java.util.Date;

/*
token工具类，用来生成token和校验token
此处到期时间可以自定义按情况进行设置，1000是1秒。此处token的生成方法以及效验方法可以根据具体情况进行更改，生成token1是使用的jwt，此处验证方法存
在一个用户有多个token的情况（可以同时多次登陆同一账号，重新请求token之后，前一次的token只要没有过期也能使用。），可以整合redis后进行改造
（后面会讲到），可以达到一个用户只有一个token的效果（重新请求token之后，前一次的token即使没有过期也不能使用。）
*/
public class TokenUtils {

    //token到期时间10小时
    private static final long EXPIRE_TIME= 10*60*60*1000;
    //密钥盐
    private static final String TOKEN_SECRET="ljdyaishijin**3nkjnj??";

    /**
     * 生成token
     * @param user
     * @return
     */
    public static String sign(User user){

        String token=null;
        try {
            Date expireAt=new Date(System.currentTimeMillis()+EXPIRE_TIME);
            token = JWT.create()
                    //发行人
                    .withIssuer("auth0")
                    //存放数据
                    .withClaim("username",user.getUserName())
                    //过期时间
                    .withExpiresAt(expireAt)
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (IllegalArgumentException | JWTCreationException je) {

        }
        return token;
    }


    /**
     * token验证
     * @param token
     * @return
     */
    public static Boolean verify(String token){

        try {
            //创建token验证器
            JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
            DecodedJWT decodedJWT=jwtVerifier.verify(token);
            System.out.println("认证通过：");
            System.out.println("username: " + decodedJWT.getClaim("username").asString());
            System.out.println("过期时间：      " + decodedJWT.getExpiresAt());
        } catch (IllegalArgumentException | JWTVerificationException e) {
            //抛出错误即为验证不通过
            return false;
        }
        return true;
    }

}
