import java.util.Objects;

public class CollectionObject {

    private String str;
    private CollectionObject nextElement;


    public CollectionObject(String str) {
        this.str = str;

    }

    public void setStr(String str) {
        this.str = str;
    }

    public void setNextElement(CollectionObject nextElement) {
        this.nextElement = nextElement;
    }

    public String getStr() {
        return str;
    }

    public CollectionObject getNextElement() {
        return nextElement;
    }

    @Override
    public String toString() {
        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollectionObject that = (CollectionObject) o;
        return str.equals(that.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(str);
    }
}
