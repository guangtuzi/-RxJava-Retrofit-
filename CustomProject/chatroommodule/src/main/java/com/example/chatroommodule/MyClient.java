package com.example.chatroommodule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Administrator on 2016/12/7.
 */
public class MyClient {
    private static final int SERVER_PORT = 30000;
    private Socket socket;
    private PrintStream ps;
    private BufferedReader brServer;
    private BufferedReader keyIn;

    public MyClient(String username) {
        init(username);
    }

    public void init(String username) {
        try {
            keyIn = new BufferedReader(new InputStreamReader(System.in));
            socket = new Socket("127.0.0.1", SERVER_PORT);
            ps = new PrintStream(socket.getOutputStream());
            brServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String tip = "";
            // 要求输入用户名
            while (true) {
                ps.println(MyProtocol.USER_ROUND + username + MyProtocol.USER_ROUND);
                String result = brServer.readLine();
                if (result.equals(MyProtocol.NAME_REP)) {
                    tip = "用户名重复！请重新";
                    continue;
                }
                if (result.equals(MyProtocol.LOGIN_SUCCESS)) {
                    break;
                }
            }
        } catch (UnknownHostException hostEx) {
            // 找不到服务器时，关闭网络资源，并退出程序
            System.out.println("找不到远程服务器,请确定服务器已经启动");
            closeRs();
            System.exit(1);
        } catch (IOException e) {
            System.out.println("网络异常！请重新登录");
            closeRs();
            System.exit(1);
        }
        try {
            new ClientThread(brServer).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readAndSend() {
        try {
            String line = null;
            while ((line = keyIn.readLine()) != null) {
                // 如果发送的消息中有冒号，且以//开头,则认为想发私聊信息
                if (line.indexOf(":") > 0 && line.startsWith("//")) {
                    line = line.substring(2);
                    ps.println(MyProtocol.PRIVATE_ROUND
                            + line.split(":")[0] + MyProtocol.SPLIT_SING + line.split(":")[1]
                            + MyProtocol.PRIVATE_ROUND);
                } else {
                    ps.println(MyProtocol.MSG_ROUND + line + MyProtocol.MSG_ROUND);
                }
            }
        } catch (IOException e) {
            System.out.println("网络异常！请重新登录");
            closeRs();
            System.exit(1);
        }
    }

    //　关闭资源
    private void closeRs() {
        try {
            if (ps != null) {
                ps.close();
            }
            if (brServer != null) {
                brServer.close();
            }
            if (keyIn != null) {
                keyIn.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {

        }
    }
}
