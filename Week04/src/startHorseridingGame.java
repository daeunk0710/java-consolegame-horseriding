/*
승마 게임
접속시 메인 화면
*/

import java.util.Scanner;

public class startHorseridingGame {
    public static void main (String[] args){
        display display = new display();
        display.logo100();
        display.boxUpper();

        display.boxMid();

        System.out.println(
                        "┃                   승마의 세계에 오신 것을 환영합니다! 말과 함께 성장하여 마왕에 도전하세요                 ┃\n"+
                        "┃                                                                                                  ┃\n"+
                        "┃                                     1. 새로운 게임 시작하기                                         ┃\n"+
                        "┃                                      2. 이전 게임 불러오기                                          ┃\n"+
                        "┃                                      (숫자로 입력해주세요)                                          ┃"
        );

        display.boxMid();
        display.boxLower();

        Scanner sc = new Scanner(System.in);
        while(true) {
            String choice = sc.nextLine();
            if (choice.equals("1")) {
                newRider r = new newRider();
                r.createRider();
            } else if (choice.equals("2")) {

            } else {
                System.out.println("잘못된 입력입니다. 선택지에 있는 숫자를 입력해주세요.");
            }
        }
    }
}
