package Networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// 채팅프로그램(부)
public class NetworkingStudy6 {
    public static void main(String args[]) {
        try {
            String serverIP = "127.0.0.1";
            Socket socket = new Socket(serverIP, 7777);
            Sender sender = new Sender(socket);
            Receiver receiver = new Receiver(socket);

            sender.start();
            receiver.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
