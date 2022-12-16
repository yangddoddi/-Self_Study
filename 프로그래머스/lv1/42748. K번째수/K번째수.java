import java.util.*;

class Solution {
    // commands[][0]-1 = 자르기 시작 지점
    // commands[][1] = 자르기 끝 지점
    // commands[][2]-1 = 뽑으려는 수
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        // 반복 (commands.length)
        for (int i=0; i<commands.length; i++) {
        // {
            int start = commands[i][0]-1;
            int end = commands[i][1];
            int pick = commands[i][2]-1;
        // int[] 배열 = array 복사본
            int[] arr = Arrays.copyOfRange(array, start, end);
        // int[] 임시 배열 = 배열과 같은 크기 
            int[] temp = new int[arr.length];
        // 
        // mergeSort（배열, 임시 배열, 0, 배열 길이-1)
            mergeSort(arr, temp, 0, arr.length-1);
        // answer[i] = arr[뽑으려는 수]
            answer[i] = arr[pick];
        // }
        }
        
        return answer;
        // return answer
    }
    
    static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left != right) {
            int mid = (left+right) / 2;
            mergeSort(arr, temp, left, mid);
            mergeSort(arr, temp, mid+1, right);
            merge(arr, temp, left, right);
        }
    }
    
    static void merge(int[] arr, int[] temp, int left, int right) {
        int l = left;
        int mid = (left+right)/2;
        int r = mid+1;
        int idx = left;
        
        while (l<=mid && r<=right) {
            if (arr[l] > arr[r]) {
                temp[idx++] = arr[r++];
            } else {
                temp[idx++] = arr[l++];
            }
        }
        
        while (l<=mid) {
            temp[idx++] = arr[l++];
        }
        
        while (r<=right) {
            temp[idx++] = arr[r++];
        }
        
        for (int i=left; i<=right; i++) {
            arr[i] = temp[i];
        }
    }
}