package com.yangtze.laboratory.oil.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * @program: tcpClient
 * @Author 陈欣
 * @description 将txt文件的数据读出来,返回double数组
 * @Date 2022/11/6 19:32
 * @Version 1.0
 **/

public class ReadTxt {
    /**
     *
     * @param pathname 要读取的文件，包括文件路径和名字
     * @param length 表示一次要读取的数据长度
     * @return
     * @throws Exception
     */
    public static Double[] ReadTxtToDoubleArr(String pathname,int length) throws Exception{
        Double[] buffer=new Double[length];
        Double[] ans=null;
        Double temp;
        File file=new File(pathname);
        InputStreamReader reader=new InputStreamReader(new FileInputStream(file));//建立一个输入流对象reader
        BufferedReader br=new BufferedReader(reader);//建立一个对象，它把文件内容转成计算机能读懂的语言
        String line="";
        line=br.readLine();
        int index=0;
        while(line!=null){
            temp=Double.valueOf(line.trim());
            buffer[index++]=temp;
            line=br.readLine();//一次读入一行数据
        }
        if(index!=length) {
            ans = new Double[index];
            for (int loop = 0; loop < index; loop++)
                ans[loop] = buffer[loop];
        }
        return ans;
    }

    public static void mainTest(String[] args) throws Exception {
        Double[] re=ReadTxt.ReadTxtToDoubleArr("D:\\STUDY\\tcpClient\\src\\main\\resources\\txts\\a.txt",250);
        for(Double a:re)
            System.out.println(a);
    }
}
