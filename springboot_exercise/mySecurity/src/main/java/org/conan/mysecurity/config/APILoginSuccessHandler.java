package org.conan.mysecurity.config;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.conan.mysecurity.dto.SubscriberDTO;
import org.conan.mysecurity.utils.JWTUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@Log4j2
public class APILoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("=============================");
        log.info(authentication);
        log.info("=============================");
        SubscriberDTO subscriberDTO = (SubscriberDTO) authentication.getPrincipal();
        Map<String, Object> claims = subscriberDTO.getClaims();
        String accessToken = JWTUtil.generateToken(claims, 10);
        String refreshToken = JWTUtil.generateToken(claims, 60 * 24);
        claims.put("accessToken", accessToken);
        claims.put("refreshToken", refreshToken);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(claims);
        response.setContentType("application/json; charset=UTF-8");
        PrintWriter pw = response.getWriter();
        pw.println(jsonStr);
        pw.close();
    }
}
