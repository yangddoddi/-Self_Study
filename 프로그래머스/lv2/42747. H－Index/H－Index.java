import java.util.*;

class Solution {
// 발표 논문 중 h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었으면 h 최대값이 h-in     
// 1 <= 발표 논문 수 <= 1000
// 0 <= 논문별 인용횟수 <= 10,000
    public int solution(int[] citations) {
        int answer = 0;
        
        // mergeSort(citations);
        
        Queue<Integer> queue = new PriorityQueue<>();
        for (int citation : citations) {
            queue.add(citation);
        }
        
        int temp = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            if (count > temp) temp = queue.poll();
            
            if (count <= temp && queue.size()+1 >= count) answer = count;
            
            if (count <= temp) count++;
        }
        
        return answer;
    }
    
    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        split(arr, temp, 0, arr.length-1);
    }
    
    public static void split(int[] arr, int[] temp, int left, int right) {
        if (left != right) {
            int mid = (left+right)/2;
            split(arr, temp, left, mid);
            split(arr, temp, mid+1, right);
            merge(arr, temp, left, right);
        }
    }
    
    public static void merge(int[] arr, int[] temp, int left, int right) {
        int l = left;
        int m = (left+right)/2;
        int r = m+1;
        int idx = left;
        
        while (l<=m && r<=right) {
            if ( arr[r] > arr[l] ) {
                temp[idx++] = arr[l++];
            } else {
                temp[idx++] = arr[r++];
            }
        }
        
        while (l<=m) {
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