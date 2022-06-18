package LambdaExpression;

// 해당 패키지에서 기본 제공되는 함수형 인터페이스들을 사용하는 것이 통일성, 재사용성, 유지보수 측면에서 좋다.
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class LambdaStudy2 {
    public static void main(String[] args) {
        // 1. Runnable -> 매개변수 없고 반환 값도 없다.
        Runnable r = () -> {
            System.out.println("나는 Runnable이다!");
        };
        r.run();

        // 2. Supplier -> 매개변수가 없고 반환 값만 존재한다.
        Supplier<String> s = () -> { return "s"; };
        System.out.println(s.get());

        // 3. Consumer -> 매개변수만 있고 반환 값은 존재하지 않는다.
        int b = 10;
        Consumer<Integer> c = (Integer a) -> { System.out.println(" result " + a);};
        c.accept(b);

        // 4. Function -> 한 개의 매개변수와 한 개의 반환값이 존재한다.(가장 보편적)
        int x = 20;
        Function<Integer, Integer> RemainingCalculator = (Integer num) -> { return num % 2; };
        System.out.println(RemainingCalculator.apply(20));

        // 5. Predicate -> Function과 유사하나 반환값이 boolean
        int y = 20;
        Predicate<Integer> p = (Integer num) -> {
            return num % 2 == 0;
        };
        System.out.println(p.test(y));

        // 6. 매개변수가 두개 들어가면 앞에 Bi가 붙는다.
        BiConsumer<Integer,String> bic = (Integer num, String str) -> { System.out.println( str + num ); };
        bic.accept(10,"10");
        BiFunction<Integer,Integer,Integer> bif = (Integer num1, Integer num2) -> { return num1 + num2; };
        System.out.println(bif.apply(10,10));
        BiPredicate<Integer,Integer> bip = (Integer num1, Integer num2) -> { return num2 > num1; };
        System.out.println(bip.test(20,10));

        // 7. UnaryOperator, BinaryOperator
        // 각각 Function, BiFunction의 자손으로써 매개변수와 반환값의 타입이 모두 같다.
        UnaryOperator<String> uo = (String str) -> { return "입력값 : " + str; };
        BinaryOperator<String> bo = (str1,str2) -> { return "입력값1 : " + str1 + ", 입력값2: " + str2; };
        System.out.println(uo.apply("황도"));
        System.out.println(bo.apply("감자탕","김치찌개"));

        // 컬렉션 프레임웍에 정의된 메서드 중 함수형 인터페이스를 지원하는 것들
        ArrayList<Integer> arr = new ArrayList<>();
        for ( int i=0; i<10; i++ ) { arr.add(i); }
        // 8. Collection -> boolean removeif(Predicate<E> filter) : 조건에 맞는 값을 삭제한다.
        arr.removeIf( (Integer i) -> { return i % 2 == 0 || i > 5;});
        System.out.println(arr); // [1, 3, 5]
        // 9. forEach -> void forEach(Consumer<T> action) : 모든 요소에 작업을 수행한다.
        arr.forEach( (i) -> { System.out.println(i + ",");}); // i, ... 출력
        //10. replaceAll -> void replaceAll(UnarayOperator<E> operator) : 모든 요소를 대체
        arr.replaceAll((i) -> { return i + 2; });
        System.out.println(arr); // [3, 5, 7]
        //map 메서드
        HashMap<String, Integer> map = new HashMap();
        map.put("순대국밥",8500);
        map.put("돼지국밥",8000);
        map.put("수육",25000);
        map.put("콜라",1500);
        // 11. compute -> V compute(K key, BiFunction<K,V,V> f) : 지정된 키에 작업 수행
        map.compute("순대국밥",(key, value) -> value += 500);
        System.out.println(map);
        // 12. V computeIfAbsent(K key, Function<K, V> f) : 해당 키가 있을 경우 실행 x 없을 경우 key=value값을 추가
        map.computeIfAbsent("순대국밥(특)",(key) -> 11000);
        System.out.println(map);
        // 13. V computeIfPresent(K key, BiFunction<V,V,V> f) : 해당 키가 있을 경우만 실행
        map.computeIfPresent("돼지국밥",(key, value) -> value += 500);
        System.out.println(map);
        // 14. V forEach(BiConsumer<K,V> action) 모든 요소에 작업 action 수행
        map.forEach((key,value) -> value += 500);
        System.out.println(map);
        // 15. V replaceAll(BiFunction<K,V,V> f) 모든 요소에 치환 작업 f 실행
        map.replaceAll((key,value) -> key.length() == 2 ? value+=1000 : value);
        System.out.println(map);
        // 16. merge : 해당하는 key 가 있다면 계산식을 따르고 없다면 새로운 값으로 생성
        map.merge("돼지국밥(특)",11000, (oldValue, newValue) -> oldValue+2000);
        System.out.println(map);

        // 기본형을 위한 함수형 인터페이스 (wrapper 클래스를 사용하면 성능에 불리함이 있으므로)
        // 17. (기본형)Function -> 매개변수는 (기본형) 반환값은 제네릭
        IntFunction<String> intf = (a) -> { return a + "안뇽"; };
        System.out.println(intf.apply(10));
        // 18. (기본형A)To(기본형B)Fucntion -> 매개변수는 (기본형A) 반환값은 (기본형B)
        IntToDoubleFunction itdf = (num) -> { return num * 0.0001; };
        System.out.println(itdf);
        // 19. To(기본형)Function -> 매개변수는 제네릭 반환값은 (기본형)
        ToDoubleFunction<Integer> tdf = (num) -> { return num / 10000; };
        System.out.println(tdf);
        // 20. ObjIntConsumer<T> -> 입력은 Obj(A,T) 반환값은 없다
        ObjIntConsumer<String> oic = (String str, int num) -> { System.out.println(num + str); };
        System.out.println(oic);
        // 참고 : 입력 타입과 반환 타입이 같을 경우 UnaryOperator를 사용하는 것이 성능에 가장 유리하다.


        Supplier<Integer> s2 = () -> (int)(Math.random()*10);
        ArrayList<Integer> arr2 = (ArrayList<Integer>)getRandomNum(s2, 20);
        System.out.println(arr2);

        List<Integer> newArr = doSomething((i) -> i-1, arr);
        System.out.println(newArr);
    }
    static <T> List<T> doSomething(Function<T,T> f, List<T> list) {
        List<T> newList = new ArrayList<>(list.size());
        for(T i : list) {
            newList.add(f.apply(i));
        }
        return newList;
    }
    static <T> List<T> changeEvenNumArr(Predicate<T> p, Function<T, List<T>> f, List<T> list) {
        List<T> newList = new ArrayList<>();
        for ( T t : list ) {
            if ( p.test(t) ) { list.add(t); }
        }
        return newList;
    }
    static <T> List<T> getRandomNum(Supplier<T> s, int num) {
        List<T> list = new ArrayList<>();
        for ( int i=0; i<10; i++) {
            list.add(s.get());
        }
        return list;
    }
}
