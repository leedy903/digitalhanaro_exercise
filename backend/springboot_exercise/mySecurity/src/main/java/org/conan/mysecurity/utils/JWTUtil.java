package org.conan.mysecurity.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.WeakKeyException;
import org.conan.mysecurity.exception.CustomJWTException;

import javax.crypto.SecretKey;
import java.io.UnsupportedEncodingException;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Map;

public class JWTUtil {
    private static String key = "1234567890012345678901234567890";
    public static String generateToken(Map<String, Object> valueMap, int min) {
        SecretKey key = null;
        try {
            key = Keys.hmacShaKeyFor(JWTUtil.key.getBytes("UTF-8"));
        } catch (WeakKeyException | UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage());
        }
        return Jwts.builder().setHeader(Map.of("typ", "JWT"))
                .setClaims(valueMap).setIssuedAt(Date.from(ZonedDateTime.now().toInstant()))
                .setExpiration(Date.from(ZonedDateTime.now().plusMinutes(min).toInstant()))
                .signWith(key).compact();
    }

    public static Map<String, Object> validateToken(String token) {
        Map<String, Object> claim = null;
        SecretKey key = null;
        try {
            key = Keys.hmacShaKeyFor(JWTUtil.key.getBytes("UTF-8"));
            claim = Jwts.parserBuilder().setSigningKey(key)
                    .build().parseClaimsJws(token)//파싱 및 검증, 실패 시 에러
                    .getBody();
        } catch (WeakKeyException e) {
            throw new CustomJWTException("WeakKeyException");
        } catch (UnsupportedEncodingException e) {
            throw new CustomJWTException("UnsupportedEncodingException");
        }
        return claim;

    }
}
