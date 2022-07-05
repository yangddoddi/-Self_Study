package standardOfJava.Basic;

class Watch {
    private int hour;
    private int minute;

    public void setHour(int hour) {
        if (hour > 24 || hour < 0) {
            return;
        } else {
            this.hour = hour;
        }
    }

    public int getHour() {
        return this.hour;
    }

    public void setMinute(int minute) {
        if (minute > 59 || minute < 0) {
            return;
        } else {
            this.minute = minute;
        }
    }

    public int getMinute() {
        return this.minute;
    }
}

final class MathMath {
    private MathMath() {
    }

    public static final double PI = 3.14159265358979323846;
    public static final double E = 2.7182818284590452354;

    public static int plus(int x, int y) {
        return x+y;
    }
}

public class Modifier {
    public static void main(String[] args) {
        Watch watch = new Watch();
        watch.setHour(12);
        watch.setMinute(45);
        System.out.println(watch.getHour() + " : " + watch.getMinute());

//        MathMath math = new MathMath(); 에러!
        System.out.println(MathMath.PI);
        System.out.println(MathMath.plus(1,5));
    }
}
