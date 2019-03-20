package com.example.demo.params;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWT {

    private byte[] secret;

    public JWT(String secret) {
        this.secret = secret.getBytes();
    }

    public String sign(Map payload, Date expiration) {
        String token = Jwts.builder()
                .setClaims(payload)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
        return token;
    }

    public Claims verify(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }

    public static void main(String[] args) {

        int a = 10 >> 1;//5
        int b = a++;//5
        int c = ++a;//7
        int d = b*a++;//35
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);


//        // secret
//        String secret = "Uncle_Suyi";
//        JWT jwt = new JWT(secret);
//
//        // payload
//        Map<String, Object> payload = new HashMap<String, Object>();
//        payload.put("name", "suyi");
//
//        // expiration
//        Date expiration = new Date(System.currentTimeMillis() + 5 * 60 * 1000);
//
//        // sign
//        String token = jwt.sign(payload, expiration);
//        System.out.println(token);
//
//        // verify
//        Claims claims = jwt.verify(token);
//        System.out.println(claims.toString());


    }
}
