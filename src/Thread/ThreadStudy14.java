package Thread;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadStudy14 {
    public static void main(String[] args) throws InterruptedException {
        Table2 table = new Table2();

        new Thread(new Cook2(table), "요리사").start();
        new Thread(new Customer2("donut", table), "도넛 매니아").start();
        new Thread(new Customer2("buger", table), "햄버거 매니아").start();

        Thread.sleep(100);
        System.exit(0);
    }
}
class Table2 {
    ReentrantLock lock = new ReentrantLock();
    // ReentrantLock는 가장 일반적인 락으로써 synchronized와 기능적으로 거의 일치한다.
    // 같은 메서드에만 락을 걸 수 있는 synchronized에 비해 자유도가 높으나 직접 락을 컨트롤해줘야 한다.
    Condition cookLock = lock.newCondition();
    Condition customerLock = lock.newCondition();
    // Condition은 기존 wait(), notify()메서드가 대상을 특정하지 않고 작동하는 것으로 인한 불편함을 제거해준다.

    String[] dishNames = {"donut", "donut", "buger"};
    final int MAX_FOOD = 6;

    private ArrayList<String> dishes = new ArrayList<>();

    // 해당 음식 추가
    public synchronized void add(String dish) {
        if (dishes.size() >= MAX_FOOD) {
            return;
        } else {
            dishes.add(dish);
        }
        System.out.println("dishes : " + dishes.toString());
        customerLock.signal(); // signal이 기존의 notify와 같은 기능이다. 대상을 특정해줄 뿐.
    }

    // 해당 음식 제거
    public boolean remove(String dish) {
        synchronized (this){
            while(dishes.size()==0) {
                String name = Thread.currentThread().getName();

                try {
                    customerLock.await(); // 해당 구문에서 await하게 된 것은 오직 customerLock으로 처리된다.
                    System.out.println(name + "이(가) 기다리고 있습니다...");
                } catch (InterruptedException e) {}

            }

            for (int i = 0; i < dishes.size(); i++) {
                if (dishes.get(i).equals(dish)) {
                    dishes.remove(i);
                    return true;
                }
            }}
        return false;
    }

}

class Cook2 implements Runnable {
    private Table2 table;

    public Cook2(Table2 t) {
        this.table = t;
    }

    public void run() {
        while (true) {
            int randomIndex = (int) (Math.random() * table.dishNames.length);
            table.add(table.dishNames[randomIndex]);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
        }
    }
}

class Customer2 implements Runnable {
    private Table2 table;
    private String dish;

    Customer2(String name, Table2 table) {
        this.table = table;
        this.dish = name;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String name = Thread.currentThread().getName();
            if (eat()) {
                System.out.println(name + "은 " + this.dish + "를 먹었습니다.");
            } else {
                System.out.println(this.dish + "는 아직 준비되지 않았습니다. " + name + "는(은) 대기 중입니다.");
            }
        }
    }

    public boolean eat() {
        return table.remove(this.dish);
    }
}

