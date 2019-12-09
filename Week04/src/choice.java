/*
선택지를 보여주고 유저에게 선택값을 입력받는 클래스
 */
import java.util.Scanner;

public class choice {
    Scanner sc = new Scanner(System.in);

    public void receiveChoice(int n){
        while(true) {
            String choice = sc.nextLine();
            if (choice.equals("1")) {
                newRider rider1 = new newRider();
                rider1.createRider();
            } else if (choice.equals("2")) {
                if (n<2) {
                    System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                }
            } else if (choice.equals("3")) {
                if (n<3) {
                    System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                }
            } else if (choice.equals("4")) {
                if (n<4) {
                    System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                }
            } else if (choice.equals("5")) {
                if (n<5) {
                    System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                }
            } else {
                System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
            }
        }
    }
}
