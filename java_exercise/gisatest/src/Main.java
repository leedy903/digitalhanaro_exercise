public class Main {
    public static void main(String[] args) {
        new Container<>(0).print();

    }
    public static class Container {
        T value;
        public Container(T t) {
            value = t;
        }
        public void print() {
            new Printer().print(value);
        }
    }
}