import java.util.Scanner;

public class Question4 {
    // comparison operation
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("어린이의 신장을 입력하세요: ");
        int height = sc.nextInt();
        System.out.println(height > 125);
    }
}
