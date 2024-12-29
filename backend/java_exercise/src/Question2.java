import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("시간을 초 단위로 입력하세요: ");
        int time = sc.nextInt();
        int hours = time / 3600;
        int minutes = (time % 3600) / 60;
        int second = time % 60;
        System.out.println(time + "는 " + hours + "시간 " + minutes + "분 " + second + "초 입니다.");
    }
}
