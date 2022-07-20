import java.util.*;

class Solution {
    public static boolean[] isCompositeNum = new boolean[3001];
    public int solution(int[] nums) {
        int length = nums.length;
        int result = 0;
        for (int i=0; i<length-2; i++) {
            for (int j=i+1; j<length-1; j++) {
                for (int k=j+1; k<length; k++) {
                    int sum = nums[i]+nums[j]+nums[k];
                    if (sum%2==0 || sum%3==0) {continue;}
                    result += (isPrimeNum(sum)) ? 1 : 0;
                }
            }
        }
        return result;
    }
        

    
    public static boolean isPrimeNum(int num) {
        for (int i=5; i*i<=num; i+=2) {
            if (num%i==0) { return false; }
        }
        return true;
    }
}