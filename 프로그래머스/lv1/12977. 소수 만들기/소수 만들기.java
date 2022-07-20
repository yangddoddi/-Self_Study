import java.util.*;

class Solution {
    public static boolean[] isCompositeNum = new boolean[3001];
    public int solution(int[] nums) {
        findCompositeNum();
        int length = nums.length;
        int result = 0;
        for (int i=0; i<length-2; i++) {
            for (int j=i+1; j<length-1; j++) {
                for (int k=j+1; k<length; k++) {
                    int sum = nums[i]+nums[j]+nums[k];
                    if (!isCompositeNum[sum]) {
                        result+=1;
                    }
                }
            }
        }
        return result;
    }
    
    public static void findCompositeNum() {
        isCompositeNum[0] = isCompositeNum[1] = true;
        for (int i=2; i*i<=isCompositeNum.length; i++) {
            if ( !isCompositeNum[i]) {
            for (int j=i*i; j<=isCompositeNum.length; j+=i) {
                isCompositeNum[j] = true;
            }
            }
        }
    }
}