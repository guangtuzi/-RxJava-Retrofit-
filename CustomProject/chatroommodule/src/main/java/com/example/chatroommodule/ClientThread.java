package com.example.chatroommodule;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Administrator on 2016/12/7.
 */
public class ClientThread extends Thread {
    private BufferedReader br = null;

    public ClientThread(BufferedReader br) throws IOException {
        this.br = br;
    }

    @Override
    public void run() {
        try {
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println("来自服务器的消息：" + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
