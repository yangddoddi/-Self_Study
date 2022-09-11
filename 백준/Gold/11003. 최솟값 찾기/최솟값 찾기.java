import java.util.*;
import java.io.*;


public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        * 첫 번째 입력 : 숫자 개수 N과 임의 수 L
        * 두 번째 입력 : 임의 수 배열
        * Di = A(i-L+1) ~ Ai 중의 최소값
        * D에 저장된 수를 고르시오
        *
        * */

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Node> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<arr.length; i++) {
            Node node = new Node(i, arr[i]);

//            if (deque.size() <= 1) {
//                deque.add(node);
//            }

            while (!deque.isEmpty() && node.compareToNode(deque.getLast())) {
                deque.removeLast();
            }

            deque.addLast(node);

//            if (node.compareToNode(deque.getLast())) {
//                deque.removeLast();
//                deque.addLast(node);
//            }

            if (node.compareToNode(deque.getFirst())) {
                deque.removeFirst();
            }

            sb.append(deque.getFirst().getValue()).append(" ");

            if (deque.getFirst().expired(i, L)) {
                deque.removeFirst();
            }
        }

        System.out.println(sb);
    }
}

class Node {
    private int index;
    private int value;

    public Node(int index, int num) {
        this.index = index;
        this.value = num;
    }

    public int getValue() {
        return this.value;
    }

    public boolean compareToNode(Node node) {
        return this.value < node.getValue();
    }

    public boolean expired(int i, int L) {
        return this.index <= (i-L+1);
    }
}