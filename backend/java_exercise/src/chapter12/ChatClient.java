package chapter12;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {
        BufferedReader in = null;   // 소켓 입력
        BufferedReader stin = null; // 키보드 입력
        PrintWriter out = null;
        Socket socketOfClient = null;
        try {
            socketOfClient = new Socket("localhost", 9999);
            in = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));
            stin = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));
            String outputMessage;
            while (true) {
                outputMessage = stin.readLine();
                if (outputMessage.equalsIgnoreCase("bye")) {
                    out.println(outputMessage);
                    out.flush();
                    break;
                }
                out.println("클라이언트> " + outputMessage);
                out.flush();
                String inputMessage = in.readLine();
                System.out.println(inputMessage);
            }

        } catch (IOException e) {
        } finally {
            try {
                socketOfClient.close();
            } catch (IOException e) {

            }
        }
    }
}
