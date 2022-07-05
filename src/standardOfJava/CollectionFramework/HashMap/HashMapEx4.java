package standardOfJava.CollectionFramework.HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapEx4 {
    public static void main(String[] args) {
        int[] numArr = new int[50];
        for (int i=0; i< numArr.length; i++) {
            numArr[i] = (int)(Math.random()*10+1);
        } // 숫자 배열 생성
        System.out.println(Arrays.toString(numArr));

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i=0; i< numArr.length; i++) {
            Integer num = numArr[i];
            if ( !hashMap.containsKey(num) ) { // Map은 중복되지 않으므로
                hashMap.put(num, 1); // 키가 존재하지 않는다면 키와 값(1)을 넣어주고
            } else {
                int value = hashMap.get(num); // 존재한다면 값을 가져와서
                hashMap.put(num, value+1); // +1하고 다시 넣어줌.
            }
        }
        System.out.println(hashMap);

        Iterator entries = hashMap.entrySet().iterator(); // set으로 변환하고 iterator 메서드 사용하는 것과 가같음.
        while(entries.hasNext()) {
            Map.Entry entry = (Entry)entries.next();
            int key = (int)entry.getKey();
            int value = (int)entry.getValue();
            System.out.println( key + " : " + printResult(value, '#') + " 총 " + value + "개" );
        }
    }

    public static String printResult(int value,char ch) {
        char[] bar = new char[value];

        for (int i=0; i< bar.length; i++) {
            bar[i] = ch;
        }

        return new String(bar); // new standardOfJava.String(char[])는 new standardOfJava.String("문자열")과 같다.
    }
}
