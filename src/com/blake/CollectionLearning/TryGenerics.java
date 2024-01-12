package com.blake.CollectionLearning; /**
 * Dec.20
 * 49泛型详解_自定义泛型
 */

import java.util.ArrayList;
import java.util.List;

public class TryGenerics {

    public static void main(String[] args) {

        List<qiHuaHua> qiHuaHuas = new ArrayList<>();
        List<taiDi> taiDis = new ArrayList<>();
        List<Animal> Animals = new ArrayList<>();

        ShowDogName(qiHuaHuas);
        ShowDogName(taiDis);
        // Doglist(Animals); -- 报错
    }

    public static void ShowDogName(List<? extends Dog> Dogs){
        System.out.println(Dogs);
    }
}

interface li<E>{
    public boolean isEmpty();
    public E get(int index);
    public void add(E e);
} // 创建接口

class myArray<E> implements li<E>{
    List<E> l = new ArrayList<>();

    public myArray(List<E> l) {
        this.l = l;
    }

    @Override
    public boolean isEmpty() {
        return l.isEmpty();
    }

    @Override
    public E get(int index) {
        return l.get(index);
    }

    @Override
    public void add(E e) {
        l.add(e);
    }
} // 自动实现泛型定义

class Animal{}
class Dog extends Animal{}
class taiDi extends Dog{}
class qiHuaHua extends Dog{}