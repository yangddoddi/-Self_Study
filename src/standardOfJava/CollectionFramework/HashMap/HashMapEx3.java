package standardOfJava.CollectionFramework.HashMap;

import java.util.*;
import java.util.Map.Entry;

public class HashMapEx3 {
    public static void main(String[] args) {
    // 전화번호를 추가할 메서드..
        addPhoneNo("가족","어머니","010-1111-1111");
        addPhoneNo("가족", "아버지", "010-2222-2222");
        addPhoneNo("회사", "김대리", "010-3333-3333");
        addPhoneNo("회사", "부장님", "010-4444-4444");
        addPhoneNo("회사", "장사원", "010-5555-5555");
        addPhoneNo("세탁소","02-333-1111");

        printPhoneBook(phoneBook);
    }

    // phonebook 초기화
    static HashMap<String,HashMap<String, String> > phoneBook = new HashMap<>();
    // 전화번호를 추가할 메서드..
    public static void addPhoneNo(String group, String name, String phoneNum) {
        addGroup(group);
        HashMap<String, String> member = phoneBook.get(group);
        member.put(phoneNum, name);
    }
    //
    public static void addGroup(String groupName) {
        if ( !phoneBook.containsKey(groupName) ) {
            phoneBook.put(groupName, new HashMap<>());
        }
        // 처음에는 addGroup 메서드를 따로 만들지 않고 addPhoneNo에서 그룹과 멤버를 모두 만들었다
        // 중복되는 키값이 들어가서 한 명씩만 저장되는 상황 발생. 따로 분리해서 재사용성을 증가시키고 조건문으로 키 값이 중복 등록되지 않도록 변경.
    }
    //
    public static void addPhoneNo(String name, String phoneNum) {
        addGroup("기타");
        HashMap<String, String> member = phoneBook.get("기타");
        member.put(phoneNum, name);
    }

    public static void printPhoneBook(HashMap<String,HashMap<String, String>> phoneBook) {
        Set groupSet = phoneBook.entrySet();
        Iterator groupIt = groupSet.iterator();
        while(groupIt.hasNext()) {
            Map.Entry e = (Entry) groupIt.next();
            Set subSet = ((HashMap)(e.getValue())).entrySet();
            Iterator subSetIt = subSet.iterator();
            System.out.println(e.getKey() + "[" + subSet.size() + "]");
            while(subSetIt.hasNext()) {
                Map.Entry e2 = (Entry)subSetIt.next();
                System.out.println("이름 : " + e2.getValue() + ", 연락처 : " + e2.getKey());
            }
            System.out.println();
        }
    }
}
