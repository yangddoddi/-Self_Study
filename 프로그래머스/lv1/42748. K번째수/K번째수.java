import java.util.*;

class Solution {
    // i부터 j까지 자르고 정렬한 뒤 k번째 수를 구한다
    
    // array를 각각 commands[idx][0],commands[idx][1]로 자르고 정렬된 배열에서 commnads[idx]     // [2]의 값 구하기
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i=0; i<commands.length; i++) {
            int[] arr = new int[commands[i][1] - commands[i][0] + 1];
            int[] temp = new int[arr.length];
            
            System.arraycopy(array, commands[i][0]-1, arr, 0, commands[i][1] - commands[i][0] +1);
            // mergeSort(temp, 0, temp.length-1, temp);
            Arrays.sort(arr);
            
            answer[i] = arr[commands[i][2]-1];
        }
        
        return answer;
    }
    
    static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left != right) {
            int mid = (left+right)/2;
            
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid+1, right, temp);
            
            merge(arr, left, right, temp);
        }
    }
    
    static void merge(int[] arr, int left, int right, int[] temp) {
        int l = left;
        int r = right;
        int m = (left+right)/2;
        int idx = left;
        
        while (l<=m && r <=right) {
            if (arr[l] > arr[r]) {
                temp[idx++] = arr[r++];
            } else {
                temp[idx++] = arr[l++];
            }
        }
        
        if (l<=m) {
            while (l<=m) {
                temp[idx++] = arr[l++];
            }
        }
        
        if (r<=right) {
            while (r<=right) {
                temp[idx++] = arr[r++];
            }
        }
        
        for (int i=left; i<=right; i++) {
            arr[i] = temp[i];
        }
    }
}