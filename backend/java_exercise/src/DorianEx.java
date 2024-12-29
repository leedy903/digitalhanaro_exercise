import java.io.*;
import java.util.*;

public class DorianEx {
    public static void main(String[] args) {
        File file = new File("dorian.txt");
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> wordCount = new HashMap<>();
        StringTokenizer st;
        String content;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((content = br.readLine()) != null) {
                st = new StringTokenizer(content, ".|,|\"|\' ");
                while (st.hasMoreTokens()) {
                    String word = st.nextToken().toLowerCase();
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
            System.out.println();
            while (true) {
                System.out.print("찾고 싶은 단어는 무엇입니까? ");
                String targetWord = sc.next().toLowerCase();
                if (!wordCount.containsKey(targetWord)) {
                    System.out.println("한번도 사용된 적 없음");
                }
                else {
                    System.out.println(wordCount.get(targetWord) + "번 사용됨");
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
