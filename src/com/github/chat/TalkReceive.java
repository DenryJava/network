package com.github.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable{
    DatagramSocket socket = null;
    private int port;
    private String msgFrom;

    public TalkReceive(int port,String msgFrom){
        this.port = port;
        this.msgFrom = msgFrom;
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        //准备接收包裹
        while (true) {
            try {
                byte[] container = new byte[1024];
                DatagramPacket packet = new DatagramPacket(container, 0, container.length);
                socket.receive(packet); // 阻塞式接收包裹
                // 断开连接 bye
                String str = new String(packet.getData());
                System.out.println(msgFrom+"--："+str);
                if ("bye".equals(str.trim()))break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
