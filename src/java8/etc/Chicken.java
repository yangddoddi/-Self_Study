package java8.etc;

import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME) // 런타임 시 작동
@Target(ElementType.TYPE_USE) // 파라미터에 작성할 수 있음
//@Target(ElementType.TYPE_USE) 모든 곳에 사용 가능
@Repeatable(ChickenBox.class) // 컨테이너역항할 어노테이션 범위가 더 넓어야함
public @interface Chicken {
    String value();
}
