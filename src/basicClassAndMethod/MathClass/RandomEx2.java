package basicClassAndMethod.MathClass;

import java.util.Arrays;

public class RandomEx2 {
    public static void main(String[] args) {
        for(int i=0; i<10; i++) {
            System.out.printf("%d,",getRandom(5,10));
        }
        System.out.println("");

        System.out.println(Arrays.toString(fillRandom(new int[10], 5, 10)));
        int[] arr = fillRandom(new int[10], 5, 10);
        System.out.println(Arrays.toString(fillRandom(new int[20], arr)));
    }

    // getRandom() 메서드를 이용하여 원하는 크기의 배열에 from~to까지의 난수 삽입
    public static int[] fillRandom(int[] arr, int from, int to) {
        int[] newArr = new int[arr.length];
        for (int i=0; i<arr.length; i++) {
            newArr[i] = getRandom(from, to);
        }
        return newArr;
    }

    // 배열에 포함된 값을 원하는 크기의 배열에 랜덤하게 삽입
    public static int[] fillRandom(int[] arr, int[] data) {
        int[] newArr = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            newArr[i] = data[getRandom(0, data.length-1)];
        }
        return newArr;
    }

    // from ~ to 사이의 난수 생성
    public static int getRandom(int from, int to) {
        return (int)(Math.random() * (Math.abs(to-from)+1)+Math.min(to,from));
    }
}
