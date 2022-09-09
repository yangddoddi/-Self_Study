package java8.methodAndStaticMethod;

/*
*
* default method 사용 시 이를 상속받은 모든 클래스가 별도 구현 없이 해당 메서드를 사용할 수 있다.
* 단, 기본 구현체가 정확히 어떤 역할을 하는지 문서화 필수(@ImplSpec)
* (인터페이스 구현이 어떤 형태가 될지 모르니 항상 동일한 작동을 보장할 수 없음)
* 필요하다면 구현하는 쪽에서 또 오버라이딩해서 재정의할 수 있다.
*
* Object 에서 제공하는 메서드는 default 메서드로 재정의할 수 없다.
*
* Interface가 Interface를 상속받을 때, Default Method를 추상 메서드로 변환하면 기존 메서드를 덮어씌운다.
* 두 인터페이스를 모두 구현받는데 양쪽 모두 같은 디폴트 메서드를 가지고 있으면 어떻게 되는가?
* 컴파일 에러가 발생한다. (충돌하는 경우는 직접 오버라이딩해야 한다.)
*
* */



public class StudyInterfaceImpl implements StudyInterface {
    String name;

    public StudyInterfaceImpl(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    public static void main(String[] args) {
        StudyInterfaceImpl studyInterface = new StudyInterfaceImpl("apple");
        studyInterface.printNameUpperCase();
        studyInterface.printName();

        StudyInterface.printAnything();
    }
}
