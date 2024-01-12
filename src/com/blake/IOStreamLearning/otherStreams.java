package com.blake.IOStreamLearning;

import java.io.*;
import java.util.ArrayList;

/**
 * Dec.20
 * 59IO流体系介绍
 */

public class otherStreams {

    public static void main(String[] args) {

        writeObject("/Users/jiayingxuan/Else-to-learn/Java从入门到实战/视频/58一个经典的IO流程序-实现文件读写.mp4");
        readObject("/Users/jiayingxuan/Else-to-learn/Java从入门到实战/视频/58一个经典的IO流程序-实现文件读写.mp4");

    }

    // 普通字符流 file
    public static void fileCopy(String src,String dest){
        try(FileReader fr = new FileReader(src);
            FileWriter fw = new FileWriter(dest);){

            int temp;
            while((temp = fr.read()) != -1){
                fw.write(temp);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // 缓冲字符流 file
    public static void fileCopyBuffered(String src,String dest){
        try(BufferedReader br = new BufferedReader(new FileReader(src));
            BufferedWriter bw = new BufferedWriter(new FileWriter(dest));){

            String temp = "";
            while ((temp = br.readLine()) != null){
                bw.write(temp);
                bw.newLine();
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // 字节数组流 byte[]
    public static void byteArrayStream(byte[] bytes){

        int temp;
        int num = 0;

        try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes)){

            while ((temp = bis.read()) != -1){
                System.out.println((char) temp);
                num++;
            }
            System.out.println("一共有字节"+num);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // 数据流 String和基本数据类型 write -> 二进制文件
    public static void writeData(String dest){
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(dest))) {

            dos.writeInt(2);
            dos.writeUTF("I love Java");
            dos.writeByte('y');

            dos.flush();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } ;
    }

    // 数据流 String和基本数据类型 read -> 二进制文件
    public static void readData(String src){
        try(DataInputStream dis = new DataInputStream(new FileInputStream(src))){

            // 数据类型顺序需要提前知道
            System.out.println(dis.readInt());
            System.out.println(dis.readUTF());
            System.out.println(dis.readByte());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 对象流 Objects write
    public static void writeObject(String dest){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dest))){

            ArrayList<User> l = new ArrayList<>();

            l.add(new User(1,"Blake","123"));
            l.add(new User(2,"NN","234"));
            l.add(new User(3,"Bella","345"));

            oos.writeObject(l);
            oos.flush();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 对象流 Objects read
    public  static void readObject(String src){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(src))){

            ArrayList<User> l = (ArrayList<User>)ois.readObject();
            for(User u:l){
                System.out.println(u.getID()+"\t"+u.getName()+"\t"+u.getPwd());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

class User implements java.io.Serializable{
    private int ID;
    private String name;
    transient String pwd;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public User(int ID, String name, String pwd) {
        this.ID = ID;
        this.name = name;
        this.pwd = pwd;
    }
}
