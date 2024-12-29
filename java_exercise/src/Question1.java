import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름을 입력하세요: ");
        String name = sc.next();
        System.out.print("주소를 입력하세요: ");
        String address = sc.next();
        System.out.print("나이를 입력하세요: ");
        int age = sc.nextInt();
        System.out.print("키를 입력하세요: ");
        float height = sc.nextFloat();

        System.out.println("name = " + name);
        System.out.println("address = " + address);
        System.out.println("age = " + age);
        System.out.println("height = " + height);
        sc.close();
    }

}
