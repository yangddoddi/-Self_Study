import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 첫 번째 줄 숫자 개수 N, 임의 값 L
        // 두 번째 줄 N개의 수 배열

        //  i-L+1 => A(i-l+1) ~ Ai
        // 입력값 처리 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 입력값 처리 끝
        // 덱 생성
        Deque<Node> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<arr.length; i++) {
            Node node = new Node(i, arr[i]);
            int min = i-L+1;

            while (deque.size() != 0 && !node.compareToNode(deque.getLast())) {
                deque.removeLast();
            }

            deque.add(node);

            sb.append(deque.getFirst().getValue()).append(" ");

            if (deque.getFirst().getIndex() == min) {
                deque.removeFirst();
            }
        }

        System.out.println(sb);
    }
}

class Node {
    private final int index;
    private final int value;

    public Node (int index, int value) {
        this.index = index;
        this.value = value;
    }

    public boolean compareToNode(Node node) {
        return this.value > node.getValue();
    }

    public int getValue() {
        return this.value;
    }

    public int getIndex() {
        return this.index;
    }
}