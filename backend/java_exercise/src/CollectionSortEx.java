import java.util.Collections;
import java.util.LinkedList;

public class CollectionSortEx {
    public static void main(String[] args) {
        LinkedList<String> myList = new LinkedList<>();
        myList.add("트랜스포머");
        myList.add("스타워즈");
        myList.add("매트릭스");
        myList.add(0, "터미네이터");
        myList.add(2, "아바타");

        System.out.println("저장 후--------------------------");
        for (String str : myList) {
            System.out.print(str + " ");
        }
        System.out.println();

        Collections.sort(myList);

        System.out.println("문자열 정렬 후--------------------------");
        for (String str : myList) {
            System.out.print(str + " ");
        }
        System.out.println();

        Collections.reverse(myList);

        System.out.println("역순으로 정렬 후--------------------------");
        for (String str : myList) {
            System.out.print(str + " ");
        }
        System.out.println();

    }
}
