package standardOfJava.Thread;

import javax.swing.*;

public class ThreadStudy3 {
    public static void main(String[] args) {
//        long startTime = System.currentTimeMillis();
//        standardOfJava.String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
//        for(int i= 10; i>0; i--) {
//            System.out.println("sleep standardOfJava.Thread...");
//            try {
//                standardOfJava.Thread.sleep(1000);
//            } catch (Exception e) {}
//        }
//        System.out.println("총 소요 시간 : " + (System.currentTimeMillis() - startTime));
        // 총 소요시간 13996

        Thread th1 = new CustomThread3();
        Thread th2 = new CustomThread4();

        th1.start(); // th1 소요 시간 4156
        th2.start(); // th2 소요 시간 10039
        // 총 소요시간 10039 -> 서로 다른 자원 점유 시(다른 작업 시) 입력 대기 시간이 없어 멀티쓰레드가 유리하다.
    }
}

class CustomThread3 extends Thread {
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("th1 소요시간 ? " + (System.currentTimeMillis() - startTime));
    }
}

class CustomThread4 extends Thread {
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        for(int i= 10; i>0; i--) {
            System.out.println("sleep standardOfJava.Thread...");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
        System.out.println("th2 소요시간 ? " + (System.currentTimeMillis() - startTime));
    }
}