import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    final static int[] FOUR_WAY_X = {1,-1,0,0};
    final static int[] FOUR_WAY_Y = {0,0,-1,1};
    static ArrayList<Integer> countArr = new ArrayList<>();
    static int counter = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        map = new int[T][T];
        visited = new boolean[T][T];
        int temp = 0;

        for (int i=0; i<T; i++) {
            String inputMap = br.readLine();
            for (int j=0; j<T; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(inputMap.charAt(j)));
            }
        }

        for (int i=0; i<map.length; i++) {
            for (int j=0; j<map.length; j++) {
                if ( map[i][j] == 1 && !visited[i][j]) {
                    findHouse(i,j);
                    countArr.add(counter);
                    counter=0;
                }
            }
        }

        System.out.println(countArr.size());

        Collections.sort(countArr);
        
        for (int n : countArr) {
            System.out.println(n);
        }
    }

    static void findHouse(int x, int y) {
        visited[x][y] = true;
        counter++;

        for (int i=0; i< FOUR_WAY_X.length; i++) {
            x += FOUR_WAY_X[i];
            y += FOUR_WAY_Y[i];

            if ( x>=0 && y>=0 && x< visited.length && y< visited.length && !visited[x][y] && map[x][y] == 1 ) {
                findHouse(x,y);
            }

            x -= FOUR_WAY_X[i];
            y -= FOUR_WAY_Y[i];
        }
    }
}
