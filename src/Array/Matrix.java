package Array;

import java.util.Arrays;

// 행렬 곱하
public class Matrix {
    public static void main(String[] args) {
        int[][] matrix1 = {
                { 1, 2, 3},
                { 4, 5, 6},
        };

        int [][] matrix2 = {
                { 1, 2 },
                { 3, 4 },
                { 5, 6 },
        };

        int [][] matrix3 = new int[matrix1.length][matrix2[0].length];

//        m3[0][0] =
//                m1[0][0]*m2[0][0]
//                + m1[0][1]*m2[1][0]
//                + m1[0][2]*m2[2][0]
//
//        m3[0][1] =
//                m1[0][0]*m2[0][1]
//                + m1[0][1]*m2[1][1]
//                + m1[0][2]*m2[2][1]
//
//        m3[1][0] =
//                m1[1][0]*m2[0][0]
//                + m1[1][1]*m2[1][0]
//                + m1[1][2]*m2[2][0]
//
//        m3[1][1] =
//                m1[1][0]*m2[0][1]
//                + m1[1][1]*m2[1][1]
//                + m1[1][2]*m2[2][1]
//        =>
//            m[i][j] = m[i][0] * m2[0][j]
//                     +m[i][1] * m2[1][j]
//                     +m[i][2] * m2[2][j]


        for (int i=0; i<matrix1.length; i++) {
            for (int j=0; j<matrix2[0].length; j++) {
                for (int k=0; k< matrix1[0].length; k++) {
                    matrix3[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        System.out.println(Arrays.deepToString(matrix3));
    }
}
