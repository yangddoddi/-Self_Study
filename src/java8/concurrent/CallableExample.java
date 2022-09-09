package java8.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<String> golang = () -> {
            Thread.sleep(4000);
            return "golang";
        };

        Callable<String> java = () -> {
            Thread.sleep(2000);
            return "java";
        };

        Callable<String> node = () -> {
            Thread.sleep(3000);
            return "node";
        };

        Callable<String> js = () -> {
            Thread.sleep(1000);
            return "js";
        };

        Callable<String> spring = () -> {
            Thread.sleep(1000);
            return "spring";
        };

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(js, spring, node, java, golang));
        // 끝까지 기다려서 한 번에 실행
        futures.stream()
                .forEach(e-> {
                    try {
                        System.out.println(e.get());
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    } catch (ExecutionException ex) {
                        throw new RuntimeException(ex);
                    }
                });

        String s = executorService.invokeAny(Arrays.asList(js, spring, node, java, golang));
        System.out.println("비동기 "  + s);

        executorService.shutdown();
    }

}
