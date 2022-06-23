package Networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class NetworkingStudy7_3 {
    public static void main(String[] args) {
            System.out.println("희망하는 닉네임을 입력해주세요.");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();

            String IP = "127.0.0.1";

            try {
                Socket socket = new Socket(IP, 7777);

                Thread sender = new Thread(new Sender2(socket, name));
                Thread receiver = new Thread(new Receiver2(socket));

                sender.start();
                receiver.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }