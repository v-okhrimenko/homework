import java.util.Objects;

public class Pairs {
    String key;
    String value;

    public Pairs(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" + key + ":" + value + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pairs pairs = (Pairs) o;
        return Objects.equals(key, pairs.key) && Objects.equals(value, pairs.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
