import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int c = col - 1;
        int begin = row_begin - 1;
        int end = row_end - 1;
        
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[c] != arr2[c]) {
                    return arr1[c] - arr2[c];
                }
                
                if (arr1[c] == arr2[c] && arr1[0] != arr2[0]) {
                    return arr2[0] - arr1[0];
                }
                
                return 0;
            }
        });
        
        int answer = 0;
        for (int i=begin; i<=end; i++) {
            
            int temp = 0;
            for (int j=0; j<data[i].length; j++) {
                temp += data[i][j] % (i+1);
            }
            
            answer = answer ^ temp;
        }

        return answer;
    }
}