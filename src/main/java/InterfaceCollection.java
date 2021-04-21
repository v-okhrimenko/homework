public interface InterfaceCollection {

    boolean add(Object o);

    boolean add(int index, Object o);

    boolean addAll(String[] stringArray);

    boolean delete(Object o);

    Object get(int index);

    boolean contain(Object o);

    boolean equals(StringCollectionObject str);

    boolean clear();

    int size();

}
