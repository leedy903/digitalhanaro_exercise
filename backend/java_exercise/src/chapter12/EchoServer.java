package chapter12;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(9999);
            System.out.println("접속을 기다립니다.");
            Socket socketOfServer = server.accept();
            InetAddress inetaddr = socketOfServer.getInetAddress();
            System.out.println(inetaddr.getHostAddress() + "로부터 접속했습니다.");
            OutputStream out = socketOfServer.getOutputStream();
            InputStream in = socketOfServer.getInputStream();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(out), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println("클라이언트로 부터 전송 받은 문자열 : " + line);
                pw.println(line);
            }
            pw.close();
            br.close();
            socketOfServer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
