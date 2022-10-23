import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    // 가장 멀리 있는 노드 기록할 변수 생성 -> 초기화 필요 없음
    public static int max_node;
    // max 가중치 기록할 변수 생성 -> 초기화 필요 없음
    public static int max_weight;
    public static final int START_NODE = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 트리의 지름 ?
        // 루트에서 가장 먼 노드 n1 <-> n1과 가장 멀리 있는 노드 n2의 거리.
        // 가중치와 에지 정보가 모두 필요하므로 별도의 Node 클래스가 필요하다.
        // bfs dfs? dfs를 이상하게 구현하지 않는 이상 큰 의미 없을 듯..? 어차피 완전탐색해야함.
        // 다만 깊이가 깊어질수록 dfs가 불리해서 굳이 선택하면 bfs가 무난한데 난 dfs가 좋 - 아
        // 가장 먼 노드 + 그놈하고 제일 먼 노드 => 두 번 탐색 필요

        // 근데 노드가 1번부터 시작하는 건지 0번부터인지 기재되어 있지 않음.. 뭐지
        // 예제는 1번부터니 일단 1번으로 시작

        // 1번째 입력값 노드 개수 V
        // 2번째 입력값 노드 번호 N, 에지 정보 V, -1이 나오면 다음 노드로

        // 노드 개수 V 받기
        int V = Integer.parseInt(br.readLine());

        // 노드개수 V+1 만큼의 ArrayList<Node>를 인자로 가지는 배열 lists 생성
        ArrayList<Node>[] lists = new ArrayList[V+1];

        // 2중 반복문
        for (int i=START_NODE; i<lists.length; i++) {
            // 1차 (lists.length만큼)
            // lists[i] = new ArrayList<Node>;
            String[] input = br.readLine().split(" ");
            // 2번째 입력값 받아서 split or StringTokenizer
            int node = Integer.parseInt(input[0]);
            lists[node] = new ArrayList<>();
            for (int j=1; j< input.length; j+=2) {
                // 2차 for(2번째 입력값 배열 길이만큼, +2씩 증가)
                // 0번은 노드 번호이므로 1번부터
                int input1 = Integer.parseInt(input[j]); // 노드
                // 첫번째 입력값이 -1? break
                if (input1 == -1) break;
                // 아니라면 lists[j]
                int input2 = Integer.parseInt(input[j+1]); // 가중치
                // lists[j+1] = .. 퐁당퐁당 넣기
                // lists[i].add (new Node (j , j+1));
                lists[node].add(new Node(input2,input1));
            }
        }

        // 방문 여부 기록용 변수 생성(+1)
        boolean[] visited = new boolean[V+1];
        // 가중치용 변수 (무의미함)
        int weight = 0;
        // dfs(현재 노드, 배열, 방문용 배열, 가중치)
        dfs(START_NODE, visited,lists,  weight);

        // 방문 여부 초기화
        visited = new boolean[V+1];

        // dfs(max node, 배열, 방문용 배열, 가중치)
        dfs(max_node, visited, lists, weight);

        // 출력 최대 가중치
        System.out.println(max_weight);
    }

    // dfs(현재 노드, 방문용 배열, 배열, 가중치)
    public static void dfs(int node, boolean[] visited, ArrayList<Node>[] lists, int weight) {
        // 방문했다면 리턴
        if (visited[node]) return;

        // 만약 최대 가중치보다 지금 가중치가 더 크다면?
        // 최대 가중치 = 현재 가중치
        // 최대 가중치 노드 = 현재 노드
        if (max_weight < weight) {
            max_weight = weight;
            max_node = node;
        }

        visited[node] = true;
        // 반복문
        // 배열[노드]의 길이만큼 돌면서
        for (int i=0; i<lists[node].size(); i++) {
            // if (방문 안함)
            Node next = lists[node].get(i);
            if (!visited[next.edge]) {
                // dfs(현재 노드, 방문용 배열, 배열, 가중치 + 다음 노드의 가중치)
                dfs(next.edge, visited, lists, weight + next.weight);
            }
        }
    }
}

// 노드 클래스
class Node {
    // 가중치
    int weight;
    // 에지 정보
    int edge;
    // 생성자
    public Node (int weight, int edge) {
        this.weight = weight;
        this.edge = edge;
    }
}
