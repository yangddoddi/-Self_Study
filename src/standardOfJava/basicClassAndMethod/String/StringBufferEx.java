package standardOfJava.basicClassAndMethod.String;

// StringBuffer는 쓰레드 동기화로 인해 StringBuilder보다 성능면에서 불리하다.
// 이제와서 굳이 StringBuffer를 사용할 필요는 없으나 굳이 기존 코드에서 일일히 StringBuffer를 걷어낼 필요도 없다.
public class StringBufferEx {
    public static void main(String[] args) {
        StringBuffer stringBuffer1 = new StringBuffer("호호호");
        StringBuffer stringBuffer2 = new StringBuffer("호호호");

        System.out.println("stringBuffer1 == stringBuffer2 ? " + (stringBuffer1 == stringBuffer2));
        System.out.println("stringBuffer1.equals(stringBuffer2) ? " + (stringBuffer1.equals(stringBuffer2)));

        StringBuffer stringBuffer3 = stringBuffer2.append("호호호");
        StringBuffer stringBuffer4 = stringBuffer3;

        System.out.println("stringBuffer2 ? " + stringBuffer2.toString() + ", stringBuffer3 ? " + stringBuffer3.toString());
        System.out.println("stringBuffer2 == stringBuffer3 ? " + (stringBuffer2 == stringBuffer3));
        System.out.println("stringBuffer4 == stringbuffer3 ? " + (stringBuffer3 == stringBuffer4));

        StringBuilder stringBuilderEx = new StringBuilder("사랑해요연예가중계");
        System.out.println("stringBuilderEx.reverse() = " + stringBuilderEx.reverse());
        System.out.println("stringBuilderEx.delete(0, 5) = " + stringBuilderEx.delete(0, 5));
        System.out.println("stringBuilderEx.replace(0,5,\"사랑해요자바스크립트\") = " + stringBuilderEx.replace(0,5,"사랑해요자바스크립트"));
        stringBuilderEx.setLength(6);
        System.out.println("stringBuilderEx.setLength(6) = " + stringBuilderEx );
        System.out.println();
    }
}
