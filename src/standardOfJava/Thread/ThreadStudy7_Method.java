package standardOfJava.Thread;

// 쓰레드 메서드 정리
public class ThreadStudy7_Method {
    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new ThreadStudy7_1();
        Thread th2 = new ThreadStudy7_2();

        th1.start();
        th2.start();

        th1.sleep(5000);
        System.out.println("main 종료");
    }
}
// static void sleep(long millis, int nanos)
// 실행 결과를 확인해보면 main이 가장 늦게 종료된다. 이유는 무엇일까?
// sleep 메서드는 메서드를 호출한 쓰레드에 작동되기 때문에 th1.sleep()을 호출했지만 멈춘 것은 main이다.
// sleep 메서드는 스태틱 메서드이기 때문에 standardOfJava.Thread.sleep()으로 호출하는 것이 보다 용도에 맞는 방법이다.

class ThreadStudy7_1 extends Thread {
    public void run() {
        for (int i=0; i<300; i++) {
            System.out.print("l");
        }
        System.out.println();
        System.out.println("th1 종료");
    }
}

class ThreadStudy7_2 extends Thread {
    public void run() {
        for (int i=0; i<300; i++) {
            System.out.print("l");
        }
        System.out.println();
        System.out.println("th2 종료");
    }
}