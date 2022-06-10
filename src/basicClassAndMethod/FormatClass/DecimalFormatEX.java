package basicClassAndMethod.FormatClass;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class DecimalFormatEX {
    public static void main(String[] args) {
        double num = 1234567.8901;
        String[] patterns = { "0", "#", "#######.####", "###,###,###", "-#.#", "#E0", "####.###%", "\u00A4", "###.###\u2030"};

        for ( int i=0; i< patterns.length; i++ ) {
            DecimalFormat format = new DecimalFormat(patterns[i]);
            System.out.println(patterns[i] + " : " + format.format(num));
        }

        long num2 = 123456789;
        DecimalFormat format1 = new DecimalFormat("###,###,###");
        DecimalFormat format2 = new DecimalFormat("###,###,###.0");

        System.out.println( "===================");
        System.out.println( num2 + " -> " + format1.format(num2) + " -> " + format2.format(num2));
    }
}
