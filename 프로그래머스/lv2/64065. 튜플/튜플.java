import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] arr = s.split("}");
        int[][] nums = new int[arr.length][arr.length];
        for(String str : arr) {
            int i=0;
            while(!Character.isDigit(str.charAt(i))) {
                i++;
            }
            str = str.substring(i, str.length());
            String[] tmp = str.split(",");
            for(int idx=0 ; idx<tmp.length ; idx++) {
                nums[tmp.length-1][idx] = Integer.valueOf(tmp[idx]);
            }
        }
        Set<Integer> hs = new HashSet<>();
        int[] ret = new int[arr.length];
        for(int i=0 ; i<arr.length ; i++) {
            for(int j=0 ; j<=i ; j++) {
                int num = nums[i][j];
                if(!hs.contains(num)) {
                    hs.add(num);
                    ret[i] = num;
                    break;
                }
            }
        }
        return ret;
    }
}