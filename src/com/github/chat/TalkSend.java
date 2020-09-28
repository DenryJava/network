package com.github.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TalkSend implements Runnable {
    DatagramSocket socket = null;
    BufferedReader reader = null;

    private int fromPort;
    private String toIP;
    private int toPort;

    public TalkSend(int fromPort, String toIP, int toPort) {
        this.fromPort = fromPort;
        this.toIP = toIP;
        this.toPort = toPort;
        try {
            socket = new DatagramSocket(fromPort);
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        while (true) {
            try {
                String str = reader.readLine();
                DatagramPacket packet = new DatagramPacket(str.getBytes(), 0,
                        str.getBytes().length, new InetSocketAddress(this.toIP, this.toPort));
                //发送
                socket.send(packet);
                if ("bye".equals(str.trim())) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
