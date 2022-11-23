package com.yangtze.laboratory.oil.controller;


import com.yangtze.laboratory.oil.utils.ReadXLSX;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * @program: tcpCorrespondence
 * @Author
 * @description
 * @Date 2022/11/3 16:42
 * @Version 1.0
 **/


/**
 * 注意用到的输入输出流DataInputStream和DataOutputStream，成对出现，最好用字节流
 */
// 客户端类，每60s模拟发送250个记录
class CollectAndUpload {//创建公共类
    private String host = "124.222.235.168";
//    private String host = "localhost";
    private int port = 9092;
    private int accpetLen=250;
    private DataOutputStream out=null;
    private DataInputStream in=null;
    private String filename="C:\\Users\\皮皮欣\\Desktop\\2022.9.2测量3.xlsx";
    int len;//excel第一列的行数

    public CollectAndUpload() {

    }

    public CollectAndUpload(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void chat() {
        try {
            //连接到服务器
//            Socket socket = new Socket(host, port);
                Socket socket=new Socket();
                socket.bind(new InetSocketAddress(8899));
                socket.connect(new InetSocketAddress(host,port));
            try {
                in=new DataInputStream(socket.getInputStream());//接收服务器消息
                out = new DataOutputStream(socket.getOutputStream());//向服务器端发送信息的DataOutputStream
                Double[] res = ReadXLSX.readXlsx(filename);
                len=res.length;
                int count=0;

                Double[] sendArrs = new Double[accpetLen];
                for(int loop=0;loop<len;loop+=accpetLen){
                    StringBuilder sb=new StringBuilder();

                    for(int index=loop;index<len&&index<loop+accpetLen;index++){
                        sendArrs[count++]=res[index];
                        sb.append(res[index]+"\t");
                    }
                    count=0;
                    sb.append("\r\n");
                    System.out.println(sb);
                    out.writeUTF(sb.toString());
                    Thread.sleep(100);
                }

//                out.writeBytes(sb.toString());
                socket.shutdownOutput();//告诉服务器发送完毕

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if(out!=null){
                    out.flush();
                    out.close();
                }
                socket.close();//关闭Socket监听
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new CollectAndUpload().chat();//调用chat方法

    }
}