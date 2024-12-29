import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("수심을 입력하세요: ");
        int depth = sc.nextInt();
        System.out.println("수온: " + (20 - (depth / 10) * 0.7));
    }
}
