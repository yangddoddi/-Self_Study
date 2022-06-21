package Networking;
// 소켓 ? 프로세스간 통신에 사용되는 양쪽 끝단을 의미

// TCP/IP 프로토콜
// 이기종 시스템간의 통신을 위한 표준 프로토콜. 프로토콜의 집합.
// OSI 7계층의 전송계층에 해당하는 프로토콜.
// TCP, UDP 모두 TCP/IP 프로토콜에 포함되어 있다.

// TCP
// 연결 기반( like 전화기, 1:1 통신 )
// 데이터의 경계를 구별하지 않음 (byte-stream)
// 신뢰성 있는 전송( 전송 순서 보장, 수신 여부 확인, 패킷 관리 필요 x )
// UDP보다 전송 속도 느림
// >> Soket, ServerSoket

// UDP
// 비연결기반(connectionless-oriented) : 연결 없이 통신(like 소포) 1:1, 1:n, n:n 방식
// 데이터의 경계를 구분함 (datagram)
// 전송 신뢰도⬇️ ( 전송 순서 보장x, 수신 여부 확인x, 패킷 관리 필요 o )
// TCP보다 전송 속도 빠름
// DatagramSoket, DatagramPacket, MulticastSocket

// TCP 소켓 프로그래밍에서 서버 프로그램과 클라이언트 프로그램간의 통신과정
// 1. 서버 프로그램 : 서버소켓을 사용해서 서버 컴퓨터의 특정 포트에서 클라이언트의 연결 요청 처리 준비
// 2. 클라이언트 프로그램 : 접속할 서버의 ip 주소와 포트 정보를 가지고 소켓 생성, 서버 연결 요청
// 3. 서버 소켓 : 서버에 새로운 소켓을 생성해서 클라이언트의 소켓과 연결.
// 4. 클라이언트 소켓 <-> 새로 생성된 소켓 >> 서버 소켓과 관계 없이 1:1통신
// like ( 서버 소켓 == 전화 교환기, 생성된 소켓 == 전화기 )
// 하나의 호스트가 가진 포트 개수 65536 (0~65535번)
// => 1023번 이하 포트는 FTP, Telnet같은 기존 통신 프로그램들이 사용
// 소켓은 입력 스트림과 출력 스트림을 가지고 있으며 연결된 상대 소켓의 스트림과 교차연결된다.(like 건전지 + -)
// Soket 클래스 -> 프로세스 통신 담당, 스트림을 가지고 있다.
// ServerSocket 클래스 -> 포트와 bind되어 연결 요청 대기, Socket 생성하여 통신이 이루어지도록 함.

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NetworkingStudy3 {
    public static void main(String[] args) {
        // 서버로부터 데이터 출력 (서버)
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(7777); // 8080 포트와 서버 소켓 결합
            System.out.println(getTime() + " 서버 준비 완료");
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                System.out.println(getTime() + " 연결 대기 중 ");
                // 클라이언트 요청 시까지 계속 대기하기 때문에 NetworkingStudy4 예제에서 요청을 보내지 않으면 여기서 더이상 진행되지 않는다.
                Socket socket = serverSocket.accept();
                System.out.println(getTime() + " " + socket.getInetAddress() + "로부터 연결");
                // 소켓의 출력 스트림 얻기
                OutputStream os = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);

                // 원격 소켓에 데이터 전송
                dos.writeUTF("서버로부터 전송된 메시지입니다.");
                System.out.println(getTime() + " 데이터 전송 완료");

                dos.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
        static String getTime() {
            String pattern = "[hh:mm:ss]";
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
            return formatter.format(new Date());
        }    // 서버로부터 데이터 입력 (클라이언트)
}
