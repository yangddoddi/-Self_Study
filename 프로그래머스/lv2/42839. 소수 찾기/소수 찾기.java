import java.util.*;

class Solution {
    static int MAX = 10_000_000;
    public int solution(String numbers) {
        // 완전탐색으로 모든 경우의 수를 구해야 한다.
        
        // boolean[] 소수 배열
        boolean[] isNotPrimeNum = new boolean[MAX];
        // 에라토스테네스의 체(소수 배열)
        getPrimeNum(isNotPrimeNum);
        
        // Set<Integer> 경우의 수
        Set<Integer> set = new HashSet<>();
        // boolean[] 방문여부 체크
        boolean[] visited;
        
        String[] numbersArr = numbers.split("");
        // 반복문 {
        for (int i=0; i<numbersArr.length; i++) {
        // dfs(경우의 수, 방문여부 체크, 시작 인덱스)
            visited = new boolean[numbers.length()];
            dfs(set, visited, i, numbersArr, numbersArr[i]);
        // }
        }
        
        System.out.println(set);
        
        return (int)set.stream()
            .filter(e -> !isNotPrimeNum[e])
            .count();
    }
    
    private void getPrimeNum(boolean[] arr) {
        arr[0] = arr[1] = true;
        
        for (int i=2; i*i<=MAX-1; i++) {
            if (!arr[i]) {
                for (int j=i+i; j<=MAX-1; j+=i) {
                    arr[j] = true;
                }
            }
        }
    }
    
        // dfs(경우의 수, 방문여부 체크, 시작 인덱스)
    private void dfs(Set<Integer> set, boolean[] visited, int idx, String[] arr, String str) {
        visited[idx] = true;
        
        set.add(Integer.parseInt(str));
        
        if (str.length() == arr.length) {
            return;
        }
        
        for (int i=0; i<arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(set, visited, idx, arr, str+arr[i]);
                visited[i] = false;
            }
        }
    }
}