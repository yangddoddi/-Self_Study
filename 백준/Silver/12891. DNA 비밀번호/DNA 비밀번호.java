import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        // 첫 번째 입력 : 만들 문자열 길이 S와 비밀번호로 사용할 길이 P
        // 두 번째 입력 : 임의 DNA 문자열
        // 세 번째 입력 : {A,C,G,T}의 최소 개수가 주어
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int dnaLength = Integer.parseInt(st.nextToken());
        int pwdLength = Integer.parseInt(st.nextToken());

        String[] temporaryDna = br.readLine().split("");

        st = new StringTokenizer(br.readLine(), " ");
        Map<String,Integer> requiredDna = new HashMap<>();
        Map<String,Integer> checkDna = new HashMap<>();

        requiredDna.put("A", Integer.parseInt(st.nextToken()));
        requiredDna.put("C", Integer.parseInt(st.nextToken()));
        requiredDna.put("G", Integer.parseInt(st.nextToken()));
        requiredDna.put("T", Integer.parseInt(st.nextToken()));

        for (int i=0; i<pwdLength; i++) {
            add(temporaryDna[i], checkDna);
        }

        int answer = checkCount(requiredDna, checkDna);

        for (int i=pwdLength; i<dnaLength; i++) {
            int j = i-pwdLength;
            add(temporaryDna[i], checkDna);
            remove(temporaryDna[j], checkDna);
            answer += checkCount(requiredDna, checkDna);
        }

        System.out.println(answer);
    }

    public static void add(String str, Map<String,Integer> checkDna) {
        checkDna.put(str,checkDna.getOrDefault(str, 0)+1);
    }

    public static void remove(String str, Map<String,Integer> checkDna) {
        checkDna.put(str,checkDna.get(str)-1);
    }

    public static int checkCount(Map<String,Integer> requiredDna, Map<String,Integer> checkDna) {
        boolean bool = requiredDna.entrySet()
                .stream()
                .map((entry) -> {
                    if (checkDna.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                        return 0;
                    }
                    else return 1;
                })
                .noneMatch(num -> num==0);

        return (bool) ? 1 : 0;
    }
}