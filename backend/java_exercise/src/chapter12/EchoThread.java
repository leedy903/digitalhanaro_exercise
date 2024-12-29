package chapter12;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class EchoThread extends Thread {
    private Socket socketOfServer;

    public EchoThread(Socket socketOfServer) {
        this.socketOfServer = socketOfServer;
    }

    @Override
    public void run() {
        try {
            InetAddress inetaddr = socketOfServer.getInetAddress();
            System.out.println(inetaddr.getHostAddress() + "로 부터 접속했습니다.");
            OutputStream out = socketOfServer.getOutputStream();
            InputStream in = socketOfServer.getInputStream();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(out), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println("클라이언트로 부터 받은 문자열: " + line);
                pw.println(line);
            }
            pw.close();
            br.close();
            socketOfServer.close();
        } catch (IOException e) {

        }
    }
}
