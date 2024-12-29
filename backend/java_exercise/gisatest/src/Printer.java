public class Printer {
    void print(Integer a) {
        System.out.print("A" + a);
    }
    void print(Object a) {
        System.out.print("B" + a);
    }
    void print(Number a) {
        System.out.print("C" + a);
    }
}
