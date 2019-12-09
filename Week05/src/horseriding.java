import java.util.ArrayList;
import java.util.Scanner;

public class horseriding {
    private int oneRidePrice = 5;

    public int getOneRidePrice() {
        return oneRidePrice;
    }

    public void setOneRidePrice(int oneRidePrice) {
        this.oneRidePrice = oneRidePrice;
    }
    // rider rider = new rider();

    // 말 객체 담는 어레이리스트 생성
    private ArrayList<horse> horses = new ArrayList<horse>();

    public ArrayList<horse> getHorses() {
        return horses;
    }

    public void setHorses(ArrayList<horse> horses) {
        this.horses = horses;
    }

    // 리스트에 말 객체 추가
    void addHorse(horse horse){
        this.horses.add(horse);

    }


    // 보유 마필 보여주는 메소드
    void showHorses(){
        display.boxUpper(20);
        display.title("마 필",20);
        String horseList = "\n";
        for (horse horse: this.horses){
            int index =this.horses.indexOf(horse)+1;
            horseList+= "  "+index+". "+horse.getHorseName()+"\n";}
        System.out.println(horseList);
        display.boxLower(20);
    }

    // 마필 선택지 메소드
    void chooseHorseView(){
        display.boxUpper(40);
        display.title("마 필 선 택",40);
        String horseList = "\n";
        for (horse horse: this.horses){
            int index =this.horses.indexOf(horse)+1;
            horseList+= "  "+index+". "+horse.getHorseName()+"\n";}
        System.out.print(horseList);
        System.out.print("  "+(horses.size()+1)+". 사장님께 추천을 부탁드린다.\n");
        display.boxLower(40);
    }

}
