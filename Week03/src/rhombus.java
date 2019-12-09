import java.util.Scanner;
/*
마름모 그리기
마름모의 가로 세로 길이를 입력받고,
그에 따라 크기가 다른 마름모와 마름모의 한 변의 길이 출력
 */
public class rhombus {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double h = 0; //공간 높이
        double w = 0; //공간 너비
        double l = 0; //마름모 한 변의 길이

        System.out.println("\n가로, 세로 크기를 지정해주면 그에 맞는 마름모가 그려집니다.");
        System.out.println("마름모를 그릴 공간의 가로 너비를 자연수로 입력해주세요. (ex. 100)");
        w = input.nextInt();
        System.out.println("마름모를 그릴 공간의 세로 폭를 자연수로 입력해주세요. (ex. 50)");
        h = input.nextInt();

        l = Math.sqrt((w/2)*(w/2)+(h/2)*(h/2));

        // 속이 찬 마름모
        for (double i = 0; i < (h / 2); i++) {
            for (int j = 0; j < (w / 2 - w * i / h); j++) {
                System.out.print("  ");
            }
            for (int j = 0; j <= (2 * w * i / h); j++) {
                System.out.print("* ");
            }
            for (int j = 0; j < (w / 2 - w * i / h); j++) {
                System.out.print("  ");
            }
            System.out.println("");
        }
        for (double i = (h / 2); i >= 0; i--) {
            for (int j = 0; j < (w / 2 - w * i / h); j++) {
                System.out.print("  ");
            }
            for (int j = 0; j <= (2 * w * i / h); j++) {
                System.out.print("* ");
            }
            for (int j = 0; j < (w / 2 - w * i / h); j++) {
                System.out.print("  ");
            }
            System.out.println("");
        }

        System.out.print("\n");

        /*
        // 속이 빈 마름모
        for (double i = 0; i < (h / 2); i++) {
            for (int j = 0; j < (w / 2 - w * i / h); j++) {
                System.out.print("  ");
            }
            System.out.print("* ");
            for (int j = 0; j <= (2 * w * i / h); j++) {
                System.out.print("  ");
            }
            System.out.print("* ");
            for (int j = 0; j < (w / 2 - w * i / h); j++) {
                System.out.print("  ");
            }
            System.out.println("");
        }
        for (double i = (h / 2); i >= 0; i--) {
            for (int j = 0; j < (w / 2 - w * i / h); j++) {
                System.out.print("  ");
            }
            System.out.print("* ");
            for (int j = 0; j <= (2 * w * i / h); j++) {
                System.out.print("  ");
            }
            System.out.print("* ");
            for (int j = 0; j < (w / 2 - w * i / h); j++) {
                System.out.print("  ");
            }
            System.out.println("");
        }

         */
        System.out.println("\n마름모 한 변의 길이는 "+Math.round(l)+"입니다.");
    }
}
