package com.github.test1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务端
public class TcpServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            // 创建地址
            serverSocket = new ServerSocket(9999);
            // 等待客户端连接
            socket = serverSocket.accept();
            // 读取客户度消息
            inputStream = socket.getInputStream();
            // 管道流
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int let;
            while((let=inputStream.read(bytes)) != -1){
                byteArrayOutputStream.write(bytes,0,let);
            }
            System.out.println(byteArrayOutputStream.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(byteArrayOutputStream != null){
                    byteArrayOutputStream.close();
                }
                if(inputStream != null){
                    inputStream.close();
                }
                if(socket != null){
                    socket.close();
                }
                if(serverSocket != null){
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
