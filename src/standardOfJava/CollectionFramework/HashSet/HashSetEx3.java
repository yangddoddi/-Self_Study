package standardOfJava.CollectionFramework.HashSet;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetEx3 {
    public static void main (String[] args) {
        HashSet<Integer> hashA = new HashSet<>();
        HashSet<Integer> hashB = new HashSet<>();
        HashSet<Integer> Kyo = new HashSet<>();
        HashSet<Integer> Hab = new HashSet<>();
        HashSet<Integer> AminusB = new HashSet<>();

        for(int i=0; i<=6; i++) {
            hashA.add(i);
        }

        for(int i=10; i>=4; i--) {
            hashB.add(i);
        }



        Iterator it = hashA.iterator(); // 교집합 구하기
        while (it.hasNext()) {
            Object temp = it.next();
            if ( hashB.contains(temp) ) {
                Kyo.add((Integer) temp);
            }
        }

        it = hashA.iterator(); // 합집합 구하기
        while (it.hasNext()) {
            Object temp = it.next();
            if ( !hashB.contains(temp) ) {
                Hab.add((Integer) temp);
            }
        }

        it = hashB.iterator(); // 합집합 구하기
        while (it.hasNext()) {
            Object temp = it.next();
            if ( !hashA.contains(temp) ) {
                Hab.add((Integer) temp);
            }
        }

       it = hashA.iterator();
        while (it.hasNext()) {
            AminusB.add((Integer) it.next());
        }

        it = hashB.iterator();
        while (it.hasNext()) {
            Object temp = it.next();
            if ( hashA.contains(temp) ) {
                AminusB.remove(temp);
            }
        }

        System.out.println("hashA = " + hashA);
        System.out.println("hashB = " + hashB);
        System.out.println("교집합 : " + Kyo);
        System.out.println("합집합 : " + Hab);
        System.out.println("A-B : " + AminusB);
    }
}
