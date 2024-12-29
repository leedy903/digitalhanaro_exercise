import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("기계의 온도를 입력하세요: ");
        float temperature = sc.nextFloat();
        System.out.println("팬(Fan) " + (temperature >= 40 ? "가동" : "중지"));
    }
}
