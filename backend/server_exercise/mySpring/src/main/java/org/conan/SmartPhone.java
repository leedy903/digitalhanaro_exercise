package org.conan;

public class SmartPhone {
//    private Battery b;
    private Chargeable c;

    // composition - 결합력이 높음.
    public SmartPhone() {
//        this.b = new Battery();
    }

//    public void setBattery(Battery b) {
//        this.b = b;
//    }

    public void setBattery(Chargeable c) {
        this.c = c;
    }

    public void change() {
        System.out.printf("%s으로 충전", c.getMode());
    }
}
