package java8.concurrent;

/*
*
* Concurrent Programming ?
* 동시에 여러 기능을 사용할 수 있는 소프트웨어
*
* 자바에서 사용하는 Concurrent ?
* Multi Thread or Multi Process
*
* sleep() 일정 시간 재운다
* interrupt() 재운 쓰레드를 다시 깨운다.
* InterruptedException -> Checked Exception이라 Catch하지 않는 이상 계속 작동함 종료시키고 싶을 경우 활용
* join() 다른 스레드를 기다린다
*
* */

public class ThreadBasic {
    public static void main(String[] args) {



        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread ? " + Thread.currentThread().getName());
            }
        });

        thread.start();
        System.out.println("main ? " + Thread.currentThread().getName());
        // 순서가 보장되지 않음


    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread : " + Thread.currentThread().getName());
        }
    }
}
