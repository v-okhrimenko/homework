import java.util.Arrays;

public class SimpleStringCollection {

    private static final String[] fullMassive = new String[10000];
    private int index = 0;

    public void add(String string) {
        fullMassive[index] = string;
        index++;
    }

    public void add(int index, String string) throws ArrayIndexOutOfBoundsException {
        if (index <= this.index & index >= 0) {
            String[] temp = new String[this.index];
            System.arraycopy(fullMassive, index, temp, 0, this.index - index);
            fullMassive[index] = string;
            System.arraycopy(temp, 0, fullMassive, index + 1, this.index - index);
            this.index++;
        } else if (index == this.index) {
            fullMassive[index + 1] = string;
            this.index++;
        } else if (index > this.index) {
            throw new ArrayIndexOutOfBoundsException("index который вы хотите добавить - " + index + ", за пределами массива : " + getArrayNoNull().length);
        }
    }

    public String get(int index) {
        try {
            return getArrayNoNull()[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(int index) throws ArrayIndexOutOfBoundsException {
        if (index <= this.index) {
            System.arraycopy(fullMassive, index + 1, fullMassive, index, this.index - index);
            this.index--;
        } else {
            throw new ArrayIndexOutOfBoundsException("индекс: " + index + ", который вы хотите удалить - за пределами массива: " + getArrayNoNull().length);
        }
    }

    public void delete(String string) {
        int indexForDelete = indexOf(string);
        if (indexForDelete != -1) {
            delete(indexForDelete);
        } else {
            System.out.println("Не могу удалить <" + string + "> -  Такая запись отсутствует.");
        }
    }

    public int indexOf(String string) {
        String[] stringObject = getArrayNoNull();
        int tempCounter = 0;
        for (String object : stringObject) {
            tempCounter++;
            if (string.equals(object)) {
                return tempCounter;
            }
        }
        return -1;
    }

    public int size() {
        return index;
    }

    private String[] getArrayNoNull() {
        return Arrays.copyOfRange(fullMassive, 0, index);
    }

    @Override
    public String toString() {
        String[] stringObject = getArrayNoNull();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < stringObject.length; i++) {
            if (i != index - 1) {
                sb.append(stringObject[i]).append(", ");
            } else {
                sb.append(stringObject[i]).append("]");
            }
        }
        return sb.toString();
    }
}
