package java8.etc;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/*
*
* Fork/Join 프레임워클르 사용해서 배열을 정렬함
* (배열 크기가 커야 효율적)
*
* */

public class StreamParallel {
    public static void main(String[] args) {
        int size = 1500;
        int[] numbers = new int[size];
        Random random = new Random();

        IntStream.range(0,size).forEach(i -> numbers[i] = random.nextInt());
        long start = System.nanoTime();
        Arrays.sort(numbers);
        System.out.println("serial sorting took " + ((System.nanoTime()) - start));

        IntStream.range(0,size).forEach(i -> numbers[i] = random.nextInt());
        start = System.nanoTime();
        Arrays.parallelSort(numbers);
        System.out.println("serial sorting took " + ((System.nanoTime()) - start));

    }
}
