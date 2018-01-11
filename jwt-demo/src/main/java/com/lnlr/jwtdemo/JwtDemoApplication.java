package com.lnlr.jwtdemo;

import com.lnlr.jwtdemo.entity.User;
import com.lnlr.jwtdemo.response.ObjectResponse;
import com.lnlr.jwtdemo.response.Response;
import com.lnlr.jwtdemo.response.SuccessResponse;
import com.lnlr.jwtdemo.utils.AccessToken;
import com.lnlr.jwtdemo.utils.Audience;
import com.lnlr.jwtdemo.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * jwt学习
 *
 * @author 雷洪飞
 */
@ComponentScan({"com.lnlr.*"})
@RequestMapping("/jwt")
@Controller
@SpringBootApplication
public class JwtDemoApplication {
    @Autowired
    private Audience audienceEntity;



    @PostMapping("/login")
    @ResponseBody
    Response login(@RequestBody User user) {
        String accessToken = JwtUtils.createJWT(
                "lnlr",
                "123",
                audienceEntity.getClientId(),
                audienceEntity.getName(),
                audienceEntity.getExpiresSecond() * 1000,
                audienceEntity.getBase64Secret());

        //返回accessToken
        AccessToken accessTokenEntity = new AccessToken();
        accessTokenEntity.setAccess_token(accessToken);
        accessTokenEntity.setExpires_in(audienceEntity.getExpiresSecond());
        accessTokenEntity.setToken_type("bearer");
        return new ObjectResponse<>(accessToken);
    }

    @GetMapping("/token-Decrypt")
    @ResponseBody
    Response Decrypt(@RequestParam("token") String token) {
        String auth = token.substring(7, token.toString().length());
        Claims claims = JwtUtils.parseJWT(auth, audienceEntity.getBase64Secret());
        System.out.println(claims.get("loginUser"));
        return new SuccessResponse();
    }


    public static void main(String[] args) {
        SpringApplication.run(JwtDemoApplication.class, args);
    }
}
