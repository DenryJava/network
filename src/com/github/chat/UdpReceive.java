package com.github.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceive {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(6666);
        //准备接收包裹
        while (true) {
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            socket.receive(packet); // 阻塞式接收包裹
            // 断开连接 bye
            String str = new String(packet.getData());
            System.out.println(str);
            if ("bye".equals(str.trim()))break;
        }
        socket.close();
    }
}
