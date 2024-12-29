class Goods {
    String name;
    int price;
    int numberOfStock;
    int sold;

    Goods (String name, int price, int numberOfStock, int sold) {
        this.name = name;
        this.price = price;
        this.numberOfStock = numberOfStock;
        this.sold = sold;
    }

    public void showInfo() {
        System.out.println("상품 이름: " + this.name);
        System.out.println("상품 가격: " + this.price);
        System.out.println("재고 수량: " + this.numberOfStock);
        System.out.println("팔린 수량: " + this.sold);
    }
}

public class Question8 {
    public static void main(String[] args) {
        Goods shampoo = new Goods("앨라스틴", 13000, 30, 50);
        shampoo.showInfo();
    }
}
