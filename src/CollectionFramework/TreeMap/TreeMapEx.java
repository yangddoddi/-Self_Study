package CollectionFramework.TreeMap;

import java.sql.Connection;
import java.util.*;

// 검색 성능은 TreeMap보다 HashMap이 유리하다.
// 범위 검색 및 정렬이 필요한 경우에는 TreeMap을 활용.
public class TreeMapEx {
    public static void main(String[] args) {
        TreeMap<String, Integer> tree = new TreeMap<>();
        String[] strArr = {"a", "c", "c", "s", "c", "b", "a", "s", "s", "k", "k", "s", "d",};
        for (int i = 0; i < strArr.length; i++) {
            if (tree.containsKey(strArr[i])) {
                int value = tree.get(strArr[i]);
                tree.put(strArr[i], value + 1);
            } else {
                tree.put(strArr[i], 1);
            }
        }

        Iterator entries = tree.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry e = (Map.Entry) entries.next();
            String key = e.getKey().toString();
            int value = (int) e.getValue();
            System.out.println(key + " : " + printHash(value) + " 총 " + value + "개");
        }
        // 기본 정렬 (TreeMap은 기본적으로 key를 정렬해준다)

        ArrayList list = new ArrayList<>(tree.entrySet());
        list.sort(new MyComparator());
        System.out.println(list);

        entries = list.listIterator();
        while (entries.hasNext()) {
            Map.Entry e = (Map.Entry) entries.next();
            int value = (int) e.getValue();
            String key = e.getKey().toString();
            System.out.println(key + " : " + printHash(value) + " 총 " + value + "개");
        }
    }
    // 값에 따라 #으로 개수 표기
    public static String printHash(int value) {
        char[] charArr = new char[value];
        for (int i=0; i<value; i++) {
            charArr[i] = '#';
        }
        return new String(charArr);
    }
}


// 복습용, 굳이 이렇게 정렬할 필요는 없다.
class MyComparator implements Comparator {
    @Override
    public int compare(Object obj1, Object obj2) {
        if (obj1 instanceof Comparable || obj2 instanceof Comparable) {
            Comparable c1 = (Comparable) obj1;
            Comparable c2 = (Comparable) obj2;
            return c1.compareTo(c2) * -1;
        }
        return -1;
    }
}