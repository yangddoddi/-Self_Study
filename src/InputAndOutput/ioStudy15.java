package InputAndOutput;

// RandomAccessFile은 DataInput 인터페이스와 DataOutput 인터페이스를 모두 구현하고 있기 때문에
// 입출력을 하나의 클래스에서 모두 할 수 있도록 만들어져 있다.
// 또한 해당 인터페이스에는 기본 자료형 읽고 쓰기에 대한 정의가 있기 때문에 마찬가지로 기본 자료형 읽고 쓰기가 가능하다.
// 파일을 읽고 쓰는 위치에도 제한이 없으며 포인터도 개발자가 원하는 위치로 옮길 수 있다.

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ioStudy15 {
    public static void main (String[] args) {
        RandomAccessFile raf = null;
        String str = "";

        try {
            raf = new RandomAccessFile("ioStudy15.txt", "rw");
            // r = 읽기 w = 쓰기 s = 파일 메타 정보

            System.out.println("포인터 위치 : " + raf.getFilePointer()); // 0
            raf.writeChars("돼지국밥"); // char 하나당 2바이트이므로 총 8바이트 이동한다.
            System.out.println("포인터 위치 : " + raf.getFilePointer()); // 8
            raf.writeChars("/n");
            raf.writeChars("순대국밥");
            System.out.println("포인터 위치 : " + raf.getFilePointer()); // 20

            raf.seek(0);
            // 파일을 작성하면서 포인터가 끝까지 이동했으므로 다시 앞으로 가져와야 한다.

            while (true) {
                str += raf.readChar();
            }
        } catch (EOFException e) {
            System.out.println(" result : " + str);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
