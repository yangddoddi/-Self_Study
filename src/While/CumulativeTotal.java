package While;

// 1부터 ?까지의 수를 더하며 100과 가까운 수 만들기.
public class CumulativeTotal {
    public static void main(String[] args) {
        int maxNum = 0;
        int num = 0;
        while ((maxNum += ++num) < 100) {
            System.out.printf("%d ... %d%n", num, maxNum);
        }
    }
}

// 내가 만든 코드는 쓸데없이 길다.
// while 조건문 안에서도 연산이 가능하다는 것을 배웠다.
//public class whileStudy.CumulativeTotal {
//    public static void main(String[] args) {
//        int maxNum = 0;
//        int num = 0;
//        while (maxNum < 100) {
//            num++;
//            maxNum += num;
//            if (maxNum > 100) { break; };
//            System.out.printf("%d ... %d%n", num, maxNum);
//        }
//    }
//}

