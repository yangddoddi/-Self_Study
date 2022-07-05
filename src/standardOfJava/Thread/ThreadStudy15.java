package standardOfJava.Thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

// https://blog.naver.com/2feelus/220732310413 참고용 블로그 포스팅
// fork & join frameWork
// 하나의 작업을 가장 작은 단위까지 fork(분산)한 뒤
// 가장 작은 단위부터 다시 join(취합)하여 결과물을 리턴한다. (재귀함수를 이용한 분할 정복 알고리즘과 흡사하다)
// fork로 만들어진 작업 큐가 끝났으나 다른 작업 큐가 실행중일 때는 해당 큐에서 work stealing하여 쓰레드가 쉬지 않고 최대한으로 일해서 빠른 속도로 작업을 처리하게 돕는다.
public class ThreadStudy15 {
    static final ForkJoinPool pool = new ForkJoinPool();
    public static void main(String[] args) {
        long from = 1L, to = 100_000_000L;
        SumTask task = new SumTask(from,to);

        long start = System.currentTimeMillis();
        Long result = pool.invoke(task);
        System.out.println("Elapsed time(4 Core):" + (System.currentTimeMillis()-start));

        System.out.printf("sum of %d~%d=%d%n", from, to, result);
        System.out.println();
        result = 0L;
        start = System.currentTimeMillis();
        for(long i=from; i<=to; i++) {
            result += i;
        }
        System.out.println("Elapesd time(1 Core):"+(System.currentTimeMillis()-start));
        System.out.printf("sum of %d~%d=%d%n", from, to, result);
        // 결과를 보면 결국 for문으로 계산한 것이 두배가량 더 빠르다.
        // 최대한 나눠서 계산했을 때 효율을 얻을 수 있는 작업이 아닌 이상 join fork가 필요하지는 않다.
        // 작업을 나누고 합치는데 시간이 걸리기 때문이다.
    }
}

class SumTask extends RecursiveTask<Long> {
    long from;
    long to;

    SumTask(long from, long to) {
        this.from = from;
        this.to = to;
    }
    public Long compute() {
        long size = to - from + 1;
        if(size <= 5) { return sum(); }
        long half = (from+to)/2;

        SumTask leftSum = new SumTask(from,half);
        SumTask rightSum = new SumTask(half+1,to);
        leftSum.fork();
        return rightSum.compute() + leftSum.join();
    }

    long sum() {
        long temp = 0L;
        for(long i=from; i<=to; i++) {
            temp += i;
        }
        return temp;
    }
}