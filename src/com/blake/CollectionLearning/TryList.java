package com.blake.CollectionLearning; /**
 * Dec.19
 * 45 容器_List用法  testList
 * 46 容器_Set用法   test Set
 * 47 容器_Map的用法 test Map
 * 47 遍历所有类型 test Iterate
 * Dec.20
 * 48 容器_存取二维表格信息 testTable
 */

import java.util.*;

public class TryList {

    public static void main(String[] args) {

        testTable();

    }

    private static void testList(){
        List l = new ArrayList();

        // 增
        l.add("Blake");
        l.add("Bella");
        l.add("haoea");
        l.add(2,"Blake");

        System.out.println(l);

        // 删
        l.remove(3);
        l.remove("Blake");

        System.out.println(l);

        // 查
        String a = l.get(1).toString();
        System.out.println(a);

        //其他
        l.contains("Blake");  // true
        l.size(); // 1
    }

    public static void testSet(){

        Set s = new HashSet();

        s.add("Blake");

        emp e1 = new emp(21060721,"Blake");
        emp e2 = new emp(21060721, "Bella");      // set 不重复是根据equals判断的！
        emp e3 = new emp(2100000,"Haoea");

        s.add(e1);
        s.add(e2);
        s.add(e3);

        System.out.println(s);
    }

    public static void testMap(){

        Map my_map = new HashMap(); // HashTable() <- same

        // 增
        my_map.put(1,"Blake");
        my_map.put(2, "Bella");
        my_map.put(3,"NN");

        // 删
        my_map.remove(1);

        // 改
        my_map.put(2,"BLAKE");  // 重复的就会删掉旧的，根据equals()

        // 查
        Object a = my_map.get(2);
        System.out.println(a);

        System.out.println(my_map);
    }

    public static void testIterate(){

        List<String> l = new ArrayList<>(); // 泛形

        l.add("aa");
        l.add("bb");
        l.add("cc");

        // 方式一，for循环 -- only list
        for (int i = 0; i< l.size(); i++){
            String temp = l.get(i);
            System.out.println(temp);
        }

        // 方式二，增强for循环
        for (String temp:l){
            System.out.println(temp);
        }

        // 方式三，iterator
        for (Iterator<String> temp = l.iterator(); temp.hasNext();){
            String a = temp.next();
            System.out.println(a);
        }


        // Map

        Map<Integer,String> my_map = new HashMap<>();

        my_map.put(1,"one");
        my_map.put(2,"two");
        my_map.put(3,"three");

        // 方法一 -- map.ketSet()
        Set<Integer> keys = my_map.keySet();
        for (Integer temp:keys){
            String a = my_map.get(temp);
            System.out.println(temp+"----"+a);
        }

        // 方法二 -- map.values()
        Collection<String> values = my_map.values();
        for (String temp:values){
            System.out.println(temp);
        }

        // 方法三 -- map.entrySet() + getKet, getValue -- 了解即可
        Set<Map.Entry<Integer,String>> entrys = my_map.entrySet();
        for (Map.Entry<Integer,String> temp:entrys){
            System.out.println(temp.getKey()+"----"+temp.getValue());
        }

    }

    public static void testTable(){

        // 方法一 -- Map + ArrayList
        Map<String, Object> m1 = new HashMap<>();
        m1.put("ID",1);
        m1.put("name","Blake");
        m1.put("height",183);

        Map<String, Object> m2 = new HashMap<>();
        m2.put("ID",2);
        m2.put("name","Bella");
        m2.put("height",127);

        List<Map<String, Object>> people = new ArrayList<>();
        people.add(m1);
        people.add(m2);

        System.out.println("ID\tname\theight\t");
        for (Map<String, Object> person:people){
            System.out.println(person.get("ID")+"\t"
                              +person.get("name")+"\t"
                              +person.get("height"));
        }

        // 方法二 -- JavaBean + ArrayList
        personInfo p1 = new personInfo(1,"Blake",183,1000);
        personInfo p2 = new personInfo(2,"Bella", 130, 100);

        List<personInfo> my_people = new ArrayList<>();
        my_people.add(p1);
        my_people.add(p2);

        System.out.println("ID\tname\theight\tlength");
        for (personInfo person:my_people){
            System.out.println(person.toString());
        }
    }
}

class emp{
    int id;
    String name;

    @Override
    public String toString() {
        return "com.blake.CollectionLearning.emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        emp emp = (emp) o;
        return id == emp.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class personInfo{
    int ID;
    String name;
    int height;
    int length;

    @Override
    public String toString() {
        return  ID + "\t"+
                name + "\t"+
                height + "\t"+ "\t"+
                length ;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public personInfo(int ID, String name, int height, int length) {
        this.ID = ID;
        this.name = name;
        this.height = height;
        this.length = length;
    }
}