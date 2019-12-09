public class item {
    String itemName;
    int itemQuantity;
    int itemSellingPrice; // 아이템 판매시 가격
    int itemBuyingPrice; // 아이템 구매시 가격

    // 아이템 생성
    void add(){
        this.itemQuantity++;
    }

    // 아이템 제거
    void remove(){
        this.itemQuantity--;
    }

    String getItemName() {
        return itemName;
    }

    public int getItemBuyingPrice() {
        return itemBuyingPrice;
    }

    public int getItemSellingPrice() {
        return itemSellingPrice;
    }

    int getItemQuantity() {
        return itemQuantity;
    }

}

class riderEquipment extends item {
    private int equipmentType; // 0: 승마 모자, 1: 승마 부츠, 2: 승마 장갑
    private int riderStatImprovePercent; // 승마 장비는 해당하는 속성을 특정 퍼센트 개선시킴
    // 승마 모자 - 최대 체력 증가, 승마 부츠 - 숙련도 증가, 승마 장갑 - 기승 중 체력 차감율 감소
    private int mountableLevel; // 장착 가능 레벨 조건

    riderEquipment(String itemName, int equipmentType, int mountableLevel, int riderStatImprovePercent, int itemBuyingPrice, int itemSellingPrice){
        this.itemName = itemName;
        this.equipmentType = equipmentType;
        this.mountableLevel = mountableLevel;
        this.riderStatImprovePercent = riderStatImprovePercent;
        this.itemBuyingPrice = itemBuyingPrice;
        this.itemSellingPrice = itemSellingPrice;
        this.itemQuantity = 1;
    }

    public int getEquipmentType() {
        return equipmentType;
    }

    public int getMountableLevel() {
        return mountableLevel;
    }

    public int getRiderStatImprovePercent() {
        return riderStatImprovePercent;
    }

    void showRiderEquipment(){
        int width = 50;
        display.boxUpper(width);
        display.title(this.itemName, (int) (width*0.8));
        display.blankLine(1);

        // 장비 설명 - 승마 모자
         if (this.getEquipmentType() == 0){
             System.out.println("  장비 타입: 승마 모자\n  기능: 징착 시 최대 체력이 "
                     +this.getRiderStatImprovePercent()+"% 증가합니다.\n  착용 가능 레벨: "+this.getMountableLevel()+
                     "\n  가격: "+this.itemBuyingPrice+" 은화");

         // 장비 설명 - 승마 부츠
         } else if (this.getEquipmentType() == 1) {
             System.out.println("  장비 타입: 승마 부츠\n  기능: 징착 시 숙련도가 "
                     +this.getRiderStatImprovePercent()+"% 증가합니다.\n  착용 가능 레벨: "+this.getMountableLevel()+
                     "\n  가격: "+this.itemBuyingPrice+" 은화");

         // 장비 설명 - 승마 장갑
         } else if (this.getEquipmentType() == 2) {
             System.out.println("  장비 타입: 승마 장갑\n  기능: 징착 시 기승 중 체력 차감율이 "
                     +this.getRiderStatImprovePercent()+"% 감소합니다.\n  착용 가능 레벨: "+this.getMountableLevel()+
                     "\n  가격: "+this.itemBuyingPrice+" 은화");
         } else {

         }
         display.boxLower(50);
         display.blankLine(1);

    }
}


class snack extends item {
    private int snackType; // 0: 말 간식, 1: 사람 간식
    private int recoveryAmount; // 말: 친밀도 증가 값, 사람: 체력 회복 값

    snack(String itemName, int snackType, int recoveryAmount, int itemBuyingPrice, int itemSellingPrice){
        this.itemName = itemName;
        this.snackType = snackType;
        this.recoveryAmount = recoveryAmount;
        this.itemBuyingPrice = itemBuyingPrice;
        this.itemSellingPrice = itemSellingPrice;
        this.itemQuantity = 0;
    }

    public int getSnackType() {
        return snackType;
    }

    public int getRecoveryAmount() {
        return recoveryAmount;
    }

    void showSnack() {
        int width = 30;
        display.boxUpper(30);
        display.title(this.itemName, width);
        display.blankLine(1);

        // 간식 설명 - 말 간식
        if (this.getSnackType() == 0) {
            System.out.println("  간식 타입: 말 간식\n  기능: 말 친밀도 " + this.getRecoveryAmount() + " 증가" +
                    "\n  가격: " + this.itemBuyingPrice + " 은화");

            // 간식 설명 - 사람 간식
        } else if (this.getSnackType() == 1) {
            System.out.println("  간식 타입: 사람 간식\n  기능: 사용 시 체력 " + this.getRecoveryAmount() + " 회복" +
                    "\n  가격: " + this.itemBuyingPrice + " 은화");
        }
        display.boxLower(30);
        display.blankLine(1);
    }
}