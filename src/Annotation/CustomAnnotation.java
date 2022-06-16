package Annotation;

import Annotation.CustomAnnotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
@SuppressWarnings("1111") // 무의미한 애너테이션은 무시된다.
@TestInfo(testedBy="aaa", testDate=@DateTime(yymmdd="160101", hhmmss ="235959"))
// interface에서 정의한 변수를 모두 지정해줘야 한다.
public class CustomAnnotation {
    public static void main(String[] args) {
        Class<CustomAnnotation> cls = CustomAnnotation.class;
        // 클래스 객체를 얻는다
        TestInfo anno = (TestInfo) cls.getAnnotation(TestInfo.class);
        System.out.println("anno.testedBy()="+anno.testedBy());
        System.out.println("anno.testDate().yymmdd()="+anno.testDate().yymmdd());
        System.out.println("anno.testDate().hhmmss()="+anno.testDate().hhmmss());

        for(String str : anno.testTools()) {
            System.out.println("testTools="+str);
        }

        System.out.println();

        Annotation[] annoArr = cls.getAnnotations();
        // 해당 클래스에 저장된 모든 어노테이션을 가져온다
        // SuppressWarning은 무의미한 값 지정으로 저장이 되지 않은 것 확인 가능
        for(Annotation a : annoArr) {
            System.out.println(a);
        }
    }
}

@Retention(RetentionPolicy.RUNTIME) //
@interface TestInfo {
    int count() default 1;
    String testedBy();
    String[] testTools() default "JUnit";
    TestType testType() default TestType.FIRST;
    DateTime testDate();
}

@Retention(RetentionPolicy.RUNTIME) //
@interface DateTime {
    String yymmdd();
    String hhmmss();
}

enum TestType { FIRST, FINAL }