package com.blake.IOStreamLearning;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Dec.20
 * 57IO流是什么-四大抽象类
 * 58一个经典的IO流程序-实现文件读写
 */

public class ioStream {

    public static void main(String[] args) {

        copyBuffered("/Users/jiayingxuan/Downloads/a.txt","/Users/jiayingxuan/Downloads/b.txt");

    }

    public static void testReadFile(){
        try (FileInputStream fis = new FileInputStream("/Users/jiayingxuan/Downloads/a.txt");){

            StringBuilder message = new StringBuilder();
            int temp = 0;
            while ((temp = fis.read())!=-1){
                message.append((char)temp);
            }
            System.out.println(message);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void testWriteFile(){
        try (FileOutputStream fos = new FileOutputStream("/Users/jiayingxuan/Downloads/a.txt");){

            fos.write("Blake".getBytes());

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void copyBuffered(String src, String dest){

        try (FileInputStream fis = new FileInputStream(src); FileOutputStream fos = new FileOutputStream(dest);){
            byte[] buffer = new byte[1024];            // 缓存，Buffer
            while ((fis.read(buffer)) != -1){
                fos.write(buffer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
