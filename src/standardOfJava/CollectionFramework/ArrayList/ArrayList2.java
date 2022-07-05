package standardOfJava.CollectionFramework.ArrayList;

import java.util.ArrayList;

public class ArrayList2 {
    public static void main(String[] args) {
        final int LIMIT = 10;
        String source = "0123456789ㄱㄴㄷㄹㅁㅂㄷㅈㄱㄴabcdertwqe!@$%^&!#$%ssssss";
        ArrayList<String> arrList = new ArrayList<>(source.length()+10);
        int length = source.length();

        for ( int i=0; i<length; i+=LIMIT) {
            if( i+LIMIT < length ) {
                arrList.add(source.substring(i,i+LIMIT));
            } else { // 10자리씩 끊어낼 수 없을 경우
                arrList.add(source.substring(i));
            }
        }

        System.out.println(arrList.size());
        for (String arr : arrList) {
            System.out.println(arr);
        }
    }
}
