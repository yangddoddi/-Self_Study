package Networking;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class  NetworkingStudy7 {
    public static void main(String[] args) {
        System.out.println("희망하는 닉네임을 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        String IP = "127.0.0.1";

        try {
            Socket socket = new Socket(IP,7777);

            Thread sender = new Thread(new Sender2(socket, name));
            Thread receiver = new Thread(new Receiver2(socket));

            sender.start();
            receiver.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

class Sender2 extends Thread {
    DataOutputStream output;
    Socket socket;
    String name;

    Sender2(Socket socket, String name) {
        this.socket = socket;
        try {
            this.name = name;
            output = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) { e.printStackTrace(); }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            if (output != null) {
                output.writeUTF(name);
            }
            while (output != null) {
                    output.writeUTF("[" + name + "] : " + scanner.nextLine());
            }
//            scanner.close();
//            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

    class Receiver2 extends Thread {
        DataInputStream input;
        Socket socket;

        Receiver2(Socket socket) {
            this.socket = socket;
            try {
                input = new DataInputStream(socket.getInputStream());
            } catch (IOException e) { e.printStackTrace(); }
        }

        public void run() {
            if (input != null) {
                try {
                    System.out.println(input.readUTF());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }