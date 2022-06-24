import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
//        System.out.println(computeAverageOfNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    public static String computeDifference(int num1, int num2) {
        // TODO:
        return String.format("%s,%s의 차이는 %s입니다.", num1, num2, Math.abs(num1 - num2));
    }

    //조건문을 사용하여 짝수인 경우 return false를,
    //홀수인 경우 return true;를 작성해야 합니다.
    //조건 : while문만 사용 가능
    public static boolean isOdd(int num) {
        while (num != 0) {
            num = Math.abs(num) - 2;
        }
        return num != 0 ? true : false;
    }

    // 수를 입력 받아 1부터 해당 수 까지의 수 중에서 3의 배수로만 구성된 문자열 반환
    public String makeMultiplesOfDigit(int num) {
        String result = "";
        for (int i = 1; i <= num; i++) {
            if (i % 3 == 0) {
                result += i;
            }
        }
        return result;
    }

    // 두 개의 수를 입력받아 두 수를 포함해 두 수 사이의 수 중 2의 배수 리턴
    public int makeMultiplesOfDigit2(int num1, int num2) {
        int max = Math.max(num1, num2);
        int min = Math.min(num1, num2);
        int result = 0;
        for (int i = 0; i <= max; i += 2) {
            if (min <= i && i != 0 && max >= i) {
                result += 1;
            }
        }
        return result;
    }

    // 문자열에서 특정 char 인덱스 리턴
    public int findTheBug(String word) {
        int noBug = -1;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '#') {
                return i;
            }
        }
        return noBug;
    }

    // 문자열에서 문자 등장하는 횟수 리턴
    public int countCharacter(String str, char letter) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == letter) {
                sum += 1;
            }
        }
        return sum;
    }

    // 문자열에서 가장 큰 숫자 찾기
    public static int getMaxNumberFromString(String str) {
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            if (max < Character.getNumericValue(str.charAt(i))) {
                max = Character.getNumericValue(str.charAt(i));
            }
        }
        return max;
    }

    // 문자열 , 문자 두 개를 받아 문자열 변형
    public String replaceAll(String str, char from, char to) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != from) {
                result += str.charAt(i);
            } else {
                result += to;
            }
        }
        return result;
    }

    // 문자열을 받아 각 문자열 뒤에 해당 문자의 인덱스가 추가된 문자열 리턴
    public static String characterAndNumber(String word) {
        String result = "";
        for (int i = 0; i < word.length(); i++) {
            result += word.charAt(i) + String.valueOf(i);
        }
        return result;
    }

    // 밑과 지수를 입력 받아 밑의 거듭제곱 구하기
    // Math 클래스 사용 금지
    public static int computePower(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        int result = base;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    // 수를 입력받아 약수(factor)의 합을 리턴해야 합니다.
    public int getSumOfFactors(int num) {
        int result = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                result += i;
            }
        }
        return result;
    }

    // 1 이상의 자연수를 입력받아 소수인지 여부 리턴한다.
    public boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        if (num % 2 == 0) {
            return false;
        }
        // 무의미한 연산을 제외하기 위해 짝수는 모조리 false
        for (int i = 3; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
            // 제곱근 밑으로는 모두 더 큰 수의 짝이 있기 때문에 제곱근 이하까지만 계산한다.
        }
        return true;
    }

    // 2 이상의 자연수를 입력받아 2부터 해당 수가지 소수를 리턴
    // 조건 : 이중반복문
    public static String listPrimes(int num) {
        String result = "2";
        for (int i = 2; i < 3; i++) {
            for (int j = 3; j <= num; j++) {
                if (j % i != 0) {
                    result += "-" + String.valueOf(j);
                }
            }
        }
        return result;
    }

    // n 이하의 소수 구하기
    public static String test(int num) {
        boolean[] booleans = new boolean[num + 1];
        booleans[0] = booleans[1] = true;

        ArrayList<Integer> results = new ArrayList<>();

        for (int i = 2; i * i <= num; i++) {
            if (!booleans[i]) { // java에서 boolean의 기본값은 false이다.
                for (int j = i * i; j <= num; j += i) {
                    booleans[j] = true; // 특정 수의 배수는 모두 소수가 아니다.
                }
            }
        }

        for (int i = 0; i < booleans.length; i++) {
            if (!booleans[i]) {
                results.add(i);
            }
        }
        return results.toString();
    }

    // 문자열을 입력받아 해당 문자열에 등장하는 각 문자를 가지고 만들 수 있는 길이 2의 문자열들 리턴
    public static String makePermutations(String str) {
        String prev = "";
        String next = "";
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            prev = str.substring(i, i + 1);
            for (int j = 0; j < str.length(); j++) {
                next = str.substring(j, j + 1);
                if (i == str.length() - 1 && j == str.length() - 1) {
                    result += prev + next;
                } else {
                    result += prev + next + ",";
                }
            }
        }
        return result;
    }

    // 문자열을 분할하여 재출력하기
    public static String makeMarginalString(String str) {
        String temp = "";
        String result = "";
        if (str == "") {
            return "";
        }
        for (int i = 0; i < 1; i++) {
            temp += str.charAt(i);
            for (int j = 1; j < str.length(); j++) {
                result += temp;
                temp += str.charAt(j);
            }
            result += temp;
        }
        return result;
    }

    // 다음 요일 출력하기
    public String followingDay(String day) {
        String[] days = {
                "월요일", "화요일", "수요일", "목요일", "금요일", "토요일", "일요일"
        };
        for (int i = 0; i < days.length; i++) {
            if (days[i].equals(day)) {
                if (i == days.length - 1) {
                    return days[0];
                } else {
                    return days[i + 1];
                }
            }
        }
        return "올바른 요일이 아닙니다";
    }

    // 점수별 출력
    public String convertScoreToGradeWithPlusAndMinus(int score) {
        if (score > 100 || score < 0) {
            return "INVALID SCORE";
        }
        String result = "";
        if (score == 100) {
            return "A+";
        }

        if (score >= 90) {
            result += "A";
        } else if (score >= 80) {
            result += "B";
        } else if (score >= 70) {
            result += "C";
        } else if (score >= 60) {
            result += "D";
        } else if (score < 60) {
            result += "F";
        }

        if (!result.equals("F")) {
            if (score % 10 < 3) {
                result += "-";
            } else if (score % 10 >= 8) {
                result += "+";
            }
        }
        return result;
    }

    //빗변 세개가 주어졌을 때 직각 삼각형 여부
    public class Solution {
        public boolean isPythagorean(int side1, int side2, int side3) {
            double a = Math.pow(side1, 2);
            double b = Math.pow(side2, 2);
            double c = Math.pow(side3, 2);

            if (a == b + c || b == a + c || c == a + b) {
                return true;
            }
            return false;
        }
    }

    // 배열 복사해서 앞에 다른 요소 넣음
    public int[] addToFront(int[] arr, int el) {
        // TODO:
        int[] newArr = new int[arr.length + 1];
        newArr[0] = el;
        System.arraycopy(arr, 0, newArr, 1, arr.length);
        return newArr;
    }

    // 해당 인덱스를 제외한 배열 생성
    public int[] getAllElementsButNth(int[] arr, int n) {
        // TODO:
        if (arr.length < n) {
            return arr;
        }
        if (arr.length == 0 || arr.length == 1) {
            return new int[0];
        }
        int[] newArr = new int[arr.length - 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == n) {
                continue;
            }
            newArr[index++] = arr[i];
        }
        return newArr;
    }

    // 배열 받아서 전화번호 형태로 바꾸기.. 정말 싫다
    public String createPhoneNumber(int[] arr) {
        int[] head1 = {0, 1, 0};
        int[] head2 = new int[3];
        int[] body = new int[4];
        int[] tail = new int[4];
        int[] newArr = new int[11];

        if (arr.length == 8) {
            System.arraycopy(arr, 0, body, 0, 4);
            System.arraycopy(arr, 4, tail, 0, 4);
            String str = "(" + Arrays.toString(head1) + ")" + Arrays.toString(body) + "-" + Arrays.toString(tail);
            str = str.replace("[", "");
            str = str.replace("]", "");
            str = str.replace(",", "");
            str = str.replace(" ", "");
            return str;
        } else {
            System.arraycopy(arr, 0, head2, 0, 3);
            System.arraycopy(arr, 3, body, 0, 4);
            System.arraycopy(arr, 7, tail, 0, 4);
            String str = "(" + Arrays.toString(head2) + ")" + Arrays.toString(body) + "-" + Arrays.toString(tail);
            str = str.replace("[", "");
            str = str.replace("]", "");
            str = str.replace(",", "");
            str = str.replace(" ", "");
            return str;
        }
    }

    //피보나치 배열
    public static long fibonacci(int num) {
        long[] arr = new long[num];
        long result = 0;
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[arr.length - 1];
    }

    //피보나치 재귀
    public static long fibonacci2(int num) {
        if (num == 1) {
            return 1;
        }
        if (num == 2) {
            return 1;
        }
        return fibonacci2(num - 1) + fibonacci2(num - 2);
    }

    // 피보나치 메모이제이션
    static long[] memo = new long[100];

    public static long fibonacci3(int num) {
        if (num == 1 || num == 2) {
            return 1;
        } else if (memo[num] != 0) {
            return memo[num];
        } else {
            return memo[num] = fibonacci3(num - 1) + fibonacci3(num - 2);
        }
    }
}