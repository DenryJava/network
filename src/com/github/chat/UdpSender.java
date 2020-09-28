package com.github.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UdpSender {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(8888);
        // 数据 :: 控制台读取
        while(true){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str = reader.readLine();
            DatagramPacket packet = new DatagramPacket(str.getBytes(), 0,
                    str.getBytes().length, new InetSocketAddress("127.0.0.1", 6666));
            //发送
            socket.send(packet);
            if("bye".equals(str))break;
        }
        socket.close();
    }
}
