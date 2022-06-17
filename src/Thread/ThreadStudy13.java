package Thread;

import java.util.ArrayList;


// 동기화 과정 없이 실행 시 두가지 예외가 발생한다
// 1. ConcurrentModificationException : ArrayList애 요소가 추가되는 과정에 remove하려고 함
// 2. IndexOutOfBoundsException : 이미 하나의 쓰레드가 remove 호출했는데 있는데 다른 쓰레드가 같은 인덱스에 remove 호출함

// 만약 add() remove() 메서드에 synchronized 메서드를 추가하면 어떤 문제가 발생하는가?
// 햄버거 매니아 혹은 도넛 매니아 쓰레드가 계속해서 객체를 점거하고 있다.
// 왜 계속해서 대기하게 되는가?
// 해당 쓰레드가 메서드에 lock을 걸어놓고 점유하고 있으니 더이상 Cook 클래스에서 add해주지 못하고 있는 것이다.

// wait() notify() 메서드로 이것을 해결할 수 있다.
// wait 메서드는 쓰레드를 waiting pool로 이동시키기고 notify는 다시 실행 대기열로 데려온다.
// 다만 더 안정적인 프로그래밍을 위해 요리사 쓰레드와 고객 쓰레드를 모두 wait notify로 제어하면 문제가 생길 수 있다.
// notify는 선별적으로 작동시킬 수 있는 게 아니기 때문에 재수가 없다면 하나의 쓰레드만 계속해서 기회를 받을 수 있기 때문이다.
// 이것을 기아(starvation) 현상이라고 한다.
// 또한 이것을 해결하기 위해서 notifyAll 메서드를 사용할 경우 동시에 꺠어나서 서로 lock을 얻기 위해 경쟁 상태(race condition)에 빠질 수도 있다.


public class ThreadStudy13 {
    public static void main(String[] args) throws InterruptedException {
        Table table = new Table();

        new Thread(new Cook(table), "요리사").start();
        new Thread(new Customer("donut", table), "도넛 매니아").start();
        new Thread(new Customer("buger", table), "햄버거 매니아").start();

        Thread.sleep(100);
        System.exit(0);
    }
}
    class Table {
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
            notify();
        }

        // 해당 음식 제거
        public boolean remove(String dish) {
            synchronized (this){
            while(dishes.size()==0) {
                String name = Thread.currentThread().getName();

                try {
                    wait();
//                    Thread.sleep(10);
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

    class Cook implements Runnable {
        private Table table;

        Cook(Table t) {
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

    class Customer implements Runnable {
        private Table table;
        private String dish;

        Customer(String name, Table table) {
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