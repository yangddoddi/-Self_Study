package basicClassAndMethod.WrapperClass;

public class WrapperClass {
    public static void main(String[] args) {
        Boolean bool = new Boolean(false);
        Character c = new Character('s');
        Byte b = new Byte((byte) 1);
        Short s = new Short((short) 1111);
        Integer integer = new Integer(100);
        Long longLong = new Long(100000000000000L);
        Float f = new Float(123.123f);
        Double d = new Double(123.1112334455);

        System.out.println("bool == new Boolean(false) ? " + (bool == new Boolean(false)));
        System.out.println("bool.equals(new Boolean(false)) ? " + (bool.equals(new Boolean(false))));
        // Integer는 비교 연산자를 사용할 수 없기 때문에 compareTo로 비교해야 한다.
        System.out.println("f.compareTo(823.123f) ? " + f.compareTo(823.123f));
        System.out.println("bool.compareTo(new Boolean(true) ? " + bool.compareTo(new Boolean(true)));
        System.out.println("longLong.toString() ? " + longLong.toString());
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println("Double.Min_VALUE = " + Double.MIN_VALUE);

        // 문자열 변환
        byte num1 = Byte.parseByte("2");
        int num2 = Integer.parseInt("3000");
        int num3 = Integer.parseInt("FF",16);

        //
        int i = new Integer("100").intValue();
        int i2 = Integer.parseInt("100");
        Integer i3 = Integer.valueOf("100");
        System.out.println(i2 + 2); // i2.intValue() + 2와 같다.
        // 기본형과 덧셈의 더하기를 자동으로 가능하게 만들어줌(오토박싱)

        int intint = 0;
        Integer inte = (Integer)intint;
        Integer inte2 = Integer.valueOf(i);

        Object obj = (Object)inte;
        Object obj2 = (Object)Integer.valueOf(i);

        Long lng = 100L;
        Long lng2 = new Long(100);
    }
}
