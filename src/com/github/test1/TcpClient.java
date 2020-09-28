package com.github.test1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

//客户端
public class TcpClient {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            // 得到服务端地址，端口号
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            int port = 9999;
            // 创建socket连接
            socket = new Socket(inetAddress,port);
            // 发送消息
            outputStream = socket.getOutputStream();
            outputStream.write("测试socket连接".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(outputStream != null){
                    outputStream.close();
                }
                if(socket != null){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
