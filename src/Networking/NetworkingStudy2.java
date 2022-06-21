package Networking;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
// URL(Uniform Resource Locator)
// 프로토콜:://호스트명:포트번호/경로명/파일명?쿼리스트링#참조
// http or https(프로토콜) 자원에 접근하기 위해 서버와 통신하는데 사용되는 통신규약
// www.naver.com(호스트명) 자원을 제공하는 서버의 이름
// :80(포트 번호) 통신에 사용되는 서버의 포트 번호
// /weptoon(경로명) 접근하려는 자원이 저장된 서버상의 위치
// (index.html)(파일명) 접근하려는 자원의 이름
// 쿼리(query) url에서 ? 이후의 부분
// 참조(anchor) url에서 #이후의 부분

public class NetworkingStudy2 {
    public static void main(String[] args) {
        String address = "https://post.naver.com/viewer/postView.naver?memberNo=49797427&volumeNo=33989584";
        URL url = null;
        BufferedReader br = null;
        String line = "";

        // url에 접속해서 내용을 읽어오는 예제
        try {
            url = new URL (address);
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            while((line=br.readLine())!=null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    static void URLConnectionMethod () {
        URL url = null;
        String address = "https://post.naver.com/viewer/postView.naver?memberNo=49797427&volumeNo=33989584";

        try {
            url = new URL(address);
            URLConnection com = url.openConnection();
            // 어플리케이션과 URL간의 통신 연결을 나타내는 최상위 클래스.(추상 클래스다.)
            // 연결하고자하는 자원에 접근하고 읽고 쓰기를 할 수 있다.

            System.out.println("connecion.toString : " + com.toString());
            System.out.println("getAllowUserInteraction : " + com.getAllowUserInteraction());
            // UserInteraction의 허용 여부를 반환한다.
            System.out.println("getConnectTimeout() : " + com.getConnectTimeout());
            // 연결 종료 시간을 반홚나다
            System.out.println("getContent() : " + com.getContent());
            // content 객체를 반환한다.
            System.out.println("getContentEncoding() ? " + com.getContentEncoding());
            // content의 encoding을 반환한다.
            System.out.println("getContentLength() : " + com.getContentLength());
            // content의 길이를 반환한다.
            System.out.println("com.getContentType() : " + com.getContentType());
            // content의 type을 반환한다.
            System.out.println("com.getDate() : " + com.getDate());
            // 헤더의 date필드값을 확인한다.
            System.out.println("com.getDefaultUseCaches() : " + com.getDefaultUseCaches());
            // UseCaches의 디폴트 값을 얻는다.
            System.out.println("com.getDoInput() : " + com.getDoInput());
            // doInput의 값을 반환한다
            System.out.println("com.getDoInput() : " + com.getDoOutput());
            // doOutput..
            System.out.println("com.getExpiration() : " + com.getExpiration());
            //URL 만료일자를 얻는다
            System.out.println("com.getHeaderField() : " + com.getHeaderFields());
            // 모든 필드와 값이 저장된 MAP을 얻는다.
            System.out.println("com.getIfModifiedSince() : " + com.getIfModifiedSince());
            // (변경여부)필드의 값을 반환한다.
            System.out.println("com.getReadTimeout() : " + com.getReadTimeout());
            // 읽기 제한 시간의 값을 반환한다.
            System.out.println("com.getURL() : " + com.getURL());
            // URL Connection의 URL 반환
            System.out.println("com.getUseCaches() : " + com.getUseCaches());
            // 캐쉬 사용 여부 반환
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}