import java.util.ArrayList;

public class horse {
    private String horseName; // 말 이름
    private int horseIntimacy; // 말 친밀도
    private int horseBounceStrength; // 말 반동강도
    private int horseMaxSpeed; // 말 최대 속도

    // getter setter
    public String getHorseName() {
        return horseName;
    }

    public void setHorseName(String horseName) {
        this.horseName = horseName;
    }

    public int getHorseIntimacy() {
        return horseIntimacy;
    }

    public void setHorseIntimacy(int horseIntimacy) {
        this.horseIntimacy = horseIntimacy;
    }

    public int getHorseBounceStrength() {
        return horseBounceStrength;
    }

    public void setHorseBounceStrength(int horseBounceStrength) {
        this.horseBounceStrength = horseBounceStrength;
    }

    public int getHorseMaxSpeed() {
        return horseMaxSpeed;
    }

    public void setHorseMaxSpeed(int horseMaxSpeed) {
        this.horseMaxSpeed = horseMaxSpeed;
    }



    // 생성자
    horse(String horseName, int horseIntimacy, int horseBounceStrength, int horseMaxSpeed){
        this.horseName = horseName;
        this.horseIntimacy = horseIntimacy;
        this.horseBounceStrength = horseBounceStrength;
        this.horseMaxSpeed = horseMaxSpeed;
    }

    // 말 정보 보여주는 메소드
    void showHorseInfo(){
        display.boxUpper(20);
        System.out.println("  말 정보");
        System.out.println("  이름: "+getHorseName());
        System.out.println("  친밀도: "+getHorseIntimacy());
        System.out.println("  반동 강도: "+getHorseBounceStrength());
        System.out.println("  최대 속도: "+getHorseMaxSpeed());
        display.boxLower(20);
    }

    // 간식 주기
    void feedHorse(snack snack){
        setHorseIntimacy(getHorseIntimacy() + snack.getRecoveryAmount());
        snack.itemQuantity -= 1;

        music eatingSnack = new music("soundeffect","먹는소리",false);
        eatingSnack.start();
        System.out.println(getHorseName()+"이가 "+snack.itemName+"을(를) 먹었습니다.");
        System.out.println("친밀도가 "+snack.getRecoveryAmount()+" 증가했습니다.");
    }
}
