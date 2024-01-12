/**
 * Dec.20
 * 50手写容器_自定义实现ArrayList1
 * 51手写容器_自定义实现ArrayList2
 */
package com.blake.CollectionLearning.MyCollections;

public class myArrayList<E> implements MyList<E>{

    public static void main(String[] args) {

        myArrayList<Object> l = new myArrayList<>(3);
        l.add(1);
        l.add(2);
        l.add(1);
        l.add("Blake");
        l.add(1,"z");
        l.set(3,111);
        System.out.println(l.contains(3));
        l.remove(2);
        l.add("NN");
        l.add("I need to test!");
        l.add("more!");
        l.add(3,"Blake");
        Object a = 111;
        l.remove(a); //这里111不再是int，而是obj
        l.remove("aaaaa");
        System.out.println(l.toString());
        l.clear();
        System.out.println(l.toString());
    }


    private int size;
    private Object[] elementData;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    private void checkRange(int index){
        if (index<0 || index>=size){
            try {
                throw  new Exception("索引位置错误！");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    private void ensureCapacity(){
        if(size == elementData.length){
            Object[] newArray = new Object[elementData.length*2+1];
            System.arraycopy(elementData,0,newArray,0,elementData.length);
            elementData = newArray;
        }
    }

    myArrayList(){
        this(10);
    }

    myArrayList(int initialCapacity){
        elementData = new Object[initialCapacity];
    }
    @Override
    public void add(E e) {
        ensureCapacity();
        elementData[size] = e;
        size++;
    }

    @Override
    public void add(int index, E obj) {
        checkRange(index);
        ensureCapacity();

        System.arraycopy(elementData,index,elementData,index+1,size-index);
        elementData[index] = obj;
        size++;
    }

    @Override
    public E set(int index, E obj) {
        checkRange(index);
        Object oldValue = elementData[index];
        elementData[index] = obj;
        return (E)oldValue;

    }

    @Override
    public E get(int index){
        checkRange(index);
        return (E) elementData[index];
    }

    @Override
    public boolean contains(E obj) {
        for (Object temp:elementData){
            if(temp == obj){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return elementData;
    }

    @Override
    public int indexOf(E obj) {
        for (int i = 0; i<size; i++){
            if(elementData[i].equals(obj)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean remove(int index) {
        checkRange(index);
        System.arraycopy(elementData,index+1,elementData,index,size-index+1);
        size--;
        return true;
    }

    @Override
    public boolean remove(E obj) {
        int index = indexOf(obj);
        if(index>=0){
            remove(index);
            size--;
            return true;
        }
        return false;
    }

    public String toString(){
        StringBuilder string = new StringBuilder();
        string.append("[");
        for (int i=0; i<size; i++){
            string.append(elementData[i]).append(" ,");
        }
        string.append("]");
        return string.toString();
    }

    @Override
    public void clear() {
        elementData = new Object[3];
        size = 0;
    }
}
