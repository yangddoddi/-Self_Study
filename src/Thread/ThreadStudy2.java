package Thread;

// 싱글 스레드 - 멀티 스레드 작업 속도 차이 (1) 동일 자원 점유시
public class ThreadStudy2 {
    public static void main(String[] args) {
//        long startTime = System.currentTimeMillis();
//
//        for(int i=0; i<1000; i++) {
//            System.out.print(new String("test1"));
//        }
//        System.out.println();
//        System.out.println("test1 소요시간 ? " + (System.currentTimeMillis() - startTime));
//        // 27 25 26 32 20 5회 테스트
//        for(int i=0; i<1000; i++) {
//            System.out.print(new String("test2"));
//        }
//        System.out.println();
//        System.out.println("test1 + test2 소요시간 ? " + (System.currentTimeMillis() - startTime));
//        // 32 34 29 35 32 5회 테스트

        Thread th1 = new CustomThread1();
        Thread th2 = new CustomThread2();
        th1.start();
        th2.start();
        // (33, 33) (45, 44) (56, 45) (40, 40) (33, 35)
        // 멀티쓰레드가 오히려 평균적으로 더 오래 걸렸다.
        // 쓰레드간의 작업 전환(context switching) 시간 때문이다.
        // 한개의 단순 작업은 오히려 싱글 쓰레드로 하는 것이 더 빠르다. (자원 점유)
        // 쓰레드는 OS종속적이기 때문에 어떤 쓰레드가 얼마동안 실행될 것인지 매 순간 상황에 따라 달라지고 불확실하다.
    }
}

class CustomThread1 extends Thread {
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        for(int i=0; i<1000; i++) {
            System.out.print(new String("test1"));
        }
        System.out.println();
        System.out.println("th1 소요시간 ? " + (System.currentTimeMillis() - startTime));
    }
}

class CustomThread2 extends Thread {
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        for(int i=0; i<1000; i++) {
            System.out.print(new String("test2"));
        }
        System.out.println();
        System.out.println("th2 소요시간 ? " + (System.currentTimeMillis() - startTime));
    }
}