import java.util.*;
import java.io.*;

public class Main {
    static long count = 0;

    public static void main(String[] args) throws Exception {
//        N개의 수로 이루어진 수열
//        버블소트 수행 시 swap이 발생하는 횟수 체크하는 프로그램 작성
//        N의 최대 개수 500,000
//        버블소트로 연산 시 O(n^2) => 250000000000
//        머지소트로 연산 시 O(nlog(n)) => 2849485
//        일반적으로 초당 연산 가능 횟수 -> 1억~10억
//        -> 다른 방법도 있겠지만 일반적으로 저격이 어려운 merge sort로 풀자.
//        A[i]의 최대 범위 = 1,000,000,000 -> 헷갈리니까 일단 long 자료형을 쓰자 (ㅋㅋ 응 아니야~ int 20억까지 커버됨)
//        수의 위치가 바뀌는 경우 (left가 right보다 큰 경우) 마다 카운트를 ++해주면 될 듯?
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        long[] temp = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        mergeSort(arr, 0, arr.length-1, temp);

        System.out.println(count);
    }

    public static void mergeSort(long[] arr, int left, int right, long[] temp) {
        if (left != right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, right, temp);
        }
    }

    public static void merge(long[] arr, int left, int right, long[] temp) {
        int m = (left + right) / 2;
        int l = left;
        int r = m + 1;
        int i = left;

        while (l <= m && r <= right) {
            if (arr[l] > arr[r]) {
                count += (m-l+1);
                temp[i++] = arr[r++];
            } else {
                temp[i++] = arr[l++];
            }
        }
        // 만약 l이 r보다 크다면
        // r++ index++
        // count++

        // else
        // l++ index++

        if (l > m) {
            while (r <= right) {
                temp[i++] = arr[r++];
            }
        }
        // 만약 l이 m보다 크다면
        // index가 가득찰 때까지 r++
        if (r > l) {
            while (l <= m) {
                temp[i++] = arr[l++];
            }
        }
        // else
        // 만약 r이 l보다 크다면
        // index가 가득찰 때까지 l++
        // 여기서 count++해줘야 하나..? 헷갈린다.

        for (int j = left; j <= right; j++) {
            arr[j] = temp[j];
        }
        // arr에 temp 값 저장
    }
}