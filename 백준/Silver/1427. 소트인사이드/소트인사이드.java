import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] arr = new int[input.length()];

        for (int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(input.substring(i, i+1));
        }

        for (int i=0; i<arr.length; i++) {
            int max = i;
            for (int j = i; j<arr.length; j++) {
                if (arr[j] > arr[max]) {
                    max = j;
                }
            }
            swap(arr, max, i);
        }

        for (int i : arr) {
            System.out.print(i);
        }
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}