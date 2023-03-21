import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static long answer = Long.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int treeCount = Integer.parseInt(input[0]);
        int treeLength = Integer.parseInt(input[1]);

        int maxTree = Integer.MIN_VALUE;
        int[] trees = new int[treeCount];
        input = br.readLine().split(" ");
        for (int i=0; i<trees.length; i++) {
            trees[i] = Integer.parseInt(input[i]);
            maxTree = Math.max(trees[i], maxTree);
        }

        getCutterLength(0, maxTree, trees, treeLength);
        System.out.println(answer);
    }

    private static void getCutterLength(int low, int high, int[] trees, int treeLength) {
        long l = low;
        long r = high;

        while (l < r) {
            long mid = (l+r) / 2;

            long length = 0;
            for (int tree : trees) {
                if (tree - mid > 0) {
                    length += (tree - mid);
                }
            }

            if (length >= treeLength) {
                l = mid+1;
                answer = Math.max(answer, mid);
            } else {
                r = mid;
            }
        }
    }
}