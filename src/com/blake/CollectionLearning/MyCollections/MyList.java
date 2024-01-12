package com.blake.CollectionLearning.MyCollections;

public interface MyList<E> {

    int size();
    boolean isEmpty();
    public void add(E e);
    public void add(int index,E obj);
    public E set(int index, E obj);

    public boolean contains(E obj);
    public E get(int index);
    Object[] toArray();
    public int indexOf(E obj);
    public boolean remove(int index);
    boolean remove(E obj);
    void clear();
    public String toString();

}
