package org.conan.myboot.navers;

import org.springframework.stereotype.Service;

@Service
//@Log4j
public class NaverAPIs /* implements NaverProperties */ {
	public static final  String  NCP_CLIENT_ID ="j410cex2kr";
	public static final String  NCP_CLIENT_SECRET="GZqwmwZpP38oYoLx865Ek303RnBaazyuOirXFDKx";
	public static final String IMAGE_CAPTCHA_URL = "https://naveropenapi.apigw.ntruss.com/captcha/v1/nkey";
	public static final String IMAGE_CAPTCHA_KEY = "4YvFy86xFVt7Gfhn"; //요청할 때마다 키가 바뀜, 1번을 실행한 결과로 얻음

	public static final String SOUND_KEY_URL = "https://naveropenapi.apigw.ntruss.com/scaptcha/v1/skey";
	public static final String SOUND_SOUND_URL="https://openapi.naver.com/v1/captcha/scaptcha.bin";


	public static final String NAVER_CLIENT_ID="you_client_id";
	public static final String NAVER_CLIENT_SECRET="your_client_secret";
	public static final String NAVER_REDIRECT_URL="your_redirect_url";

}
