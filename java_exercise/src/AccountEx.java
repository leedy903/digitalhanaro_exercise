import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Account {
    private String id;
    private String name;
    private int balance = 0;

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account[" +
                "id=" + id +
                ", name=" + name +
                ", balance=" + balance +
                "]";
    }
}

public class AccountEx {
    public static void main(String[] args) {
        Account a1 = new Account("1111", "conan", 10000);
        Account a2 = new Account("2222", "rose", 20000);

        File file = new File("account.txt");
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            pw.println(a1);
            pw.println(a2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
