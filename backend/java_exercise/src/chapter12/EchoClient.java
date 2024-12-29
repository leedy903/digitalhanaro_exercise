package chapter12;

import java.io.*;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) {
        try {
            Socket socketOfClient = new Socket("127.0.0.1", 9999);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            OutputStream out = socketOfClient.getOutputStream();
            InputStream in = socketOfClient.getInputStream();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(out), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = null;
            while ((line = keyboard.readLine()) != null) {
                if (line.equals("quit")) break;
                pw.println(line);
                String echo = br.readLine();
                System.out.println("서버로부터 받은 문자열: " + echo);
            }
            pw.close();
            br.close();
            socketOfClient.close();
        } catch (Exception e) {
        }
    }
}
