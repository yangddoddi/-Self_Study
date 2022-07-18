import java.util.*;
import java.io.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 입력받을 파일명 개수
        String[] inputPattern = br.readLine().split("\\*");
        String[] fileNames = new String[T];

        String pattern = "^" + inputPattern[0] + ".*" + inputPattern[1] + "$";

        for (int i=0; i<T; i++) {
            fileNames[i] = br.readLine();
        }

        for (String s : fileNames) {
            if (Pattern.matches(pattern, s) && s.length() != 1) {
                result.append("DA").append("\n");
            } else {
                result.append("NE").append("\n");
            }
        }

//        for (String s : fileNames) {
//            if (s.indexOf(inputPattern[0])==0 && s.lastIndexOf(inputPattern[1])==s.length()-inputPattern[1].length() && s.length()!=1) {
//                result.append("DA").append("\n");
//            } else {
//                result.append("NE").append("\n");
//            }
//        }

        System.out.println(result);
        }
    }
