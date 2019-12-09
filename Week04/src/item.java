public class item {
    String itemName;
    int itemQuantity;
    int itemPrice;

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

    public int getItemPrice() {
        return itemPrice;
    }

    int getItemQuantity() {
        return itemQuantity;
    }

}

class riderEquipment extends item {
    public boolean mountable;
    private int equipmentType; // 0: 승마 모자, 1: 승마 부츠, 2: 승마 장갑
    private int mountableLevel; // 장착 가능 레벨
    private int riderStatImprovePercent; // 승마 장비는 해당하는 속성을 특정 퍼센트 개선시킴
                                        // 승마 모자 - 최대 체력 증가, 승마 부츠 - 숙련도 증가, 승마 장갑 - 기승 중 체력 차감율 감소


    riderEquipment(String itemName, int equipmentType, int mountableLevel, int riderStatImprovePercent, int itemPrice){
        this.itemName = itemName;
        this.equipmentType = equipmentType;
        this.mountableLevel = mountableLevel;
        this.riderStatImprovePercent = riderStatImprovePercent;
        this.itemPrice = itemPrice;
        this.itemQuantity = 0;
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
}


class snack extends item {
    public boolean eatable;
    private int snackType; // 0: 말 간식, 1: 사람 간식
    private int recoveryAmount; // 말: 친밀도 증가 값, 사람: 체력 회복 값

    snack(String itemName, int snackType, int recoveryAmount, int itemPrice){
        this.itemName = itemName;
        this.snackType = snackType;
        this.recoveryAmount = recoveryAmount;
        this.itemPrice = itemPrice;
        this.itemQuantity = 0;
    }

    public int getSnackType() {
        return snackType;
    }

    public int getRecoveryAmount() {
        return recoveryAmount;
    }
}