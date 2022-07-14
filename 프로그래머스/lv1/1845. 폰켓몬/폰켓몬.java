class Solution {
    public int solution(int[] nums) {
        boolean[] mylist = new boolean[200001];
        for (int i=0; i<nums.length; i++) {
            if (!mylist[nums[i]]) {
                mylist[nums[i]] = true;
            }
        }
        
        int answer = 0;
        for (int i=0; i<mylist.length; i++) {
            if(mylist[i]) {
                answer+=1;
                if(answer==nums.length/2) { return answer; }
            }
        }
        
    
        return answer;
    }
}
