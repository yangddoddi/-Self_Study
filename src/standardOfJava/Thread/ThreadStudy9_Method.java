package standardOfJava.Thread;

public class ThreadStudy9_Method {
    public static void main(String[] args){
        // 1. suspend()
        // 쓰레드를 멈추게 한다. resume이 호출되어야 재실행된다.
        // 2. resume()
        // 3. stop()
        // 쓰레드를 완전히 소멸시킨다.
        // 이 메서드들은 Deprecated되어 있기 때문에 사용을 지양하는 것이 좋다.
        // 직접 개선된 방법으로 구현할 수 있다.

        ThreadStudy9_1 th1 = new ThreadStudy9_1("*");
        ThreadStudy9_1 th2 = new ThreadStudy9_1("**");
        ThreadStudy9_1 th3 = new ThreadStudy9_1("***");

        th1.start();
        th2.start();
        th3.start();

        try {
            th2.suspend();
            th3.suspend();
            Thread.sleep(1000);
            th1.suspend();
            th2.resume();
            Thread.sleep(1000);
            th2.suspend();
            th3.resume();
            th1.stop();
            th2.stop();
            th3.stop();
        } catch (Exception e) {}
    }
}

class ThreadStudy9_1 implements Runnable {
    Thread th;
    volatile boolean suspend =false;
    volatile boolean stop = false;

    ThreadStudy9_1(String name) {
        th = new Thread(this, name); // 기존에 Runnable을 먼저 생성한 뒤 new standardOfJava.Thread(r, "어쩌고")를 해야 했던 것을 한 번에 끝낼 수 있다.
    }

    public void run() {
        while (!stop) {
            while (!suspend) {
                System.out.println(Thread.currentThread().getName());
                try { Thread.sleep(1000);} catch(InterruptedException e) {
                };
            }
        }
        System.out.println(Thread.currentThread().getName() + " - stop ");
    }


    void suspend() {
        this.suspend = true;
    };
    void resume() {
        this.suspend = false;
    };
    void stop() {
        this.stop = true;
        this.suspend = true;
    };
    void start() {
        th.start();
    }
}
