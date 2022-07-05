package standardOfJava.CollectionFramework.StackAndQueue;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;

public class QueueEx {
    static Queue<String> q = new LinkedList<>();
    static final int MAX_SIZE = 5;

    public static void main(String[] args) {
        System.out.println("help를 입력하면 도움말을 볼 수 있습니다.");

        while ( true ) {
            Scanner scan = new Scanner(System.in);
            System.out.println("help를 입력하면 명령어를 확인할 수 있습니다.");
            System.out.print(">>");
            String input = scan.nextLine();
            if ( input.equals("") ) continue;
            if ( input.equalsIgnoreCase("help") ) {
                save(input);
                System.out.println(" help - 도움말을 보여줍니다. ");
                System.out.println(" q 또는 Q - 프로그램을 종료합니다. ");
                System.out.println(" history - 최근에 입력한 명령어를 " + MAX_SIZE +"개까지 보여줍니다.");
            } else if ( input.equalsIgnoreCase("q")) {
                System.exit(0);
            } else if ( input.equalsIgnoreCase("history") ) {
                load(q);
                save(input);
            } else {
                save(input);
                System.out.println("정의되지 않은 명령어입니다.");
            }
        }
    }

    static void save(String str) {
        if (q.size() > MAX_SIZE) {
            q.remove(); }
        // 제일 먼저 들어간 것이 삭제되므로 과거 기록순으로 삭제된다.
        else {
            q.add(str);
        }
    }

    static void load(Queue<String> list) {
        LinkedList<String> temp = (LinkedList<String>) list;
        ListIterator<String> it = temp.listIterator();
        int i=1;
        while (it.hasNext()) {
            System.out.println(i + " : " + it.next());
            i++;
        }
    }
}
