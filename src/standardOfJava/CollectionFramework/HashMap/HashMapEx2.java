package standardOfJava.CollectionFramework.HashMap;

import java.util.*;

public class HashMapEx2 {
    public static void main(String[] args) {
        HashMap<String, Integer> list = new HashMap<>();
        list.put("양천재",100);
        list.put("김바보",40);
        list.put("나평범",75);
        list.put("강수재",95);

        Set<Map.Entry<String, Integer>> set = list.entrySet(); // map은 iterator 메서드를 가지고 있지 않다.
        Iterator<Map.Entry<String, Integer>> it = set.iterator();
        while(it.hasNext()) {
            Map.Entry<String,Integer> e = it.next();
            System.out.println("이름 = " + e.getKey() + ", 점수 = " + e.getValue());
        }

        System.out.println("참가자 명단 = " + set);
        it = set.iterator();
        int total = 0;
        while(it.hasNext()) {
            Map.Entry<String,Integer> e = it.next();
            total += (int)(e.getValue());
        }
        System.out.println("총점 = " + total);
        System.out.println("평균 = " + total / set.size());

        Collection<Integer> value = list.values();
        System.out.println("최고점 = " + Collections.max(value));
        System.out.println("최저점 = " + Collections.min(value));


    }
}
