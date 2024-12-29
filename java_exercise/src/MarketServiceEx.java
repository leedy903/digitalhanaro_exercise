import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

class Customer {
    String name;
    boolean member = false;
    String memberType;

    public Customer(String name, boolean member) {
        this.name = name;
        this.member = member;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    @Override
    public String toString() {
        return "Customer[" +
                "name=" + name +
                ", member=" + member +
                ", memberType=" + memberType +
                "]";
    }
}

class Visit {
    Customer customer;
    Calendar date;
    int serviceExpense;
    int productExpense;

    public Visit(Customer customer, Calendar date) {
        this.customer = customer;
        this.date = date;
    }

    public String getName() {
        return customer.getName();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public int getServiceExpense() {
        return serviceExpense;
    }

    public void setServiceExpense(int serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    public int getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(int productExpense) {
        this.productExpense = productExpense;
    }

    public int getTotalExpense() {
        if (customer.getMemberType() == null) {
            return productExpense + serviceExpense;
        }
        else {
            return (int) (productExpense * (1 - DiscountRate.getProductDiscountRate(customer.getMemberType())) +
                    serviceExpense * (1 - DiscountRate.getServiceDiscountRate(customer.getMemberType())));
        }

    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        DecimalFormat df = new DecimalFormat("###,###");
        return "Visit[" +
                "Customer=" + customer +
                ", Date=" + format.format(date.getTime()) +
                ", 제품 비용=" + df.format(productExpense) + "원" +
                ", 서비스 비용=" + df.format(serviceExpense) + "원" +
                ", 총 사용 비용=" + df.format(getTotalExpense()) + "원" +
                "]";
    }
}

class DiscountRate {
    static double serviceDiscountPremium = 0.2;
    static double serviceDiscountGold = 0.15;
    static double serviceDiscountSilver = 0.1;
    static double productDiscountPremium = 0.1;
    static double productDiscountGold = 0.1;
    static double productDiscountSilver = 0.1;

    static double getServiceDiscountRate(String type) {
        switch (type) {
            case "Premium" -> {
                return serviceDiscountPremium;
            }
            case "Gold" -> {
                return serviceDiscountGold;
            }
            case "Silver" -> {
                return serviceDiscountSilver;
            }
            default -> {
                return 0.0;
            }
        }
    }

    static double getProductDiscountRate(String type) {
        switch (type) {
            case "Premium" -> {
                return productDiscountPremium;
            }
            case "Gold" -> {
                return productDiscountGold;
            }
            case "Silver" -> {
                return productDiscountSilver;
            }
            default -> {
                return 0.0;
            }
        }
    }
}

public class MarketServiceEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;

        Visit[] visits = new Visit[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("고객의 이름, 회원 여부, 등급을 입력하세요>> ");
            st = new StringTokenizer(sc.nextLine());
            String name = st.nextToken();
            String isMember = st.nextToken();
            boolean member = isMember.equals("true");
            Customer customer = new Customer(name, member);
            if (st.hasMoreTokens()) {
                customer.memberType = st.nextToken();
            }

            Random random = new Random();
            Calendar calendar = Calendar.getInstance();
            calendar.clear();
            calendar.set(2024, Calendar.JANUARY, random.nextInt(31) + 1);
            Visit visit = new Visit(customer, calendar);
            visit.setProductExpense(random.nextInt(19) * 1000 + 1000);
            visit.setServiceExpense(random.nextInt(19) * 1000 + 1000);
            visits[i] = visit;
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(visits[i]);
        }
    }
}

