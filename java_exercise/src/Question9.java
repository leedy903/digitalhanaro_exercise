class MyExp {
    int base;
    int exp;

    MyExp(int base, int exp) {
        this.base = base;
        this.exp = exp;
    }

    int getValue() {
        return (int) Math.pow(base, exp);
    }

    void showMessage() {
        System.out.println(this.base + "의 " + this.exp + "승 = " +  getValue());
    }
}

public class Question9 {
    public static void main(String[] args) {
        MyExp myExp = new MyExp(2, 3);
        myExp.showMessage();
        MyExp myExp1 = new MyExp(3, 4);
        myExp1.showMessage();
    }
}
