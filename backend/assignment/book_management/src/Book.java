public class Book {
    String title;
    Author author;
    double price;
    int qty;

    public Book(String title, Author author, double price, int qty) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String toString() {
        return "Book[" +
                "title=" + title +
                ", author=" + author +
                ", price=" + price +
                ", qty=" + qty +
                "]";
    }
}
