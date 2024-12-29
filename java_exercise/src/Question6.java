import java.util.Scanner;

public class Question6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("인원 수를 입력하세요: ");
        int houseHolds = sc.nextInt();
        System.out.println(String.format("%, d", 400000 + (Math.min(3, houseHolds - 1)) * 200000));
        sc.close();
    }
}