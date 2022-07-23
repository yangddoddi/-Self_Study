import java.util.*;
import java.io.*;

public class Main {
    static LinkedList<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for ( int i=0; i<T; i++ ) {
            String userInput = br.readLine();
            String[] inputArr = userInput.split(" ");

            if (userInput.startsWith("push")) {
                int inputNum = Integer.parseInt(inputArr[1]);
                queue.addFirst(inputNum);
            }

            else if (userInput.equals("pop")) {
                if ( queue.peekLast() != null ) {
                    bw.write(String.valueOf(queue.pollLast()));
                    bw.newLine();
                } else {
                    bw.write(String.valueOf(-1));
                    bw.newLine();
                }
            }

            else if (userInput.equals("size")) {
                bw.write(String.valueOf(queue.size()));
                bw.newLine();
            }

            else if (userInput.equals("empty")) {
                if ( queue.isEmpty() ) {
                    bw.write(String.valueOf(1));
                    bw.newLine();
                } else {
                    bw.write(String.valueOf(0));
                    bw.newLine();
                }
            }

            else if (userInput.equals("front")) {
                if ( queue.peekLast() != null ) {
                    bw.write(String.valueOf(queue.peekLast()));
                    bw.newLine();
                } else {
                    bw.write(String.valueOf(-1));
                    bw.newLine();
                }
            }

            else if (userInput.equals("back")) {
                if ( queue.peekFirst() != null ) {
                    bw.write(String.valueOf(queue.peekFirst()));
                    bw.newLine();
                } else {
                    bw.write(String.valueOf(-1));
                    bw.newLine();
                }
            }
        }
        bw.flush();
    }
}