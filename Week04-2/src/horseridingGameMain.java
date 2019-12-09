public class horseridingGameMain {

    public static void main(String[] args) {
        // 기승자 객체 생성
        riderItem riderItem = new riderItem();
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
        riderEquipment helmet = new riderEquipment("자전거 헬멧",0,1,0,0,0);
        riderEquipment hat = new riderEquipment("낡은 승마 모자",0,1,0,0,0);
        riderEquipment chap = new riderEquipment("낡은 승마 챕",1,1,0,0,0);
        riderEquipment globe = new riderEquipment("3M 장갑",2,1,0,0,0);

        // 간식 객체 생성
        snack chocolate = new snack("초콜릿",1,20,5,3);
        snack carrot = new snack("당근",0,10,5,3);

        // 게임 플레이
        process.openingVer1();
        selection.pass();

        // 사용자 이름 설정
        System.out.println("당신의 이름은 무엇인가요?\n");
        rider.setRiderName(selection.textinput());

        display.blankLine(1);
        System.out.println(rider.getRiderName()+"님 안녕하세요!");
        System.out.println("처음 오셨나요? 승마장에 대해 설명 드릴게요.");

        // 튜토리얼 선택
        display.blankLine(1);
        System.out.println("1. 튜토리얼을 본다\n2. 바로 게임을 시작한다.\n");
        String choice = selection.getchoice(2);

        if (choice.equals("1")) {
            process.tutorial();
        }

        // 홈 화면
        while (true) {
            display.boxUpper(80);
            display.title("마장 입구", 80);
            display.blankLine(1);
            display.title("승마클럽에 오신 것을 환영합니다. 무엇이 필요하신가요?", (int) (80 * 0.85));
            //display.blankLine(1);
            display.title("1. 이동하기  2. 인벤토리 열기 3. 장착 장비 보기", (int) (80 * 0.85));
            display.title("4. 게임 종료하기", (int)(80));
            display.blankLine(1);
            display.riderStatView(80);
            display.blankLine(1);
            String choice100 = selection.getchoice(4);

            // 1. 이동하기
            if (choice100.equals("1")) {
                display.line();
                display.blankLine(1);
                System.out.println("어디로 이동하시겠습니까?");
                System.out.println("1. 장비 보관함\n2. 마루\n3. 마사\n4. 마장\n\n5. 홈 화면 가기\n");

                String choice110 = selection.getchoice(5);
                // 1. 장비 보관함
                if (choice110.equals("1")) {
                    display.line();
                    System.out.println("장비 보관함에 도착했습니다. 공용 장비들이 보이네요.");
                    display.blankLine(1);
                    display.boxUpper(80);
                    display.title("장비 보관함", 80);
                    display.blankLine(1);
                    display.title("현재 위치는 장비 보관함입니다. 무엇이 필요하신가요?", (int) (80 * 0.85));
                    //display.blankLine(1);
                    display.title("1. 승마 모자가 있는 장 살펴보기 2. 승마 챕이 있는 서랍장 열기 3. 홈 화면 가기", (int) (80 * 0.85));
                    display.blankLine(1);
                    display.riderStatView(80);
                    display.blankLine(1);

                    // 장비 보관함에서 상황
                    String choice111 = selection.getchoice(3);

                    // 1. 승마 모자(자전거 헬멧) 획득
                    if (choice111.equals("1")) {
                        display.line();
                        System.out.println("낡은 승마 모자와 헬멧이 뒤섞여 있습니다. 선택해주세요.\n1. 낡은 승마 모자\n2. 헬멧");
                        String choice1111 = selection.getchoice(2);
                        if (choice1111.equals("1")){
                            System.out.println("\n낡은 승마 모자를 획득했습니다.");
                            riderItem.addEquipment("낡은 승마 모자", 0, 1, 0, 0, 0);
                            display.line();
                            riderItem.showRiderInventory();
                            System.out.println("\n엔터 키를 누르면 홈 화면으로 돌아갑니다.");
                            selection.pass();

                        } else {
                            display.line();
                            System.out.println("\n자전거 헬멧을 획득했습니다.");
                            riderItem.addEquipment("자전거 헬멧", 0, 1, 0, 0, 0);
                            display.line();
                            riderItem.showRiderInventory();
                            System.out.println("\n엔터 키를 누르면 홈 화면으로 돌아갑니다.");
                            selection.pass();

                        }

                    // 2. 승마 부츠(낡은 승마 챕) 획득
                    } else if (choice111.equals("2")) {
                        display.line();
                        System.out.println("승마 챕이 쌓여 있습니다. 짝이 맞는 두 쌍을 골라봅시다.\n");
                        System.out.println(
                                "       승마 챕 A                                  승마 챕 C\n" +
                                        "                              승마 챕 B\n" +
                                        "                 승마 챕 D                                               승마 챕 E\n" +
                                        "                                                     승마 챕 F\n"
                        );

                        // 공용 승마챕 0행은 왼발용, 1행은 오른발용. 각각 한 짝 씩 골라야 함
                        String left = "ACD";
                        String right = "BEF";

                        System.out.println("첫 번째 승마 챕을 선택해주세요.\n알파벳 대문자로 입력하세요. EX) A");
                        String firstChap = selection.getAtoF();
                        System.out.println("\n두 번째 승마 챕을 선택해주세요.\n알파벳 대문자로 입력하세요. EX) A");
                        String secondChap = selection.getAtoF();

                        while (true) {
                            if (firstChap.equals(secondChap)) {
                                System.out.println("같은 챕을 두 번 선택할 수 없습니다. 다시 선택헤주세요.");
                                secondChap = selection.getAtoF();
                            } else if (left.contains(firstChap) == right.contains(secondChap)) {
                                System.out.println("\n짝을 찾았습니다! 공용 승마챕을 획득했습니다.");

                                riderItem.addEquipment("낡은 승마 챕", 1, 1, 0, 0, 0);

                                display.line();
                                riderItem.showRiderInventory();

                                System.out.println("\n엔터 키를 누르면 홈 화면으로 돌아갑니다.");
                                selection.pass();
                                break;

                            } else {
                                System.out.println("짝이 맞지 않습니다. 디른 챕을 선택해주세요");
                                secondChap = selection.getAtoF();
                            }
                        }

                    } else {

                    }

                // 2. 마루
                } else if (choice110.equals("2")){
                    display.line();
                    System.out.println("\n마루에 도착했습니다.\n칸: "+ rider.getRiderName() +"씨 왔어? 오늘 괜찮은 물건이 많은데 둘러봐");
                    display.blankLine(1);
                    display.boxUpper(80);
                    display.title("마루",80);
                    display.blankLine(1);
                    display.title("현재 위치는 마루입니다. 무엇이 필요하신가요?", (int) (80 * 0.85));
                    //display.blankLine(1);
                    display.title("1. 칸에게 말걸기  2. 테이블 위 박스 살펴보기 3. 홈 화면 가기", (int) (80 * 0.85));
                    display.blankLine(1);
                    display.riderStatView(80);
                    display.blankLine(1);
                    String choice112 = selection.getchoice(3);

                    // 1. 칸에게 말걸기
                    if (choice112.equals("1")) {
                        display.line();
                        System.out.println("쎄미가 선택되었습니다.");
                        rider.setChosenHorse("쎄미");

                    // 2. 승마 장갑이 있는 박스 열기
                    } else if (choice112.equals("2")) {
                        display.line();
                        System.out.println("박스를 열어보니 공용 장갑이 쌓여 있네요! 3M 장갑 한 쌍을 획득했습니다.");
                        riderItem.addEquipment("3M 장갑", 2, 1, 0, 0, 0);

                        display.line();
                        riderItem.showRiderInventory();

                        System.out.println("\n엔터 키를 누르면 홈 화면으로 돌아갑니다.");
                        selection.pass();

                    // 3. 홈 화면 가기
                    } else {

                    }


                // 3. 마사
                } else if (choice110.equals("3")){
                    display.line();
                    System.out.println("\n마사에 도착했습니다.\n박배우: "+ rider.getRiderName() +"님 안녕하세요~");
                    display.blankLine(1);
                    display.boxUpper(80);
                    display.title("마사",80);
                    display.blankLine(1);
                    display.title("현재 위치는 마사입니다. 무엇이 필요하신가요?", (int) (80 * 0.85));
                    //display.blankLine(1);
                    display.title("1. 박배우에게 말걸기 2. 말에게 다가가기 3. 홈 화면 가기", (int) (80 * 0.85));
                    display.blankLine(1);
                    display.riderStatView(80);
                    display.blankLine(1);

                    String choice113 = selection.getchoice(3);

                    // 1. 박배우에게 말걸기
                    if (choice113.equals("1")) {
                        display.line();
                        System.out.println("쎄미가 선택되었습니다.");
                        rider.setChosenHorse("쎄미");

                    // 2. 말에게 다가가기
                    } else if (choice113.equals("2")) {
                        display.line();
                        System.out.println("제국이가 선택되었습니다.");
                        rider.setChosenHorse("제국이");
                        display.blankLine(1);
                        System.out.println("\n엔터 키를 누르면 홈 화면으로 돌아갑니다.");
                        selection.pass();

                    // 홈 화면 가기
                    } else {

                    }

                // 4. 마장
                } else if (choice110.equals("4")) {
                    display.line();
                    System.out.println("\n마장에 도착했습니다. 사장님이 원형 마장에서 레슨을 하고 계시네요.");
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

                    String choice114 = selection.getchoice(3);

                    // 1. 사장님에게 말걸기
                    if (choice114.equals("1")) {
                        display.line();
                        System.out.println(rider.getRiderName() + ": 사장님 안녕하세요!");
                        System.out.println("사장님: 어 " + rider.getRiderName() + "씨 왔어요?");
                        System.out.println(rider.getRiderName() + ": 오늘 어떤 말을 타면 좋을까요?");
                        display.blankLine(1);
                        System.out.println("사장님: 오늘 마사에 있는 말을 보여줄게. 골라봐요");
                        ssemi.showHorseInfo();
                        empire.showHorseInfo();
                        masterpiece.showHorseInfo();

                        display.blankLine(1);
                        System.out.println("1. 쎄미\n2. 제국이\n3. 걸작이\n4. 추천을 부탁드린다.");
                        String choice1141 = selection.getchoice(4);
                        if (choice1141.equals("1")) {
                            display.line();
                            System.out.println("쎄미가 선택되었습니다.");
                            rider.setChosenHorse("쎄미");

                        } else if (choice1141.equals("2")) {
                            display.line();
                            System.out.println("제국이가 선택되었습니다.");
                            rider.setChosenHorse("제국이");
                            display.blankLine(1);
                            System.out.println("\n엔터 키를 누르면 홈 화면으로 돌아갑니다.");
                            selection.pass();

                        } else if (choice1141.equals("3")) {
                            display.line();
                            System.out.println("걸작이가 선택되었습니다.");
                            rider.setChosenHorse("걸작이");
                            display.blankLine(1);
                            System.out.println("\n엔터 키를 누르면 홈 화면으로 돌아갑니다.");
                            selection.pass();

                        } else {
                            System.out.println(rider.getRiderName() + "씨는 오늘 쎄미가 좋겠다. 준비하고 마장으로 와요~");
                            System.out.println("쎄미가 선택되었습니다.");
                            rider.setChosenHorse("쎄미");
                            display.blankLine(1);
                            System.out.println("\n엔터 키를 누르면 홈 화면으로 돌아갑니다.");
                            selection.pass();
                        }

                    // 2. 승마하기
                    } else if (choice114.equals("2")) {
                        if (riderItem.equipmentCheck()==false){
                            display.line(100);
                            System.out.println("승마 장비를 모두 장착하지 않으면 기승할 수 없습니다. 장비를 착용해주세요.");
                            riderItem.showMountedEquip();
                            display.blankLine(1);
                            System.out.println("\n엔터 키를 누르면 홈 화면으로 돌아갑니다.");
                            selection.pass();
                        } else {
                            if (riderItem.getChosenHorse()==null){
                                display.line(100);
                                System.out.println("아직 말을 선택하지 않았습니다! 마장에서 말을 선택해주세요.");

                            } else {
                                display.line(100);
                                horseriding.doOneRide();
                            }
                        }

                    // 3. 홈 화면 가기
                    } else {
                    }
                }

            // 2. 인벤토리
            } else if (choice100.equals("2")) {
                display.line(100);
                display.blankLine(1);
                riderItem.showRiderInventory();
                display.blankLine(1);
                System.out.println("1. 장비 장착하기\n2. 간식 먹기\n3. 말에게 간식 주기\n4. 홈 화면 가기\n");
                String choice120 = selection.getchoice(4);

                // 1. 장비 장착하기
                if (choice120.equals("1")){
                    display.line(100);
                    System.out.println("\n승마를 하려면 장비를 갖추어야 하지요. 어떤 장비를 장착하실래요?\n원하는 장비의 이름을 입력해주세요.\n");
                    String equipChoice = selection.textinput();
                    riderItem.mountEquipment(equipChoice);

                    System.out.println("엔터키를 입력하면 홈 화면으로 돌아갑니다.");
                    selection.pass();
                    display.blankLine(1);

                // 2. 간식 먹기
                } else if (choice120.equals("2")){
                    display.line(100);
                    System.out.println("\n에너지를 보충은 필수! 어떤 간식을 드시겠어요?\n원하는 간식의 이름을 입력해주세요.");
                    String snackChoice = selection.textinput();
                    riderItem.eatSnack(snackChoice);

                    System.out.println("엔터키를 입력하면 홈 화면으로 돌아갑니다.");
                    selection.pass();
                    display.blankLine(1);

                // 3. 말에게 간식 주기
                } else if (choice120.equals("3")){
                    display.line(100);
                    System.out.println("아직 이용하실 수 없는 기능입니다. 업데이트를 기다려주세요!");

                    System.out.println("엔터키를 입력하면 홈 화면으로 돌아갑니다.");
                    selection.pass();
                    display.blankLine(1);

                // 4. 홈 화면 가기
                }  else {
                    display.blankLine(1);
                }

            //3. 장착 장비 보기
            } else if (choice100.equals("3")) {
                display.line(100);
                display.blankLine(1);
                riderItem.showMountedEquip();
                display.blankLine(1);
                System.out.println("엔터키를 입력하면 홈 화면으로 돌아갑니다.");
                selection.pass();
                display.blankLine(1);

            //4. 게임 종료하기
            } else if (choice100.equals("4")) {
                System.out.println("게임을 종료합니다.");
                System.out.println("다음에 다시 만나요 "+rider.getRiderName()+"님");
                System.exit(0);
            } else {

            }
        }

        /*

        rideritem.showRiderInventory();
        rideritem.addEquipment(helmet.itemName,helmet.getEquipmentType(),helmet.getMountableLevel(),helmet.getRiderStatImprovePercent(),helmet.itemBuyingPrice,helmet.itemSellingPrice);
        rideritem.showRiderInventory();

        rideritem.mountEquipment("자전거 헬멧");
        rideritem.showMountedEquip();
        rideritem.showRiderInventory();




        rideritem.addSnack(chocolate.itemName,chocolate.getSnackType(),chocolate.getRecoveryAmount(),chocolate.itemBuyingPrice,chocolate.itemSellingPrice);
        rideritem.addSnack(carrot.itemName, carrot.getSnackType(),carrot.getRecoveryAmount(),carrot.itemBuyingPrice,carrot.itemSellingPrice);

        rideritem.showRiderInventory();
        rideritem.addSnack(chocolate.itemName,chocolate.getSnackType(),chocolate.getRecoveryAmount(),chocolate.itemBuyingPrice,chocolate.itemSellingPrice);
        rideritem.increaseSnackQuantity("초콜릿");
        rideritem.showRiderInventory();
        rideritem.increaseSnackQuantity("초콜릿");
        rideritem.showRiderInventory();

        rideritem.eatSnack("초콜릿");
        rider.showRiderInfo();
        rideritem.showRiderInventory();


        //while (true){
        //horseriding.doOneRide();
        //}

         */
        }
    }


