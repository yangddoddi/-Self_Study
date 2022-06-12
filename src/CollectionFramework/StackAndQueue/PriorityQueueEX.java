package CollectionFramework.StackAndQueue;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueEX<I extends Number> {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=6; i>0; i--) {
            pq.add(i);
        }
        System.out.println(pq);
        for(int i= pq.size(); i>0; i--) {
            System.out.println("pq1 : " + pq.poll());
        }

        PriorityQueue<String> pq2 = new PriorityQueue<>();
        pq2.add("a");
        pq2.add("b");
        pq2.add("z");
        pq2.add("h");
        System.out.println(pq2);
        for(int i=pq2.size(); i>0; i--) {
            System.out.println(pq2.poll());
        }
    }
}
