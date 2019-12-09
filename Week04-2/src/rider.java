import java.util.Scanner;
import java.util.ArrayList;

public class rider {
    Scanner sc = new Scanner(System.in); // 스캐너 객체 생성
    static String riderName; // 기승자명
    static int riderLevel = 1; // 기승자 레벨 초기값
    static int riderProficiency = 0; // 기승자 숙련도 초기값
    private static String chosenHorse;

    static void setChosenHorse(String chosenHorse) {
        rider.chosenHorse = chosenHorse;
    }

    public String getChosenHorse() {
        return chosenHorse;
    }

    void showChosenHorse(){
        if (chosenHorse == null){
            System.out.println("선택된 말이 없습니다. 사장님에게 가서 기승할 말을 선택해주세요.");
        } else {
            System.out.println("기승 마필: "+chosenHorse);
        }
    }


    public static String getRiderName() {
        return riderName;
    }

    public static void setRiderProficiency(int riderProficiency) {
        rider.riderProficiency = riderProficiency;
    }

    public static int getRiderProficiency() {
        return riderProficiency;
    }

    private static int[][] arrayLevelStat = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, // 레벨
            {50, 60, 70, 80, 90, 120, 150, 180, 240, 300}, // 레벨에 따른 최대 체력
            {20, 40, 80, 160, 320, 640, 1280, 2560, 5120, 10240}}; //레벨업 하기 위해 필요한 운동량

    private static int levelEnergy = arrayLevelStat[1][(riderLevel-1)]; //레벨에 따른 최대 체력
    private static int riderEnergy = levelEnergy; //체력 초기화

    public static void setRiderName(String riderName) {
        rider.riderName = riderName;
    }

    public static int getRiderLevel() {
        return riderLevel;
    }

    void setRiderEnergy(int riderEnergy) {
        rider.riderEnergy = riderEnergy;
    }
    static int getRiderEnergy() {
        return riderEnergy;
    }

    public static int getLevelEnergy() {
        return levelEnergy;
    }

    public static void setLevelEnergy(int levelEnergy) {
        rider.levelEnergy = levelEnergy;
    }

    public static int getLevelKcalBurned() {
        return levelKcalBurned;
    }

    private static int levelKcalBurned = arrayLevelStat[2][(riderLevel-1)]; //레벨업 하기 위해 필요한 운동량
    private static int riderKcalBurned = 0; //운동량 초기값

    void setRiderKcalBurned(int riderKcalBurned) {
        rider.riderKcalBurned = riderKcalBurned;
    }

    static int getRiderKcalBurned() {
        return riderKcalBurned;
    }

    void showRiderInfo(){
        display.boxUpper(20);
        System.out.println("  기승자 상태");
        System.out.println("  레벨: "+riderLevel);
        System.out.println("  체력: "+riderEnergy+"/"+levelEnergy);
        System.out.println("  운동량: "+riderKcalBurned+"/"+levelKcalBurned);
        display.boxLower(20);
    }

    void levelUp(int proficiencyUp, int width){
        if(riderKcalBurned>=levelKcalBurned){
            riderLevel = (riderLevel +1);
            riderProficiency = (riderProficiency + proficiencyUp);
            riderEnergy = levelEnergy;
            riderKcalBurned = 0;
            display.line(width);
            System.out.println("레벨업! 축하합니다.");
        }
    }

    void badEnd(int width){
        if(riderEnergy<=0){
            display.line(width);
            display.line(width);
            display.line(width);
            display.badEnd100();
            display.blankLine(1);
            System.out.println("체력이 모두 소모되었습니다. 안전이 제일 중요해요~\n푹 쉬고 다음에 만나요.\n");
            System.exit(0);
        }
    }

    void levelMaxEnd(int maxLevel, int width){
        if(riderLevel>=maxLevel){
            display.line(width);
            display.blankLine(1);
            display.horseImg100();
            System.out.println("축하합니다!!! 마왕의 칭호를 획득하셨습니다.");
            System.exit(0);
        }
    }
}

// 기승자의 스킬 수행에 대한 클래스
// 숙련도에 따라 수행 가능한 스킬을 업데이트하고 화면에 출력한다.
// 스킬 시행 성공 여부를 판별하여 기승자 상태에 반영한다.
class riderSkill extends rider{
    private ArrayList <skill> possibleSkill = new ArrayList<skill>(); // 기승자가 수행 가능한 skill 객체를 담는 arraylist possibleSkill 생성
    int skillNum = possibleSkill.size();
    boolean skillSuccess; // 스킬 성공 여부

    // possibleSkill 리스트에 객체 추가
    void addPossibleSkill(int index, String skillName, int proficiencyNeed, int skillSuccessP, int skillKcalBurned, int skillEnergyUsed){
        if (riderProficiency >= proficiencyNeed) {
            this.possibleSkill.add(new skill(index, skillName, proficiencyNeed, skillSuccessP, skillKcalBurned, skillEnergyUsed));
        }
    }

    public ArrayList<skill> getPossibleSkill() {
        return possibleSkill;
    }

    public void setPossibleSkill(ArrayList<skill> possibleSkill) {
        this.possibleSkill = possibleSkill;
    }

    // 수행 가능한 스킬 출력
    void showPossibleSkill(){
        display.boxUpper(20);
        System.out.println("  기승자 스킬\n"+
                "  (현재 숙련도: "+riderProficiency+ ")");
        String result = " ";
        for (skill skill: this.possibleSkill){
            result +=("\n  "+skill.index+". "+skill.skillName);
        }
        System.out.println(result);
        display.boxLower(20);
    }

    // 기승자의 숙련도를 반영한 스킬 성공 확률 변수 선언
    private int riderSkillPossibleP;

    public void setRiderSkillPossibleP(int riderSkillPossibleP) {
        this.riderSkillPossibleP = riderSkillPossibleP;
    }

    // 스킬 수행 결과값을 얻는 메소드
    public boolean getSkillResult(){
        if(riderSkillPossibleP>100){
            skillSuccess = true;
        } else {
            //100칸 배열 생성
            boolean[] possibilityBox = new boolean[100];
            //skillSuccessP 만큼 true 로 채우고
            for (int i = 0; i < riderSkillPossibleP; i++) {
                possibilityBox[i] = true;
            }
            //나머지를 false로 채움
            for (int i = riderSkillPossibleP; i < 100; i++) {
                possibilityBox[i] = false;
            }

            //랜덤함수로 랜덤 인덱스 생성
            int j = (int) (Math.random() * 100);
            skillSuccess = possibilityBox[j];
        }
        return skillSuccess;
    }

    void skillSuccess(String skillName, int skillKcalBurned, int skillEnergyUsed){
        System.out.println(skillName+"를 성공했습니다!");
        int temp;
        temp = getRiderKcalBurned();
        setRiderKcalBurned(temp+skillKcalBurned);
        System.out.println("운동량을 "+skillKcalBurned+"Kcal 소모했습니다.");
        temp = getRiderEnergy();
        setRiderEnergy(temp-skillEnergyUsed);
        System.out.println("체력이 "+skillEnergyUsed+"만큼 감소했습니다.");
    }

    void skillFail(String skillName, int skillEnergyUsed){
        System.out.println(skillName+"에 실패했습니다. 역시 "+skillName+"는 쉽지 않네요.");
        int temp;
        temp = getRiderEnergy();
        setRiderEnergy(temp-skillEnergyUsed);
        System.out.println("체력이 "+skillEnergyUsed+"만큼 감소했습니다.");
    }

}

// 기승자 인벤토리에 대한 클래스
class riderInvent extends rider{
    private int riderMoney = 0;

    public int getRiderMoney() {
        return riderMoney;
    }

    public void setRiderMoney(int riderMoney) {
        this.riderMoney = riderMoney;
    }

    private ArrayList <riderEquipment> equipmentInvent = new ArrayList<riderEquipment>(); // riderEquipment 객체를 담는 arraylist 선언
    private ArrayList <snack> snackInvent = new ArrayList<snack>(); // snack 객체를 담는 arraylist 선언

    // equipmentInvent 리스트에 객체 추가
    void addEquipment(String itemName, int equipmentType, int mountableLevel, int riderStatImprovePercent, int itemBuyingPrice, int itemSellingPrice){
        this.equipmentInvent.add(new riderEquipment(itemName, equipmentType, mountableLevel, riderStatImprovePercent, itemBuyingPrice, itemSellingPrice));
    }

    // equipmentInvent 리스트에 객체 제거
    void removeEquipment(String itemName, int equipmentType, int mountableLevel, int riderStatImprovePercent, int itemBuyingPrice, int itemSellingPrice){
        this.equipmentInvent.remove(new riderEquipment(itemName, equipmentType, mountableLevel, riderStatImprovePercent, itemBuyingPrice, itemSellingPrice));
    }

    // snackInvent 리스트에 객체 추가
    public void addSnack(String itemName, int snackType, int recoveryAmount, int itemBuyingPrice, int itemSellingPrice){
        this.snackInvent.add(new snack(itemName, snackType, recoveryAmount, itemBuyingPrice, itemSellingPrice));
    }

    // snackInvent 리스트 객체의 수량 추가
    public void increaseSnackQuantity(String itemName) {
        for (snack snack : this.snackInvent) {
            if (itemName.equals(snack.getItemName())) {
                snack.add();
                return;
            }
        }
    }

    // snackInvent 리스트 객체의 수량 감소
    public void decreaseSnackQuantity(String itemName) {
        for (snack item : this.snackInvent) {
            if (itemName.equals(item.getItemName())) {
                if (item.getItemQuantity()>=0) {
                    item.remove();
                }
                return;
            }
        }
    }

    public ArrayList<riderEquipment> getEquipmentInvent() {
        return equipmentInvent;
    }

    public ArrayList<snack> getSnackInvent() {
        return snackInvent;
    }

    public void setEquipmentInvent(ArrayList<riderEquipment> equipmentInvent) {
        this.equipmentInvent = equipmentInvent;
    }

    public void setSnackInvent(ArrayList<snack> snackInvent) {
        this.snackInvent = snackInvent;
    }

    // 보유 장비 출력
    public void showEquipmentInvent(){
        String result = "  보유 장비:\n";
        for (riderEquipment item: this.equipmentInvent){
            result+= "  "+item.itemName +"\n";}
        System.out.println(result);
    }

    // 보유 간식 출력
    public void showSnackInvent(){
        String result = "  보유 간식:\n";
        for (snack item: this.snackInvent) {
            if (item.itemQuantity > 0) {
                result += "  "+item.itemName + " " + item.itemQuantity + "개\n";
            }
        }
        System.out.println(result);
    }

    // 인벤토리 출력
    public void showRiderInventory (){
        display.boxUpper(30);
        display.title("인벤토리",30);
        display.boxLower(30);
        showEquipmentInvent();
        display.perforation2(30);
        showSnackInvent();
        display.perforation2(30);
        System.out.println("  보유 현금: "+getRiderMoney()+" 은화\n");
        display.boxLower(30);
    }
}

// 기승자의 아이템 사용에 대한 클래스
// 간식을 먹거나 장비를 장착할 수 있다.
// 현재 장작 창비를 보여준다.
class riderItem extends riderInvent{
    private riderEquipment[] arrayRiderMountedEquip = new riderEquipment[3]; // 장착 장비칸 배열 선언. 순서대로 승마 모자, 승마 부츠, 승마 장갑 장착 가능

    public void setArrayRiderMountedEquip(riderEquipment[] arrayRiderMountedEquip) {
        this.arrayRiderMountedEquip = arrayRiderMountedEquip;
    }

    public riderEquipment[] getArrayRiderMountedEquip() {
        return arrayRiderMountedEquip;
    }


    // 기승자가 간식을 먹는 메소드
    public void eatSnack(String itemName){
        display.line();
        for (snack item: super.getSnackInvent()){
            if (itemName.equals(item.getItemName())&&item.itemQuantity>0){
                // recoveryAmount 만큼 회복
                if (getRiderEnergy()+item.getRecoveryAmount()>getLevelEnergy()){
                    setRiderEnergy(getLevelEnergy()); // 합이 레벨 최대 체력보다 커지면 레벨 최대 체력 반환
                } else {
                    setRiderEnergy(getRiderEnergy() + item.getRecoveryAmount());
                }
                System.out.println(itemName+"을 먹었습니다. 체력이 "+item.getRecoveryAmount()+" 증가합니다.");

                // 인벤토리에서 itemQuantity -1
                item.remove();
                break;
            }

            // 아이템이 존재하지 않는 경우
            else {
                System.out.println(itemName+"이 부족합니다. 아이템을 구입해주세요.");
                break;
            }
        }
        display.blankLine(1);
    }

    // 기승자가 장비를 장착하는 메소드
    public void mountEquipment(String itemName) {
        display.line();
        for (riderEquipment item : this.getEquipmentInvent()) {
            // 아이템이 존재하는 경우
            if (itemName.equals(item.itemName)) {

                // 장착 가능 레벨 확인
                if (item.getMountableLevel() <= riderLevel) {

                    // 현재 장비 장착 여부에 따라
                    // 장착 중인 장비가 있을 때
                    if (arrayRiderMountedEquip[item.getEquipmentType()] != null) {
                        System.out.println("현재 " + arrayRiderMountedEquip[item.getEquipmentType()].itemName + "을(를) 착용 중입니다. 장비를 교체할까요?\n"
                                + "1.교체한다\n2.교체하지 않는다");
                        display.blankLine(1);

                        String choice = selection.getchoice(2);

                        //장비를 교체할 때
                        if (choice.equals("1")) {

                            // 기존에 장착중인 장비 객체를 인벤토리 리스트에 추가
                            addEquipment(arrayRiderMountedEquip[item.getEquipmentType()].itemName, arrayRiderMountedEquip[item.getEquipmentType()].getEquipmentType(), arrayRiderMountedEquip[item.getEquipmentType()].getMountableLevel(), arrayRiderMountedEquip[item.getEquipmentType()].getRiderStatImprovePercent(), arrayRiderMountedEquip[item.getEquipmentType()].itemBuyingPrice, arrayRiderMountedEquip[item.getEquipmentType()].itemSellingPrice);

                            // 새로 장착할 장비를 인벤토리 리스트에서 제거
                            removeEquipment(item.itemName, item.getEquipmentType(), item.getMountableLevel(), item.getRiderStatImprovePercent(), item.itemBuyingPrice, item.itemSellingPrice);

                            // 새로 장착한 장비를 장비 배열에 추가
                            arrayRiderMountedEquip[item.getEquipmentType()] = new riderEquipment(item.itemName, item.getEquipmentType(), item.getMountableLevel(), item.getRiderStatImprovePercent(), item.itemBuyingPrice, item.itemSellingPrice);

                            display.line();
                            System.out.println(item.itemName + "를 장착했습니다.");

                            // EquipmentType 에 따라
                            // 승마 모자: 최대 체력 증가
                            if (item.getEquipmentType() == 0) {
                                System.out.println("최대 체력이 " + item.getRiderStatImprovePercent() + "% 증가합니다.");
                                setLevelEnergy((int) (getLevelEnergy() * (1 + item.getRiderStatImprovePercent() / 100)));
                            }
                            // 승마 부츠: 숙련도 증가
                            else if (item.getEquipmentType() == 1) {
                                System.out.println("숙련도가 " + item.getRiderStatImprovePercent() + "% 증가합니다.");
                                setRiderProficiency((int) (getRiderProficiency() * (1 + item.getRiderStatImprovePercent() / 100)));
                            }
                            // 승마 장갑: 체력 차감율 감소
                            else {
                                System.out.println("기승 중 체력 소모량이 " + item.getRiderStatImprovePercent() + "% 감소합니다.");

                            }

                        }

                        // 장비를 교체하지 않을 때
                        else if (choice.equals("2")) {
                            display.line();
                            System.out.println("장비를 교체하지 않습니다. 홈 화면으로 돌아갑니다.");
                        } else {
                        }

                        // 장착 중인 장비가 없을 때
                    } else {
                        // 새로 장착할 장비를 인벤토리 리스트에서 제거
                        removeEquipment(item.itemName, item.getEquipmentType(), item.getMountableLevel(), item.getRiderStatImprovePercent(), item.itemBuyingPrice, item.itemSellingPrice);

                        // 새로 장착한 장비를 장비 배열에 추가
                        arrayRiderMountedEquip[item.getEquipmentType()] = new riderEquipment(item.itemName, item.getEquipmentType(), item.getMountableLevel(), item.getRiderStatImprovePercent(), item.itemBuyingPrice, item.itemSellingPrice);

                        display.line();
                        System.out.println(item.itemName + "를 장착했습니다.");

                        // Equipment Type 에 따라
                        // 승마 모자: 최대 체력 증가
                        if (item.getEquipmentType() == 0) {
                            System.out.println("최대 체력이 " + item.getRiderStatImprovePercent() + "% 증가합니다.");
                            setLevelEnergy((int) (getLevelEnergy() * (1 + item.getRiderStatImprovePercent() / 100)));
                        }
                        // 승마 부츠: 숙련도 증가
                        else if (item.getEquipmentType() == 1) {
                            System.out.println("숙련도가 " + item.getRiderStatImprovePercent() + "% 증가합니다.");
                            setRiderProficiency((int) (getRiderProficiency() * (1 + item.getRiderStatImprovePercent() / 100)));
                        }
                        // 승마 장갑: 체력 차감율 감소
                        else {
                            System.out.println("기승 중 체력 소모량이 " + item.getRiderStatImprovePercent() + "% 감소합니다.");
                        }
                    }

                } else {
                    System.out.println("레벨이 낮아 " + item.itemName + "을 장착할 수 없습니다. 장착 가능 레벨은 " + item.getMountableLevel() + " 입니다.");
                }

            }

            // 아이템이 존재하지 않는 경우
            else {
                System.out.println(itemName + "을(를) 보유하고 있지 않습니다.");
                display.blankLine(1);
                showEquipmentInvent();
                System.out.println("다시 입력하시갰습니까?\n1. 네\n2. 아니오\n");
                String choice2 = selection.getchoice(2);

                if (choice2.equals("1")) {
                    System.out.println("\n원하는 장비의 이름을 입력해주세요.\n");
                    String itemchoice = selection.textinput();
                    mountEquipment(itemchoice);
                } else {
                }
            }
            display.blankLine(1);
        }
    }

    // Null 값을 고려한 장비창 상황
    String getMountedEquipStatus(int i){
        String mountedEquipStatus = "";
        if (arrayRiderMountedEquip[i]!=null){
            mountedEquipStatus = arrayRiderMountedEquip[i].itemName;
        }
        else {
            mountedEquipStatus = "장비 없음";
        }
        return mountedEquipStatus;

    }

    // 장착 장비창 보여주는 메소드
    public void showMountedEquip (){
        display.boxUpper(40);
        display.title("장착 장비",40);
        display.blankLine(1);
        System.out.println(
                        "  승마 모자: "+getMountedEquipStatus(0)+
                        "\n  승마 부츠: "+getMountedEquipStatus(1)+
                        "\n  승마 장갑: "+getMountedEquipStatus(2)
        );
        display.boxLower(40);
    }

    // 기승 가능 여부 판별하는 메소드. 3가지 장비를 모두 장착해야 기승할 수 있다.
    public boolean equipmentCheck(){
            if (arrayRiderMountedEquip[0]!=null&&arrayRiderMountedEquip[1]!=null&&arrayRiderMountedEquip[2]!=null){
                return true;
            } else {
                return false;
            }
        }
    }


