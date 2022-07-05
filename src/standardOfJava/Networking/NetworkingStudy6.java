package standardOfJava.Networking;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

// 채팅프로그램(부)
public class NetworkingStudy6 {
    // 클라이언트가 서버에 접속하면 HashMap에 저장, 접속을 해제하면 HashMap에서 제거.
    // 클라이언트의 데이터 입력 -> HashMap의 value에 저장 -> 각 클라이언트에게 전송
    ConcurrentHashMap<String,DataOutputStream> clients;
    NetworkingStudy6() {
//        clients = new HashMap<standardOfJava.String, DataOutputStream>();
//        Collections.synchronizedMap(clients);
        clients = new ConcurrentHashMap<>();
        // HashMap이 쓰레드에 동기적으로 작동하도록 지정
    }

    public void start () {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(7777);
            System.out.println("Server Ready..");
            // 서버 소켓을 8080포트에 바인딩
            while(true) {
                socket = serverSocket.accept();
                // 8080 포트로 클라이언트 요청이 들어오면 새로운 소켓을 생성
                ReceiveManager receiveManager = new ReceiveManager(socket);
                receiveManager.start();
                // 새로운 클라이언트가 연결될 때마다 새로운 쓰레드 할당
                // 해당 쓰레드는 종료 전까지 계속해서 메인 소켓 관리를 담당한다.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        }

    void sendToAll(String msg) throws IOException {
        Iterator it = clients.keySet().iterator();
        while(it.hasNext()) {
            try {
                DataOutputStream out = (DataOutputStream) clients.get(it.next());
                out.writeUTF(msg);
            } catch (IOException e) { e.printStackTrace(); }
            // clients의 각 key에
        }
    }

    public static void main(String[] args) {
        new NetworkingStudy6().start();
    }

    class ReceiveManager extends Thread {
        DataInputStream dis;
        DataOutputStream dos;
        Socket socket;

        ReceiveManager(Socket socket) {
            this.socket = socket;
            try {
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) { e.printStackTrace(); }
        }

        public void run() {
            String name = "";
            try {
                name = dis.readUTF();
                sendToAll(name + "님이 입장하셨습니다.");
                clients.put(name, dos);
                // 클라이언트의 아이디와 해당 클라이언트가 입력하는 데이터를 hashMap에 저장
                System.out.println("접속자 수 : " + clients.size());
                while(dis!=null) {
                    sendToAll(dis.readUTF());
                }
            } catch (IOException e) {
                // 접속 종료시 에러 메세지 무시
            } finally {
                // 접속이 종료될 경우(dis=null)
                try {
                    sendToAll(name + "님이 접속을 종료했습니다.");
                    clients.remove(name);
                    System.out.println(socket.getInetAddress() + " 에서 접속 종료");
                    System.out.println("남은 인원 : " + clients.size() + "명");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

