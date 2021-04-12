import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

public class SortDuplicates {

    public static void main(String[] args) {

        ArrayList<String> c1 = new ArrayList<>();
        c1.add("1");
        c1.add("2");
        c1.add("2");
        c1.add("3");

        LinkedList<String> ls = new LinkedList<>();
        ls.add("3");
        ls.add("4");
        ls.add("6");
        ls.add("4");
        ls.add("3");

        System.out.println(c1);
        System.out.println(sortNoDuplicate(c1) + "      <-- no duplicate");

        System.out.println(ls);
        System.out.println(sortNoDuplicate(ls) + "      <-- no duplicate");

    }

    public static Collection<?> sortNoDuplicate(Collection<?> collection) {
        return new HashSet<>(collection);
    }


}
