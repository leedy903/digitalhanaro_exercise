package org.conan.mysecurity.filter;

import com.google.gson.Gson;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.conan.mysecurity.utils.JWTUtil;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@Log4j2
public class JWTCheckFilter extends OncePerRequestFilter {

    @Override // 필터로 체크하지 않을 경로나 메소드를 지정하기 위한 용도
    protected boolean shouldNotFilter(@NonNull HttpServletRequest request) throws ServletException {
        // Prefilght 요청은 체크하지 않음

        if (request.getMethod().equals("OPTIONS")) {
            return true;
        }
        String path = request.getRequestURI();
        log.info("check url..." + path);
        if (path.startsWith("/api/subscriber")) {
            return true;
        }
//        이미지 조회 경로의 호출은 체크하지 않음.
//        if (path.startsWith("/api/todo/view")) {
//            return true;
//        }
        return false;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("====================JWTCheckFilter====================");
        String authHeaderStr = request.getHeader("Authorization");
        try {
            String accessToken = authHeaderStr.substring(7);
            Map<String, Object> claims = JWTUtil.validateToken(accessToken); // 예외 발생 여부 확인
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
        log.info("========================================");
        filterChain.doFilter(request, response);
    }
}
