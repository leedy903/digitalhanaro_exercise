import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

class PhoneBook {
    String name;
    int id;
    String phoneNo;

    public PhoneBook(String name, int id, String phoneNo) {
        this.name = name;
        this.id = id;
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return name + "(" + id + "): " + phoneNo;
    }
}

public class PhoneBookEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;

        Map<String, PhoneBook> map = new HashMap<>();

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(sc.nextLine());
            String name = st.nextToken();
            int id = Integer.parseInt(st.nextToken());
            String phoneNo = st.nextToken();
            map.put(name, new PhoneBook(name, id, phoneNo));
        }

        System.out.println("등록된 학생의 수: " + map.size());
        for (Map.Entry <String, PhoneBook> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
