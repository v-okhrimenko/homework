import java.util.Arrays;

public class SimpleStringCollection {

    private static String[] fullMassive = new String[10];
    private int index = 0;
    private static int massiveExtendSize = 0;
    private int tempIndex = 0;

    public void add(String string) {
        checkMassiveLength();
        fullMassive[index] = string;
        index++;
    }

    private void checkMassiveLength() {
        String[] tempMassive = getArrayNoNull();
        if (index == massiveExtendSize) {
            massiveExtendSize = massiveExtendSize + 10;
            fullMassive = new String[massiveExtendSize];
            tempIndex = index;
            System.arraycopy(tempMassive, 0, fullMassive, 0, tempMassive.length);
        }
        if (index > 0 & index < tempIndex) {
            System.out.println(index);
            massiveExtendSize = massiveExtendSize - 10;
            fullMassive = new String[massiveExtendSize];
            tempIndex = tempIndex - 10;
            System.arraycopy(tempMassive, 0, fullMassive, 0, tempMassive.length);
        }
    }

    public void add(int index, String string) throws ArrayIndexOutOfBoundsException {
        checkMassiveLength();
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
            if (index == this.index) {
                fullMassive[index - 1] = null;
                this.index--;
            } else {
                fullMassive[index] = null;
                System.arraycopy(fullMassive, index + 1, fullMassive, index, this.index - index);
                this.index--;
                fullMassive[this.index] = null;
            }
        } else {
            throw new ArrayIndexOutOfBoundsException("индекс: " + index + ", который вы хотите удалить - за пределами массива: " + getArrayNoNull().length);
        }
        checkMassiveLength();

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
        for (int i = 0; i < index; i++) {
            if (string.equals(fullMassive[i])) {
                return i;
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
        String[] stringObject = fullMassive;
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
