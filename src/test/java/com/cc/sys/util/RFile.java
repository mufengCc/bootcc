package com.cc.sys.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

/**
 * @Author: cc
 * @Date: 2022/1/14 10:36 上午
 */
public class RFile {


    public static void main(String[] args) {

        try {
            File file = new File("/Users/chencheng0823/cc.txt");
            FileInputStream fis = new FileInputStream(file);

            byte[] buffer = new byte[3];

            int len = 0;
            while ((len = fis.read(buffer)) != -1) {
                byte[] bytes = Arrays.copyOfRange(buffer, 0, len);
                String str = new String(bytes);
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
