import java.util.HashMap;
import java.util.Map;

public class FruitEx {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("banana", "바나나");
        map.put("apple", "사과");
        map.put("strawberry", "딸기");
        map.put("banana", "바나나1");
        map.put("banana", "바나나2");


        for (Map.Entry m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        System.out.println("-------------------------");

        for (String key : map.keySet()) {
            System.out.println(" key : " + key + " value: " + map.get(key));
        }

        for (String value : map.values()) {
            System.out.println("value: " + value);
        }

        Map<Integer, String> he = new HashMap<>();
        he.put(1, "바나나");
        he.put(2, "사과");
        he.put(3, "오렌지");

        for (Integer i : he.keySet()) {
            System.out.println("key: " + i + " value: " + he.get(i));
        }

        he.remove(1);

        for (Integer i : he.keySet()) {
            System.out.println("key: " + i + " value: " + he.get(i));
        }
    }
}
