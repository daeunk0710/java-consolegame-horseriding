import java.util.Scanner;
/*
place: 장소를 표현하는 클래스
1. home: 승마장 입구. 게임을 시작하는 화면
2. equipmentLocker: 장비 보관함. 공용 승마 장비를 장착할 수 있다.
3. seatingArea: 마루. npc 칸에게 개인 승마 장비와 잡화를 구입할 수 있다.
4. boardingStable: 마사. 말에게 간식을 줄 수 있다. npc 박배우의 일을 돕고 코인을 받을 수 있다.
5. ridingArea: 마장. 승마를 하는 공간이다.
    5.1. roundPen: 원형 마장. 방향 조절 스킬을 사용하지 못한다.
    5.2. indoorArena: 실내 마장. 방향 조절이 가능하다. 특정 조건을 만족해야 입장 가능하다.
*/

public class process {
    Scanner sc = new Scanner(System.in);
    String placeName;
    riderItem riderItem = new riderItem();

    static void showPlaceName(String placeName, int width){
        display.boxUpper(width);
        display.title(placeName,width);
        display.boxLower(width);
    }

    static void openingVer1(){
        display.logo100();
        display.boxUpper();
        display.boxMid();
        display.boxMid();
        System.out.println(
                "┃                   승마의 세계에 오신 것을 환영합니다! 말과 함께 성장하여 마왕에 도전하세요                 ┃\n"+
                        "┃                                                                                                  ┃\n"+
                        "┃                                   엔터 키를 누르면 시작됩니다.                                       ┃\n"+
                        "┃                                                                                                  ┃"
        );
        display.boxMid();
        display.boxLower();
    }

    static void openingVer2(){
        display.logo100();
        display.boxUpper();
        display.boxMid();
        System.out.println(
                "┃                   승마의 세계에 오신 것을 환영합니다! 말과 함께 성장하여 마왕에 도전하세요                 ┃\n"+
                        "┃                                                                                                  ┃\n"+
                        "┃                                     1. 새로운 게임 시작하기                                         ┃\n"+
                        "┃                                      2. 이전 게임 불러오기                                          ┃\n"+
                        "┃                                      (숫자로 입력해주세요)                                          ┃"
        );
        display.boxMid();
        display.boxLower();
    }

    static void tutorial(){
        display.line();
        System.out.println("승마장 지도를 먼저 보여드릴게요.");
        System.out.println("엔터 키를 누르면 다음 설명을 볼 수 있습니다.");
        System.out.println(
                "                                                                                \n" +
                        "              7154517                                                           \n" +
                        "           4080888088806                                08080888080808080808080 \n" +
                        "         58880808088808080                              88808088888080808888808 \n" +
                        "        8888088888088808888                             08088888080808080808888 \n" +
                        "       788808088808888808081                            88888088808888888888808 \n" +
                        "       108080808880888888880                            88088808080808080888080 \n" +
                        "        80808080888088888887                            88808880888880808080808 \n" +
                        "        7808880888080888082                             88080808080888080808880 \n" +
                        "          8888808888888087                              80808880808880808888808 \n" +
                        "            74088888097                                 88888888080808080888088 \n" +
                        "             <원형 마장>                                 80808880808080808088888 \n" +
                        "   808088808088808088808888808080808888808888808080808  88080808888808888808080 \n" +
                        "   880808080808080808088888088808880808080888080888088  88808080808088808088888 \n" +
                        "   888080808088888088888080808880808880808888808088808  08080808080808080888080 \n" +
                        "   080808880888888808080888088888088808080888880888880  80808088808080808080888 \n" +
                        "                         <마사>                          08088888080808080808088 \n" +
                        "   5177777777717                   1777777777777777711  88888088888888808080888 \n" +
                        "   8088888888888                   8088808888808880808  88080808080888088888080 \n" +
                        "   0888080808880                   0888080808080808080         <실내 마장>       \n" +
                        "   8880808880808                   8088808880888080808                          \n" +
                        "   8808080808080                   0808880888080808880                          \n" +
                        "   8080808080888                   8880808080808880888                          \n" +
                        "   0808880808080                   0888088808888808880                          \n" +
                        "   8880808080808                   8080808088808080808                          \n" +
                        "   0808088808080                   8808080808888888888                          \n" +
                        "    <장비 보관함>                          <마루>                                 \n" +
                        "                 2888088808885                                                  \n" +
                        "                 7064999494087                                                  \n"+
                        "                   <마장 입구>"
        );
        display.blankLine(1);
        System.out.println("저희 승마장에는 숭머룰 하기 위해 필요한 4개의 공간이 있어요.");
        selection.pass();
        System.out.println("장비 보관함, 마루, 마사, 마장이지요.");
        selection.pass();
        display.blankLine(1);
        System.out.println("지금 있는 곳은 마장 입구예요. 항상 여기서 게임을 시작하게 되지요.");
        selection.pass();
        System.out.println("장비 보관함에는 무료로 사용할 수 있는 공용 장비가 있답니다. 말을 타려면 어떤 장비가 필요할까요?");
        selection.pass();
        System.out.println("마루는 동호회 회원분들이 모여 담소를 나누는 곳이에요. 맞춤 개인 장비를 마련하고 싶다면 칸에게 문의하세요");
        selection.pass();
        System.out.println("마사는 말들의 집이랍니다. 말과 교감할수록 승마가 쉬워지겠죠?");
        selection.pass();
        System.out.println("모든 준비가 끝나고 말을 타는 공간을 마장이라고 해요. 원형 마장과 실내 마장이 있답니다.");
        selection.pass();
        System.out.println("원형 마장은 한 방향으로 계속 타는 곳이고, 실내 마장은 방향 조절을 할 수 있어요.");
        selection.pass();
        display.blankLine(1);
        System.out.println("아쉽게도 지금 실내 마장은 공사중이라 이용할 수 없어요!");
        selection.pass();
        System.out.println("더 좋은 환경으로 찾아뵐게요. 잠시만 기다려주세요.");
        selection.pass();
        display.blankLine(3);
        System.out.println("조금은 이해가 되셨나요? 그럼 이제 시작할까요?");
        selection.pass();
        display.line();
    }


    public void moveTo(int width){
        display.line();

        System.out.println("어디로 이동하시겠습니까?");
        System.out.println("1. 장비 보관함\n2. 마루\n3. 마사\n4. 마장\n\n5. 홈 화면 가기\n");

        String choice = selection.getchoice(5);
        if (choice.equals("1")){
            System.out.println("1이 선택됨");
        } else if (choice.equals("2")){
            System.out.println("2이 선택됨");
        } else if (choice.equals("3")){
        System.out.println("3이 선택됨");
        } else if (choice.equals("4")){
        System.out.println("4이 선택됨");
        } else {
            home(width);
        }

    }

    public void home(int width){
        display.boxUpper(width);
        display.title("마장 입구",width);
        display.blankLine(1);
        display.title("인덕원 승마클럽에 오신 것을 환영합니다. 무엇이 필요하신가요?",(int)(width*0.85));
        //display.blankLine(1);
        display.title("1. 이동하기  2. 인벤토리 열기 3. 장착 장비 보기",(int)(width*0.85));
        display.blankLine(1);
        display.riderStatView(width);

        display.blankLine(1);
        String choice = selection.getchoice(3);

        System.out.println(choice);
        if (choice.equals("1")){
            moveTo(width);
        } else if (choice.equals("2")){
            inventory(width);
        } else {
            mountedEquipment(width);
        }
    }

    static void placeView(){

    }

    public void inventory(int homewidth){
        display.line(100);
        display.blankLine(1);
        riderItem.showRiderInventory();
        display.blankLine(1);
        System.out.println("1. 장비 장착하기\n2. 간식 먹기\n3. 말에게 간식 주기\n4. 홈 화면 가기\n");
        String choice = selection.getchoice(4);

        if (choice.equals("1")){
            display.line(100);
            System.out.println("\n승마를 하려면 장비를 갖추어야 하지요. 어떤 장비를 장착하실래요?\n원하는 장비의 이름을 입력해주세요.\n");
            String equipChoice = selection.textinput();
            riderItem.mountEquipment(equipChoice);

            System.out.println("엔터키를 입력하면 홈 화면으로 돌아갑니다.");
            selection.pass();
            display.blankLine(1);
            home(homewidth);

        } else if (choice.equals("2")){
            display.line(100);
            System.out.println("\n에너지를 보충은 필수! 어떤 간식을 드시겠어요?\n원하는 간식의 이름을 입력해주세요.");
            String snackChoice = selection.textinput();
            riderItem.eatSnack(snackChoice);

            System.out.println("엔터키를 입력하면 홈 화면으로 돌아갑니다.");
            selection.pass();
            display.blankLine(1);
            home(homewidth);

        } else if (choice.equals("3")){
            display.line(100);
            System.out.println("아직 이용하실 수 없는 기능입니다. 업데이트를 기다려주세요!");

            System.out.println("엔터키를 입력하면 홈 화면으로 돌아갑니다.");
            selection.pass();
            display.blankLine(1);
            home(homewidth);

        }  else {
            display.blankLine(1);
            home(homewidth);
        }
    }

    public void mountedEquipment(int homewidth){
        display.line(100);
        display.blankLine(1);
        riderItem.showMountedEquip();
        display.blankLine(1);
        System.out.println("엔터키를 입력하면 홈 화면으로 돌아갑니다.");
        selection.pass();
        display.blankLine(1);
        home(homewidth);
    }

}
