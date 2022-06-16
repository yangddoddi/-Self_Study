package Thread;

public class ThreadStudy6 implements Runnable {
    static boolean autoSave = false;
    public static void main(String[] args) {
        Thread t = new Thread(new ThreadStudy6());
        // ThreadStudy6 클래스가 Runnable을 구현하고 있고 run() 메서드를 가지고 있기 때문에
        // ThreadStudy6으로 쓰레드 생성 가능
        t.setDaemon(true);
        // 일반 쓰레드처럼 생성하고 setDaemon메서드로 true만 지정해주면 된다.
        t.start();
        // 프로세스 시작 전에 데몬 프로세스를 실행시켜야함

        for (int i=0; i <=10; i++) {
            try{
                Thread.sleep(1000);
                // 1초마다 +1
            } catch (Exception e) {}
            System.out.println(i);
            if (i%3==0) {
                autoSave = true;
                // 3초마다 autoSave를 하도록 지시한다.
            }
        }
    }

    public void run() {
        while(true) {
            try {
                Thread.sleep(1000);
                // 1초마다 체크
            } catch (Exception e) {}
            if (autoSave) {
                autoSave();
                // autoSave == true면 autoSave() 호출
            }
        }
    }

    public static void autoSave() {
        System.out.println("자동 저장 완료.");
        autoSave = false;
        // 실행 후 다시 false로 전환
    }
}
