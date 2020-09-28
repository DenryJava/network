package com.github.test3;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// 网络资源下载
public class URLDown {
    public static void main(String[] args) throws Exception {
        // 下载地址
        URL url = new URL("https://img2018.cnblogs.com/blog/1110225/201904/1110225-20190412175824905-588629276.png");
        // 连接到该资源 HTTP
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        // 转为流读取
        InputStream inputStream = urlConnection.getInputStream();
        // 文件流输出
        FileOutputStream fileOutputStream = new FileOutputStream("test.pngd");
        byte[] bytes = new byte[1024];
        int let;
        while((let=inputStream.read(bytes)) != -1){
            fileOutputStream.write(bytes,0,let);
        }
        fileOutputStream.close();
        inputStream.close();
        urlConnection.disconnect(); // 断开连接
    }
}
