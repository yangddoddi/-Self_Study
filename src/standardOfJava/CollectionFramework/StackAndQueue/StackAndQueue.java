package standardOfJava.CollectionFramework.StackAndQueue;

import java.util.*;

public class StackAndQueue {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<4; i++) {
            s.push(i);
            q.add(i);
        }

        while (!s.isEmpty()) {
            System.out.println("Stack.pop : " + s.pop());
        }

        while (!q.isEmpty()) {
            System.out.println("Queue.poll : " + q.poll());
        }

        MyStack<Integer> arr = new MyStack<>();
        arr.push(1);
        arr.push(2);
        arr.push(3);
        arr.push(4);
        arr.push(5);
        System.out.println(arr);
        System.out.println(arr.search(1));
    }
}

class MyStack<T> extends Vector<T> {
    public Object push(Object item) {
        addElement((T)item);
        return item;
    }

    public Object peek() {
        if (size() == 0) throw new EmptyStackException();
        return elementAt(size());
    }

    public Object pop() {
        Object temp = peek();
        removeElementAt(size());
        return temp;
    }

    public boolean empty() {
        return size() == 0;
    }

    public int search(Object o) {
        int i = lastIndexOf(o);
//        System.out.println(lastIndexOf(o));
        if ( i >= 0 ) {
            return size() - i;
            // stack은 맨 위에 저장된 객체의 index를 1로 정의한다.
        }
        return -1;
    }
}
