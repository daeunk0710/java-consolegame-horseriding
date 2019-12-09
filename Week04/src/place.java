import java.util.ArrayList;
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

//place: 장소를 표현하는 클래스
public class place {
    Scanner sc = new Scanner(System.in);
    display display = new display();
    riderStat r = new riderStat();
    String placeName;

    private void printPlaceName(){
        System.out.println(
                "                                현재 위치는 "+placeName+"입니다. 당신의 선택은?                              ");
    }

    void placeViewUpper(String s){
        display.boxUpper();
        display.boxMid();
        printPlaceName();
    }

    // 0. 저장하기
    void placeViewLower1(){
        display.selectionBox1();
        display.boxMid();
        display.riderStatView();
    }

    public void placeViewLower2(){
        display.selectionBox2();
        display.boxMid();
        display.riderStatView();
    }

    void moveTo(){
        System.out.println("어디로 이동하시겠습니까?");
        System.out.println("1. 장비 보관함\n2. 마루\n3. 마사\n4. 마장\n\n0. 홈 화면 가기");

        // 선택지 입력
        while (true) {
            String choice = sc.nextLine();
            if (choice.equals("1")) {
                display.line();
                System.out.println("\n장비 보관함에 도착했습니다. 공용 장비들이 보이네요.");
                equipmentLocker e = new equipmentLocker();
                e.equipmentLockerView();

            } else if (choice.equals("2")) {
                display.line();
                System.out.println("\n마루에 도착했습니다.\n칸: "+ r.getRiderName() +"씨 왔어? 오늘 괜찮은 물건이 많은데 둘러봐");
                seatingArea s = new seatingArea();
                s.seatingAreaView();

            } else if (choice.equals("3")) {
                display.line();
                System.out.println("\n마사에 도착했습니다.\n박배우: "+ r.getRiderName() +"님 안녕하세요~");
                boardingStable b = new boardingStable();
                b.boardingStableView();

            } else if (choice.equals("4")) {
                display.line();
                System.out.println("\n마장에 도착했습니다. 사장님이 원형 마장에서 레슨을 하고 계시네요.");
                ridingArea r = new ridingArea();
                r.ridingAreaView();

            } else if (choice.equals("0")) {
                display.line();
                System.out.println("\n홈 화면으로 이동합니다.");
                entrance e = new entrance();
                e.entranceView();

            } else {
                System.out.println("잘못된 입력입니다. 선택지에 있는 숫자를 입력해주세요.");
            }
        }
    }

}

//1. entrance: 승마장 입구. 게임을 시작하는 화면
class entrance extends place {

    // 마장 입구 화면
    void entranceView() {
        riderMountedEquip r = new riderMountedEquip();

        //입구 화면 출력. 기승자의 현재 레벨, 체력, 운동량 정보를 보여준다.
        placeViewUpper(placeName="마장 입구");
        System.out.println(
                "                              1. 이동하기  2. 인벤토리 열기 3. 장착 장비 보기\n                             ");
        placeViewLower1();

        // 선택지 입력
        Scanner sc = new Scanner(System.in);
        while (true) {
            String choice = sc.nextLine();
            if (choice.equals("1")) {
                moveTo();
            } else if (choice.equals("2")) {
                r.showRiderInventory();
            } else if (choice.equals("3")) {
                r.showRiderMountedEquip();
            } else if (choice.equals("0")) {

            } else {
                System.out.println("잘못된 입력입니다. 선택지에 있는 숫자를 입력해주세요.");
            }
        }
    }
}

//2. equipmentLocker: 장비 보관함. 공용 승마 장비를 장착할 수 있다.
class equipmentLocker extends place{

    // 장비 보관함 화면
    void equipmentLockerView() {

        //장비 보관함 화면 출력.
        placeViewUpper(placeName="장비 보관함");
        System.out.println(
                "                   1. 승마 챕이 있는 서랍장 열기 2. 승마 모자가 있는 장 살펴보기 3. 이동하기\n                             ");
        placeViewLower1();

        // 선택지 입력
        Scanner sc = new Scanner(System.in);
        while (true) {
            String choice = sc.nextLine();

            // 공용 승마 챕 획득을 위하여
            if (choice.equals("1")) {
                display.line();
                System.out.println("승마 챕이 쌓여 있습니다. 짝이 맞는 두 쌍을 골라봅시다.\n");
                System.out.println(
                        "       승마 챕 A                                  승마 챕 C\n"+
                        "                              승마 챕 B\n"+
                        "                 승마 챕 D                                               승마 챕 E\n"+
                        "                                                     승마 챕 F\n"
                );

                // 공용 승마챕 0행은 왼발용, 1행은 오른발용. 각각 한 짝 씩 골라야 함
                String left = "ACD";
                String right = "BEF";

                System.out.println("첫 번째 승마 챕을 선택해주세요.\n알파벳 대문자로 입력하세요. EX) A");
                while (true) {
                    String firstChap = sc.nextLine();
                    if (firstChap.equals("A")||firstChap.equals("B")||firstChap.equals("C")||firstChap.equals("D")||firstChap.equals("E")||firstChap.equals("F")){
                        System.out.println("두 번째 승마 챕을 선택해주세요.\n알파벳 대문자로 입력하세요. EX) A");
                        while (true) {
                            String secondChap = sc.nextLine();
                            if (firstChap.equals(secondChap)) {
                                System.out.println("같은 챕을 두 번 선택할 수 없습니다. 다시 선택헤주세요.");
                            } else if (!(secondChap.equals("A")||secondChap.equals("B")||secondChap.equals("C")||secondChap.equals("D")||secondChap.equals("E")||secondChap.equals("F"))) {
                                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                            } else if (left.contains(firstChap) == right.contains(secondChap)) {
                                System.out.println("\n짝을 찾았습니다! 공용 승마챕을 획득했습니다.");
                                riderInvent riderInvent = new riderInvent();
                                riderInvent.addEquipment("낡은 승마 챕", 1, 0, 0);
                                riderInvent.setRiderOwnedEquip(riderInvent.getRiderOwnedEquip());

                                display.line();
                                riderInvent.showRiderOwnedEquip();

                                System.out.println("\n엔터 키를 누르면 홈 화면으로 돌아갑니다.");
                                sc.nextLine();
                                entrance e = new entrance();
                                e.entranceView();
                            } else {
                                System.out.println("짝이 맞지 않습니다. 디른 챕을 선택해주세요");
                            }
                        }
                    } else {
                        System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    }
                }
            } else if (choice.equals("2")) {

            } else if (choice.equals("3")) {
                moveTo();
            } else {
                System.out.println("잘못된 입력입니다. 선택지에 있는 숫자를 입력해주세요.");
            }
        }
    }

}

//3. seatingArea: 마루. npc 칸에게 개인 승마 장비와 잡화를 구입할 수 있다.
class seatingArea extends place{
    void seatingAreaView() {

        //마루 화면 출력.
        placeViewUpper(placeName = "마루");
        System.out.println(
                "                      1. 칸에게 말걸기  2. 승마 장갑이 있는 박스 열기 3. 이동하기\n                             ");
        placeViewLower1();

        // 선택지 입력
        Scanner sc = new Scanner(System.in);
        while (true) {
            String choice = sc.nextLine();
            if (choice.equals("1")) {

            } else if (choice.equals("2")) {

            } else if (choice.equals("3")) {
                moveTo();
            } else if (choice.equals("0")) {

            } else {
                System.out.println("잘못된 입력입니다. 선택지에 있는 숫자를 입력해주세요.");
            }
        }
    }

}

//4. boardingStable: 마사. 말에게 간식을 줄 수 있다. npc 박배우의 일을 돕고 코인을 받을 수 있다.
class boardingStable extends place{

    // 마사 화면
    void boardingStableView() {

        //마사 화면 출력.
        placeViewUpper(placeName="마사");
        System.out.println(
                "                           1. 박배우에게 말걸기 2. 말에게 다가가기 3. 이동하기\n                             ");
        placeViewLower1();

        // 선택지 입력
        Scanner sc = new Scanner(System.in);
        while (true) {
            String choice = sc.nextLine();
            if (choice.equals("1")) {
                moveTo();
            } else if (choice.equals("2")) {

            } else if (choice.equals("3")) {
                moveTo();
            } else if (choice.equals("0")) {

            } else {
                System.out.println("잘못된 입력입니다. 선택지에 있는 숫자를 입력해주세요.");
            }
        }
    }

}

//5. ridingArea: 마장. 승마를 하는 공간이다.
class ridingArea extends place{
    // 마장 화면
    void ridingAreaView() {

        //마장 화면 출력
        placeViewUpper(placeName="마장");
        System.out.println(
                "                             1. 사장님에게 말걸기 2. 승마하기 3. 이동하기\n                             ");
        placeViewLower1();

        // 선택지 입력
        Scanner sc = new Scanner(System.in);
        while (true) {
            String choice = sc.nextLine();
            if (choice.equals("1")) {
                moveTo();
            } else if (choice.equals("2")) {

            } else if (choice.equals("3")) {
                moveTo();
            } else if (choice.equals("0")) {

            } else {
                System.out.println("잘못된 입력입니다. 선택지에 있는 숫자를 입력해주세요.");
            }
        }
    }

}

//    5.1. roundPen: 원형 마장. 방향 조절 스킬을 사용하지 못한다.
class roundPen extends ridingArea{

}

//    5.2. indoorArena: 실내 마장. 방향 조절이 가능하다. 특정 조건을 만족해야 입장 가능하다.
class indoorArena extends ridingArea{

}

