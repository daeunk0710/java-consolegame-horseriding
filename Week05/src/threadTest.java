/*
스레드 사용 연습하는 클래스
 */
public class threadTest extends Thread {
    int time;

    threadTest(int time) {
        this.time = time;
    }

    public void run() {
        try {
            System.out.println("LOADING...");
            for (int i = 0; i < 100; i++) {
                Thread.sleep(time);
                System.out.print("■");
            }
        } catch (InterruptedException e) {
            System.out.println("스레드 강제 종료");
            return;
        }
    }

    public static void main(String[] args) {
        raceRank r = new raceRank();
        music raceBGM = new music("bgm", "경마게임", true);

        raceHorse h1 = new raceHorse(1, r);
        raceHorse h2 = new raceHorse(2, r);
        raceHorse h3 = new raceHorse(3, r);
        raceHorse h4 = new raceHorse(4, r);
        raceHorse h5 = new raceHorse(5, r);

        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();

        if (h1.isAlive() || h2.isAlive() || h3.isAlive() || h4.isAlive() || h5.isAlive()) {
            raceBGM.start();
        } else {
            raceBGM.close();
        }
    }
}
