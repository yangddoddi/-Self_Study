package CollectionFramework.HashSet;

import com.sun.org.apache.xerces.internal.dom.RangeImpl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetEx {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>(25);

        for (int i=1; hashSet.size()<=25; i++) {
            hashSet.add((int)(Math.random()*50+1));
        }

        Iterator it = hashSet.iterator();
        Integer[][] bingoBoard = new Integer[5][5];

        for (int i=0; i< bingoBoard.length; i++) {
            for (int j=0; j< bingoBoard.length; j++) {
                bingoBoard[i][j] = (int)(it.next());
                System.out.print( bingoBoard[i][j] < 10 ? "  " + bingoBoard[i][j] : " " + bingoBoard[i][j] );
            }
            System.out.println();
        }
    }
    // HashSet이 자체적인 저장 방식에 따라 순서가 결정되기 떄문에
    // 비슷한 결과가 반복해서 나온다.
    // 진짜 무작위를 원한다면 순서를 보장해주는 LinkedHashSet을 이용할 것.
}