package standardOfJava.Networking;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

// NetworkingStudy3과 이어지는 소켓 네트워킹 기초 예제
public class NetworkingStudy4 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 7777); // 127.0.0.1은 자신의 컴퓨터를 의미한다.

            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            System.out.println("서버로부터 전송 받은 메세지 : " + dis.readUTF());

        } catch (IOException e) { e.printStackTrace(); }
    }

    static String getTime() {
        String pattern = "[hh:mm:ss]";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(new Date());
    }
    }