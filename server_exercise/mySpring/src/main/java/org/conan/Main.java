package org.conan;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("setting.txt");
        Scanner scan = new Scanner(fis);
//        System.out.printf(scan.nextLine());

        Class clazz = Class.forName(scan.nextLine());

        // 내가 사용할 부품의 정보 클래스 이름
        // 클래스 이름을 가진 배터리 객체를 생성

        SmartPhone sp = new SmartPhone();
//        Battery b = new Battery();
//        Chargeable c = new Battery();
        Chargeable c = (Chargeable) clazz.newInstance();
        sp.setBattery(c);
        sp.change();
    }
}
