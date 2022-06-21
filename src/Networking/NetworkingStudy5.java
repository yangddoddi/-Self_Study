package Networking;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// 채팅 프로그램
// 넘 재미있다
public class NetworkingStudy5 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // 8080 포트에 serverSocket을 바인딩
            serverSocket = new ServerSocket(7777);
            System.out.println("Server Ready.");
            // 해당 포트로 클라이언트가 요청을 보내면 새로운 소켓을 생성
            socket = serverSocket.accept();

            Sender sender = new Sender(socket);
            Receiver receiver = new Receiver(socket);

            sender.start();
            receiver.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 타임 포멧
    public static String getTime() {
        String pattern = "[hh:mm:ss]";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(new Date());
    }
}

    class Sender extends Thread {
        Socket socket;
        OutputStream output = null;
        DataOutputStream dos = null;

        Sender(Socket socket) throws IOException {
            this.socket = socket;
            output = socket.getOutputStream();
            dos = new DataOutputStream(output);
        }

        public void run() {
            while (dos != null) {
                // 콘솔창에 텍스트를 입력받아 전송
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                try {
                    dos.writeUTF(input);
                    System.out.println();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    class Receiver extends Thread {
        Socket socket;
        InputStream input = null;
        DataInputStream dis = null;

        Receiver(Socket socket) throws IOException {
            this.socket = socket;
            input = socket.getInputStream();
            dis = new DataInputStream(input);
            System.out.println();
        }

        public void run() {
            while (dis !=null ) {
                try {
                    String time = NetworkingStudy5.getTime();
                    String input = dis.readUTF();
                    System.out.println(time + socket.getInetAddress() + "부터 전송된 메세지 : " + input);
                } catch (EOFException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }