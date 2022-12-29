import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> setList = new ArrayList<>();
        
        for (int i=0; i<9; i++) {
            setList.add(new HashSet<Integer>());
        }
        
        setList.get(1).add(N);
        
        for (int i=2; i<9; i++) {
            Set<Integer> currentSet = setList.get(i);
            
            for (int j=1; j<i; j++) {
                Set<Integer> preSet = setList.get(j);
                Set<Integer> postSet = setList.get(i-j);
                
                for (Integer pre : preSet) {
                    for (Integer post : postSet) {
                        currentSet.add(pre + post);
                        currentSet.add(pre * post);
                        currentSet.add(pre - post);
                        if (pre != 0 && post != 0) {
                            currentSet.add(pre / post);
                            currentSet.add(post / pre);
                        }
                    }
                }
            }
            
            currentSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }
        
        for (Set set : setList) {
            if (set.contains(number)) {
                return setList.indexOf(set);
            }
        }
        
        return -1;
    }
}