package com.blake.IOStreamLearning;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Dec.21
 * 60Apache IO包的使用
 */
public class CommonStreams {

    public static void main(String[] args) {

        fileCopy("/Users/jiayingxuan/Else-to-learn/Java从入门到实战/视频/a.mp4",
                "/Users/jiayingxuan/Else-to-learn/Java从入门到实战/视频/b.mp4");

    }

    private static void readFile(String src){
        try {
            String content = FileUtils.readFileToString(new File(src),"UTF-8");
            System.out.println(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeFile(String dest){
        try {
            FileUtils.write(new File(dest),"I love you","UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readURL(String address){

        try {
            String content = IOUtils.toString(new URL(address).openStream(),"UTF-8");
            System.out.println(content);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void fileCopy(String src,String dest){
        try {
            FileUtils.copyFile(new File(src), new File(dest));
            System.out.println("copy Finished");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void dictionaryCopy(String src, String dest){
        try {
            FileUtils.copyDirectory(new File(src), new File(dest), new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    if(pathname.isDirectory()||pathname.toString().endsWith("png")){
                        return true;
                    }
                    return false;
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
