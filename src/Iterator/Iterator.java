package Iterator;

public class Iterator implements IteratorMethods {

    private int counter;
    private final Object[] strArr;

    public Iterator(Object[] strArr) {
        this.strArr = strArr;
    }

    @Override
    public boolean hasNext() {
        return counter <= strArr.length - 1;
    }

    @Override
    public Object next() {
        return strArr[counter++];
    }
}
