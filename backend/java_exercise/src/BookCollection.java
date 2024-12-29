import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Book {
    int id;
    String title;
    String author;
    int quantity;

    public Book(int id, String title, String author, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }
}

public class BookCollection {
    public static void main(String[] args) {
        HashSet<Book> set = new HashSet<>();
        set.add(new Book(100, "어린 왕자", "생떽쥐베리", 5));
        set.add(new Book(200, "행복한 왕자", "오스카와일드", 10));
        set.add(new Book(300, "셜록 홈즈", "코난도일", 8));

        for (Book book : set) {
            System.out.println(book.id +" " + book.title + " " + book.author + " " + book.quantity);
        }

        HashMap <Integer, Book> map = new HashMap<>();
        map.put(1, new Book(100, "어린 왕자", "생떽쥐베리", 5));
        map.put(2, new Book(200, "행복한 왕자", "오스카와일드", 10));
        map.put(3, new Book(300, "셜록 홈즈", "코난도일", 8));

        for (Map.Entry <Integer, Book> entry : map.entrySet()) {
            int key = entry.getKey();
            Book book = entry.getValue();
            System.out.println(key + "의 세부 항목");
            System.out.println(book.id +" " + book.title + " " + book.author + " " + book.quantity);
            System.out.println("------------------------------------");
        }
    }
}
