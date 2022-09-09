package java8.concurrent;

/*
*
* 고수준(High level) Concurrency 프로그래밍
* - 쓰레드를 만들고 관리하는 작업을 분리
* - Executor가 관리함
*
* - 쓰레드를 미리 만들어 쓰레드 풀 관리
* - 쓰레드 생명 주기 관리
* - 쓰레드로 실행할 작업 제공할 수 있는 API
*
* Executor : execute(Runnable)
* ExecutorService : Executor 상속 받은 인터페이스, Callable로 실행 가능, Executor종료 시키거나 동시실행하는 등 기능 제공
* ScheduledExecutorService : ExecutorService를 상속 받은 인터페이스로 특정 시간 이후 주기적 작업 실행 가능
*
*
* shutdown() : 하던 일을 끝까지 마치고 끈다. => graceful shutdown
* shutdownNow() : 도중에 끝날 수도, 끝까지 마치고 끝날 수도 있음.
*
*
* Fork/ Join ? -> MultiProcess
*
* Callable<T> -> Runnable과 달리 리턴값을 가짐
*
* */

/*
*
*
* Executor
* BlockingQueue와 ThreadPool로 구성됨
* BlockingQueue -> 쓰레드 부족할 경우 대기
* ThreadPool -> 쓰레드 미리 만들어놓고 대기
*
*
* */


import java.util.concurrent.*;

public class ExecutorsBasic {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        /*executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread " + Thread.currentThread());
            }
        });
        executorService.shutdown();

        executorService.submit(() -> {
            System.out.println("Thread " + Thread.currentThread());
        });
        executorService.shutdown();*/

        executorService.execute(getRunnable("Runnable1"));
        executorService.execute(getRunnable("Runnable2"));
        executorService.execute(getRunnable("Runnable3"));
        executorService.execute(getRunnable("Runnable4"));
        executorService.execute(getRunnable("Runnable5"));

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
//        scheduledExecutorService.scheduleAtFixedRate(getRunnable("scheduled"), 1, 2, TimeUnit.SECONDS);


        Future<String> future = executorService.submit(getCallable("Callable1"));
        System.out.println(future.isDone());
        System.out.println("started");
        future.get(); // blocking
        System.out.println(future.isDone());
        System.out.println("end");


        executorService.shutdown();



    }

    public static Runnable getRunnable(String message) {
        return () -> System.out.println(message + " " + Thread.currentThread().getName());
    }

    public static Callable<String> getCallable(String message) {
        return () -> {
            System.out.println(message + " " + Thread.currentThread().getName());
            return "OK";
        };
    }
}
