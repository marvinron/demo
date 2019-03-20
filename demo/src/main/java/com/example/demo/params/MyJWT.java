package com.example.demo.params;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MyJWT {
    byte[] secrete;

    public MyJWT(String secrete) {
        this.secrete = secrete.getBytes();
    }
    //签名token
    public String sign(Map data, Date expireDate){
        String compact = Jwts.builder()
                          .setClaims(data)
                          .setExpiration(expireDate)
                          .signWith(SignatureAlgorithm.HS256, secrete)
                          .compact();
        return compact;

    }
    //验证签名
    public Claims verify(String token){
        Claims body = Jwts.parser().setSigningKey(secrete).parseClaimsJws(token).getBody();

        return body;
    }

    public static void main(String[] args) {
        Date date = new Date(System.currentTimeMillis()+5*60*1000);
        Map<String,String> map = new HashMap<>();
        map.put("name","james");
        map.put("id","1");
        map.put("sex","男");

        String secrete ="my_secrete";
        MyJWT myJWT = new MyJWT(secrete);
        String sign = myJWT.sign(map, date);
        System.out.println("========="+sign);
        Claims verify = myJWT.verify(sign);
        System.out.println("======="+verify);
    }

}
