package Thread;

public class ThreadStudy4 {
    public static void main(String[] args) {
        Thread th1 = new CustomThread5();
        Thread th2 = new CustomThread6();

        th1.setPriority(5);// 기본값이다. 쓰레드의 우선순위는 1~10이며 main의 우선순위는 5로 설정되어 있다.
        th2.setPriority(7);

        th1.start();
        th2.start();
        // 멀티코어 환경에서 실행시 우선순위를 줘도 41초 48초로 큰 차이가 없다.
        // 우선 순위를 준다고 해서 더 많은 실행시간과 실행기회를 갖게될 것이라고 기대할 수 없다.
        // OS 종속이기 때문에 OS의 스케줄링 방식을 따르므로 복잡하고, 만약 각각 OS에서의 스케줄링을 모두 이해하고 프로그래밍해도 동일한 결과를 기대하기 힘들다.
        // 차라리 우선순위 큐(Priority Queue)를 활용하는 것이 나을 수도 있다.
    }
}

class CustomThread5 extends Thread {
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        for(int i=0; i<1000; i++) {
            System.out.print(new String("1"));
        }
        System.out.println();
        System.out.println("th1 소요시간 ? " + (System.currentTimeMillis() - startTime));
    }
}

class CustomThread6 extends Thread {
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        for(int i=0; i<1000; i++) {
            System.out.print(new String("2"));
        }
        System.out.println();
        System.out.println("th2 소요시간 ? " + (System.currentTimeMillis() - startTime));
    }
}