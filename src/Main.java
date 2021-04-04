public class Main {

    public static void main(String[] args) {

        SimpleStringCollection ssc = new SimpleStringCollection();

        System.out.println(ssc.toString());

        ssc.add("Hello");
        System.out.println(ssc.toString());

        ssc.add(0, "World");
        System.out.println(ssc.toString());

        ssc.add("This");
        System.out.println(ssc.toString());

        ssc.delete(0);
        System.out.println(ssc.toString());

        ssc.delete("Hello");
        System.out.println(ssc.toString());

        System.out.println(ssc.indexOf("This"));

    }
}
