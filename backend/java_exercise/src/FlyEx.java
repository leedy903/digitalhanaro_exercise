interface Flyable {
    void fly();
}

class Bird implements Flyable {

    @Override
    public void fly() {
        System.out.println("[새]가 날개를 펼치며 날아간다.");
    }
}

class Helicopter implements Flyable {

    @Override
    public void fly() {
        System.out.println("[헬리콥터]가 프로펠러를 돌리며 날아간다.");
    }
}

class Rocket implements Flyable {

    @Override
    public void fly() {
        System.out.println("[로켓]이 불꽃을 뿜어내며 날아간다.");
    }
}

public class FlyEx {
    public static void main(String[] args) {
        Flyable[] fArray = {new Bird(), new Helicopter(), new Rocket()};
        for (int i = 0; i < fArray.length; i++) {
            fArray[i].fly();
        }
    }
}
