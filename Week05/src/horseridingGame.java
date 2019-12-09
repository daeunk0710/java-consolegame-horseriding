import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class horseridingGame extends Thread {
    // 스레드 객체 생성
    loading l1 = new loading("LOADING...",50,10);
    loading l2 = new loading("쓱싹쓱싹...",50,100);
    loading l3 = new loading("어느 말이 가장 빠를까?...",50,100);
    loading l4 = new loading("쏴아아...",50,150);
    percent p1 = new percent();
    tutorial t1 = new tutorial(200);


    music introMusic = new music("bgm","INTRO", true);
    music shower = new music("soundeffect","씻는소리",false);
    music selectedMusic;


    // 기승자 객체 생성
    riderItem riderItem = new riderItem();
    riderSkill riderSkill = new riderSkill();
    horseriding horseriding = new horseriding();

    // 말 객체 생성
    horse ssemi = new horse("쎄미", 20, 10, 10); // 쎄미
    horse empire = new horse("제국이", 30, 30, 20); // 제국이
    horse masterpiece = new horse("걸작이", 10, 20, 30); //걸작이

    // 스킬 객체 생성
    skill 평보 = new skill(1, "평보", 0, 90, 5, 5);
    skill 경속보 = new skill(2, "경속보", 0, 70, 20, 15);
    skill 좌속보 = new skill(3, "좌속보", 10, 50, 30, 25);
    skill 전경속보 = new skill(4, "전경속보", 20, 60, 25, 20);
    skill 구보 = new skill(5, "구보", 30, 40, 35, 15);
    skill 전경구보 = new skill(6, "전경구보", 40, 30, 45, 10);

    // 공용 승마 장비 객체 생성
    riderEquipment publicHelmet = new riderEquipment("자전거 헬멧",0,1,0,0,0);
    riderEquipment publicHat = new riderEquipment("낡은 승마 모자",0,1,0,0,0);
    riderEquipment publicChap = new riderEquipment("낡은 승마 챕",1,1,0,0,0);
    riderEquipment publicGlobe = new riderEquipment("3M 장갑",2,1,0,0,0);

    // 개인 승마 장비 객체 생성
    riderEquipment privateHat1 = new riderEquipment("기본 승마 헬멧",0,1,5,5,3);
    riderEquipment privateHat5 = new riderEquipment("풀 카본 승마 헬멧",0,5,10,10,5);
    riderEquipment privateHat10 = new riderEquipment("고급 스웨이드 승마 헬멧", 0,10,20,20,10);

    riderEquipment privateBoots1 = new riderEquipment("챕스",1,1,5,10,5);
    riderEquipment privateBoots5 = new riderEquipment("앵클 부츠",1,5,10,20,10);
    riderEquipment privateBoots10 = new riderEquipment("클래식 롱부츠", 1,10,20,30,15);

    riderEquipment privateGlobe1 = new riderEquipment("스포츠 장갑",2,1,5,5,3);
    riderEquipment privateGlobe5 = new riderEquipment("기본 승마 장갑",2,5,10,10,5);
    riderEquipment privateGlobe10 = new riderEquipment("고급 승마 장갑", 2,10,20,15,7);

    // 간식 객체 생성
    snack chocolate = new snack("초콜릿",1,20,5,3);
    snack carrot = new snack("당근",0,10,5,3);

    public horseridingGame() {

        // 게임 플레이
        introMusic.start();
        process.openingVer1();
        selection.pass();

        // 로딩 스레드드
        // l1.start(); // main 클래스랑 같이 진행됨
        // l1.interrupt();

        l1.run (); // run 메소드 실행 끝날때까지 메인 작동 안함

       // 사용자 이름 설정
        System.out.println("당신의 이름은 무엇인가요?\n");
        rider.setRiderName(selection.textinput());

        display.blankLine(1);
        System.out.println(rider.getRiderName()+"님 안녕하세요!");
        System.out.println("처음 오셨나요? 승마장에 대해 설명 드릴게요.");
        System.out.println("승마가 낯선 스포츠인만큼, 처음 게임을 하시는 분들은 튜토리얼을 보는 것을 권장해요!\n");

        // 튜토리얼 선택
        display.blankLine(1);
        System.out.println("1. 튜토리얼을 본다\n2. 바로 게임을 시작한다.\n");


        int choice = selection.getchoice(2);
        // choice 로그
        // System.out.println("튜토리얼 선택 choice: "+choice);

        if (choice == 1) {
            //process.tutorialWithoutThread();
            t1.run();
        }
        display.blankLine(1);
        l1.run ();

        introMusic.close();

        // 사전 세팅 - horses 리스트에 객체 담기
        horseriding.addHorse(ssemi);
        horseriding.addHorse(empire);
        horseriding.addHorse(masterpiece);

        // 사전 세팅 - skillList 리스트에 객체 담기
        riderSkill.addSkillList(평보);
        riderSkill.addSkillList(경속보);
        riderSkill.addSkillList(좌속보);
        riderSkill.addSkillList(전경속보);
        riderSkill.addSkillList(구보);
        riderSkill.addSkillList(전경구보);

        // 홈 화면
        while (true) {
            rider.isWhere = "마장 입구";
            display.boxUpper(80);
            display.title("마장 입구", 80);
            display.blankLine(1);
            display.title("승마클럽에 오신 것을 환영합니다. 무엇이 필요하신가요?", (int) (80 * 0.85));
            display.blankLine(1);
            display.title("1. 이동하기  2. 인벤토리 열기 3. 장착 장비 보기", (int) (80 * 0.85));
            display.title("4. 지도 보기", (int)(80));
            display.title("5. 게임 종료하기", (int)(80));
            display.blankLine(1);
            display.riderStatView(80);
            display.blankLine(1);

            int choice100 = selection.getchoice(5);


            // choice100 로그
            // System.out.println("홈 화면 choice100: "+choice100);

            // 1. 이동하기
            if (choice100 == 1) {
                display.line();
                display.blankLine(1);
                System.out.println("어디로 이동하시겠습니까?");
                System.out.println("1. 장비 보관함\n2. 마루\n3. 마사\n4. 마장\n\n5. 홈 화면 가기\n");

                int choice110 = selection.getchoice(5);
                // 1. 장비 보관함
                if (choice110 == 1) {
                    while (true) {
                        rider.isWhere = "장비 보관함";
                        display.line();
                        display.placeName(rider.isWhere);

                        System.out.print("장비 보관함에 도착했습니다. 공용 장비들이 보이네요.");
                        display.blankLine(1);
                        display.boxUpper(80);
                        display.title("장비 보관함", 80);
                        display.blankLine(1);
                        display.title("현재 위치는 장비 보관함입니다. 무엇이 필요하신가요?", (int) (80 * 0.85));
                        //display.blankLine(1);
                        display.title("1. 승마 모자가 있는 장 살펴보기 2. 승마 챕이 있는 서랍장 열기", (int) (80 * 0.85));
                        display.title("3. 장비 설명서 보기 4. 홈 화면 가기", (int) (80 * 0.85));
                        display.blankLine(1);
                        display.riderStatView(80);
                        display.blankLine(1);

                        // 장비 보관함에서 상황
                        int choice111 = selection.getchoice(4);

                        // 1. 승마 모자(자전거 헬멧) 획득
                        if (choice111 == 1) {
                            rider.isWhere = "승마 모자가 있는 장";
                            display.line();
                            display.placeName(rider.isWhere);
                            System.out.print("낡은 승마 모자와 헬멧이 뒤섞여 있습니다. 선택해주세요.\n1. 낡은 승마 모자\n2. 헬멧\n");
                            int choice1111 = selection.getchoice(2);
                            if (choice1111 == 1) {
                                System.out.println("\n낡은 승마 모자를 획득했습니다.");
                                riderItem.addEquipment(publicHat);
                                display.line();
                                riderItem.showRiderInventory();
                                System.out.println("\n엔터 키를 누르면 홈 화면으로 돌아갑니다.");
                                selection.pass();

                            } else {
                                display.line();
                                System.out.println("\n자전거 헬멧을 획득했습니다.");
                                riderItem.addEquipment(publicHelmet);
                                display.line();
                                riderItem.showRiderInventory();
                                System.out.println("\n엔터 키를 누르면 홈 화면으로 돌아갑니다.");
                                selection.pass();

                            }

                            // 2. 승마 부츠(낡은 승마 챕) 획득
                        } else if (choice111 == 2) {
                            rider.isWhere = "승마 챕이 있는 서랍장";
                            display.line();
                            display.placeName(rider.isWhere);

                            System.out.print("승마 챕이 쌓여 있습니다. 짝이 맞는 두 쌍을 골라봅시다.\n");
                            System.out.println(
                                    "       승마 챕 A                                  승마 챕 C\n" +
                                            "                              승마 챕 B\n" +
                                            "                 승마 챕 D                                               승마 챕 E\n" +
                                            "                                                     승마 챕 F\n"
                            );
                            // System.out.println("\n1. 승마 챕 A\n2. 승마 챕 C\n3. 승마 챕 B\n4. 승마 챕 D\n5. 승마 챕 F\n6. 승마 챕 E\n");
                            // 공용 승마챕 0행은 왼발용, 1행은 오른발용. 각각 한 짝 씩 골라야 함
                            String left = "ACD";
                            // int[] arrayLeft = {1, 2, 4};
                            String right = "BEF";
                            // int[] arrayRight = {3, 5, 6};

                            System.out.println("첫 번째 승마 챕을 선택해주세요.\n알파벳 대문자로 입력하세요. EX) A");
                            String firstChap = selection.getAtoF();
                            System.out.println("승마 챕 " + firstChap + "가 선택되었습니다.\n");
                            System.out.println("\n두 번째 승마 챕을 선택해주세요.\n알파벳 대문자로 입력하세요. EX) A");
                            String secondChap = selection.getAtoF();

                        /* 숫자로 선택받는 경우
                        while (true) {
                            if (firstChap == secondChap) {
                                System.out.println("같은 챕을 두 번 선택할 수 없습니다. 다시 선택헤주세요.");
                                secondChap = selection.getchoice(6);
                            } else if (Arrays.asList(arrayLeft).contains(firstChap) == Arrays.asList(arrayRight).contains(secondChap)) {
                                System.out.println("\n짝을 찾았습니다! 공용 승마챕을 획득했습니다.");

                                riderItem.addEquipment("낡은 승마 챕", 1, 1, 0, 0, 0);

                                display.line();
                                riderItem.showRiderInventory();

                                System.out.println("\n엔터 키를 누르면 홈 화면으로 돌아갑니다.");
                                selection.pass();
                                break;

                            } else {
                                System.out.println("짝이 맞지 않습니다. 디른 챕을 선택해주세요");
                                secondChap = selection.getchoice(6);
                            }
                        }
                         */

                            while (true) {
                                if (firstChap.equals(secondChap)) {
                                    System.out.println("승마 챕 " + secondChap + "가 선택되었습니다.\n");
                                    System.out.println("같은 챕을 두 번 선택할 수 없습니다. 다시 선택헤주세요.");
                                    secondChap = selection.getAtoF();
                                } else if (left.contains(firstChap) == right.contains(secondChap)) {
                                    System.out.println("승마 챕 " + firstChap + ", 승마 챕 " + secondChap + "가 선택되었습니다.");
                                    System.out.println("\n짝을 찾았습니다! 공용 승마챕을 획득했습니다.");

                                    riderItem.addEquipment(publicChap);
                                    display.line();
                                    riderItem.showRiderInventory();

                                    System.out.println("\n엔터 키를 누르면 홈 화면으로 돌아갑니다.");
                                    selection.pass();
                                    break;

                                } else {
                                    System.out.println("승마 챕 " + firstChap + ", 승마 챕 " + secondChap + "가 선택되었습니다.");
                                    System.out.println("짝이 맞지 않습니다. 디른 챕을 선택해주세요");
                                    secondChap = selection.getAtoF();
                                }
                            }

                        //3. 장비 설명서 보기
                        } else if(choice111 == 3) {
                            display.line(100);
                            display.aboutEquipment();
                            System.out.println("\n엔터 키를 누르면 장비 보관함으로 돌아갑니다.");
                            selection.pass();

                        //4. 홈 화면 가기
                        } else {
                            display.line(100);
                            break;
                        }
                    }

                // 2. 마루
                } else if (choice110 == 2){
                    while (true) {
                        display.line();
                        rider.isWhere = "마 루";
                        display.placeName(rider.isWhere);

                        System.out.print("마루에 도착했습니다.\n칸: " + rider.getRiderName() + "씨 왔어? 오늘 괜찮은 물건이 많은데 둘러봐");
                        display.blankLine(1);

                        // 랜덤 이벤트 스레드
                        randomEvent horseRacing = new randomEvent(rider.isWhere,50);
                        horseRacing.start();

                        // 이벤트 스레드 실행되는동안 메인 스레드 대기
                        try {
                            horseRacing.join();
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }

                        // 디버그
                        // System.out.println(horseRacing.getIsHappened());
                        if (horseRacing.getIsHappened()){
                            display.boxUpper(50);
                            display.title("경 마 게 임", 50);
                            System.out.println("  동호회 사람들이 경마 게임을 하고 있어요. 참여할까요?");
                            display.blankLine(1);
                            display.title("1. YES | 2. NO",50);
                            display.boxLower(50);

                            int choice111 = selection.getchoice(2);
                            if (choice111 == 1){
                                // 참가자 객체 생성
                                participant p1 = new participant("타이슨");
                                participant p2 = new participant("일레이나");
                                participant p3 = new participant("문희");
                                participant p4 = new participant("안나");

                                display.line(100);
                                display.boxUpper(50);
                                display.title("경 마 게 임", 50);
                                System.out.println("  다섯 마리 경주마가 있습니다. 1등 말에게 배팅하세요!");
                                display.blankLine(1);
                                System.out.println("    1번 말 | 2번 말 | 3번 말 | 4번 말 | 5번 말");
                                display.blankLine(1);
                                System.out.println("  배팅 현황: ");
                                p1.showChosenHorse();
                                p2.showChosenHorse();
                                p3.showChosenHorse();
                                p4.showChosenHorse();
                                display.boxLower(50);

                                System.out.println("\n당신의 선택은?");
                                int choice1111 = selection.getchoice(5);

                                System.out.println("\n베팅할 금액을 입력해주세요.");
                                while (true) {
                                    int riderMoney = selection.getNum();

                                    // 돈이 부족하지 않은 경우
                                    if (riderMoney <= riderItem.getRiderMoney()) {
                                        System.out.println(riderMoney+" 은화를 배팅했습니다. 다른 참가자들을 기다려보아요.\n");
                                        riderItem.setRiderMoney(riderItem.getRiderMoney()-riderMoney);

                                        l3.run();

                                        p1.randomParticipantMoney(riderMoney);
                                        p2.randomParticipantMoney(riderMoney);
                                        p3.randomParticipantMoney(riderMoney);
                                        p4.randomParticipantMoney(riderMoney);

                                        display.boxUpper(50);
                                        display.title("경 마 게 임", 50);
                                        System.out.println("  배팅 현황: ");
                                        System.out.println("  "+rider.getRiderName()+": "+choice1111+"번 말, "+riderMoney+" 은화");
                                        p1.showHorsenMoney();
                                        p2.showHorsenMoney();
                                        p3.showHorsenMoney();
                                        p4.showHorsenMoney();
                                        display.boxLower(50);

                                        display.blankLine(1);
                                        System.out.println("\n엔터 키를 누르면 경주를 시작합니다.");
                                        selection.pass();

                                        // 카운트다운 스레드
                                        countdown c = new countdown();
                                        c.start();
                                        try {
                                            c.join();
                                        } catch (Exception e){System.out.println(e);}


                                        raceRank r = new raceRank();
                                        music raceBGM = new music("bgm", "경마게임", false);
                                        raceBGM.start();

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

                                        try {
                                            h1.join();
                                            h2.join();
                                            h3.join();
                                            h4.join();
                                            h5.join();
                                        } catch (Exception e) {System.out.println(e);}

                                        display.line(100);
                                        System.out.println("경기가 종료되었습니다.");
                                        raceBGM.close();
                                        r.showRank();

                                        // 총 배당금 계산
                                        int totalMoney = riderMoney + p1.getParticipantMoney() + p2.getParticipantMoney() + p3.getParticipantMoney() + p4.getParticipantMoney();
                                        int award = 0;

                                        // 나와 같은 말에 배팅한 사람 수(나 포함)
                                        int peopleNum = 1;
                                        if (p1.getHorseNumber() == choice1111) {peopleNum+=1;}
                                        if (p2.getHorseNumber() == choice1111) {peopleNum+=1;}
                                        if (p3.getHorseNumber() == choice1111) {peopleNum+=1;}
                                        if (p4.getHorseNumber() == choice1111) {peopleNum+=1;}

                                        // 1등 전체 배당금의 80%
                                        if (choice1111 == r.getRankAll()[1][0]){
                                            // 디버그
                                            // System.out.println("totalMoney: "+totalMoney+" peoplenum: "+peopleNum+" award: "+award);
                                            award = totalMoney * 4 / peopleNum / 5;
                                            riderItem.setRiderMoney(riderItem.getRiderMoney()+award);

                                            display.blankLine(1);
                                            System.out.println("축하합니다! 배팅한 말이 1위를 차지했습니다.");
                                            System.out.println("배당금 "+award+" 은화를 획득하였습니다. 현재 보유 은화는 "+riderItem.getRiderMoney()+" 은화입니다.");

                                            display.blankLine(1);
                                            System.out.println("\n엔터 키를 누르면 마루로 돌아갑니다.");
                                            selection.pass();
                                            break;

                                        // 2~5등 전체 배당금의 5% 씩
                                        } else {
                                            // 디버그
                                            // System.out.println("totalMoney: "+totalMoney+" peoplenum: "+peopleNum+" award: "+award);
                                            award = totalMoney / peopleNum / 20;
                                            riderItem.setRiderMoney(riderItem.getRiderMoney()+award);

                                            System.out.println("배당금 "+award+" 은화를 획득하였습니다. 현재 보유 은화는 "+riderItem.getRiderMoney()+" 은화입니다.");

                                            display.blankLine(1);
                                            System.out.println("\n엔터 키를 누르면 마루로 돌아갑니다.");
                                            selection.pass();
                                            break;

                                        }

                                    // 돈이 부족한 경우
                                    } else {
                                        display.blankLine(1);
                                        // display.line(100);
                                        System.out.println("은화가 부족합니다! 현재 보유 은화는 " + riderItem.getRiderMoney() + " 은화입니다.");
                                        System.out.println("다시 입력해주세요.");
                                        display.blankLine(1);
                                    }
                                }


                            } else {
                                System.out.println("\n이벤트에 참여하지 않습니다. 엔터 키를 누르면 마루로 돌아갑니다.");
                                selection.pass();
                                display.line(100);
                            }
                        } else {

                        }



                        display.boxUpper(80);
                        display.title("마루", 80);
                        display.blankLine(1);
                        display.title("현재 위치는 마루입니다. 무엇이 필요하신가요?", (int) (80 * 0.85));
                        //display.blankLine(1);
                        display.title("1. 칸에게 말걸기  2. 테이블 위 박스 살펴보기 3. 홈 화면 가기", (int) (80 * 0.85));
                        display.blankLine(1);
                        display.riderStatView(80);
                        display.blankLine(1);
                        int choice112 = selection.getchoice(3);

                        // 1. 칸에게 말걸기
                        if (choice112 == 1) {
                            display.line();
                            rider.isWhere = "상 점";

                            // 상점 출력
                            while (true) {
                                display.placeName(rider.isWhere);
                                System.out.print("칸: 좋은 기승자에게 좋은 장비는 필수지!\n\n당신의 선택은?");
                                System.out.println("\n1. 물품 구입하기\n2. 물품 판매하기\n3. 돌아가기\n");
                                int choice1121 = selection.getchoice(4);

                                // 물품 구입하기
                                if (choice1121 == 1) {
                                    boolean isTrue = true;

                                    while (isTrue) {
                                        display.line(100);
                                        System.out.println("\n칸: 어때 필요한 물건이 있나?\n");
                                        process.shopView(50);
                                        riderItem.showRiderMoney(50);


                                        System.out.println("\n구입하고 싶은 물품을 선택해주세요.\n");
                                        int choice11211 = selection.getchoice0(11);

                                        if (choice11211 == 1) {
                                            isTrue = riderItem.buyingEquipmentProcess(privateHat1);
                                        } else if (choice11211 == 2) {
                                            isTrue = riderItem.buyingEquipmentProcess(privateHat5);
                                        } else if (choice11211 == 3) {
                                            isTrue = riderItem.buyingEquipmentProcess(privateHat10);
                                        } else if (choice11211 == 4) {
                                            isTrue = riderItem.buyingEquipmentProcess(privateBoots1);
                                        } else if (choice11211 == 5) {
                                            isTrue = riderItem.buyingEquipmentProcess(privateBoots5);
                                        } else if (choice11211 == 6) {
                                            isTrue = riderItem.buyingEquipmentProcess(privateBoots10);
                                        } else if (choice11211 == 7) {
                                            isTrue = riderItem.buyingEquipmentProcess(privateGlobe1);
                                        } else if (choice11211 == 8) {
                                            isTrue = riderItem.buyingEquipmentProcess(privateGlobe5);
                                        } else if (choice11211 == 9) {
                                            isTrue = riderItem.buyingEquipmentProcess(privateGlobe10);
                                        } else if (choice11211 == 10) {
                                            isTrue = riderItem.buyingSnackProcess(carrot);
                                        } else if (choice11211 == 11) {
                                            isTrue = riderItem.buyingSnackProcess(chocolate);
                                        } else {
                                            break;
                                        }
                                        display.line(100);
                                    }

                                // 2. 물품 판매하기
                                } else if (choice1121 == 2) {
                                    display.line(100);
                                    display.placeName(rider.isWhere);
                                    System.out.print("칸: 어디보자.. 물건을 팔고 싶다고?\n");
                                    riderItem.showRiderInventory();

                                    System.out.println("\n어떤 물품을 판매하시겠어요?\n1. 장비\n2. 간식\n3. 판매하지 않는다.\n");
                                    int choice1122 = selection.getchoice(3);

                                    // 1. 장비 판매
                                    if (choice1122 == 1) {
                                        // 장비 선택
                                        System.out.println("\n판매하고 싶은 장비를 선택해주세요.\n");
                                        int choice11221 = selection.getchoice(riderItem.getEquipmentInvent().size());

                                        // 판매 확인
                                        System.out.println(riderItem.getEquipmentInvent().get(choice11221 - 1).itemName + "의 판매 가격은 " + riderItem.getEquipmentInvent().get(choice11221 - 1).getItemSellingPrice() +
                                                " 은화입니다.\n정말 판매하시겠습니까?\n\n1. 판매한다.\n2. 판매하지 않는다.\n");
                                        int choice112211 = selection.getchoice(2);

                                        // 판매
                                        if (choice112211 == 1) {
                                            riderItem.sellingEquipment(riderItem.getEquipmentInvent().get((choice11221 - 1)));
                                            System.out.println("\n엔터 키를 누르면 마루로 돌아갑니다.");
                                            selection.pass();
                                            break;

                                        // 판매하지 않음 -> 상점 화면으로
                                        } else {
                                            System.out.println("\n엔터 키를 누르면 상점으로 돌아갑니다.");
                                            selection.pass();
                                        }

                                    // 2. 간식 판매
                                    } else if (choice1122 == 2) {
                                        // 간식 선택
                                        System.out.println("\n판매하고 싶은 간식을 선택해주세요.\n");
                                        int choice11222 = selection.getchoice(riderItem.getSnackInvent().size());

                                        // 판매 수량
                                        System.out.println("\n몇 개 판매하시겠습니까?");
                                        int num = selection.getNum();

                                        // 판매 가능 여부 - 가능
                                        if (num <= riderItem.getSnackInvent().get(choice11222 - 1).itemQuantity) {

                                            // 판매 확인
                                            System.out.println(riderItem.getSnackInvent().get(choice11222 - 1).itemName + " " + num + "개의 판매 가격은 " + riderItem.getSnackInvent().get(choice11222 - 1).getItemSellingPrice() * num +
                                                    " 은화입니다.\n정말 판매하시겠습니까?\n\n1. 판매한다.\n2. 판매하지 않는다.\n");
                                            int choice112221 = selection.getchoice(2);

                                            // 1. 판매
                                            if (choice112221 == 1) {
                                                riderItem.sellingSnack(riderItem.getSnackInvent().get(choice11222 - 1), num);
                                                System.out.println("\n엔터 키를 누르면 마루로 돌아갑니다.");
                                                selection.pass();
                                                break;
                                                // 2. 판매하지 않음 -> 상점 화면으로
                                            } else {
                                                System.out.println("\n엔터 키를 누르면 마루로 돌아갑니다.");
                                                selection.pass();
                                            }

                                            // 판매 가능 여부 - 불가
                                        } else {
                                            System.out.println("수량이 부족합니다! 현재 " + riderItem.getSnackInvent().get(choice11222 - 1).itemName + "을 " + riderItem.getSnackInvent().get(choice11222 - 1).itemQuantity + "개 보유하고 있습니다.");
                                            System.out.println("\n엔터 키를 누르면 상점 화면으로 돌아갑니다.");
                                            selection.pass();
                                            display.line(100);
                                        }

                                        // 3. 상점 화면으로 돌아가기
                                    } else {
                                        System.out.println("\n엔터 키를 누르면 상점 화면으로 돌아갑니다.");
                                        selection.pass();
                                    }

                                // 3. 마루 가기
                                } else if (choice1121 == 3) {
                                    display.blankLine(1);
                                    display.line(100);
                                    break;
                                }

                                // 4. 치트키 - 1000 은화 충전
                                else {
                                    riderItem.setRiderMoney(riderItem.getRiderMoney() + 1000);
                                    display.blankLine(1);
                                    display.boxUpper(50);
                                    display.title("치 트 키", 50);
                                    System.out.println("  치트키를 사용했습니다. 1000 은화가 충전되었습니다.");
                                    System.out.println("  보유 현금: " + riderItem.getRiderMoney() + " 은화");
                                    display.boxLower(50);
                                }
                            }

                        // 2. 승마 장갑이 있는 박스 열기
                        } else if (choice112 == 2) {
                            display.line();
                            rider.isWhere = "마루 테이블";
                            display.placeName(rider.isWhere);

                            System.out.print("박스를 열어보니 공용 장갑이 쌓여 있네요! 3M 장갑 한 쌍을 획득했습니다.");
                            riderItem.addEquipment(publicGlobe);
                            display.line();
                            riderItem.showRiderInventory();

                            System.out.println("\n엔터 키를 누르면 마루로 돌아갑니다.");
                            selection.pass();

                        // 3. 홈 화면 가기
                        } else {
                            break;
                        }

                    horseRacing.interrupt();

                    }


                // 3. 마사
                } else if (choice110==3){
                    while (true) {
                        rider.isWhere = "마 사";
                        display.line();
                        display.placeName(rider.isWhere);
                        System.out.print("마사에 도착했습니다.\n박코치: " + rider.getRiderName() + "님 안녕하세요~");
                        display.blankLine(1);
                        display.boxUpper(80);
                        display.title("마사", 80);
                        display.blankLine(1);
                        display.title("현재 위치는 마사입니다. 무엇이 필요하신가요?", (int) (80 * 0.85));
                        //display.blankLine(1);
                        display.title("1. 박코치에게 말걸기 2. 말에게 다가가기 3. 홈 화면 가기", (int) (80 * 0.85));
                        display.blankLine(1);
                        display.riderStatView(80);
                        display.blankLine(1);

                        int choice113 = selection.getchoice(3);

                        // 1. 박배우에게 말걸기
                        if (choice113 == 1) {
                            display.line();
                            display.blankLine(1);
                            display.placeName(rider.isWhere);
                            System.out.println(rider.getRiderName()+": 코치님! 뭐하고 계세요?");
                            System.out.println("박코치: 마사를 관리하고 있어요. 매일매일 할 일이 정말 많네요.");
                            display.blankLine(1);
                            System.out.println("바쁜 박코치를 도와줄까요? 당신의 선택은? \n1. 마사 청소하기\n2. 돌아 나가기\n");

                            int choice1131 = selection.getchoice(2);

                            // 마사 청소하기
                            if (choice1131 == 1){
                                display.line(100);
                                display.blankLine(1);
                                System.out.println("마사를 청소 중입니다.");
                                l2.run();
                                //p1.start();
                                riderItem.setRiderMoney(riderItem.getRiderMoney()+10);

                                System.out.println("10 은화를 획득했습니다. 현재 보유 은화는 "+riderItem.getRiderMoney()+" 은화 입니다.\n");
                                System.out.println("\n엔터 키를 누르면 홈 화면으로 돌아갑니다.");
                                selection.pass();
                                break;

                            // 건초 나르기
                            // } else if (choice1131 == 2) {

                            } else {

                            }

                        // 2. 말에게 다가가기
                        } else if (choice113 == 2) {
                            while (true) {
                                display.line();
                                display.placeName(rider.isWhere);
                                System.out.print("마사에 말들이 쉬고 있네요. 어느 말에게 가볼까요?\n");
                                horseriding.showHorses();

                                int choice1132 = selection.getchoice(3); // 1. 쎄미 2. 제국이 3. 걸작이
                                display.blankLine(1);
                                System.out.println(horseriding.getHorses().get(choice1132 - 1).getHorseName() + "(이)랑 교감해볼까요? 당신의 선택은?\n1. 간식 주기\n2. 목욕 시키기\n3. 돌아가기\n");

                                int choice1133 = selection.getchoice(3);

                                // 간식 주기
                                if (choice1133 == 1) {
                                    while (true) {
                                        display.line(100);
                                        riderItem.showSnackInvent();
                                        System.out.println(horseriding.getHorses().get(choice1132 - 1).getHorseName() + "(이)에게 줄 간식을 선택해주세요.");
                                        int choice11331 = selection.getchoice0(riderItem.getSnackInvent().size());

                                        if (choice11331 == 0) {
                                            break;
                                        }

                                        // 말 간식 선택
                                        if (riderItem.getSnackInvent().get(choice11331 - 1).getSnackType() == 0) {
                                            if (riderItem.getSnackInvent().get(choice11331 - 1).getItemQuantity() > 0) {
                                                horseriding.getHorses().get(choice1132 - 1).feedHorse(riderItem.getSnackInvent().get(choice11331 - 1));
                                                display.blankLine(1);
                                                System.out.println("간식을 더 줄까요?\n1. 간식을 선택한다.\n2. 돌아 나간다.\n");

                                                int choice113311 = selection.getchoice(2);
                                                if (choice113311 == 1) {
                                                } else {
                                                    break;
                                                }
                                            } else {
                                                System.out.println(riderItem.getSnackInvent().get(choice11331 - 1).itemName + "이 부족합니다. 아이템을 구입해주세요.");
                                                display.blankLine(1);
                                                System.out.println("엔터키를 입력하면 이전 화면으로 돌아갑니다.");
                                                selection.pass();
                                                break;
                                            }

                                            // 사람 간식 선택
                                        } else {
                                            System.out.println(riderItem.getSnackInvent().get(choice11331 - 1).itemName + "은 말이 먹는 간식이 아니에요! 위험해요.");
                                            display.blankLine(1);
                                            System.out.println("다른 간식을 줄까요?\n1. 다른 간식을 선택한다.\n2. 돌아 나간다.\n");

                                            int choice11332 = selection.getchoice(2);
                                            if (choice11332 == 0) {

                                            } else {
                                                break;
                                            }
                                        }
                                    }

                                    // 목욕시키기
                                } else if (choice1133 == 2) {
                                    display.line(100);
                                    System.out.println(horseriding.getHorses().get(choice1132 - 1).getHorseName() + "(이) 땀을 많이 흘렸네. 목욕 시켜볼까?\n1. 목욕 시킨다.\n2. 돌아 나간다.\n");
                                    int choice11333 = selection.getchoice(2);

                                    if (choice11333 == 1) {
                                        display.blankLine(1);

                                        shower.start();
                                        l4.start();

                                        try {
                                            l4.join();
                                        } catch (Exception e){System.out.println(e); }

                                        horseriding.getHorses().get(choice1132 - 1).setHorseIntimacy(horseriding.getHorses().get(choice1132 - 1).getHorseIntimacy()+10);
                                        rider.setRiderEnergy(rider.getRiderEnergy()-15);

                                        System.out.println("어휴 힘들다. 체력이 15 감소했습니다.");
                                        System.out.println(horseriding.getHorses().get(choice1132 - 1).getHorseName()+"(이)의 친밀도가 10 증가했습니다.");
                                        break;

                                    } else {

                                    }

                                    // 마사로 돌아가기
                                } else {
                                    display.line(100);
                                    display.blankLine(1);
                                    break;
                                }
                            }

                        // 홈 화면 가기
                        } else {
                            display.line(100);
                            display.blankLine(1);
                            break;
                        }
                    }

                // 4. 마장
                } else if (choice110==4) {
                    while (true) {
                        display.line();
                        rider.isWhere = "마 장";
                        display.placeName(rider.isWhere);
                        System.out.print("마장에 도착했습니다. 사장님이 원형 마장에서 레슨을 하고 계시네요.");
                        display.blankLine(1);
                        display.boxUpper(80);
                        display.title("마장", 80);
                        display.blankLine(1);
                        display.title("현재 위치는 마장입니다. 무엇이 필요하신가요?", (int) (80 * 0.85));
                        //display.blankLine(1);
                        display.title("1. 사장님에게 말걸기 2. 승마하기 3. 홈 화면 가기", (int) (80 * 0.85));
                        display.blankLine(1);
                        display.riderStatView(80);
                        display.blankLine(1);

                        int choice114 = selection.getchoice(3);

                        // 1. 사장님에게 말걸기
                        if (choice114 == 1) {
                            display.line();
                            display.placeName(rider.isWhere);
                            System.out.println(rider.getRiderName() + ": 사장님 안녕하세요!");
                            System.out.println("사장님: 어 " + rider.getRiderName() + "씨 왔어요?");
                            System.out.println(rider.getRiderName() + ": 오늘 어떤 말을 타면 좋을까요?");
                            display.blankLine(1);
                            System.out.println("사장님: 오늘 마사에 있는 말을 보여줄게. 골라봐요    『Enter』");
                            selection.pass();

                            ssemi.showHorseInfo();
                            empire.showHorseInfo();
                            masterpiece.showHorseInfo();

                            display.blankLine(1);
                            horseriding.chooseHorseView();

                            int choice1141 = selection.getchoice(4);
                            if (choice1141 == 1) {
                                display.line();
                                System.out.println("쎄미가 선택되었습니다.");
                                rider.setChosenHorse("쎄미");

                            } else if (choice1141 == 2) {
                                display.line();
                                System.out.println("제국이가 선택되었습니다.");
                                rider.setChosenHorse("제국이");
                                display.blankLine(1);
                                System.out.println("\n엔터 키를 누르면 마장으로 돌아갑니다.");
                                selection.pass();

                            } else if (choice1141 == 3) {
                                display.line();
                                System.out.println("걸작이가 선택되었습니다.");
                                rider.setChosenHorse("걸작이");
                                display.blankLine(1);
                                System.out.println("\n엔터 키를 누르면 마장으로 돌아갑니다.");
                                selection.pass();

                            } else {
                                System.out.println(rider.getRiderName() + "씨는 오늘 쎄미가 좋겠다. 준비하고 마장으로 와요~");
                                System.out.println("쎄미가 선택되었습니다.");
                                rider.setChosenHorse("쎄미");
                                display.blankLine(1);
                                System.out.println("\n엔터 키를 누르면 마장으로 돌아갑니다.");
                                selection.pass();
                            }

                        // 2. 승마하기
                        } else if (choice114 == 2) {
                            // 장비 체크
                            if (!riderItem.equipmentCheck()) {

                                display.line(100);
                                System.out.println("승마 장비를 모두 장착하지 않으면 기승할 수 없습니다. 장비를 착용해주세요.");
                                riderItem.showMountedEquip();
                                display.blankLine(1);
                                System.out.println("\n엔터 키를 누르면 마장으로 돌아갑니다.");
                                selection.pass();

                            } else {

                                // 말 선택 여부
                                if (riderItem.getChosenHorse() == null) {
                                    display.line(100);
                                    System.out.println("아직 말을 선택하지 않았습니다! 사장님과 이야기해서 말을 선택해주세요.");
                                    display.blankLine(1);
                                    System.out.println("\n엔터 키를 누르면 마장으로 돌아갑니다.");
                                    selection.pass();

                                    // 승마 가능
                                } else {

                                    while (true) {
                                        display.line(100);
                                        System.out.println("［ 원 형 마 장 ］");
                                        System.out.println("1회 기승 비용은 "+horseriding.getOneRidePrice()+"은화입니다. 입장하시겠어요?\n\n1. 승마 시작하기\n2. 간식 먹기\n3. 마장으로 돌아가기\n");
                                        int choice1142 = selection.getchoice(4);

                                        if (choice1142 == 1) {

                                            // 돈이 충분히 있는 경우
                                            if (riderItem.getRiderMoney() >= horseriding.getOneRidePrice()) {

                                                // 입장료 지불
                                                riderItem.setRiderMoney(riderItem.getRiderMoney() - horseriding.getOneRidePrice());
                                                System.out.println(horseriding.getOneRidePrice() + " 은화를 사용하여 입장합니다. 현재 남은 은화는 " + riderItem.getRiderMoney() + "은화 입니다.");

                                                display.line(100);
                                                display.blankLine(1);
                                                System.out.println("승마를 시작합니다.");

                                                // 기승자 상태창
                                                rider.showRiderInfo();

                                                // 기승자 스킬창
                                                riderSkill.setRiderAvailability();

                                                riderSkill.resetPossibleSkill();

                                                riderSkill.setPossibleSkill(riderSkill.getSkillList());

                                                riderSkill.showPossibleSkill();

                                                // 스킬 선택창
                                                display.line(100);
                                                display.blankLine(1);
                                                System.out.println("시행할 스킬을 선택해주세요. \n(해당 선택지의 번호를 숫자로 입력해주세요)");

                                                int choice11421 = selection.getchoice(riderSkill.getPossibleSkill().size());

                                                display.line(100);
                                                display.blankLine(1);

                                                // 스킬 시행
                                                System.out.println(riderSkill.getPossibleSkill().get(choice11421 - 1).skillName + "를 시행합니다.\n");
                                                riderSkill.setRiderSkillPossibleP(riderSkill.getPossibleSkill().get(choice11421 - 1).skillSuccessP + rider.riderProficiency);

                                                if (riderSkill.getSkillResult()) {
                                                    riderSkill.skillSuccess(riderSkill.getPossibleSkill().get(choice11421 - 1).skillName, riderSkill.getPossibleSkill().get(choice11421 - 1).skillKcalBurned, riderSkill.getPossibleSkill().get(choice11421 - 1).skillEnergyUsed);
                                                } else {
                                                    riderSkill.skillFail(riderSkill.getPossibleSkill().get(choice11421 - 1).skillName, riderSkill.getPossibleSkill().get(choice11421 - 1).skillEnergyUsed);
                                                }

                                                rider.levelUp(5, 100);
                                                rider.badEnd(100);
                                                rider.levelMaxEnd(10, 100);

                                                System.out.println("\n엔터 키를 누르면 게임을 이어서 진행할 수 있습니다.");
                                                selection.pass();

                                            // 돈이 부족한 경우
                                            } else {
                                                display.blankLine(1);
                                                display.line(100);
                                                System.out.println("은화가 부족합니다!");
                                                System.out.println("현재 보유 은화는 "+riderItem.getRiderMoney()+" 입니다.");
                                                System.out.println("\n은화가 필요하다면 박코치를 찾아가보세요.");
                                                display.blankLine(1);
                                                System.out.println("\n엔터 키를 누르면 마장으로 돌아갑니다.");
                                                selection.pass();

                                            }

                                        // 2. 간식 먹기
                                        } else if (choice1142 == 2){
                                            boolean isTrue = true;
                                            while (isTrue) {
                                                display.line(100);
                                                System.out.println("\n에너지를 보충은 필수! 어떤 간식을 드시겠어요?\n원하는 간식의 이름을 입력해주세요.");
                                                riderItem.showRiderInventory();
                                                int choice1202 = selection.getchoice0(riderItem.getSnackInvent().size());
                                                if (choice1202 == 0) {
                                                    break;
                                                }

                                                System.out.println("\n섭취할 개수를 입력해주세요.");
                                                int num = selection.getNum();

                                                isTrue = riderItem.eatSnack(riderItem.getSnackInvent().get(choice1202 - 1), num);
                                            }
                                        // 3. 마장으로 돌아가기
                                        } else if (choice1142 == 3){
                                            break;

                                        // 4. 치트키 - 만렙
                                        } else {
                                            display.blankLine(1);
                                            display.boxUpper(50);
                                            display.title("치 트 키", 50);
                                            System.out.println("  치트키를 사용했습니다. 최대 레벨까지 레벨업합니다.");
                                            display.boxLower(50);

                                            while (true){
                                            rider.levelCheatKey(5, 100);
                                                if (rider.getRiderLevel()>=10){
                                                    break;
                                                }
                                            }
                                            rider.levelMaxEnd(10,100);

                                        }

                                    }
                                }
                            }

                        // 3. 홈 화면 가기
                        } else {
                            break;
                        }
                    }
                // 5. 홈 화면 가기
                } else {

                }

            // 2. 인벤토리
            } else if (choice100==2) {
                while (true) {
                    display.line(100);
                    display.blankLine(1);
                    riderItem.showRiderInventory();
                    display.blankLine(1);
                    System.out.println("1. 장비 장착하기\n2. 간식 먹기\n3. 홈 화면 가기\n");
                    int choice120 = selection.getchoice(4);

                    // 1. 장비 장착하기
                    if (choice120 == 1) {
                        boolean isTrue = true;
                        while (isTrue) {
                            display.line(100);
                            System.out.println("\n승마를 하려면 장비를 갖추어야 하지요. 어떤 장비를 장착하실래요?\n장착하고 싶은 장비를 선택해주세요.\n");
                            riderItem.showRiderInventory();
                            int choice1201 = selection.getchoice0(riderItem.getEquipmentInvent().size());
                            if (choice1201 == 0){
                                break;
                            }
                            isTrue = riderItem.mountEquipment(riderItem.getEquipmentInvent().get((choice1201 - 1)));

                        }

                    // 2. 간식 먹기
                    } else if (choice120 == 2) {
                        boolean isTrue = true;
                        while (isTrue) {
                            display.line(100);
                            System.out.println("\n에너지를 보충은 필수! 어떤 간식을 드시겠어요?\n원하는 간식의 이름을 입력해주세요.");
                            riderItem.showRiderInventory();
                            int choice1202 = selection.getchoice0(riderItem.getSnackInvent().size());
                            if (choice1202 == 0){
                                break;
                            }

                            System.out.println("\n섭취할 개수를 입력해주세요.");
                            int num = selection.getNum();

                            isTrue = riderItem.eatSnack(riderItem.getSnackInvent().get(choice1202-1),num);
                        }
                    // 3. 홈 화면 가기
                    } else if (choice120 == 3) {
                        display.blankLine(1);
                        break;

                    // 4. 만렙 치트키
                    } else {

                    }
                }
            //3. 장착 장비 보기
            } else if (choice100==3) {
                display.line(100);
                display.blankLine(1);
                riderItem.showMountedEquip();
                display.blankLine(1);
                System.out.println("엔터키를 입력하면 홈 화면으로 돌아갑니다.");
                selection.pass();
                display.blankLine(1);

            //4. 마장 지도 보기
            } else if (choice100==4) {
                display.line(100);
                display.map();
                System.out.println("\n엔터 키를 누르면 홈 화면으로 돌아갑니다.");
                selection.pass();

            //5. 게임 종료하기
            } else {
                System.out.println("게임을 종료합니다.");
                System.out.println("다음에 다시 만나요 "+rider.getRiderName()+"님");
                System.exit(0);
            }
        }

        }
    }


