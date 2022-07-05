package standardOfJava.CollectionFramework.TreeSet;

import java.util.Arrays;
import java.util.TreeSet;

public class TreeSetEx {
    public static void main(String[] args) {
        TreeSet<String> tree = new TreeSet<>();
        String start = "c";
        String end = "f";

        String[] str = {"samsung","batman","superman","apple","google","dude","babo","cj","hynix","shaomi","eland","Emart","fanfan"};
        tree.addAll(Arrays.asList(str));

        System.out.println("tree = " +tree);
        System.out.println("tree.subSet(start, end) = " + tree.subSet(start, end));
        System.out.println("tree.subSet(start, end+\"zzz\") = " + tree.subSet(start, end+"zzz"));
        // zzz같은 의미 없는 문자열을 더해주면 마지막 문자열까지 포함시킬 수 있다

        TreeSet<Integer> tree2 = new TreeSet<>();
        for (int i=0; i<=100; i+=10) {
            tree2.add(i);
        }

        System.out.println("tree2.tailSet( 50 ) = " + tree2.tailSet( 50 )); // 50 이상의 값
        System.out.println("tree2.headSet(50) = " + tree2.headSet(50)); // 50 '미만'의 값
        // 이진트리에서 원을 그렸을 때 노드의 왼쪽 아래 노드부터 원을 그리면 headSet 노드를 포함해서 오른쪽으로 원을 그리면 tailSet


    }
}
