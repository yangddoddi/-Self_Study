package Thread;

// 멀티쓰레드 프로세스에서 쓰레드 A가 5라는 자원을 가지고 작업 중 B가 이 자원을 1로 바꾸면 작업의 결과가 예상과 달라질 수 있다.
// 이런 것을 막기 위해 임계구역을 설정해서 해당 구역은 하나의 쓰레드가 작업을 끝내기 전까지 락을 걸어 다른 쓰레드가 간섭할 수 없게 만든다.
// 이것을 "쓰레드의 동기화" 라고 부른다.
public class ThreadStudy12 {
    public static void main(String[] args) {
        Runnable r = new MyThread12_1();
        Thread th1 = new Thread(r);
        Thread th2 = new Thread(r);

        th1.start();
        th2.start();
    }
}

class Account {
    private int balance = 1000;
    public int getBalance() {
        return balance;
    } // 잔액
    // 만약 여기에 synchronized를 붙이지 않는다면 하나의 쓰레드에서 balance를 감산하기 전에 다른 쓰레드가 메서드를 실행한다
    // 따라서 해당 메서드를 동기화하여 한 번에 하나의 쓰레드만 작업할 수 있도록 변경한다.
    synchronized public void withdraw(int money) {
        if(balance >= money ) {
            try { Thread.sleep(1000);} catch (InterruptedException e) {}
            balance -= money;
        }
    } // 출금 메서드
}

class MyThread12_1 implements Runnable {
    Account acc = new Account();

    public void run() {
        while(acc.getBalance()>0) {
            // 100, 200, 300 중 임의 값 출금
            int money = (int)(Math.random() * 3+1) * 100;
            acc.withdraw(money);
            System.out.println("잔액:"+acc.getBalance());
        }
    }
}