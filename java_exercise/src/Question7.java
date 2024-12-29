import java.util.Arrays;

public class Question7 {
    public static void main(String[] args) {
        int sum = Arrays.stream(args).mapToInt(Integer::parseInt).sum();
//        System.out.println("전달 받은 수는 " + Arrays.toString(args));
        System.out.print("전달 받은 수는 ");
        Arrays.stream(args).forEach(n -> System.out.print(n + " "));
        System.out.println("\n숫자들의 합은 " + sum);
        System.out.println("숫자들의 평균은 " + (float) sum / args.length);
    }
}