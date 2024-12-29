interface Alam {
    abstract public void playMusic(String title);

    abstract public void beep();
}

interface Messenger {
    void sendMessage(String phoneNumber, String msg);

    void receiveMsg();
}

interface Phone {
    void call(String phoneNumber);

    void receive();
}


class SmartPhone implements Alam, Messenger, Phone {
    private String phoneNumber;

    @Override
    public void playMusic(String title) {
        System.out.printf("[%s]이 재생됨\n", title);
    }

    @Override
    public void beep() {
        for (int i = 0; i < 3; i++) {
            System.out.println("삐이익 ~ ");
        }
    }

    @Override
    public void sendMessage(String phoneNumber, String msg) {
        System.out.printf("[%s]로 메세지 전송: %s\n", phoneNumber, msg);
    }

    @Override
    public void receiveMsg() {
        System.out.println("메시지가 도착했음");
    }

    @Override
    public void call(String phoneNumber) {
        System.out.printf("[%s]로 전화걸기 시도...rrr\n", phoneNumber);
    }

    @Override
    public void receive() {
        System.out.println("전화를 받음");
    }
}

public class SmartPhoneEx {
    public static void main(String[] args) {
        SmartPhone sp = new SmartPhone();
        sp.playMusic("상어송");
        sp.call("010-1111-1111");
        sp.sendMessage("010-2222-2222", "내 이름은 코난, 나는 탐정이죠");
    }
}
