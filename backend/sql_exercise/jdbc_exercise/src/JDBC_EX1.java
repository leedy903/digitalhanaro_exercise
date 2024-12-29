import java.sql.*;

public class JDBC_EX1 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/scottdb?useSSL=false", "scott", "tiger"
            );
            System.out.println("DB 연결 완료");

            Statement stat = conn.createStatement(); // statement 객체 생성
            ResultSet rs = stat.executeQuery("SELECT * FROM BOOK");// 테이블 반환 -> ResultSet
            while (rs.next()) { // 커서 위치 이동
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) +
                        " " + rs.getString("price"));
            }

            ResultSet baseballRs = stat.executeQuery("SELECT * FROM BOOK WHERE BOOKNAME = \"야구의 추억\"");
            System.out.println(baseballRs.getString(1));


        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 에러");
        } catch (SQLException e) {
            System.out.println("DB 연결 오류");
        }
    }
}
