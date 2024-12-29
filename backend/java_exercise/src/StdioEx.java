import java.io.IOException;

public class StdioEx {
    public static void main(String[] args) throws IOException {
        int b, len = 0;
        int bArray[] = new int[100];

        System.out.println("---입력 스트림---");
        while ((b = System.in.read()) != '\n') {
            System.out.printf("%c(%d)", (char) b, b);
            bArray[len++] = b;
        }

        System.out.println("\n\n---출력 스트림---");
        for (int i = 0; i < len; i++) {
            System.out.write(bArray[i]);
        }

        System.out.flush();
    }
}
