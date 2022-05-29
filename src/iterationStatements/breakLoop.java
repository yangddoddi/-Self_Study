package iterationStatements;

public class breakLoop {
    public static void main(String[] args) {
        LoopOrigin : for (int i=1; i < 10; i++) {
            for (int j=0; j < 10; j++) {
                if ( j == 5 ) {
//                    break LoopOrigin; // for문을 아예 빠져나가므로 반복 종료
//                    break; // j 반복문을 빠져나가고 i don't like 5를 출력한 뒤 i 반복문부터 다시 시작
//                    continue; // j==5 5만 제외하고 모든 코드 실행
                    continue LoopOrigin; // for i => j => j==5 => i로 넘어가므로 idon'like5는 출력 x
                }
                System.out.printf("%d * %d = %d%n",i,j,i*j);
            }
            System.out.println("i don't like 5");
        }
    }
}
