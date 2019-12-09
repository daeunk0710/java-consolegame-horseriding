/*
기승자 정보에 대한 클래스
rider:
1. riderSkill:
2. riderInvent:
2.1. riderItem:
 */

import java.util.ArrayList;

public class rider {
    static String riderName; // 기승자명

    public static void setRiderLevel(int riderLevel) {
        rider.riderLevel = riderLevel;
    }

    static int riderLevel = 1; // 기승자 레벨 초기값
    static int riderProficiency = 0; // 기승자 숙련도 초기값
    private static String chosenHorse;
    static String isWhere; // 기승자의 장소

    static boolean mawang = false; // 마왕

    public static boolean isMawang() {
        return mawang;
    }

    public static void setMawang(boolean mawang) {
        rider.mawang = mawang;
    }

    static void setChosenHorse(String chosenHorse) {
        rider.chosenHorse = chosenHorse;
    }

    static public String getChosenHorse() {
        return chosenHorse;
    }

    static void showChosenHorse(){
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

    public static int[][] getArrayLevelStat() {
        return arrayLevelStat;
    }

    public static void setArrayLevelStat(int[][] arrayLevelStat) {
        rider.arrayLevelStat = arrayLevelStat;
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

    static void setRiderEnergy(int riderEnergy) {
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

    public static void setLevelKcalBurned(int levelKcalBurned) {
        rider.levelKcalBurned = levelKcalBurned;
    }

    private static int levelKcalBurned = arrayLevelStat[2][(riderLevel-1)]; //레벨업 하기 위해 필요한 운동량
    private static int riderKcalBurned = 0; //운동량 초기값

    static void setRiderKcalBurned(int riderKcalBurned) {
        rider.riderKcalBurned = riderKcalBurned;
    }

    static int getRiderKcalBurned() {
        return riderKcalBurned;
    }

    static void showRiderInfo(){
        display.boxUpper(20);
        System.out.println("  기승자 상태");
        System.out.println("  레벨: "+riderLevel);
        System.out.println("  체력: "+riderEnergy+"/"+levelEnergy);
        System.out.println("  운동량: "+riderKcalBurned+"/"+levelKcalBurned);
        display.boxLower(20);
    }


    static void levelUp(int proficiencyUp, int width){
        if(riderKcalBurned>=levelKcalBurned){
            setRiderLevel(getRiderLevel()+1);
            riderProficiency = (riderProficiency + proficiencyUp);
            setLevelEnergy(getArrayLevelStat()[1][getRiderLevel()-1]);
            setLevelKcalBurned(getArrayLevelStat()[2][getRiderLevel()-1]);
            setRiderEnergy(getLevelEnergy());
            setRiderKcalBurned(0);
            display.line(width);
            System.out.println("레벨업! 축하합니다.");
        }
    }

    static void levelCheatKey(int proficiencyUp, int width){
        setRiderLevel(getRiderLevel()+1);
        riderProficiency = (riderProficiency + proficiencyUp);
        setLevelEnergy(getArrayLevelStat()[1][getRiderLevel()-1]);
        setLevelKcalBurned(getArrayLevelStat()[2][getRiderLevel()-1]);
        setRiderEnergy(getLevelEnergy());
        setRiderKcalBurned(0);
        display.line(width);
        System.out.println("레벨업! 축하합니다.");

    }

    static void badEnd(int width){
        if(riderEnergy<=0){
            display.line(width);
            display.line(width);
            display.line(width);
            display.badEnd100();
            display.blankLine(1);
            System.out.println("체력이 모두 소모되었습니다. 안전이 제일 중요해요~\n푹 쉬고 다음에 만나요.\n");

            display.blankLine(1);
            System.out.println("온동량이 삭감되었습니다.");
            setRiderKcalBurned(getRiderKcalBurned()*2/10);
            setRiderEnergy(10);

            display.blankLine(1);
            System.out.println("엔터키를 누르면 게임 화면으로 복귀합니다.");
            selection.pass();
            display.line(100);

        }
    }

    static void levelMaxEnd(int maxLevel, int width){
        if(riderLevel>=maxLevel){
            display.line(width);
            display.blankLine(1);
            display.horseImg100();
            System.out.println("축하합니다!!! 마왕의 칭호를 획득하셨습니다.");
            setMawang(true);
        }
    }
}

// 기승자의 스킬 수행에 대한 클래스
// 숙련도에 따라 수행 가능한 스킬을 업데이트하고 화면에 출력한다.
// 스킬 시행 성공 여부를 판별하여 기승자 상태에 반영한다.
class riderSkill extends rider{

    // 스킬 목록 담는 리스트 생성
    private ArrayList <skill> skillList = new ArrayList<skill>(); // 기승자가 수행 가능한 skill 객체를 담는 arraylist possibleSkill 생성

    public ArrayList<skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(ArrayList<skill> skillList) {
        this.skillList = skillList;
    }

    // SkillList 리스트에 객체 추가
    void addSkillList(int index, String skillName, int proficiencyNeed, int skillSuccessP, int skillKcalBurned, int skillEnergyUsed){
        this.skillList.add(new skill(index, skillName, proficiencyNeed, skillSuccessP, skillKcalBurned, skillEnergyUsed));
    }

    void addSkillList(skill skill){
        this.skillList.add(skill);
    }

    // 숙련도에 따른 수행 가능 스킬
    void setRiderAvailability() {
        for (skill skill : this.skillList) {
            if (riderProficiency >= skill.proficiencyNeed) {
                skill.riderAvailability = true;
            }
        }
    }


    // 수행 가능 스킬 담는 리스트 생성
    private ArrayList <skill> possibleSkill = new ArrayList<skill>();

    public ArrayList<skill> getPossibleSkill() {
        return possibleSkill;
    }

    // 수행 가능 스킬 리스트에 객체 추가
    public void setPossibleSkill(ArrayList<skill> skillList) {
        for (skill skill: this.skillList){
            if(skill.riderAvailability == true){
                possibleSkill.add(skill);
            }
        }

    }

    // 수행 가능 스킬 리스트 초기화
    void resetPossibleSkill(){
        possibleSkill.clear();
    }

    // 수행 가능한 스킬 출력
    void showPossibleSkill(){
        display.boxUpper(20);
        System.out.println("  기승자 스킬\n"+
                "  (현재 숙련도: "+riderProficiency+ ")");
        String result = " ";
        for (skill skill: this.possibleSkill) {
                result += ("\n  " + (possibleSkill.indexOf(skill)+1)+ ". " + skill.skillName);
        }
        System.out.println(result);
        display.boxLower(20);
    }


    // 기승자의 숙련도를 반영한 스킬 성공 확률 변수 선언
    private int riderSkillPossibleP;

    public int getRiderSkillPossibleP() {
        return riderSkillPossibleP;
    }

    public void setRiderSkillPossibleP(int riderSkillPossibleP) {
        this.riderSkillPossibleP = riderSkillPossibleP;
    }


    // 스킬 수행 결과값을 얻는 메소드
    public boolean getSkillResult(){
        // 스킬 성공 여부
        boolean skillSuccess;
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

    // 스킬 성공
    void skillSuccess(String skillName, int skillKcalBurned, int skillEnergyUsed){
        System.out.println(skillName+"를 성공했습니다!");
        int temp;
        temp = getRiderKcalBurned();
        setRiderKcalBurned(temp+skillKcalBurned);
        System.out.println("운동량을 "+skillKcalBurned+"Kcal 소모했습니다.");
        temp = getRiderEnergy();
        setRiderEnergy(temp-skillEnergyUsed);
        System.out.println("체력이 "+skillEnergyUsed+"만큼 감소했습니다.");
        display.blankLine(1);
    }

    // 스킬 실패
    void skillFail(String skillName, int skillEnergyUsed){
        System.out.println(skillName+"에 실패했습니다. 역시 "+skillName+"는 쉽지 않네요.");
        int temp;
        temp = getRiderEnergy();
        setRiderEnergy(temp-skillEnergyUsed);
        System.out.println("체력이 "+skillEnergyUsed+"만큼 감소했습니다.");
        display.blankLine(1);
    }

}

// 기승자 인벤토리에 대한 클래스
class riderInvent extends rider{
    private int riderMoney = 0;

    int getRiderMoney() {
        return riderMoney;
    }

    public void setRiderMoney(int riderMoney) {
        this.riderMoney = riderMoney;
    }

    void showRiderMoney(int width){
        System.out.println("  보유 현금: "+ this.riderMoney +" 은화\n");
        display.boxLower(width);
    }



    private ArrayList <riderEquipment> equipmentInvent = new ArrayList<riderEquipment>(); // riderEquipment 객체를 담는 arraylist 선언
    private ArrayList <snack> snackInvent = new ArrayList<snack>(); // snack 객체를 담는 arraylist 선언

    // equipmentInvent 리스트에 객체 추가 - 변수값들로
    void addEquipment(String itemName, int equipmentType, int mountableLevel, int riderStatImprovePercent, int itemBuyingPrice, int itemSellingPrice){
        this.equipmentInvent.add(new riderEquipment(itemName, equipmentType, mountableLevel, riderStatImprovePercent, itemBuyingPrice, itemSellingPrice));
    }

    // equipmentInvent 리스트에 객체 추가 - 객체로
    void addEquipment(riderEquipment riderEquipment) {
        this.equipmentInvent.add(riderEquipment);
    }

    // equipmentInvent 리스트에 객체 제거 - 뱐수값들로
    void removeEquipment(String itemName, int equipmentType, int mountableLevel, int riderStatImprovePercent, int itemBuyingPrice, int itemSellingPrice){
        this.equipmentInvent.remove(new riderEquipment(itemName, equipmentType, mountableLevel, riderStatImprovePercent, itemBuyingPrice, itemSellingPrice));
    }

    // equipmentInvent 리스트에 객체 제거 - 객체로
    void removeEquipment(riderEquipment riderEquipment) {
        this.equipmentInvent.remove(riderEquipment);
    }

    // snackInvent 리스트에 객체 추가 - 변수값들로
    public void addSnack(String itemName, int snackType, int recoveryAmount, int itemBuyingPrice, int itemSellingPrice){
        this.snackInvent.add(new snack(itemName, snackType, recoveryAmount, itemBuyingPrice, itemSellingPrice));
    }

    // snackInvent 리스트에 객체 추가 - 객체로
    void addSnack(snack snack) {
        this.snackInvent.add(snack);
    }

    // snackInvent 리스트 객체의 수량 추가
    void increaseSnackQuantity(snack snack, int num) {
        snack.itemQuantity = snack.itemQuantity + num;
    }

    // snackInvent 리스트 객체의 수량 감소
    void decreaseSnackQuantity(snack snack, int num) {
        snack.itemQuantity = snack.itemQuantity - num;
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
            int index =this.equipmentInvent.indexOf(item)+1;
            result+= "  "+index+". "+item.itemName +"\n";}
        if (this.equipmentInvent.isEmpty()){
            result= "  보유 장비: 없음\n";
        }
        System.out.println(result);
    }

    // 보유 간식 출력
    public void showSnackInvent(){
        String result = "  보유 간식:\n";
        for (snack item: this.snackInvent) {
            if (item.itemQuantity >= 0) {
                int index =this.snackInvent.indexOf(item)+1;
                result += "  "+index+ ". " + item.itemName + " " + item.itemQuantity + "개\n";
            }
            else {
                result = "  보유 간식: 없음\n";
            }
        }
        if (this.snackInvent.isEmpty()){
            result = "  보유 간식: 없음\n";
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
        System.out.println("  보유 현금: "+this.getRiderMoney()+" 은화\n");
        display.boxLower(30);
    }

    // 장비 구입창 메소드
    public boolean buyingEquipmentProcess(riderEquipment riderEquipment){
        // 장비 정보 보여주기
        riderEquipment.showRiderEquipment();

        // 구매 확인
        System.out.println("\n정말 구입하시겠습니까?\n1. 구입한다.\n2. 구입하지 않는다.\n");
        int choice1 = selection.getchoice(2);

        // 구매
        if (choice1 == 1) {
            boolean isTrue = buyingEquipment(riderEquipment);

            // 돈이 충분해서 구매 성공
            if (isTrue) {
                System.out.println("\n다른 물품을 구입하실래요?\n1. 구입한다.\n2. 구입하지 않는다.\n");
                int choice2 = selection.getchoice(2);

                if (choice2 == 1) {
                    display.blankLine(1);
                    return true;
                } else {
                    display.line();
                    showRiderInventory();
                    System.out.println("\n엔터 키를 누르면 마루로 돌아갑니다.");
                    selection.pass();
                    return false;
                }

            // 돈이 부족한 경우 마루로 돌아가기
            } else {
                System.out.println("\n엔터 키를 누르면 마루로 돌아갑니다.");
                selection.pass();
                return false;
            }

        // 비구매
        } else {
            System.out.println("장비를 구입하지 않습니다. 다른 물품도 둘러보세요.\n");
            return false;
        }
    }

    // 장비 구입 메소드
    public boolean buyingEquipment(riderEquipment riderEquipment){
            // 장비 가격 이상의 돈을 가지고 있을 때

            // 디버그
            // System.out.println("구입 전 보유 은화 this.getRiderMoney(): "+this.getRiderMoney());

            if (this.getRiderMoney() >= riderEquipment.itemBuyingPrice) {
                // 디버그
                // System.out.println("보유 은화 this.getRiderMoney(): "+this.getRiderMoney());
                // System.out.println("상품 가격 riderEquipment.itemBuyingPrice: "+riderEquipment.itemBuyingPrice);

                addEquipment(riderEquipment);
                setRiderMoney((this.getRiderMoney() - riderEquipment.itemBuyingPrice));

                // 디버그 새로 설정된 riderMoney
                // System.out.println("구입 후 보유 은화 this.getRiderMoney(): "+this.getRiderMoney());

                display.line(100);
                display.blankLine(1);
                System.out.println(riderEquipment.itemBuyingPrice+" 은화를 사용하여 "+riderEquipment.itemName+"를 구입하였습니다!\n");
                System.out.println("현재 보유 은화는 "+this.getRiderMoney()+" 입니다.");
                return true;

            // 돈이 부족할 때
            } else {
                display.blankLine(1);
                display.line(100);
                System.out.println("은화가 부족합니다! "+riderEquipment.itemName+"을(를) 구입하려면 "+riderEquipment.itemBuyingPrice+" 은화가 필요합니다.");
                System.out.println("현재 보유 은화는 "+this.getRiderMoney()+" 입니다.");
                System.out.println("\n은화가 필요하다면 박코치를 찾아가보세요.");
                display.blankLine(1);
                return false;
            }
    }

    // 장비 판매 메소드
    public void sellingEquipment(riderEquipment riderEquipment){
        removeEquipment(riderEquipment);
        setRiderMoney(this.getRiderMoney()+riderEquipment.getItemSellingPrice());

        display.line(100);
        display.blankLine(1);
        System.out.println(riderEquipment.itemName+"을(를) 판매하여 "+riderEquipment.itemSellingPrice+" 은화를 얻었습니다!");
        System.out.println("현재 보유 은화는 "+this.getRiderMoney()+" 은화입니다.");
    }

    // 간식 구입창 메소드
    public boolean buyingSnackProcess(snack snack){
        // 장비 정보 보여주기
        snack.showSnack();

        // 개수 입력
        System.out.println("몇 개 구입하시겠습니까?");
        int num = selection.getNum();

        // 구매 확인
        System.out.println("정말 구입하시겠습니까?\n1. 구입한다.\n2. 구입하지 않는다.\n");
        int choice1 = selection.getchoice(2);

        // 구매
        if (choice1 == 1) {
            boolean isTrue = buyingSnack(snack, num);

            // 돈이 충분해서 구매 성공
            if (isTrue) {
                System.out.println("\n다른 물품을 구입하실래요?\n1. 구입한다.\n2. 구입하지 않는다.\n");
                int choice2 = selection.getchoice(2);

                if (choice2 == 1) {
                    display.blankLine(1);
                    return true;
                } else {
                    display.line();
                    showRiderInventory();
                    System.out.println("\n엔터 키를 누르면 상점으로 돌아갑니다.");
                    selection.pass();
                    return false;
                }

                // 돈이 부족한 경우 마루로 돌아가기
            } else {
                System.out.println("\n엔터 키를 누르면 마루로 돌아갑니다.");
                selection.pass();
                return false;
            }

            // 비구매
        } else {
            System.out.println("간식을 구입하지 않습니다. 다른 물품도 둘러보세요.\n");
            return false;
        }
    }

    // 간식 구입 메소드
    public boolean buyingSnack(snack snack, int num){

        // 구입하려는 가격 이상 돈이 있을 때
        if (this.getRiderMoney() >= (snack.itemBuyingPrice * num)){

            // 리스트에 객체가 있을 때
            if (snackInvent.contains(snack)){
                increaseSnackQuantity(snack, num);
                setRiderMoney((this.getRiderMoney() - (snack.itemBuyingPrice * num)));
                display.line(100);
                display.blankLine(1);
                System.out.println((snack.itemBuyingPrice * num)+" 은화를 사용하여 "+snack.itemName+" "+num+"개를 구입하였습니다!\n");
                System.out.println("현재 보유 은화는 "+this.getRiderMoney()+" 입니다.");
                return true;

            // 리스트에 객체가 없을 때
            } else {
                this.addSnack(snack);
                increaseSnackQuantity(snack, num);
                setRiderMoney((this.getRiderMoney() - (snack.itemBuyingPrice * num)));
                display.line(100);
                display.blankLine(1);
                System.out.println((snack.itemBuyingPrice * num)+" 은화를 사용하여 "+snack.itemName+" "+num+"개를 구입하였습니다!\n");
                System.out.println("현재 보유 은화는 "+this.getRiderMoney()+" 입니다.");
                return true;
            }

        // 돈이 부족할 때
        } else {
            display.blankLine(1);
            display.line(100);
            System.out.println("은화가 부족합니다! "+snack.itemName+"을(를) "+num+"개 구입하려면 "+(snack.itemBuyingPrice * num)+" 은화가 필요합니다.");
            System.out.println("현재 보유 은화는 "+this.getRiderMoney()+" 입니다.");
            System.out.println("\n은화가 필요하다면 박코치를 찾아가보세요.");
            display.blankLine(1);
            return false;
        }

    }

    // 간식 판매 메소드
    public void sellingSnack(snack snack, int num){
            decreaseSnackQuantity(snack, num);
            setRiderMoney(this.getRiderMoney()+snack.getItemSellingPrice()*num);
            display.line(100);
            display.blankLine(1);
            System.out.println(snack.itemName+"을(를) 판매하여 "+snack.getItemSellingPrice()*num+" 은화를 얻었습니다!");
            System.out.println("현재 보유 은화는 "+this.getRiderMoney()+" 은화입니다.");

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
    public boolean eatSnack(snack snack, int num){
        display.line();

        if (snack.getSnackType()==1) {
            if (snack.itemQuantity >= num) {
                // recoveryAmount 만큼 회복
                if (getRiderEnergy() + num * snack.getRecoveryAmount() > getLevelEnergy()) {
                    setRiderEnergy(getLevelEnergy()); // 합이 레벨 최대 체력보다 커지면 레벨 최대 체력 반환
                } else {
                    setRiderEnergy(getRiderEnergy() + num * snack.getRecoveryAmount());
                }
                System.out.println(snack.itemName + "을(를) " + num + "개 먹었습니다. 체력이 " + num * snack.getRecoveryAmount() + " 회복되었습니다.");
                rider.showRiderInfo();

                // 간식 수량 감소
                snack.itemQuantity = snack.itemQuantity - num;

                // 추가 간식 섭취
                display.blankLine(1);
                System.out.println("다른 간식을 더 드시겠어요?\n1. 먹는다.\n2. 먹지 않는다.\n");

                int choice = selection.getchoice(2);
                if (choice == 1) {
                    return true;
                } else {
                    System.out.println("엔터키를 입력하면 이전 화면으로 돌아갑니다.");
                    selection.pass();
                    return false;
                }
            } else {
                System.out.println(snack.itemName + "이 부족합니다. 아이템을 구입해주세요.");
                display.blankLine(1);
                System.out.println("다른 간식을 드시겠어요?\n1. 먹는다.\n2. 먹지 않는다.\n");

                int choice = selection.getchoice(2);
                if (choice == 1) {
                    return true;
                } else {
                    System.out.println("엔터키를 입력하면 이전 화면으로 돌아갑니다.");
                    selection.pass();
                    return false;
                }
            }
        } else {
            System.out.println(snack.itemName + "은 사람이 먹는 간식이 아니에요! 말에게 양보해요~");
            display.blankLine(1);
            System.out.println("다른 간식을 드시겠어요?\n1. 먹는다.\n2. 먹지 않는다.\n");

            int choice = selection.getchoice(2);
            if (choice == 1) {
                return true;
            } else {
                System.out.println("엔터키를 입력하면 이전 화면으로 돌아갑니다.");
                selection.pass();
                return false;
            }
        }
    }

    // 기승자가 장비를 장착하는 메소드
    public boolean mountEquipment(riderEquipment riderEquipment) {
        display.line();
            // 디버깅
            //System.out.println("입력받은 객체 riderEquipment: "+riderEquipment.itemName);

            // 아이템이 존재하는 경우
            if (getEquipmentInvent().contains(riderEquipment)) {

                // 디버깅
                // System.out.println("아이템이 존재함 / 매개변수 riderEquipment: "+riderEquipment+" / 리스트에서 객체의 index: "+getEquipmentInvent().indexOf(riderEquipment));

                // 장착 가능 레벨 확인
                if (riderEquipment.getMountableLevel() <= riderLevel) {

                    // 현재 장비 장착 여부에 따라
                    // 장착 중인 장비가 있을 때
                    if (arrayRiderMountedEquip[riderEquipment.getEquipmentType()] != null) {
                        System.out.println("현재 " + arrayRiderMountedEquip[riderEquipment.getEquipmentType()].itemName + "을(를) 착용 중입니다. 장비를 교체할까요?\n"
                                + "1.교체한다\n2.교체하지 않는다");
                        display.blankLine(1);

                        int choice = selection.getchoice(2);

                        //장비를 교체할 때
                        if (choice==1) {

                            // 기존에 장착중인 장비 객체를 인벤토리 리스트에 추가
                            addEquipment(arrayRiderMountedEquip[riderEquipment.getEquipmentType()]);

                            // 새로 장착할 장비를 인벤토리 리스트에서 제거
                            removeEquipment(riderEquipment);

                            // 새로 장착한 장비를 장비 배열에 추가
                            arrayRiderMountedEquip[riderEquipment.getEquipmentType()] = riderEquipment;

                            System.out.println(riderEquipment.itemName + "를 장착했습니다.");

                            // EquipmentType 에 따라
                            // 승마 모자: 최대 체력 증가
                            if (riderEquipment.getEquipmentType() == 0) {
                                System.out.println("최대 체력이 " + riderEquipment.getRiderStatImprovePercent() + "% 증가합니다.");
                                setLevelEnergy((int) (getLevelEnergy() * (1 + riderEquipment.getRiderStatImprovePercent() / 100)));
                            }
                            // 승마 부츠: 숙련도 증가
                            else if (riderEquipment.getEquipmentType() == 1) {
                                System.out.println("숙련도가 " + riderEquipment.getRiderStatImprovePercent() + "% 증가합니다.");
                                setRiderProficiency((int) (getRiderProficiency() * (1 + riderEquipment.getRiderStatImprovePercent() / 100)));
                            }
                            // 승마 장갑: 체력 차감율 감소
                            else {
                                System.out.println("기승 중 체력 소모량이 " + riderEquipment.getRiderStatImprovePercent() + "% 감소합니다.");

                            }

                            // 추가 장비 장착
                            display.blankLine(1);
                            System.out.println("다른 장비를 추가로 장착하시겠어요?\n1. 장착한다.\n2. 장착하지 않는다.\n");

                            int choice2 = selection.getchoice(2);
                            if(choice2 == 1){
                                return true;
                            } else {
                                return false;
                            }

                        }

                        // 장비를 교체하지 않을 때
                        else if (choice==2) {
                            display.line();
                            System.out.println("장비를 교체하지 않습니다. 인벤토리 화면으로 돌아갑니다.");
                            return false;
                        }

                    // 장착 중인 장비가 없을 때
                    } else {
                        // 새로 장착할 장비를 인벤토리 리스트에서 제거
                        removeEquipment(riderEquipment);

                        // 새로 장착한 장비를 장비 배열에 추가
                        arrayRiderMountedEquip[riderEquipment.getEquipmentType()] = riderEquipment;
                        display.line();
                        System.out.println(riderEquipment.itemName + "를 장착했습니다.");

                        // Equipment Type 에 따라
                        // 승마 모자: 최대 체력 증가
                        if (riderEquipment.getEquipmentType() == 0) {
                            System.out.println("최대 체력이 " + riderEquipment.getRiderStatImprovePercent() + "% 증가합니다.");
                            setLevelEnergy((int) (getLevelEnergy() * (1 + riderEquipment.getRiderStatImprovePercent() / 100)));
                        }
                        // 승마 부츠: 숙련도 증가
                        else if (riderEquipment.getEquipmentType() == 1) {
                            System.out.println("숙련도가 " + riderEquipment.getRiderStatImprovePercent() + "% 증가합니다.");
                            setRiderProficiency((int) (getRiderProficiency() * (1 + riderEquipment.getRiderStatImprovePercent() / 100)));
                        }
                        // 승마 장갑: 체력 차감율 감소
                        else {
                            System.out.println("기승 중 체력 소모량이 " + riderEquipment.getRiderStatImprovePercent() + "% 감소합니다.");
                        }

                        // 추가 장비 장착
                        display.blankLine(1);
                        System.out.println("다른 장비를 장착하시겠어요?\n1. 장착한다.\n2. 장착하지 않는다.");
                        int choice2 = selection.getchoice(2);
                        if(choice2 == 1){
                            return true;
                        } else {
                            System.out.println("엔터키를 입력하면 인벤토리 화면으로 돌아갑니다.");
                            selection.pass();
                            display.blankLine(1);
                            return false;
                        }
                    }

                } else {
                    System.out.println("레벨이 낮아 " + riderEquipment.itemName + "을 장착할 수 없습니다. 장착 가능 레벨은 " + riderEquipment.getMountableLevel() + " 입니다.");

                    // 다른 장비 장착
                    display.blankLine(1);
                    System.out.println("다른 장비를 장착하시겠어요?\n1. 장착한다.\n2. 장착하지 않는다.");
                    int choice2 = selection.getchoice(2);
                    if(choice2 == 1){
                        return true;
                    } else {
                        System.out.println("엔터키를 입력하면 인벤토리 화면으로 돌아갑니다.");
                        selection.pass();
                        display.blankLine(1);
                        return false;
                    }
                }

            // 아이템을 보유하지 않은 경우
            } else {
            System.out.println(riderEquipment.itemName + "을(를) 보유하고 있지 않습니다.");
            display.blankLine(1);
            showEquipmentInvent();
            System.out.println("다시 입력하시갰습니까?\n1. 네\n2. 아니오\n");
            int choice3 = selection.getchoice(2);

            if (choice3==1) {
                return true;
            } else {
                System.out.println("엔터키를 입력하면 인벤토리 화면으로 돌아갑니다.");
                selection.pass();
                display.blankLine(1);
                return false;
            }
        }
        display.blankLine(1);
        return false;
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


