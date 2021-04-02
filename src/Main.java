import java.util.Random;

public class Main {

    public static void main(String[] args) {

        SimpleStringCollection ssc = new SimpleStringCollection();

        ssc.add("A");
        ssc.add("B");
        ssc.add("C");
        System.out.println(ssc.toString());

        System.out.println("___ADD_BY_INDEX___");

        ssc.add(1,"D");
        ssc.add(3,"E");
        System.out.println(ssc.toString());

        System.out.println("___DELETE_BY_INDEX___");
        ssc.delete(1);
        System.out.println(ssc.toString());

        System.out.println("___INDEX_OF___");
        System.out.println(ssc.indexOf("B"));

        System.out.println("___GET_INDEX___");
        System.out.println(ssc.get(1));
        System.out.println(ssc.get(3));
        System.out.println(ssc.toString());

        System.out.println("___DELETE BY STRING___");
        ssc.delete("C");
        System.out.println(ssc.toString());

    }
}
