import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradeEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> scores = new ArrayList<>();
        while (true) {
            System.out.print("점수를 입력하세요: ");
            int score = sc.nextInt();

            if (score < 0) {
                break;
            }

            scores.add(score);
        }

        System.out.println("학생들의 성적: " + scores);
        for (int i = 0; i < scores.size(); i++) {
            System.out.println(i + "학생의 성적은 " + scores.get(i) + "이며 학점은 " + getGrade(scores.get(i)) + "이다.");
        }
        sc.close();
    }
    public static String getGrade(Integer score) {
        switch (score/10) {
            case 10, 9:
                return "A";
            case 8:
                return "B";
            case 7:
                return "C";
            case 6:
                return "D";
            default:
                return "F";
        }
    }
}
