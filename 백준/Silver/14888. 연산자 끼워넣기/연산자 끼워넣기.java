import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    final static int SIGN = 4; // 사인 종류
    static int[] numArr; // 주어지는 숫자
    static ArrayList<String> signList = new ArrayList<>(); // 사칙연산 기호 리스트
    static int min = Integer.MAX_VALUE; // 최소값 대입할 변수
    static int max = Integer.MIN_VALUE; // 최대값 대입할 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 수의 개수
        st = new StringTokenizer(br.readLine(), " ");
        numArr = new int[T];

        for (int i = 0; i < T; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        addSignList(st, signList);

        ArrayList<String> temp = new ArrayList<>();
        boolean[] visited = new boolean[signList.size()];

        backtracking(0, temp, visited);

        System.out.println(max);
        System.out.println(min);
    }

    private static void backtracking(int v, ArrayList<String> temp, boolean[] visited) {
        if (signList.size() == temp.size()) {
            int result = numArr[0];
            for (int i=0; i<temp.size(); i++) {
                result = calculate(result, temp.get(i), numArr[i+1]);
            }

            if (result > max) {
                max = result;
            }

            if ( result < min ) {
                min = result;
            }

            return;
        }

        for (int i=0; i< signList.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp.add(signList.get(i));
                backtracking(i, temp, visited);
                visited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    private static void addSignList(StringTokenizer st, ArrayList<String> signList) {
        for (int i = 0; i < SIGN; i++) {
            int token = Integer.parseInt(st.nextToken());

            for (int j = 0; j < token; j++) {
                switch (i) {
                    case 0:
                        signList.add("+");
                        break;
                    case 1:
                        signList.add("-");
                        break;
                    case 2:
                        signList.add("*");
                        break;
                    case 3:
                        signList.add("/");
                        break;
                    default:
                        throw new RuntimeException();
                }
            }
        }
    }

    private static int calculate(int num1, String sign, int num2) {
        switch (sign) {
            case "+" :
                return num1+num2;
            case "-" :
                return num1-num2;
            case "*" :
                return num1*num2;
            case "/" :
                return num1/num2;
            default:
                throw new RuntimeException();
        }
    }
}