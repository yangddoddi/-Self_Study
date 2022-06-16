package Thread;

public class ThreadStudy1 {
    public static void main(String[] args) { // 우리가 평소에 사용하는 main도 하나의 쓰레드이다.
        // 클래스 상속 방식
        MyThread2 t1 = new MyThread2();
        // 인터페이스 구현 방식
        Runnable r = new MyThread1();
        Thread t2 = new Thread(r);
//        Thread t2 = new Thread(new MyThread1()); 위 두 줄과 같은 코드임.
        // Runnable 인터페이스에서 생성한 클래스의 인스턴스를 먼저 생성하고 Thread의 인자로 준다.
        t1.setName("나는 Runnable을 구현한 쓰레드다!");
        t2.setName("나는 Thread를 구현한 쓰레드다!");
        // setName을 사용하지 않으면 그냥 thread-0, thread-1 이렇게 나옴.

        t1.start();
        t2.start();
        // start 메서드가 호출되면 실행 대기 상태 -> 자신의 차례가 되어야 실행
        // 실행이 종료된 쓰레드는 다시 실행할 수 없다. 재실행하고 싶으면 쓰레드를 다시 생성해야함. (작업을 완료한 호출 스택은 소멸되기 때문)

    }
}




// Runnable을 구현하는 방법이 더 보편적이다(재사용성, 코드의 사용성, 상속에서 Thread 상속보다 유리)
// Thread 직접 상속 시 조상인 Thread의 값을 직접 호출 가능하다.
// Runnable 구현 시에는 Thread 클래스의 static 메서드인 current Thread()를 호출하여 쓰레드에 대한 참조를 얻어 와야만 호출 가능
class MyThread1 implements Runnable {
    @Override
    public void run() {
        for(int i=0; i< 5; i++) {
            System.out.println(Thread.currentThread().getName()); // 현재 실행 중인 쓰레드 반환
        }
    }
}

class MyThread2 extends Thread {
    public void run() {
        for(int i=0; i< 5; i++) {
            System.out.println(getName()); // 조상인 Thread의 getName 호출
        }

        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        의도적으로 예외를 발생시키고 printStackTrace 메서드를 사용했을 때
        // run으로 작동 시 에러 메세지가 "main"메서드에서 발생했다고 나오지만
        //  start로 작동 시 "run"에서 발생했다고 나옴
        // run으로 작동 시에는 기존의 main thread에서 실행했기 때문에 에러가 main의 몫이지만
        // start로 작동 시 새로운 호출 스택을 만들었고 main은 작동이 끝난 상태이기 때문
        // => main의 호출 스택이 소멸되어도 다른 쓰레드가 작동이 끝날 때까지 프로그램은 종료되지 않는다.
    }
}
