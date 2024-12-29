package org.conan.myboot.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.WeakKeyException;
import org.conan.myboot.exception.CustomJWTException;

import javax.crypto.SecretKey;
import java.io.UnsupportedEncodingException;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Map;

public class JWTUtil {
    public static String key = "1234567890123456789012345678901234567890";
    public static String generateToken(Map<String, Object> valueMap, int min) {
        SecretKey key = null;
        try {
            key = Keys.hmacShaKeyFor(JWTUtil.key.getBytes("UTF-8"));
        } catch (WeakKeyException | UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage());
        }
        String jwtStr = Jwts.builder().setHeader(Map.of("typ", "JWT"))
                .setClaims(valueMap)
                .setIssuedAt(Date.from(ZonedDateTime.now().toInstant()))
                .setExpiration(Date.from(ZonedDateTime.now().plusMinutes(min).toInstant()))
                .signWith(key).compact();
        return jwtStr;
    }

    public static Map<String, Object> validateToken(String token){
        Map<String, Object> claim = null;
        SecretKey key;
        try{
            key = Keys.hmacShaKeyFor(JWTUtil.key.getBytes("UTF-8"));
            claim = Jwts.parserBuilder().setSigningKey(key)
                    .build().parseClaimsJws(token) //파싱및검증, 실패시에러
                    .getBody();
        } catch(WeakKeyException e) {
            throw new CustomJWTException("WeakKeyException");
        } catch(UnsupportedEncodingException e) {
            throw new CustomJWTException("UnsupportedEncodingException");
        } catch(MalformedJwtException malformedJwtException) {
            throw new CustomJWTException("Malformed");
        } catch(ExpiredJwtException expiredJwtException) {
            throw new CustomJWTException("Expired");
        } catch(InvalidClaimException invalidClaimException) {
            throw new CustomJWTException("Invalid");
        } catch(JwtException jwtException) {
            throw new CustomJWTException("JWTError");
        } catch(Exception e) {
            throw new CustomJWTException("Error");
        }
        return claim;
    }

}
