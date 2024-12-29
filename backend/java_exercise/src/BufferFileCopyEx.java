import java.io.*;

public class BufferFileCopyEx {
    public static void main(String[] args) {
        long start, end, duration;
        String org = "";
        String dst = "";
        start = System.nanoTime();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(org));
            bos = new BufferedOutputStream(new FileOutputStream(dst));
            while (bis.available() > 0) {
                int b = bis.read();
                bos.write(b);
            }
            bos.flush();
        } catch (Exception e) {
            end = System.nanoTime();
            duration = end - start;
            System.out.println("버퍼를 사용한 경우: " + duration);
        }
    }
}
