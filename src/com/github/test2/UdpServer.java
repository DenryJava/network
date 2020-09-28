package com.github.test2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServer {
    public static void main(String[] args) throws Exception {
        // 开发端口
        DatagramSocket socket = new DatagramSocket(9090);
        // 接收数据包
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);
        // 接收
        socket.receive(packet);
        System.out.println(new String(packet.getData()));
        socket.close();
    }
}
