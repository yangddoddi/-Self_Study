package standardOfJava.Thread;

// ThreadStudy9에 yield와 inturrpted를 추가하여 반응성 개선
// 이전 코드와 달리 지연시간 없이 별이 출력되는 것을 확인할 수 있다.
public class ThreadStudy10_Method {
    public static void main(String[] args){

        ThreadStudy10_1 th1 = new ThreadStudy10_1("*");
        ThreadStudy10_1 th2 = new ThreadStudy10_1("**");
        ThreadStudy10_1 th3 = new ThreadStudy10_1("***");

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
            th3.suspend();
            th1.resume();
            th1.suspend();
            th2.resume();
            th2.suspend();
            th3.resume();
            th1.stop();
            th2.stop();
            th3.stop();
        } catch (Exception e) {}
    }
}

class ThreadStudy10_1 implements Runnable {
    Thread th;
    volatile boolean suspend =false;
    volatile boolean stop = false;

    ThreadStudy10_1(String name) {
        th = new Thread(this, name); // 기존에 Runnable을 먼저 생성한 뒤 new standardOfJava.Thread(r, "어쩌고")를 해야 했던 것을 한 번에 끝낼 수 있다.
    }

    public void run() {
        while (!stop) {
            if (!suspend) {
                System.out.println(Thread.currentThread().getName());
                try { Thread.sleep(1000);} catch(InterruptedException e) {
                };
            } else {
                Thread.yield();
                // yield 메서드 호출 시 남은 실행 시간을 즉시 다음 실행 예정인 쓰레드에게 양보한다.
                // 만약 해당 쓰레드에 배정된 시간이 2초고 1.5초 작동했다면 즉시 실행을 일시정지하고 나머지 0.5초는 다음 쓰레드가 가지게 된다.
                // 해당 구문에서는 yield를 호출함으로써 이미 아무런 작업도 하지 않고 있는 쓰레드의 작동을 중단시켜 응답성을 향상시킨다.
                // 이렇게 아무런 할 일도 없는대 쓸데 없이 시간만 낭비하는 것을 바쁜 대기상태(busy-waiting)이라고 한다,
            }
        }
        System.out.println(Thread.currentThread().getName() + " - stop ");
    }


    void suspend() {
        this.suspend = true;
        th.interrupt();
        // while - if 문에서 Thread가 sleep 상태일 때 의도적으로 InterruptedException을 발생시켜 즉시 실행을 중단시킨다
    };
    void resume() {
        this.suspend = false;
    };
    void stop() {
        this.stop = true;
        this.suspend = true;
        th.interrupt();
    };
    void start() {
        th.start();
    }
    void setPriority(int num) {
        th.setPriority(num);
    }
}
