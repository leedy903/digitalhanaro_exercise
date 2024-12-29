import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book[] books = new Book[10];
        int bookLength = 0;
        while (true) {
            System.out.println("1.도서 정보 입력 | 2.도서 목록 보기 | 3.검색하기(제목) | 4.수량정보(여성작가수량/보유도서수량) | 5.프로그램종료");
            boolean isFinish = false;
            int menuType = sc.nextInt();
            switch (menuType) {
                case 1:
                    System.out.println("책제목, 저자, 이메일, 성별, 가격, 수량 순으로 입력하시요 -->>");
                    String title = sc.next();
                    String name = sc.next();
                    String email = sc.next();
                    String gender = sc.next();
                    double price = sc.nextDouble();
                    int qty = sc.nextInt();
                    Author author = new Author(name, email, gender);
                    books[bookLength] = new Book(title, author, price, qty);
                    bookLength++;
                    break;
                case 2:
                    for (int i = 0; i < bookLength; i++) {
                        System.out.println(books[i].toString());
                    }
                    break;
                case 3:
                    System.out.println("제목을 입력하세요-->>");
                    String targetTitle = sc.next();
                    for (int i = 0; i < bookLength; i++) {
                        if (books[i].getTitle().equals(targetTitle)) {
                            System.out.println(books[i].toString());
                            break;
                        }
                    }
                    break;
                case 4:
                    int femaleAuthorCount = 0;
                    for (int i = 0; i < bookLength; i++) {
                        if (books[i].getAuthor().getGender().equals("f")) {
                            femaleAuthorCount++;
                        }
                        System.out.println("여성작가도서/총보유도서 : " + femaleAuthorCount + "/" + bookLength);
                    }
                    break;
                case 5:
                    isFinish = true;
                    break;
            }
            if (isFinish) break;
        }
        sc.close();
    }
}