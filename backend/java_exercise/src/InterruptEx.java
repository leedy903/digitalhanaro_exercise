class TimerThreadInterrupt extends Thread {
    int n = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println(n);
            n++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

public class InterruptEx {
    public static void main(String[] args) {
        TimerThreadInterrupt th = new TimerThreadInterrupt();

        th.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        th.interrupt();

    }
}
