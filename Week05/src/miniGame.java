import java.util.Random;

public class miniGame  {
    private int length = 80;

    public void newBox (){
        System.out.println();
    }
    public static void main(String[] args){
        movingBall ball = new movingBall(5, 50, 0.5, 100);
        targetWall upperWall = new targetWall(5,50,20,2);
        targetWall lowerWall = new targetWall(5,50,20,2);

        upperWall.start();
        ball.start();
        lowerWall.start();

        /* 콘솔 화면 밀기 예제
        try {
            for (int i = 0; i <= 100; i++) {
                System.out.printf("%d%%", i);
                Thread.sleep(300);
                //System.out.printf("\b\b\b\b\b");
                System.out.printf("\r");

            }
            System.out.println();
        } catch (Exception e){
            System.out.println(e);
        }

         */
    }
}

class cleanTheBoard extends miniGame{

}

class raceRank {
    int rank = 0;

    private int[][]rankAll = new int[2][5]; // 최종 결과 배열. 0행: 순위/ 1행: 번호

    public int[][] getRankAll() {
        return rankAll;
    }

    public void setRankAll(int[][] rankAll) {
        this.rankAll = rankAll;
    }

    music raceEffect1 = new music("soundeffect", "1등환호", false);
    music raceEffect2 = new music("soundeffect", "환호", false);

    synchronized void finishLine(int num) {
        rank += 1;

        rankAll[0][rank-1] = rank;
        rankAll[1][rank-1] = num;

        System.out.println("\n\n            【" + num + "번째 말이 " + rank + "등으로 100m에 도착했습니다.】\n");
        if (rank == 1) {
            raceEffect1.start();
        } else if (rank == 5){
            raceEffect2.start();
        }
    }

    void showRank(){
        display.boxUpper(20);
        display.title("순 위",20);

        String result = "\n";
        for(int i=0; i<5; i++){
            result+="  "+rankAll[0][i]+"위: "+rankAll[1][i]+"번 말\n";
        }
        System.out.println(result);
        display.boxLower(20);
    }
}

class participant {
    Random ran = new Random();
    String name;
    int horseNumber = ran.nextInt(5)+1;

    int participantMoney; // 경마 참가자 객체가 배팅한 돈

    public int getHorseNumber() {
        return horseNumber;
    }

    public void setHorseNumber(int horseNumber) {
        this.horseNumber = horseNumber;
    }

    public int getParticipantMoney() {
        return participantMoney;
    }

    public void setParticipantMoney(int participantMoney) {
        this.participantMoney = participantMoney;
    }

    participant(String name){
        this.name = name;
    }

    void randomParticipantMoney(int riderMoney){
        this.participantMoney = ran.nextInt(riderMoney*3)+1;
    }

    void showChosenHorse(){
        System.out.println("  "+name+": "+horseNumber+"번 말");
    }

    void showHorsenMoney(){
        System.out.println("  "+name+": "+horseNumber+"번 말, "+participantMoney+" 은화");
    }
}

