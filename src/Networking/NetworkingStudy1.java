package Networking;

// 네트워킹 : 두 대 이상의 컴퓨터를 연결하여 네트워크를 구성하는 것
// 서버(sever) 서비스를 제공하는 컴퓨터(provider)
// 클라이언트(client) 서비스를 사용하는 컴퓨터(user)
// 일반 PC는 주로 클라이언트 역항를 하지만 Tomcat같은 프로그램을 설치하면 서버 역할도 수행할 수 있다.
// 전용 서버를 두는 것(서버 기반 모델) 각 클라이언트가 서버 역할을 동시에 수행하는 것(peer to peer ->P2P모델)

// 서버 기반 모델
// 안정적 서비스 제공, 공유 데이터 관리와 보안 용이, 서버 구축 비용과 관리 비용 ⬆️

// P2P 모델
// 서버 구축 및 운용 비용 절감, 자원 활용 극대화, 보안 취약, 자원 관리 난이도 ⬆️

// IP
// 4 byte(32bit)의 정수로 구성되어 있고 네개의 부호('.')로 1byte값(0~255 정수)이 구분되어 있는 형태이다.

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class NetworkingStudy1 {
    public static void main(String[] args) {
        InetAddress ip = null; // IP 주소를 다루기 위한 클래스
        InetAddress[] ipArr = null;

        try {
            // 도메인명을 통해 IP 주소를 받는다.
            ip = InetAddress.getByName("www.naver.com");
            // 호스트의 이름을 반환한다.
            System.out.println("getHostName() : " +ip.getHostName());
            // 호스트이 IP주소를 반환한다.
            System.out.println("getHostAdress() : " +ip.getHostAddress());
            //
            System.out.println("toString : " + ip.toString());

            // IP주소를 byte 배열로 반환한다.
            byte[] ipAddr = ip.getAddress();
            System.out.println("getAddress() : " + Arrays.toString(ipAddr));

            String result = "";
            for(int i=0; i<ipAddr.length; i++) {
                result += (ipAddr[i]<0) ? ipAddr[i] + 256 : ipAddr[i];
                result += ".";
            }
            System.out.println("getAddress()+256 : " + result);
            System.out.println();

        } catch (UnknownHostException e){
            e.printStackTrace();
        }

        try {
            ipArr = InetAddress.getAllByName("www.naver.com");
            // 도메인 명에 지정된 모든 호스트 주소 반환
            for(int i=0; i< ipArr.length; i++) {
                System.out.println("ipArr["+i+"] : " + ipArr[i]);
            }
        } catch (UnknownHostException e) { e.printStackTrace();
    }
}
}