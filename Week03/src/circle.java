import java.util.Scanner;
/*
원 그리기
원의 반지름을 입력받고, 그에 따라 크기가 다른 원 출력
 */
public class circle {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double r = 0; //원의 반지름

        System.out.println("\n원하는 크기의 원을 그릴 수 있습니다.");
        System.out.println("원의 반지름을 자연수로 입력해주세요. (ex. 30)\n");
        r = input.nextInt();

        // 1. 피타고라스 정리 이용
        System.out.println("피타고라스 정리 이용\n");
        // 속이 찬 원 - 원 윗부분 (엎어놓은 그릇 모양 반원)
        for (double i = 0; i < r; i++) {
            double i1 = Math.sqrt(2 * r * i - i *i);
            for (int j = 0; j <(r-i1); j++) {
                System.out.print("  ");
            }
            for (int j = 0; j <=(2*i1); j++) {
                System.out.print("* ");
            }
            for (int j = 0; j <(r-i1); j++) {
                System.out.print("  ");
            }
            System.out.println("");
        }

        // 속이 찬 원 - 원 아랫부분 (그릇 모양 반원)
        for (double i = r; i >= 0; i--) {
            double i1 = Math.sqrt(2 * r * i - i *i);
            for (int j = 0; j <(r-i1); j++) {
                System.out.print("  ");
            }
            for (int j = 0; j <=(2*i1); j++) {
                System.out.print("* ");
            }
            for (int j = 0; j <(r-i1); j++) {
                System.out.print("  ");
            }
            System.out.println("");
        }

        System.out.print("\n\n");

        /*
        // 속이 빈 원 - 원 윗부분 (엎어놓은 그릇 모양 반원)
        for (double i = 0; i < r; i++) {
            double i1 = Math.sqrt(2 * r * i - i *i);
            for (int j = 0; j <(r-i1); j++) {
                System.out.print("  ");
            }
            System.out.print(" *");
            for (int j = 0; j <=(2*i1); j++) {
                System.out.print("  ");
            }
            System.out.print(" *");
            for (int j = 0; j <(r-i1); j++) {
                System.out.print("  ");
            }
            System.out.println("");
        }

        // 속이 빈 원 - 원 아랫부분 (그릇 모양 반원)
        for (double i = r; i >= 0; i--) {
            double i1 = Math.sqrt(2 * r * i - i *i);
            for (int j = 0; j <(r-i1); j++) {
                System.out.print("  ");
            }
            System.out.print(" *");
            for (int j = 0; j <=(2*i1); j++) {
                System.out.print("  ");
            }
            System.out.print("* ");
            for (int j = 0; j <(r-i1); j++) {
                System.out.print("  ");
            }
            System.out.println("");
        }

         */

        // 2. 원의 방정식 이용
        System.out.println("원의 방정식 이용\n");
        for (double i = 0; i <= 2*r; i++) {
            for (double j = 0; j <= 2 * r; j++) {
                if (((i - r) * (i-r) + (j - r) * (j-r)) <= r * r) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
    }
}

