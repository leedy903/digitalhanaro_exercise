import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DictionaryEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("love", "사랑");
        dictionary.put("apple", "사과");
        dictionary.put("baby", "아기");

        while (true) {
            System.out.print("찾고 싶은 단어는? ");
            String input = sc.next();
            System.out.println(dictionary.get(input));
        }

    }
}
