package InputAndOutput;

import java.io.*;

// PipedReader & PipedWriter
// 쓰레드간 데이터를 주고 받을 때 사용한다.
// 다른 스트림과 다르게 입출력을 하나의 스트림으로 연결해서 데이터를 주고 받는다.
// 하나의 스트림만 닫아도 나머지 스트림도 같이 닫힌다.
public class ioStudy10 {
    public static void main(String[] args) {
        InputThread inputT = new InputThread("input Thread");
        OutputThread outputT = new OutputThread("output Thread");

        inputT.connect(outputT.getOutput());
        inputT.start();
        outputT.start();
    }
}

class InputThread extends Thread {
    PipedReader pr = new PipedReader();
    StringWriter sw = new StringWriter();

    InputThread(String name) {
        super(name);
    }

    public void run() {
        int data = 0;
        try {
            while ((data = pr.read()) !=-1 ) {
                sw.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + " received : " + sw.toString());
    }

    public PipedReader getInput() {
        return pr;
    }

    public void connect(PipedWriter output) {
        try {
            pr.connect(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class OutputThread extends Thread {
    PipedWriter pw = new PipedWriter();

    OutputThread(String name) {
        super(name);
    }

    public void run() {
        String str = "Hello";
        try {
            pw.write(str);
            pw.close();
            }
        catch (IOException e) {
        e.printStackTrace();
        }
        System.out.println(getName() + " sent : " + str);
    }

    public PipedWriter getOutput() {
        return pw;
    }

    public void connect(PipedReader input) {
        try {
            pw.connect(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}