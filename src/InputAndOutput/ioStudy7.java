package InputAndOutput;

//DataInputStream, DataOutputStream
//DataInput,Output 클래스를 구현했기 때문에 byte단위가 아닌 기본 자료형 단위로 읽고 쓸 수 있다.

import java.io.*;

public class ioStudy7 {
    public static void main(String[] args) {
        int[] score = { 75,40,100,95,89,77 };
        int[] temp = null;
        try {
            FileOutputStream fos = new FileOutputStream("ioStudy7.txt");
            DataOutputStream dos = new DataOutputStream(fos);

            for(int num : score) {
                dos.writeInt(num);
                // 16진수로 저장되기 때문에 일반 뷰어로는 내용을 확인할 수 없다.
            }

            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int total = 0;

        FileInputStream fis = null;
        DataInputStream dis = null;
        try {
            fis = new FileInputStream("ioStudy7.txt");
            dis = new DataInputStream(fis);
            while (true) {
                total += dis.readInt();
            }
        } catch (EOFException ee) {
            System.out.println("점수 총합은 " + total + "점 입니다.");
            // DataInputStream은 더이상 읽을 값이 없으면 EOFException을 발생시킨다.
            // 따라서 무한 반복문으로 값을 읽고 catch문에서 예외처리를 해줘야 한다.
        } catch (IOException ie) {
            ie.printStackTrace();
        } finally {
            try {
                if (dis != null) {
                    dis.close();
                }
                // 만약 DataInputStream이 null일 때 종료하면 예외를 발생시킨다.
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
