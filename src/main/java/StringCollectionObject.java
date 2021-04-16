import java.util.Arrays;
import java.util.Objects;

public class StringCollectionObject implements InterfaceCollection {

    private String[] fullMassive = new String[10];
    private int index = 0;
    private int extendSize = 10;
    private int extendIndex = 0;

    @Override
    public boolean add(Object o) {
        if (isString(o)) {
            chekAddSize();
            fullMassive[index] = o.toString();
            index++;
            return true;
        }
        return false;
    }

    @Override
    public boolean add(int index, Object o) {
        if (!isString(o) || index > this.index) {
            return false;
        } else {
            chekAddSize();
            if (index >= 0 & index <= this.index) {
                String[] temp = new String[this.index];
                System.arraycopy(fullMassive, index, temp, 0, this.index - index);
                fullMassive[index] = o.toString();
                System.arraycopy(temp, 0, fullMassive, index + 1, this.index - index);
                this.index++;
                return true;
            } else if (index == this.index) {
                fullMassive[index + 1] = o.toString();
                this.index++;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Object o) {
        if (isString(o)) {
            if (contain(o)) {
                int indexForDelete = indexOf(o);
                chekDeleteSize();
                System.arraycopy(fullMassive, indexForDelete + 1, fullMassive, indexForDelete, index - indexForDelete);
                index--;
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int index) {
        if (index >= 0 & index <= this.index) {
            return fullMassive[index];
        } else {
            System.out.println("Индекс: " + index + ", который вы хотите найти - за пределами массива: " + this.index);
            return null;
        }
    }

    @Override
    public boolean contain(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringCollectionObject that = (StringCollectionObject) o;
        return index == that.index && extendSize == that.extendSize && extendIndex == that.extendIndex && Arrays.equals(fullMassive, that.fullMassive);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(index, extendSize, extendIndex);
        result = 31 * result + Arrays.hashCode(fullMassive);
        return result;
    }

    @Override
    public boolean equals(StringCollectionObject str) {
        return str == this;
    }

    @Override
    public boolean clear() {
        fullMassive = new String[10];
        index = 0;
        extendSize = 10;
        extendIndex = 0;
        return true;
    }

    @Override
    public int size() {
        return index;
    }

    private String[] getArrayNoNull() {
        return Arrays.copyOfRange(fullMassive, 0, index);
    }

    private int indexOf(Object o) {
        for (int i = 0; i < index; i++) {
            if (o.equals(fullMassive[i])) {
                return i;
            }
        }
        return -1;
    }

    private Boolean isString(Object o) {
        if (Objects.nonNull(o)) {
            return o.getClass() == String.class;
        }
        return false;
    }

    private void chekAddSize() {
        if (index > 0 & index % 10 == 9) {
            String[] tempMassive = getArrayNoNull();
            extendSize = extendSize + 10;
            extendIndex = index;
            fullMassive = new String[extendSize];
            System.arraycopy(tempMassive, 0, fullMassive, 0, tempMassive.length);
        }
    }

    private void chekDeleteSize() {
        if (index > 0 & index == extendIndex) {
            String[] tempMassive = getArrayNoNull();
            extendIndex = (index < 10) ? extendIndex - 9 : index - 10;
            extendSize = extendSize - 10;
            fullMassive = new String[extendSize];
            System.arraycopy(tempMassive, 0, fullMassive, 0, tempMassive.length);
        }
    }

    @Override
    public String toString() {
        Object[] stringObject = fullMassive;
        StringBuilder sb = new StringBuilder();

        if (fullMassive[0] == null) {
            return "[]";
        } else {
            sb.append("[");
            for (int i = 0; i < index; i++) {
                if (i != index - 1) {
                    sb.append(stringObject[i]).append(", ");
                } else {
                    sb.append(stringObject[i]).append("]");
                }
            }
        }
        return sb.toString();
    }
}
