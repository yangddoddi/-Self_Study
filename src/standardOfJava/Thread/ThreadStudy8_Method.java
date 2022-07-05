package standardOfJava.Thread;

import javax.swing.*;

public class ThreadStudy8_Method {
    public static void main(String[] args) {
        Thread th = new ThreadStudy8_1();

        th.start();

        String input = JOptionPane.showInputDialog("아무 글자나 입력하세요");
        System.out.println("입력값 ? " + input);
        th.interrupt();
        System.out.println(th.isInterrupted());
    }
}
// void interrupt()
// boolean isInterrupted()
// static boolean interrupted()
// interrupt는 무조건 정지만 시키는 것이 아니라 정지 중인 쓰레드에 interrupt를 호출하면 다시 실행 대기 상태가 된다

class ThreadStudy8_1 extends Thread {
    public void run() {
        for ( int i=1000000; i>=0; i--) {
            if (!isInterrupted()) {
                System.out.println(i);
                delay(1000);
            } else {
                break;
            }
        }
        System.out.println("종료");
    }

    public void delay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception ignored) {
            interrupt();
//             왜 여기서 다시 interrupt()를 호출하는가?
//             Thread가 sleep 상태일 때 interrupt가 호출되면 InterruptedException이 발동하며
             //다시 false가 되어버리낟. 따라서 catchdptj cjflgownjdigka.
        }
    }
}
