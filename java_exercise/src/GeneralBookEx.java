interface GeneralBook {
    int size();

    String names();

    String records();

    boolean nameExist(String name);

    void add(String name, String record);

    void remove(String name, String record);

    String get(String name);

    void sort();

    void print();
}

class ArrayedGeneralBook implements GeneralBook {
    String[] names;
    String[] records;

    public ArrayedGeneralBook(String[] names, String[] records) {
        this.names = names;
        this.records = records;
    }

    @Override
    public int size() {
        return this.names.length;
    }

    @Override
    public String names() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < names.length; i++) {
            sb.append(names[i]).append(" ");
        }
        return sb.toString();
    }

    @Override
    public String records() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < records.length; i++) {
            sb.append(records[i]).append(" ");
        }
        return sb.toString();
    }

    @Override
    public boolean nameExist(String name) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(String name, String record) {
        if (nameExist(name)) {
            System.out.println("이미 존재하는 이름입니다.");
            return;
        }

        String[] newNames = new String[names.length + 1];
        String[] newRecords = new String[names.length + 1];

        for (int i = 0; i < names.length; i++) {
            newNames[i] = names[i];
            newRecords[i] = records[i];
        }

        newNames[names.length] = name;
        newRecords[names.length] = record;

        names = newNames;
        records = newRecords;

        sort();

    }

    @Override
    public void remove(String name, String record) {
        if (!nameExist(name)) {
            System.out.println("삭제 불가: 없는 이름입니다.");
            return;
        }
        String[] newNames = new String[names.length - 1];
        String[] newRecords = new String[names.length - 1];

        int index = 0;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(name)) {
                if (records[i].equals(record)) continue;
                else {
                    System.out.println("삭제 불가: 일치하는 항목이 없습니다.");
                    return;
                }
            }

            newNames[index] = names[i];
            newRecords[index] = records[i];
            index++;
        }

        names = newNames;
        records = newRecords;
    }

    @Override
    public String get(String name) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(name)) {
                return records[i];
            }
        }
        System.out.println("일치하는 항목이 없습니다.");
        return "";
    }


    @Override
    public void sort() {
        for (int i = 1; i < names.length; i++) {
            String targetName = names[i];
            String targetRecord = records[i];
            int j = i - 1;
            while (j >= 0 && names[j].compareTo(targetName) > 0) {
                names[j + 1] = names[j];
                records[j + 1] = records[j];
                j--;
            }
            names[j + 1] = targetName;
            records[j + 1] = targetRecord;
        }
    }

    @Override
    public void print() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < names.length; i++) {
            sb.append(names[i]).append(records[i]).append("\n");
        }
        System.out.println(sb);
    }
}

public class GeneralBookEx {
    public static void main(String[] args) {
        String[] names = {"Sam", "Rhee", "Kim"};
        String[] records = {"1111", "2222", "3333"};
        ArrayedGeneralBook gb = new ArrayedGeneralBook(names, records);

        System.out.println(gb.names());

        gb.add("Allan", "4444");
        gb.print();
        //Allan4444\nKim3333\nRhee2222\Sam1111

        System.out.println("현재 저장된 데이터의 크기: " + gb.size()); //4

        gb.add("Alex", "5555");
        System.out.println("현재 저장된 데이터의 크기: " + gb.size()); //5

        gb.print();
        //Alex5555\nAllan4444\nKim3333\nRhee2222\Sam1111

        System.out.println(gb.nameExist("Alex"));

        gb.remove("Alex", "5555");
        gb.remove("Sam", "1111");
        gb.print();
        //Allan4444\nKim3333\nRhee2222

        String foundRecord = gb.get("Allan");
        //4444
        System.out.println(foundRecord);

        gb.remove("Sam", "1111");
        gb.remove("Rhee", "1111");
        gb.get("Sam");
        System.out.println(gb.nameExist("Sam"));
    }
}
