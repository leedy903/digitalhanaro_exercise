package org.conan.mysecurity.config;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@Log4j2
public class APILoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.info("Login Fail..." + exception);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(Map.of("error", "Error_Login"));
        response.setContentType("application/json");
        PrintWriter pw = response.getWriter();
        pw.println(jsonStr);
        pw.close();
    }
}
