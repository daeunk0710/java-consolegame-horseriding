public class horse {
    String horseName;
    int horseIntimacy;
    int horseBounceStrength;
    int horseMaxSpeed;

    public horse(String horseName, int horseIntimacy, int horseBounceStrength, int horseMaxSpeed){
        this.horseName = horseName;
        this.horseIntimacy = horseIntimacy;
        this.horseBounceStrength = horseBounceStrength;
        this.horseMaxSpeed = horseMaxSpeed;
    }

    void showHorseInfo(){
        display.boxUpper(20);
        System.out.println("  말 정보");
        System.out.println("  이름: "+horseName);
        System.out.println("  친밀도: "+horseIntimacy);
        System.out.println("  반동 강도: "+horseBounceStrength);
        System.out.println("  최대 속도: "+horseMaxSpeed);
        display.boxLower(20);
    }
}
