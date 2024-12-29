package org.conan.myboot.navers;

import lombok.extern.log4j.Log4j2;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

@Log4j2
public class APIExamCaptchaNkey2 {
    public static void main(String[] args) {
        String CLIENT_ID = NaverAPIs.NCP_CLIENT_ID;//애플리케이션 클라이언트 아이디값";
        String CLIENT_SECRET = NaverAPIs.NCP_CLIENT_SECRET;//애플리케이션 클라이언트 시크릿값";
        String key = "";
        try {
            String code = "0"; // 이미지 파일 요청시 0,  캡차 이미지 비교시 1로 세팅
            key = NaverAPIs.IMAGE_CAPTCHA_KEY; //1번을 실행한 결과로 얻은 키
            String apiURL = "https://naveropenapi.apigw.ntruss.com/captcha-bin/v1/ncaptcha?key=" + key + "&X-NCP-APIGW-API-KEY-ID" + CLIENT_ID;
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                InputStream is = con.getInputStream();
                int read = 0;
                byte[] bytes = new byte[1024];
                // 랜덤한 이름으로 파일 생성
                String tempname = Long.valueOf(new Date().getTime()).toString();
                File f = new File("img"+tempname + ".jpg");
                f.createNewFile();
                OutputStream outputStream = new FileOutputStream(f);
                while ((read =is.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
                is.close();
            } else {  // 오류 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString());
            }
        } catch (Exception e) {
            log.info("e :"+e.getMessage());
        }
    }
}
