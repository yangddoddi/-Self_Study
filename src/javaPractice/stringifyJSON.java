package javaPractice;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class stringifyJSON {

//    public String ObjectMapper(Object data) throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.writeValueAsString(data);
//    }

    public String stringify(Object data) {

//    //입력된 값이 문자열일 경우
        if (data instanceof String) {
            return "\"" + (String)data + "\"";
        }

//    //입력된 값이 Integer일 경우
        else if (data instanceof Integer) {
            return String.valueOf(data);
        }

        //입력된 값이 Boolean일 경우
        else if (data instanceof Boolean) {
            return String.valueOf(data);
        }
//
        //입력된 값이 Object[]일 경우
        else if (data instanceof Object[]) {
            return recursiveToArray((Object[]) data);
        }
//
//    //입력된 값이 HashMap일 경우
        else if (data instanceof HashMap) {
            return recursiveToHashMap((HashMap) data);
        }

//    //지정되지 않은 타입의 경우에는 "null"을 리턴합니다.
        else {
            return "null";
        }
    }
    public String recursiveToArray(Object[] arr) {
        StringBuilder arrToString = new StringBuilder();
        arrToString.append("[");
        for (int i=0; i<arr.length; i++) {
            if (arr[i] != null) { arrToString.append(stringify(arr[i])).append(","); }
            else if ( arr[i] instanceof Object[] ) { recursiveToArray((Object[]) arr[i]); }
            // 반복문의 마지막일 경우 쉼표 제거
            if ( i == arr.length-1 ) { arrToString.deleteCharAt(arrToString.length()-1); }
        }
        arrToString.append("]");
        return arrToString.toString();
    }

    public String recursiveToHashMap(HashMap<Object, Object> map) {
        // StringBuilder 선언
        StringBuilder mapToString = new StringBuilder();
        mapToString.append("{");
        // map Iterator 생성
        Iterator<Map.Entry<Object,Object>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, Object> entry = (Map.Entry) entries.next();
            String key = stringify(entry.getKey());
            String value = stringify(entry.getValue());
            mapToString.append(key).append(":").append(value).append(",");
            // 반복문의 마지막일 경우 쉼표 제거
            if (!entries.hasNext()) { mapToString.deleteCharAt(mapToString.length()-1); }
        }
        mapToString.append("}");
        return mapToString.toString();
    }
}
