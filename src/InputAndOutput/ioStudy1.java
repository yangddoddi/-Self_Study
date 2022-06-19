package InputAndOutput;

// 스트림이란 ? 데이터를 운반하는데 사용되는 연결통로이다. (Stream이랑 다른 개념이다.)
// 스트림은 물과 같이 단방향 통싱만 가능하기 때문에 입출력을 동시에 하기 위해서는 input stream과 output stream 둘다 필요하다.
// Queue와 같은 FIFO 구조로 먼저 보낸 데이터를 먼저 받으며 연속적으로 주고 받는다.
public class ioStudy1 {
    public static void main(String[] args) {
        // 1, 바이트 기반 스트림
        // FileInputStream(파일, ByteArrayInputStream(메모리, PipedInputStream(프로세스, AudioInputStream(오디오
        // 당연히 반대도 존재한다.

        // 2. 보조 스트림
        // 코드상으로는 이들이 입출력 기능을 수행하는 것처럼 보이나 실제로는 바이트기반 스트림이 수행하며 이들이 버퍼를 제공하여 성능의 이점을 제공한다.
        // 대부분의 경우 버퍼 유무의 차이가 상당하기 때문에 버퍼를 이용한 보조 스트림을 사용한다.
        // FilterInputStream, BufferedInputStream, DataInputStream, SequenceInputStream ... 등등

        // 3. 문자 기반 스트림 (Read, Write)
        // 자바에서는 char형이 2byte이기 때문에 바이트 기반 스트림으로는 문자 입출력에 어려움이 있다.
        // 따라서 문자 데이터 입출력 시에는 바이트 스트림 대신 문자기반 스트림을 사용한다.
        // FileInputStream -> FileReader
        // ByteArrayInputStream -> CharArrayReader
        // PipedInputStream -> PipedReader
        // StringBufferInputStream -> StringReader
        // 문자 기반은 바이트 기반에서 input은 reader로 oupter은 writer로 바꾸면 된다.
    }
}

// 스트림의 구조는 다음과 같다

abstract class InputStream {
    //..
    abstract int read(); // 입력 스트림으로부터 1byte를 읽어서 반환, 읽을 수 없으면 -1 반환
    //..
//    int read(byte[] b, int off, int len) {
//        //...
//        for(int i=0; i< off+len; i++) {
//            // read를 호출해서 읽고 배열에 채운다
//            b[i] = (byte)read();
//        }
//    }

//    int read(byte[] b) {
//        // 입력스트림으로부터 byte배열 b의 크기만큼 데이터를 읽어서 배열 b에 저장한다.
//        return read(b,0,b.length);
//    }
}