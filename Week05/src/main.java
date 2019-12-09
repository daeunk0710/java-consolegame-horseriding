/*
게임을 실행하는 메인 클래스
 */

public class main {
    public static void main(String[] args) {

        try {
            new horseridingGame();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
