import java.util.Scanner;
/*
한 모서리의 각도가 36도로 고정된 별 모양 만들기
별이 외접하는 원의 반지름을 입력받고, 그에 따라 크기가 다른 별 프린트
 */
public class star_degfixed {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double r = 0; //별이 외접하는 원의 반지름
        double pi = Math.PI;

        // 길이 입력 받기
        System.out.println("\n원하는 크기의 별을 그릴 수 있습니다.");
        System.out.println("별의 중심에서 꼭짓점까지 길이를 자연수로 입력해주세요. 크기가 클수록 예쁜 별이 그려집니다. (ex. 30)\n");
        r = input.nextInt();


        // 반지름 30보다 작을 때
        if (r<30) {
            // 속이 찬 별 - 1번 파트
            for (double i = 0; i < r * (1 - Math.cos(pi * 0.4)); i++) {
                for (int j = 0; j < (r - i * Math.tan(0.1 * pi)); j++) {
                    System.out.print("  ");
                }
                for (int j = 0; j <= (2 * i * Math.tan(0.1 * pi)); j++) {
                    System.out.print("* ");
                }
                for (int j = 0; j < (r - i * Math.tan(0.1 * pi)); j++) {
                    System.out.print("  ");
                }
                // System.out.print(i);
                System.out.println("");
            }

            //속이 찬 벌 - 2번 파트
            for (double i = 0; i < (r * (1 - Math.cos(pi * 0.4)) * 0.61); i++) {
                for (int j = 0; j < (i / Math.tan(pi * 0.2) + r * (1 - Math.sin(pi * 0.4))); j++) {
                    System.out.print("  ");
                }
                for (int j = 0; j <= (2 * (r * Math.sin(0.4 * pi) - i / Math.tan(pi * 0.2))); j++) {
                    System.out.print("* ");
                }
                for (int j = 0; j < (i / Math.tan(pi * 0.2) + r * (1 - Math.sin(pi * 0.4))); j++) {
                    System.out.print("  ");
                }
                // System.out.print(i);
                System.out.println("");
            }

            //속이 찬 벌 - 3번 파트
            for (double i = r * (1 - Math.cos(pi * 0.4)) * 1.61; i < (r * (1 - Math.cos(pi * 0.4)) * 2); i++) {
                for (int j = 0; j < (r - i * Math.tan(0.1 * pi)); j++) {
                    System.out.print("  ");
                }
                for (int j = 0; j <= (2 * i * Math.tan(0.1 * pi)); j++) {
                    System.out.print("* ");
                }
                for (int j = 0; j < (r - i * Math.tan(0.1 * pi)); j++) {
                    System.out.print("  ");
                }
                // System.out.print(i);
                System.out.println("");
            }

            //속이 찬 별 - 4번 파트
            for (double i = r * (1 - Math.cos(pi * 0.4)) * 2; i < (r * (1 - Math.cos(pi * 0.4)) * 2.65); i++) {
                double I = i - r * (1 - Math.cos(pi * 0.4)) * 2;
                for (int j = 0; j < (r - i * Math.tan(0.1 * pi)); j++) {
                    System.out.print("  ");
                }
                for (int j = 0; j <= (i * Math.tan(0.1 * pi) - I * Math.tan(0.3 * pi)); j++) {
                    System.out.print("* ");
                }
                for (int j = 0; j <= (I * Math.tan(0.3 * pi)) * 2; j++) { // 모양 위해서 값 조정
                    System.out.print("  ");
                }
                for (int j = 0; j <= (i * Math.tan(0.1 * pi) - I * Math.tan(0.3 * pi)); j++) {
                    System.out.print("* ");
                }
                for (int j = 0; j < (r - i * Math.tan(0.1 * pi)); j++) {
                    System.out.print("  ");
                }
                System.out.println("");

            }
        } else {
            // 속이 찬 별 - 1번 파트
            for (double i = 0; i < r * (1 - Math.cos(pi * 0.4)); i++) {
                for (int j = 0; j < (r - i * Math.tan(0.1 * pi)); j++) {
                    System.out.print("  ");
                }
                for (int j = 0; j <= (2 * i * Math.tan(0.1 * pi)); j++) {
                    System.out.print("* ");
                }
                for (int j = 0; j < (r - i * Math.tan(0.1 * pi)); j++) {
                    System.out.print("  ");
                }
                // System.out.print(i);
                System.out.println("");
            }

        /*속이 찬 별 - 선
        for (double i = 0; i<r*(1-Math.sin(pi*0.4)); i++) {
            System.out.print("  ");
        }
        for (double i = 0; i<= (r*2*Math.sin(pi*0.4)); i++) {
            System.out.print(" *");
        }
        System.out.println("");
*/

            //속이 찬 벌 - 2번 파트
            for (double i = 0; i < (r * (1 - Math.cos(pi * 0.4)) * 0.61); i++) {
                for (int j = 0; j < (i / Math.tan(pi * 0.2) + r * (1 - Math.sin(pi * 0.4))); j++) {
                    System.out.print("  ");
                }
                for (int j = 0; j <= (2 * (r * Math.sin(0.4 * pi) - i / Math.tan(pi * 0.2))); j++) {
                    System.out.print("* ");
                }
                for (int j = 0; j < (i / Math.tan(pi * 0.2) + r * (1 - Math.sin(pi * 0.4))); j++) {
                    System.out.print("  ");
                }
                // System.out.print(i);
                System.out.println("");
            }

            //속이 찬 벌 - 3번 파트
            for (double i = r * (1 - Math.cos(pi * 0.4)) * 1.61; i < (r * (1 - Math.cos(pi * 0.4)) * 2); i++) {
                for (int j = 0; j < (r - i * Math.tan(0.1 * pi)); j++) {
                    System.out.print("  ");
                }
                for (int j = 0; j <= (2 * i * Math.tan(0.1 * pi)); j++) {
                    System.out.print("* ");
                }
                for (int j = 0; j < (r - i * Math.tan(0.1 * pi)); j++) {
                    System.out.print("  ");
                }
                // System.out.print(i);
                System.out.println("");
            }

            //속이 찬 별 - 4번 파트
            for (double i = r * (1 - Math.cos(pi * 0.4)) * 2; i < (r * (1 - Math.cos(pi * 0.4)) * 2.65); i++) {
                double I = i - r * (1 - Math.cos(pi * 0.4)) * 2;
                for (int j = 0; j < (r - i * Math.tan(0.1 * pi)); j++) {
                    System.out.print("  ");
                }
                for (int j = 0; j <= (i * Math.tan(0.1 * pi) - I * Math.tan(0.3 * pi)); j++) {
                    System.out.print("* ");
                }
                for (int j = 0; j <= ((int) (I * Math.tan(0.3 * pi))) * 2; j++) { // 모양 위해서 값 조정
                    System.out.print("  ");
                }
                for (int j = 0; j <= (i * Math.tan(0.1 * pi) - I * Math.tan(0.3 * pi)); j++) {
                    System.out.print("* ");
                }
                for (int j = 0; j < (r - i * Math.tan(0.1 * pi)); j++) {
                    System.out.print("  ");
                }
                System.out.println("");
            }
        }
    }
}
