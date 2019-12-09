/*
rider: 기승자를 생성하고 기승자 정보를 저장하는 클래스
1. riderFunc
1.1. newRider: 새로운 기승자 객체 생성
1.2. loadRider: 기존 기승자 객체 불러오기
1.3. saveRider: 현재 기승자 객체 저장

2. riderInfo
2.1. riderStat: 기승자 스탯 정보(레벨, 체력, 숙련도, 운동량)
2.2. riderInvent: 기승자 인벤토리
2.3. riderMountedEquip: 기승자 장착 장비
 */

import java.util.ArrayList;
import java.util.Scanner;

public class rider {
    Scanner sc = new Scanner(System.in);
    private static String riderName; // 기승자 이름 선언
    display display = new display();

    String getRiderName() {
        return riderName;
    }

    void setRiderName(String riderName) {
        this.riderName = riderName;
    }

    display getDisplay() {
        return display;
    }

}

// 1. riderFunc
class riderFunc extends rider {
    String password; // 비밀번호
    public String fileAddress; // 정보 저장 위치
}

// 1.1. newRider
class newRider extends riderFunc {

    // createRider 메소드: 새로운 기승자를 생성하는 메소드
    void createRider() {
        getDisplay().line();

        // 기승자명 입력
        System.out.println("새로운 게임을 시작합니다.\n당신의 이름은 무엇인가요?\n");
        super.setRiderName(sc.nextLine());
        System.out.println("\n" + getRiderName() + "님 안녕하세요!");

        // 비밀번호 입력 및 확인
        /*Console console = System.console();
        if (console == null) {
            System.out.println("Couldn't get Console Instance");
            System.exit(0);
        }

         */
        while (true) {
            System.out.println("비밀번호를 입력해주세요. 비밀번호는 게임 저장 및 로드 시 사용됩니다.");
            //char[] readpw = console.readPassword();
            //password = new String(readpw);
            password = sc.nextLine();

            System.out.println("\n비밀번호를 다시 한 번 입력해주세요.");
            //char[] checkpw = console.readPassword();
            //String checkPW = new String(checkpw);
            String checkPW = sc.nextLine();
            if (checkPW.equals(password)) {
                System.out.println("\n비밀번호가 확인되었습니다.");
                break;
            } else {
                System.out.println("\n비밀번호가 일치하지 않습니다. 다시 설정해주세요.");
            }
        }

        getDisplay().line();
        System.out.println("\n마장에 오신 것을 환영합니다.");
        System.out.println("\n처음 방문하셨으니 마장 구조를 설명드릴게요. 튜토리얼을 진행하시겠습니까?");
        System.out.println("1. 튜토리얼을 진행한다.\n2. 바로 게임을 시작한다.");

        while (true) {
            String choice = sc.nextLine();
            if (choice.equals("1")) {
                tutorial();
            } else if (choice.equals("2")) {
                entrance entrance = new entrance();
                entrance.entranceView();
            } else {
                System.out.println("잘못된 입력입니다. 선택지에 있는 숫자를 입력해주세요.");
            }
        }
    }

    // tutorial: 튜토리얼을 실행하는 메소드
    private void tutorial(){
        getDisplay().line();
        System.out.println("튜토리얼을 시작합니다.\n");
    }

}

// 1.2. loadRider
class loadRider extends riderFunc {

}

// 1.3. saveRider
class saveRider extends riderFunc {

}

// 2. riderInfo
class riderInfo extends rider {
    public void show() { // 기승자 정보를 콘솔창에 출력한다

    }

}

// 2.1. riderStat
class riderStat extends riderInfo {

    //레벨에 따른 스텟 속성 정의
    private static int[][] arrayLevelStat = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, // 레벨
            {50, 60, 70, 80, 90, 120, 150, 180, 240, 300}, // 레벨에 따른 최대 체력
            {20, 40, 80, 160, 320, 640, 1280, 2560, 5120, 10240}}; //레벨업 하기 위해 필요한 운동량

    private int riderLevel = 1; //레벨 초기값

    private int levelEnergy = arrayLevelStat[1][(riderLevel-1)]; //레벨에 따른 최대 체력
    private int riderEnergy = levelEnergy; //체력 초기값

    private int levelKcalBurned = arrayLevelStat[2][(riderLevel-1)]; //레벨업 하기 위해 필요한 운동량
    private int riderKcalBurned = 0; //운동량 초기값

    private int riderProficiency = 0; //숙련도 초기값

    private int[] arrayRiderStat = {riderLevel, riderEnergy, riderKcalBurned, riderProficiency}; // 레벨, 체력, 운동량, 숙련도

    int getLevelEnergy() {
        return levelEnergy;
    }

    int getLevelKcalBurned() {
        return levelKcalBurned;
    }

    int getRiderLevel() {
        return riderLevel;
    }

    int getRiderEnergy() {
        return riderEnergy;
    }

    public int getRiderProficiency() {
        return riderProficiency;
    }

    int getRiderKcalBurned() {
        return riderKcalBurned;
    }

    public int[] getArrayRiderStat() {
        return arrayRiderStat;
    }

    public void levelUp(){
        if(riderKcalBurned >= levelKcalBurned) {
            riderLevel = riderLevel + 1;
            riderEnergy = levelEnergy;
            riderKcalBurned = 0;
        }
    }

    public void loseEnergy(){
        riderEnergy = riderEnergy - 10;
    }

    public void proficiencyUp(){
        riderProficiency = riderProficiency + 5;
    }

    public void kcalBurned(int ridingTime){
        riderKcalBurned = ridingTime * 10;
    }
}

// 2.2. riderInvent
class riderInvent extends riderInfo {

    private ArrayList <riderEquipment>riderOwnedEquip = new ArrayList<riderEquipment>(); // riderEquipment 객체를 담는 arraylist 선언
    private ArrayList <snack>riderOwnedSnack = new ArrayList<snack>(); // snack 객체를 담는 arraylist 선언

    // riderOwnedEquip 리스트에 객체 추가
    void addEquipment(String itemName, int equipmentType, int riderStatImprovePercent, int itemPrice){
        this.riderOwnedEquip.add(new riderEquipment(itemName, equipmentType, riderStatImprovePercent, itemPrice));
    }

    // riderOwnedSnack 리스트에 객체 추가
    public void addSnack(String itemName, int snackType, int recoveryAmount, int itemPrice){
        this.riderOwnedSnack.add(new snack(itemName, snackType, recoveryAmount, itemPrice));
    }

    // riderOwnedSnack 리스트 객체의 수량 추가
    public void increaseSnackQuantity(String itemName) {
        for (snack item : this.riderOwnedSnack) {
            if (itemName.equals(item.getItemName())) {
                item.add();
                return;
            }
        }
    }

    // riderOwnedSnack 리스트 객체의 수량 감소
    public void decreaseSnackQuantity(String itemName) {
        for (snack item : this.riderOwnedSnack) {
            if (itemName.equals(item.getItemName())) {
                if (item.getItemQuantity()>=0) {
                    item.remove();
                }
                return;
            }
        }
    }

    // get riderOwnedEquip
    public ArrayList<riderEquipment> getRiderOwnedEquip() {
        return riderOwnedEquip;
    }

    // get riderOwnedSnack
    public ArrayList<snack> getRiderOwnedSnack() {
        return riderOwnedSnack;
    }

    // set riderOwnedEquip
    public void setRiderOwnedEquip(ArrayList<riderEquipment> riderOwnedEquip) {
        this.riderOwnedEquip = riderOwnedEquip;
    }

    // set riderOwnedSnack
    public void setRiderOwnedSnack(ArrayList<snack> riderOwnedSnack) {
        this.riderOwnedSnack = riderOwnedSnack;
    }

    // 보유 장비 출력
    public void showRiderOwnedEquip(){
        String result = "보유 장비:\n";
        for (riderEquipment item: this.riderOwnedEquip){
            result+= item.itemName +"\n";}
        System.out.println(result);
    }

    // 보유 간식 출력
    public void showRiderOwnedSnack(){
        String result = "보유 간식:\n";
        for (snack item: this.riderOwnedSnack){
            result+= item.itemName +"\n";}
        System.out.println(result);
    }

    // 장비 장착하기
    public void mountEquipment(){

    }

    // 간식 먹기
    public void eatSnack(){

    }

    public void showRiderInventory (){
        display.line();
        System.out.println("현재 보유하고 있는 물품입니다.\n");
        showRiderOwnedEquip();
        showRiderOwnedSnack();

        // 선택지 제공
        System.out.println("\n1. 장비 장착하기\n2. 간식 먹기\n3. 홈 화면 가기");

        // 선택값에 따라 이행
        while (true) {
            String choice = sc.nextLine();
            if (choice.equals("1")) {
                mountEquipment();
            } else if (choice.equals("2")) {
                eatSnack();
            } else if (choice.equals("3")) {
                entrance e = new entrance();
                e.entranceView();
            } else {
                System.out.println("잘못된 입력입니다. 선택지에 있는 숫자를 입력해주세요.");
            }
        }

    }


}

// 2.3. riderMountedEquip
class riderMountedEquip extends riderInvent {
    public String[] arrayRiderMountedEquip = {"장비 없음", "장비 없음", "장비 없음"}; // 장착 장비칸. 순서대로 승마 모자, 승마 부츠, 승마 장갑 장착 가능

    public void showRiderMountedEquip (){
        display.line();
        System.out.println(
                "현재 장착하고 있는 장비입니다.\n"+
                "승마 모자: "+arrayRiderMountedEquip[0]+
                "\n승마 부츠: "+arrayRiderMountedEquip[1]+
                "\n승마 장갑: "+arrayRiderMountedEquip[2]
        );
        System.out.println("\n엔터 키를 누르면 홈 화면으로 돌아갑니다.");
        sc.nextLine();
        entrance e = new entrance();
        e.entranceView();
    }

    public void mountEquipment (){

    }

}

// 2.4. riderPlace
class riderPlace extends riderInfo {
    String iswhere;

    void moveTo(){

    }
}