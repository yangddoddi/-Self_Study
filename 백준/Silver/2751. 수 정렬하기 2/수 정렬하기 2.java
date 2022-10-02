import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        int[] temp = new int[N];
        
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(arr,0,arr.length-1,temp);
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            sb.append(arr[i]).append("\n");
        }
        
        System.out.println(sb.toString());
    }
    
    private static void mergeSort(int[] arr, int low, int high, int[] temp) {
        if (low!=high) {
            int mid = (low+high)/2;
            mergeSort(arr, low, mid, temp);
            mergeSort(arr, mid+1, high, temp);
            merge(arr, low, high, temp);
        }
    }
    
    private static void merge(int[] arr, int low, int high, int[] temp) {
        int mid = (high+low)/2;
        int left = low;
        int index = low;
        int right = mid+1;

        while (left<=mid && right<=high) {
            if (arr[left] >= arr[right]) {
                temp[index++] = arr[right++];
            } else {
                temp[index++] = arr[left++];
            }
        }
        
        if (left>mid) {
            while (index<=high) {
                temp[index++] = arr[right++];
            }
        }
        
        if (right>high) {
            while (index<=high) {
                temp[index++] = arr[left++];
            }
        }
        
        for (int i=low; i<=high; i++) {
            arr[i] = temp[i];
        }
    }
}