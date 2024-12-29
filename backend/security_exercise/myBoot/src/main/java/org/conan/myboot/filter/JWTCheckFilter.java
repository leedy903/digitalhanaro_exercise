package org.conan.myboot.filter;

import com.google.gson.Gson;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.conan.myboot.util.JWTUtil;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@Log4j2
public class JWTCheckFilter extends OncePerRequestFilter {


    @Override//필터로체하지않을경로나메소드를지정하기위한용도
    protected boolean shouldNotFilter(@NonNull HttpServletRequest request) throws ServletException{
        //Preflight 요청은체크하지않음
        if(request.getMethod().equals("OPTIONS")){
         }
        String path = request.getRequestURI();
        log.info("check url ......................"+path);
        // api/subscriber 경로의호출은체크하지않음
//        if(path.startsWith("/")){
//            return true;
//        }
        if(path.startsWith("/api/subscriber") || path.startsWith("/stomp-broadcast") || path.startsWith("/webjars") || path.startsWith("/broadcast")){
            return true;
        }
        // 이미지조회경로의호출은체크하지않음
        //if(path.startsWith("/api/todo/view")){
        // return true;
        //}
        return false;
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        log.info("-------------------JWTCheckFilter---------------------");
        String authHeaderStr = request.getHeader("Authorization");
        try {
            String accessToken = authHeaderStr.substring(7);
            Map<String, Object> claims = JWTUtil.validateToken(accessToken); //예외 발생 여부 확인
            log.info("JWT Claims: " + claims);
            filterChain.doFilter(request, response); // 통과
        } catch (Exception e) {
            Gson gson = new Gson();
            String msg = gson.toJson(Map.of("error", "ERROR_ACCESS_TOKEN"));
            response.setContentType("application/json");
            PrintWriter pw = response.getWriter();
            pw.println(msg);
            pw.close();
        }
    }
}
