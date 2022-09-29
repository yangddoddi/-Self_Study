import java.util.*;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] temp = new int[N];

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(arr, 0, arr.length-1, temp);

        StringBuilder sb = new StringBuilder();
        for (int n : arr) {
            sb.append(n).append("\n");
        }
        
        System.out.println(sb.toString());
    }

    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left == right) return;

        int mid = (left+right) / 2;
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid+1, right, temp);

        sort(arr, left, right, mid, temp);
    }

    private static void sort(int[] arr, int low, int high, int mid, int[] temp) {
        int l = low;
        int r = mid+1;
        int idx = low;

        while (l <= mid && r <= high) {
            if (arr[l] < arr[r]) {
                temp[idx] = arr[l];
                idx++;
                l++;
            } else {
                temp[idx] = arr[r];
                idx++;
                r++;
            }
        }

        if (l > mid) {
            while(r <= high) {
                temp[idx] = arr[r];
                idx++;
                r++;
            }
        } else {
            while(l <= mid) {
                temp[idx] = arr[l];
                idx++;
                l++;
            }
        }

        for(int i= low; i<=high; i++) {
            arr[i] = temp[i];
        }
    }
}