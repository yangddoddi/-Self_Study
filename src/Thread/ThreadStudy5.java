package Thread;

public class ThreadStudy5 {
    public static void main(String[] args) {
        ThreadGroup main = Thread.currentThread().getThreadGroup(); // 메인 쓰레드 그룹
        ThreadGroup gr1 = new ThreadGroup("group1"); // 이 쓰레드의 참조는 ThreadGroup에 저장된다
        ThreadGroup gr2 = new ThreadGroup("group2"); // => 가비지 컬렉터에 의해 삭제되지 않음.
        // 쓰레드 그룹 생성

        ThreadGroup gr1_1 = new ThreadGroup(gr1, "group 1-1");
        // 그룹의 하위 그럽 생성

        gr1.setMaxPriority(3);
        // "최대 우선순위" 를 3으로 설정.

        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        new Thread(gr1, r, "th1").start();
        new Thread(gr2, r, "th2").start();
        new Thread(gr1_1, r, "th3").start();

        System.out.println(">>List of ThreadGroup : " + main.getName() +", Active ThreadGroup: " + main.activeGroupCount() +
                ", Active Thread: " + main.activeCount());
        main.list();
        // 결론
        // 우리가 생성하는 모든 쓰레드 그룹은 메인 쓰레드 그룹은 main 쓰레드 그룹의 하위 그룹이다.
        // 쓰레드 우선순위 설정 시 하위 그룹에도 영향을 미친다.
        // 쓰레드 그룹을 지정하지 않으면 main쓰레드 그룹에 속한다(하위가 아님)
    }
}
