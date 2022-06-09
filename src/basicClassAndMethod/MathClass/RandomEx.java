package basicClassAndMethod.MathClass;


import java.util.Arrays;

public class RandomEx {
        public static void main (String[] arg) {
                int[] numArr = new int[100];
                int[] counter = new int[10];

                //1. 난수 생성해서 배열에 넣는다.
                System.out.println("randomNum = ");
                for ( int i=0; i<numArr.length; i++) {
                        int randomNum = (int)(Math.random() * 10);
                        numArr[i] = randomNum;
                        System.out.printf("%d", randomNum);
                }
                System.out.println("=========== Random Graph");

//                for ( int i=0; i< counter.length; i++) {
//                        for ( int j=0; j< numArr.length; j++ ) {
//                                if ( i == numArr[j] ) {
//                                        counter[i]++;
//                                }
//                        }
//                }

                // 2. 해당 값을 counter의 각 인덱스에 넣음(인덱스와 numArr의 값이 동일하기 때문에 가능)
                for (int j : numArr) {
                        counter[j]++;
                }

                System.out.println(Arrays.toString(counter));

                for ( int i=0; i< counter.length; i++) {
                        System.out.println(i + "의 개수는 ? " + drawMarks('#',counter[i]) + "" + counter[i] + "개");
                }

        }

        // 3. counter의 [i]인덱스 값을 받아서 해당 개수만큼 mark를 리턴한다.
        static String drawMarks(char mark, int counter) {
                char[] drawing = new char[counter];
                for ( int i=0; i< drawing.length; i++) {
                        drawing[i] = mark;
                }
                return String.valueOf(drawing);
        }
}