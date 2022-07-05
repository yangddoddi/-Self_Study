package standardOfJava.basicClassAndMethod.ObjectsClass;
import java.util.Arrays;
import java.util.Objects;

public class ObjectsClass {
    public static void main(String[] args) {
        String[][] strArr = new String[][]{{"a","b","c"},{"A","B","C"}};
        String[][] strArr2 = new String[][]{{"a","b","c"},{"A","B","C"}};

        System.out.println("strArr = " + Arrays.deepToString(strArr));
        System.out.println("strArr2 = " + Arrays.deepToString(strArr2));

        System.out.println("strArr.equals(strArr2) ? " + strArr.equals(strArr2));
        System.out.println("Objects.equals(strArr, strArr2) ? " + Objects.deepEquals(strArr, strArr2));
        System.out.println("Objects.isNull(null) ? " + Objects.isNull(null));
        System.out.println("Objects.nonNull()Null(null) ? " +Objects.nonNull(null));
    }
}
