import java.util.*;
import java.io.*;

// 숫자를 문자열로 입력받는다
// 문자열을 char 배열로 변환한다
// 각 char를 모두 더한다

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        char[] numArr = br.readLine().toCharArray();
        Long result = 0L;
        
        for (int i=0; i<numArr.length; i++) {
            result += Character.getNumericValue(numArr[i]);
        }
        
        System.out.println(result);
    }
}