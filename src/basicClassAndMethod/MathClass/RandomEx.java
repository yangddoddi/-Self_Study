package basicClassAndMethod.MathClass;


import java.util.Arrays;

public class RandomEx {
        public static void main (String[] arg) {
                int[] numArr = new int[100];
                int[] counter = new int[10];

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
                for ( int i=0; i<numArr.length; i++) {
                        counter[numArr[i]]++;
                }

                System.out.println(Arrays.toString(counter));

                for ( int i=0; i< counter.length; i++) {
                        System.out.println(i + "의 개수는 ? " + drawMarks('#',counter[i]) + "" + counter[i] + "개");
                }

        }

        static String drawMarks(char mark, int counter) {
                char[] drawing = new char[counter];
                for ( int i=0; i< drawing.length; i++) {
                        drawing[i] = mark;
                }
                return String.valueOf(drawing);
        }
}