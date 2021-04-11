public class MyLinkedList implements CustomCollection {

    private CollectionObject first;
    private int count = 0;

    @Override
    public boolean add(String str) {
        CollectionObject newObject = new CollectionObject(str);
        newObject.setNextElement(first);
        first = newObject;
        count++;
        return true;
    }

    @Override
    public boolean addAll(String[] strArr) {
        for (String str : strArr) {
            if (str != null) add(str);
        }
        return true;
    }

    @Override
    public boolean addAll(MyLinkedList strColl) {
        CollectionObject current = strColl.first;
        while (current != null) {
            add(current.getStr());
            current = current.getNextElement();
        }
        return true;
    }

    @Override
    public boolean delete(int index) {
        if (index >= 0 & index <= size() - 1) {
            return delete(get(index));
        }
        return false;
    }

    @Override
    public boolean delete(String str) {
        CollectionObject current = first;
        CollectionObject prev = current;
        CollectionObject next = current.getNextElement();

        while (current != null) {
            if (current.getStr().equals(str)) {
                prev.setNextElement(next);
                count--;
                if (count == 0) {
                    first = null;
                }
                return true;
            }
            prev = current;
            next = current.getNextElement().getNextElement();
            current = current.getNextElement();
        }
        return false;
    }

    @Override
    public String get(int index) {
        if (index >= 0 && index <= size()) {
            CollectionObject current = first;
            int counter = 0;
            while (current != null) {
                if (counter == index) {
                    return current.getStr();
                }
                current = current.getNextElement();
                counter++;
            }
        }
        return null;
    }

    @Override
    public boolean contains(String str) {
        CollectionObject current = first;
        while (current != null) {
            if (current.getStr().equals(str)) {
                return true;
            }
            current = current.getNextElement();
        }
        return false;
    }

    @Override
    public boolean clear() {
        if (count > 0) {
            CollectionObject current = first;
            while (current != null) {
                delete(current.getStr());
                current = current.getNextElement();
            }
        }
        first = null;
        return true;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean trim() {
        return false;
    }

    @Override
    public boolean compare(MyLinkedList coll) {
        return this.equals(coll);
    }

    public void showArray() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        CollectionObject current = first;
        while (current != null) {
            if (current.getNextElement() != null) {
                sb.append(current).append(", ");
            } else {
                sb.append(current);
            }
            current = current.getNextElement();
        }
        sb.append("]");
        System.out.println(sb);
    }
}
