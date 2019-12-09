import java.util.Random;

public class thread extends Thread {
}

class loading extends thread {
    int interval;
    int length;
    String text;

    loading(String text, int length, int interval){
        this.text = text;
        this.length = length;
        this.interval = interval;
    }

    public void run(){
        try
        {
            System.out.println(text);
            for(int i=0; i<length; i++){
                Thread.sleep(interval);
                System.out.print("■");
            }
            System.out.println("\n\n");
        } catch (InterruptedException e){
            System.out.println("스레드 강제 종료");
            return;
        }
    }
}

class tutorial extends thread {
    int latency;

    tutorial(int latency){
        this.latency = latency;
    }

    public void run(){
        try
        {
        display.line();
        System.out.println("먼저 승마장 지도를 보여드릴게요.");
        System.out.println("엔터 키를 누르면 다음 설명을 볼 수 있습니다.");
        selection.pass();

        System.out.println("              7154517                                                           ");
        Thread.sleep(latency);
        System.out.println("           4080888088806                                08080888080808080808080 ");
        Thread.sleep(latency);
        System.out.println("         58880808088808080                              88808088888080808888808 ");
        Thread.sleep(latency);
        System.out.println("        8888088888088808888                             08088888080808080808888 ");
        Thread.sleep(latency);
        System.out.println("       788808088808888808081                            88888088808888888888808 ");
        Thread.sleep(latency);
        System.out.println("       108080808880888888880                            88088808080808080888080 ");
        Thread.sleep(latency);
        System.out.println("        80808080888088888887                            88808880888880808080808 ");
        Thread.sleep(latency);
        System.out.println("        7808880888080888082                             88080808080888080808880 ");
        Thread.sleep(latency);
        System.out.println("          8888808888888087                              80808880808880808888808 ");
        Thread.sleep(latency);
        System.out.println("            74088888097                                 88888888080808080888088 ");
        Thread.sleep(latency);
        System.out.println("             <원형 마장>                                 80808880808080808088888 ");
        Thread.sleep(latency);
        System.out.println("             NPC: 사장님                                 80808080808080808080808 ");
        Thread.sleep(latency);
        System.out.println("                                                        08080888080808080808080 ");
        Thread.sleep(latency);
        System.out.println("   808088808088808088808888808080808888808888808080808  88080808888808888808080 ");
        Thread.sleep(latency);
        System.out.println("   808088808088808088808888808080808888808888808080808  88080808888808888808080 ");
        Thread.sleep(latency);
        System.out.println("   808088808088808088808888808080808888808888808080808  88080808888808888808080 ");
        Thread.sleep(latency);
        System.out.println("   808088808088808088808888808080808888808888808080808  88080808888808888808080 ");
        Thread.sleep(latency);
        System.out.println("                         <마사>                          08088888080808080808088 ");
        Thread.sleep(latency);
        System.out.println("   8088888888888      NPC: 박코치   8088808888808880808  88080808080888088888080 ");
        Thread.sleep(latency);
        System.out.println("   0888080808880                   0888080808080808080         <실내 마장>       ");
        Thread.sleep(latency);
        System.out.println("   8880808880808                   8088808880888080808     ※공사중! 접근 금지    ");
        Thread.sleep(latency);
        System.out.println("   8880808880808                   8088808880888080808                          ");
        Thread.sleep(latency);
        System.out.println("   8880808880808                   8088808880888080808                          ");
        Thread.sleep(latency);
        System.out.println("   8880808880808                   8088808880888080808                          ");
        Thread.sleep(latency);
        System.out.println("   8880808880808                   8088808880888080808                          ");
        Thread.sleep(latency);
        System.out.println("   8880808880808                   8088808880888080808                          ");
        Thread.sleep(latency);
        System.out.println("    <장비 보관함>                          <마루>                                 ");
        Thread.sleep(latency);
        System.out.println("                 2888088808885     NPC: 칸, 동호회 회원                           ");
        Thread.sleep(latency);
        System.out.println("                 7064999494087                                                  ");
        Thread.sleep(latency);
        System.out.println("                   <마장 입구>");

        display.blankLine(2);
        System.out.println("［ 게 임 설 명 ］");
        display.blankLine(1);
        System.out.println("Ｈｏｒｓｅｒｉｄｉｎｇ 은 승마장을 배경으로 캐릭터를 성장시키고,\n말과 교감하여 승마를 하기까지 과정을 담은 RPG 게임입니다.");
        System.out.println("말 탈 기에 탈 승, 말을 타는 것을 기승하다라고 해요. 승마 중인 캐릭터는 기승자가 됩니다.                   『Enter』");
        selection.pass();
        System.out.println("기승자는 승마장 곳곳을 탐험하여 승마 준비를 마치고, 기승을 하며 운동량을 쌓습니다.");
        System.out.println("운동량을 쌓아 레벨업을 하면 숙련도가 증가하고, 더 어려운 승마 스킬을 사용할 수 있게 됩니다.                『Enter』 ");
        selection.pass();
        display.blankLine(2);
        System.out.println("［ 승 마 장 ］");
        display.blankLine(1);
        System.out.println("저희 승마장에는 숭마룰 하기 위해 필요한 4개의 공간이 있어요.");
        System.out.println("장비 보관함, 마루, 마사, 마장이지요.                                                               『Enter』");
        selection.pass();
        display.blankLine(1);
        System.out.println("지금 있는 곳은 마장 입구예요. 항상 여기서 게임을 시작하게 되지요.                                      『Enter』");
        selection.pass();
        System.out.println("장비 보관함에는 무료로 사용할 수 있는 공용 장비가 있답니다. 말을 타려면 어떤 장비가 필요할까요?            『Enter』");
        selection.pass();
        System.out.println("마루는 동호회 회원분들이 모여 담소를 나누는 곳이에요. 맞춤 개인 장비를 마련하고 싶다면 칸에게 문의하세요     『Enter』");
        selection.pass();
        System.out.println("마사는 말들의 집이랍니다. 말과 교감할수록 승마가 쉬워지겠죠?                                           『Enter』");
        selection.pass();
        System.out.println("모든 준비가 끝나고 말을 타는 공간을 마장이라고 해요. 원형 마장과 실내 마장이 있답니다.");
        System.out.println("원형 마장은 한 방향으로 계속 타는 곳이고, 실내 마장은 방향 조절을 할 수 있어요.                          『Enter』");
        selection.pass();
        System.out.println("아쉽게도 지금 실내 마장은 공사중이라 이용할 수 없어요!");
        System.out.println("더 좋은 환경으로 찾아뵐게요. 잠시만 기다려주세요.                                                    『Enter』");
        selection.pass();
        display.blankLine(2);
        System.out.println("［ 승 마 장 비 ］");
        display.blankLine(1);
        System.out.println("다음으로 승마를 하기 위해 필요한 장비를 설명해드릴게요.                                                ");
        System.out.println("저희 승마장에서 기승을 하려면 승마 모자, 승마 부츠, 승마 장갑을 꼭 착용해야해요.                          『Enter』");

        selection.pass();
        display.blankLine(1);
        System.out.println("승마 모자는 기승 중 발생할 수 있는 사고에서 기승자를 보호해주는 최소한의 보호 장비예요.                             ");
        System.out.println("안전이 제일 중요한 거 아시죠? 칸이 판매하는 좋은 승마 모자를 착용하면, 승마 중 최대 체력이 증가합니다.       『Enter』");
        selection.pass();
        System.out.println("승마 부츠는 스킬 이행의 정확도와 관련이 있는 장비예요.                  ");
        System.out.println("기승 중 앉은 자세에서 말 배를 지긋이 압박하거나, 발로 차는 방식으로 말에게 신호를 줄 수 있어요.              ");
        System.out.println("승마 부츠는 종류가 다양해요. ");
        System.out.println("일반 신발 위에 둘러서 착용할 수 있는 챕, 발목까지 오는 앵클 부츠 스타일, 무릎까지 오는 롱부츠 스타일이 있어요.『Enter』");
        selection.pass();
        System.out.println("승마 장갑은 기승 중 손을 보호해주는 장비예요.                                      ");
        System.out.println("기승 중 적절한 텐션으로 고삐를 유지해주는 게 중요한데, 맨손으로 가죽 고삐를 쥐고 있으면 손이 아프겠죠?       『Enter ");
        selection.pass();
        System.out.println("승마 장비는 칸에게 은화를 주고 구입할 수 있어요.");
        System.out.println("좋은 장비는 당신이 승마를 편하게 할 수 있게 도와줄 거에요.");
        System.out.println("아직 은화가 없더라도 걱정하지 마세요. 공용 장비를 무료로 이용할 수 있습니다. 승마장을 잘 둘러보세요!         『Enter』");
        selection.pass();
        display.blankLine(2);

        System.out.println("［ 승 마 스 킬 ］");
        display.blankLine(1);
        System.out.println("승마 스킬을 설명해드릴게요.");
        System.out.println("정확히는 보법이라고 해요. 말이 걷는 방법이라고 이해하시면 쉬워요.                                       『Enter』");
        selection.pass();
        System.out.println("보법에는 크게 평보, 속보, 구보 세 가지가 있습니다.                                                   『Enter』");
        selection.pass();
        System.out.println("평보는 편안하게 걷는 자세를 말해요. 승마의 가장 기본이 되는 자세입니다.                                 『Enter』");
        selection.pass();
        System.out.println("속보는 말의 두 다리가 대칭적으로 교대하여 움직이는 보법이에요.                                         ");
        System.out.println("타닥-타닥 이렇게 두 박자로 지면을 딛고 나아가게 됩니다. 평보에 비해 자유롭고 경쾌한 느낌을 줍니다.         ");
        System.out.println("속보 중 기승자의 자세에 따라 경속보, 좌속보, 전경속보로 나뉘어요.                                      『Enter』");
        selection.pass();
        System.out.println("경속보는 말의 반동에 맞추어 기승자가 앉았다 읽어나는 과정을 반복하며 충격을 최소화하는 스킬이에요.          ");
        System.out.println("좌속보는 기승자가 앉은 상태로 허리 움직임을 통해 반동을 흡수하는 스킬이에요. 경속보보다 난이도가 높아요.         ");
        System.out.println("전경속보는 안장에서 엉덩이를 살짝 뗀 상태로, 발목의 움직임을 통해 반동을 흡수하는 스킬이에요.          ");
        System.out.println("오랜 시간 승마를 할 때 많이 사용해요.                                                              『Enter』");
        selection.pass();
        System.out.println("구보는 말의 보법 중 가장 빠른 방법으로, 네 다리가 일순간 동시에 뜨고 연달아 착지하며 움직이는 보법이에요.");
        System.out.println("다그닥-다그닥 세 박자의 소리를 들을 수 있어요. 승마의 꽃이라고 할 수 있지요!");
        System.out.println("구보 중 기승자의 자세에 따라 무게중심을 뒤로 하고 안장에 앉는 일반 구보와,");
        System.out.println("무게중심을 앞으로 하고 엉덩이를 뗀 상태로 기승하는 전경 구보로 나뉘어요.                                『Enter』");
        selection.pass();

        display.blankLine(3);
        System.out.println("조금은 이해가 되셨나요? 그럼 이제 시작할까요?                                                        『Enter』");
        selection.pass();
        display.line();
        } catch (InterruptedException e){
            System.out.println("스레드 강제 종료");
            return;
        }
    }
}

class movingBall extends thread {
    int start, end; // 공 처음 위치, 끝 위치
    double x; // 공 현재 위치
    double distance; // 이동거리 pixel
    int interval; // 간격 ms

    movingBall(int start, int end, double distance, int interval){
        this.start = start;
        this.end = end;
        this.distance = distance;
        this.interval = interval;
    }

    public void run(){
        try{
            x = start;
            while (x<=end) {
                for (int i = 0; i < x; i++) {
                    System.out.print(" ");
                }
                System.out.print("●");
                Thread.sleep(interval);
                x = x + distance;
                System.out.print("\r");
            }
        } catch (InterruptedException e){
            System.out.println(e);
        }
    }

}

class targetWall extends thread {
    int start, end; // 벽 처음 위치, 끝 위치
    int x; // 타겟 위치
    int buffer; // 타겟 버퍼

    targetWall(int start, int end, int x, int buffer){
        this.start = start;
        this.end = end;
        this.x = x;
        this.buffer = buffer;
    }

    public void run(){
        for(int i = 0; i<start; i++){
            System.out.print(" ");
        }
        for(int i = start; i<(start+x-buffer) ; i++){
            System.out.print("□");
        }
        for(int i = (start+x-buffer); i<(start+x+buffer) ; i++){
            System.out.print("■");
        }
        for(int i = (start+x+buffer); i<end ; i++){
            System.out.print("□");
        }
        System.out.println("");
    }

}

class percent extends thread{

    public void run(){
        try
        {
            for(int i=0; i<=100; i++)
            {
                System.out.print(i+"%");
                Thread.sleep(100);
                System.out.print("\r");
            }
            System.out.println();
        } catch (InterruptedException e){
            System.out.println("스레드 강제 종료");
            return;
        }
    }

}

class countdown extends thread{
    music raceEffect = new music("soundeffect", "총소리", false);

    public void run(){
        try
        {
            for(int i=5; i>0; i--)
            {
                System.out.print(i);
                Thread.sleep(500);
                System.out.print("\r");
            }
            System.out.print("\rSTART!");
            raceEffect.start();
            System.out.println("\n");
            display.line(100);
        } catch (InterruptedException e){
            System.out.println("스레드 강제 종료");
        }
    }

}

class raceHorse extends thread{

    private int horseNum;
    private int meter=0;
    private int rank=0;
    raceRank r = new raceRank();

    public int getHorseNum() {
        return horseNum;
    }

    public void setHorseNum(int horseNum) {
        this.horseNum = horseNum;
    }

    public int getMeter() {
        return meter;
    }

    public void setMeter(int meter) {
        this.meter = meter;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }


    raceHorse(int horseNum, raceRank r){
        this.horseNum = horseNum;
        this.r = r;
    }

    public void run(){
        Random ran = new Random();
        for (int i=0; i<10; i++){
            setMeter(getMeter()+10);
            if (i==9) {
                break;
            } else {
                System.out.print("\r"+getHorseNum()+"번째 말이 현재 "+getMeter()+"m에 있습니다.");
                try {
                    int num = ran.nextInt(5000) + 1000;
                    Thread.sleep(num);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        r.finishLine(getHorseNum());
        this.rank = r.rank;
    }

}



class randomEvent extends thread {
    private String placeName;
    private int possibility;
    private boolean isHappened;

    randomEvent(String placeName, int possibility) {
        this.placeName = placeName;
        this.possibility = possibility;
        this.isHappened = false;
    }

    boolean getIsHappened() {
        return this.isHappened;
    }

    public void setHappened(boolean happened) {
        this.isHappened = happened;
    }

    private void setEventResult() {
        // 이벤트 발생 여부
        boolean isHappened;
        if (possibility >= 100) {
            isHappened = true;
        } else {
            //100칸 배열 생성
            boolean[] possibilityBox = new boolean[100];

            //possibility 만큼 true 로 채우고
            for (int i = 0; i < possibility; i++) {
                possibilityBox[i] = true;
            }

            //나머지를 false로 채움
            for (int i = possibility; i < 100; i++) {
                possibilityBox[i] = false;
            }

            //랜덤함수로 랜덤 인덱스 생성
            int j = (int) (Math.random() * 100);
            isHappened = possibilityBox[j];
        }
        this.isHappened = isHappened;
    }

    public void run(){
        setEventResult();
        if (this.isHappened){
            try {
                sleep(500);
            } catch (Exception e){
                System.out.println(e);
            }

            System.out.print("※※※※ 이 벤 트 ※※※※");
            for (int i =0; i<10; i++){
                System.out.print("\rㅁㅁㅁㅁ 이 벤 트 ㅁㅁㅁㅁ");
                try {
                    sleep(100);
                } catch (Exception e){
                    System.out.println(e);
                }
                System.out.print("\r※※※※ 이 벤 트 ※※※※");
                try {
                    sleep(100);
                } catch (Exception e){
                    System.out.println(e);
                }
            }

            display.blankLine(1);
        }
    }

}