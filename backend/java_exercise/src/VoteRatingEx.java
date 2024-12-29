import java.util.Random;

class VoteRating extends Thread {
    Random random = new Random();
    int voteRate = 0;

    public VoteRating(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (voteRate < 100) {
            StringBuilder sb = new StringBuilder();
            int growthRate = Math.min(100 - voteRate, random.nextInt(5) + 1);
            voteRate += growthRate;
            sb.append("제").append(getName()).append("지역구 개표율: ").append(voteRate).append("%(개표증가율: ").append(growthRate).append("%)");
            for (int i = 0; i < voteRate; i++) {
                sb.append("*");
            }
            System.out.println(sb);
            try {
                sleep(random.nextInt(10)*100);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

public class VoteRatingEx {
    public static void main(String[] args) {
        int n = 5;
        VoteRating[] voteRatings = new VoteRating[n];

        for (int i = 0; i < n; i++) {
            voteRatings[i] = new VoteRating(String.valueOf(i + 1));
        }

        for (int i = 0; i < n; i++) {
            voteRatings[i].start();
        }
    }
}
