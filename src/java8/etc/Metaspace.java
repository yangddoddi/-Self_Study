package java8.etc;

/*
*
* PermGen 메모리 영역이 없어지고 Metaspace 영역 생김
*
* PermGen
* - 클래스 메타데이터가 담김
* - Heap 영역
* - 기본값으로 제한된 크기를 가지고 있음
* - XX:PermSize=N, PermGen 초기 사이즈 설정
* - XX:MaxPermSize=N, PermGen 최대 사이즈 결졍
*
* Metaspace
* - 클래스 케타데이터를 담는 곳
* - Heap 영역이 아니라, Native 메모리 영역
* - 기본값으로 제한된 크기를 가지고 있지 않음 (따라서 모니터링, 크기 제한)
한 - 자바 8부터는 PermGen관련 Java 설정은 무시
* - XX:MetaspaceSize=N, Metaspace 초기 사이즈 서렂ㅇ
* - XX:MaxMetaspaceSize=N, Metaspace 최대 사이즈 설정
*
* */


public class Metaspace {
}
