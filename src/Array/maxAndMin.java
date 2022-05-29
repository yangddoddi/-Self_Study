package Array;

public class maxAndMin {
    public static void main (String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8};
        int maxNum = arr[0];
        int minNum = arr[5];

        for (int i=0; i<arr.length; i++) {
            if ( arr[i] > maxNum ) {
                maxNum = arr[i];
            }
            if ( arr[i] < minNum ) {
                minNum = arr[i];
            }
        }

        System.out.println("최대값 : " + maxNum);
        System.out.println("최소값 : " + minNum);
    }
}
