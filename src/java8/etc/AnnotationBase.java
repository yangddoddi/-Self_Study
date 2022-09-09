package java8.etc;

@Chicken("양념")
@Chicken("프라이드")
public class AnnotationBase {
    public static void main(String[] args) {
        ChickenBox chickenList = AnnotationBase.class.getAnnotation(ChickenBox.class);
        System.out.println(chickenList);
    }

//    public static class FeelsLikeChicken<T> {
//        public static void print(C c) { // 앞은 타입 파라미터, 뒤는 타입
//
//        }
//    }
}
