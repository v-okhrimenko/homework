package Iterator;

public class Main {

    public static void main(String[] args) {

        String[] strArr = new String[10];
        Iterator it = new Iterator(strArr);

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
