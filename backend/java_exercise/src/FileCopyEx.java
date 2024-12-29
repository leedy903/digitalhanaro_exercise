import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyEx {
    public static void main(String[] args) {
        String src = "c:/windows/system.ini";
        String dest = "c:/temp/system_copy.ini";
        try {
            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(dest);
            int c;
            while ((c = fis.read()) != -1)
                fos.write(c);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
