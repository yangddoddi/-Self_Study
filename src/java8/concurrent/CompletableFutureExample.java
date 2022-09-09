package java8.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/*
*
* 별다른 설정을 하지 않는다면 ForkJoinPool의 commonPool 사용
* 설정 시 대체 가능
*
* */

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.completedFuture("하하");

        CompletableFuture.runAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
        }); // 리턴 타입 없는 경우

        CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync " + Thread.currentThread().getName());
            return "supplyAsync";
        }); // 리턴 있는 경우

        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync.andThen " + Thread.currentThread().getName());
            return "supplyAsync.andThen";
        }).thenApply((s) -> {
            System.out.println("supplyAsync.thenApply finish " + Thread.currentThread().getName());
            return "supplyAsync.thenApply finish";
        }); // 비동기로 작업을 이어나가려는 경우

        stringCompletableFuture.get();


        CompletableFuture<String> stringCompletableFuture1 = hello().thenCompose(s -> bye());
        stringCompletableFuture.get(); // 서로 의존성 있는 경우

        hello().thenCombine(bye(), (h, w) ->
                h + " " + w); // 의존성 없는 경우 둘 다 실행하고 한 번에 출력

        CompletableFuture.allOf(hello(), bye())
                .thenAccept((result) -> {
                    System.out.println(result.toString());
                    // 중간에 예외가 발생할 수도 있고 타입이 다를 수도 있어서 이런 식으로는 의미가 없다
                });

        List<CompletableFuture> futures = Arrays.asList(hello(),bye());
        CompletableFuture[] completableFutures = futures.toArray(new CompletableFuture[futures.size()]);
        CompletableFuture<List<Object>> result = CompletableFuture.allOf(completableFutures)
                .thenApply(v -> {
                    return futures.stream()
                            .map(CompletableFuture::join)
                            .collect(Collectors.toList());
                });

        List<Object> objects = result.get();
        objects.stream().forEach(e -> System.out.println("hehe " + e));
        // 모든 작업을 기다렸다가 마지막에 반환값 만들기

        CompletableFuture.anyOf(hello(), bye())
                .thenAccept((ss) -> {
                    System.out.println(ss.toString());
                    // 아무거나 빨리 끝나는 거 하나만 리턴함
                });
    }

    public static CompletableFuture<String> hello() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return " ok ";
        });
    }


    public static CompletableFuture<String> bye() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Bye" + Thread.currentThread().getName());
            return " ok ";
        });
    }
}