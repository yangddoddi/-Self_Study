package standardOfJava.InputAndOutput;

//FilterInputStream/FilterOutputStream은 inputStream/outputStream의 자손이면서 모든 보조스트림의 조상이다.
//위의 두가지로는 어떠한 작업도 할 수 없으며 인스턴스도 생성할 수 없다. 상속을 통해 오버라이딩 되어야한다.

//FilterInputStream의 자손 : BufferedInputStream, DataInputStream, PushbackInputStream 등
//FilterOutputStream의 자손 : BufferedOutputStream, DataOutputStream, PrintStream 등

//BufferedInputStream(inputStream in, int size), BufferedOutputStream(inputStream in)
//Buffer(배열)을 이용해서 전송하는 것이 효율적이기 때문에 대부분의 입출력 작용에 사용된다.
//버퍼 크기는 일반적으로 8192(8k)로 지정
//버퍼에 크기만큼 데이터 저장 -> 읽기 (외부로부터 읽기보다 내부에서 읽는 것이 더 효율적이기 때문)
//BufferOuput의 경우에는 write의 출력을 버퍼에 저장하고 가득차면 출력소스에 출력한다.

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ioStudy6 {
    public static void main(String[] args) {
        try {
            FileOutputStream ouput = new FileOutputStream("ioStudy6-2.txt");
            BufferedOutputStream bos = new BufferedOutputStream(ouput, 8192);

            for (int i='0'; i<'9'; i++) {
                bos.write(i);
            }
            bos.close();
            // 중요
            // buffer는 기본적으로 가득차야만 출력한다.
            // 따라서 마지막에 flush()혹은 close() 메서드로 남아있는 데이터를 출력시켜줘야 한다.
            // 또한 보조스트림에서 close()메서드를 사용하면 기반 메서드에서는 close()메서드를 호출할 필요가 없다.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
