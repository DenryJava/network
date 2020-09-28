package com.github.test2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {
    public static void main(String[] args) throws Exception {
        // 建立一个socket
        DatagramSocket socket = new DatagramSocket();
        // 建个包
        String msg = "你好，服务器";
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        int port = 9090;
        DatagramPacket packet = new DatagramPacket(msg.getBytes(),0,msg.getBytes().length,inetAddress,port);
        // 发送包
        socket.send(packet);
        socket.close();
    }
}
