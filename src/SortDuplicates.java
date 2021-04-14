import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class SortDuplicates {

    public static void main(String[] args) {

        ArrayList<String> c1 = new ArrayList<>();
        c1.add("1");
        c1.add("2");
        c1.add("2");
        c1.add("3");

        ArrayList<?> newList = new ArrayList<>(sortNoDuplicate(c1));
        System.out.println(newList);
    }

    public static Collection<?> sortNoDuplicate(Collection<?> collection) {
        return new HashSet<>(collection);
    }


}
