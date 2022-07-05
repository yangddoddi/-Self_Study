package standardOfJava.Thread;

public class ThreadStudy11_Method {
    public static void main(String[] args) throws InterruptedException {
        ThreadStudy11_1 th = new ThreadStudy11_1("th");
        th.setDaemon(true);
        th.start();
        int requiredMemory = 0;

        for(int i=0; i<20; i++) {
            try {
            Thread.sleep(1000); }
            catch(InterruptedException e) {}
            requiredMemory = (int)(Math.random()*300);
            if ((th.freeMemory() < requiredMemory)) {
                th.interrupt();
                th.join(2000);
                // join() 메서드는 쓰레드의 작동을 중단시키고 해당 쓰레드에게 쓰레드 작동을 넘긴다
                // sleep()과 가장 큰 차이는 스태틱 메서드가 아니라 특정 쓰레드에 대해 작동하는 메서드라는 것이다.
            }
            th.usedMemory += requiredMemory;
            System.out.println(th.usedMemory);
        }
    }
}

class ThreadStudy11_1 implements Runnable {
    Thread th;
    ThreadStudy11_1(String name) {
        th = new Thread(this, name);
    }

    final int MAX_MEMORY = 1000;
    int usedMemory = 0;

    public void run() {
        while(true) {
            try {
            Thread.sleep(10000); }
            catch (InterruptedException e) {
                System.out.println("Awaken by interrupted.");
            }
            gc();
            System.out.println("Garbage Collected. Free Memory : " + freeMemory());
        }
    }
    public void start() {
        th.start();
    }
    public void gc() {
        usedMemory -= 300;
        if (usedMemory<0) { usedMemory=0; }
    }
    public void join(int millis) throws InterruptedException {
        th.join(millis);
    }
    public void interrupt() {
        th.interrupt();
    }
    public void setDaemon(boolean bool) {
        th.setDaemon(bool);
    }
    public int freeMemory() {
        return MAX_MEMORY-usedMemory;
    }
}