package standardOfJava.InputAndOutput;

import java.io.*;
import java.util.ArrayList;

// File
//

public class ioStudy16 {
    public static void main (String[] args) {
        final String PATH = "/Users/eunchanyang/Desktop/java/javaStudy";
        File file = new File(PATH);
        printFiles(file);

    }

    static void printFiles(File dir) {
        System.out.println(dir.getAbsolutePath()); // 절대 경로를 String으로 반환
        File[] files = dir.listFiles(); // 경로의 모든 파일 및 디렉토리를 배열로 반환
        ArrayList<Integer> subDir = new ArrayList<>();

        for (int i=0; i<files.length; i++) {
            String fileName = files[i].getName();
            if (files[i].isDirectory()) { // 디렉토리라면 true 반환
                fileName = "[" + fileName + "]";
                subDir.add(i);
                // 이는 디렉토리의 개수를 구하는데도 사용되지만 printFiles의 인자로 주는 것이 주 목적이다.
            }
            System.out.println(fileName);
        }
        System.out.println("총 " + subDir.size() +"개의 디렉토리");
        System.out.println("총 " + (files.length- subDir.size()) +"개의 파일");

        for(int i=0; i< subDir.size(); i++) {
            int index = subDir.get(i);
            printFiles(files[index]);
        }
        // 파일 개수와 디렉토리를 구한 후
        // 재귀를 통해 디렉토리에 다시 파일 개수와 디렉토리 구하기.. 그 디렉토리들의 파일 개수와 디렉토리 구하기.. 를 반복한다.
    }
}
