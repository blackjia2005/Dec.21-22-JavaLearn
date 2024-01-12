/**
 * Dec.20
 * 52手写容器_自定义实现LinkedList1
 * 53手写容器_自定义实现LinkedList2
 */

package com.blake.CollectionLearning.MyCollections;

public class MyLinkedList<E> implements MyList<E>{

    public static void main(String[] args) {
        MyLinkedList<String> my_list = new MyLinkedList<>();
        my_list.add("1");
        my_list.add("2");
        my_list.add("Blake");
        my_list.add("Hi");
        my_list.add(3,"Hi~");
        my_list.remove(2);
        System.out.println(my_list.toString());
        System.out.println(my_list.indexOf("Hi"));
        my_list.clear();
        System.out.println(my_list);
    }

    private int size;
    private Node first;
    private Node last;

    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void add(E e) {
        Node n = new Node();
        if (first == null){
            n.setNext(null);
            n.setPrevious(null);
            n.setObj(e);

            last = n;
            first = n;
        }else{
            n.setNext(null);
            n.setPrevious(last);
            n.setObj(e);

            last.setNext(n);
            last = n;
        }
        size ++;
    }

    @Override
    public void add(int index, E obj) {
        Node temp = node(index);
        Node n = new Node(temp.getPrevious(),temp,obj);
        temp.getPrevious().setNext(n);
        temp.setPrevious(n);
        size++;
    }

    @Override
    public E set(int index, E obj) {
        return null;
    }

    @Override
    public boolean contains(E obj) {
        Node temp = first;
        for (int i = 0; i<size; i++){
            if(temp.getObj().equals(obj)){
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    private void checkRange(int index){
        if(index <0 || index > size){
            try {
                throw new Exception("索引错误");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private Node node(int index){
        checkRange(index);
        Node temp;
        if (index<(size/2)){
            temp = first;
            for (int i = 0; i<index ; i++){
                temp = temp.getNext();
            }
        }else{
            temp = last;
            for (int i=size-1; i>index; i--){
                temp = temp.getPrevious();
            }
        }
        return temp;
    }
    @Override
    public E get(int index) {
        return (E) node(index).getObj();
    }

    @Override
    public Object[] toArray() {
        Object[] li = new Object[size];
        Node temp = first;
        for (int i = 0; i<size ; i++){
            li[i] = temp.getObj();
        }
        return li;
    }

    @Override
    public int indexOf(E obj) {
        Node temp = first;
        for (int i = 0; i<size ; i++){
            if (temp.getObj().equals(obj)){
                return i;
            }
            temp = temp.getNext();
        }
        return -1;
    }

    @Override
    public boolean remove(int index) {
        checkRange(index);
        Node temp = node(index);
        temp.getPrevious().setNext(temp.getNext());
        temp.getNext().setPrevious(temp.getPrevious());
        size --;
        return false;
    }

    @Override
    public boolean remove(E obj) {
        return false;
    }

    public String toString(){
        Node temp = first;
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = 0; i<size; i++){
            str.append(temp.getObj()).append(" ");
            temp = temp.getNext();
        }
        str.append("]");
        return str.toString();
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }
}

class Node{

    private Node previous;
    private Node next;
    private Object obj;

    public Node(){}

    public Node(Node previous, Node next, Object obj) {
        this.previous = previous;
        this.next = next;
        this.obj = obj;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}