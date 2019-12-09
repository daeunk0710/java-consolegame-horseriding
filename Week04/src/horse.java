/*
말 객체를 생성하는 클래스
 */

public class horse {
    display display = new display();
    String horseName;
    int horseIntimacy;
    int horseBounceStrength;
    int horseMaxSpeed;

    public horse(){

    }

    // 말 클래스 생성자: 이름, 친밀도, 반동 강도, 최대 속도
    horse(String horseName, int horseIntimacy, int horseBounceStrength, int horseMaxSpeed) {
        this.horseName = horseName;
        this.horseIntimacy = horseIntimacy;
        this.horseBounceStrength = horseBounceStrength;
        this.horseMaxSpeed = horseMaxSpeed;
    }

    void showHorseInfo(){
        display.boxUpper();
        System.out.println("말 정보");
        System.out.println("말 이름: ");
    }
}
