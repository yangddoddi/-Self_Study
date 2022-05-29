package Array;

public class sumAverage {
    public static void main (String[] args) {
        int[] arr = { 75,100,89,55,77,100,30,60,45,90 };
        int sum = 0;

        for ( int num : arr ) {
            sum += num;
        }

        int average = sum / arr.length;

        System.out.println("총합 : " + sum);
        System.out.println("평균 : " + average);
    }
}
