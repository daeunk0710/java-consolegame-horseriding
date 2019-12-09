import java.util.Scanner;

public class star {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        double r = 0; //별이 외접하는 원의 반지름
        double deg = 0; //각 모서리의 각도(degree)
        double rad = 0; //각 모서리의 각도(radian). rad = d/180*pi
        double pi = Math.PI;

        //입력 받기
        System.out.println("\n원하는 크기와 모양의 별을 그릴 수 있습니다.");
        System.out.println("별의 중심에서 꼭짓점까지 길이를 자연수로 입력해주세요. (ex. 30)\n");
        r = input.nextInt();
        System.out.println("각 모서리의 각도를 자연수로 입력해주세요(0도에서 108도 사이). (ex. 60)\n");
        deg = input.nextInt();
        rad = deg/180*pi;

        // 속이 찬 별 - 1번 파트
        //System.out.println(r);
        //System.out.println(rad);
        //System.out.println(r*(Math.sin(0.2*pi)*Math.cos(rad*0.5)/Math.sin(0.8*pi-rad*0.5)));
        for (double i = 0; i < r*(Math.sin(0.2*pi)*Math.cos(rad*0.5)/Math.sin(0.8*pi-rad*0.5)); i++) {
            for (double j = 0; j <(r-i*Math.tan(rad*0.5)); j++) {
                System.out.print(" ");
            }
            for (double j = 0; j <=(2*i*Math.tan(rad*0.5)); j++) {
                System.out.print("*");
            }
            System.out.println("");
        }

        // 속이 찬 별 - 2번 파트
        for (double i = r*(Math.sin(0.2*pi)*Math.cos(rad*0.5)/Math.sin(0.8*pi-rad*0.5)); i< r*(1-Math.sin(pi*0.1));i++){
            for (double j = 0; j <(r-i*Math.tan(rad*0.5)); j++) {
                System.out.print(" ");
            }
            for (double j = 0; j <=(2*i*Math.tan(rad*0.5)); j++) {
                System.out.print("*");
            }
            System.out.println("");

            System.out.print("*");
        }
        /*
        // 속이 찬 별 - 3번 파트
        for (double i = r*(1-Math.cos(pi*0.4)); i >= 0; i--) {
            double i1 = Math.sqrt(2 * r * i - i *i);
            for (int j = 0; j <(r-i1); j++) {
                System.out.print("  ");
            }
            for (int j = 0; j <=(2*i1); j++) {
                System.out.print(" *");
            }
            for (int j = 0; j <(r-i1); j++) {
                System.out.print("  ");
            }
            System.out.println("");
        }

        // 속이 찬 별 - 4번 파트
        for (double i = r; i >= 0; i--) {
            double i1 = Math.sqrt(2 * r * i - i *i);
            for (int j = 0; j <(r-i1); j++) {
                System.out.print("  ");
            }
            for (int j = 0; j <=(2*i1); j++) {
                System.out.print(" *");
            }
            for (int j = 0; j <(r-i1); j++) {
                System.out.print("  ");
            }
            System.out.println("");
        }

        // 속이 찬 별 - 5번 파트
        for (double i = r; i >= 0; i--) {
            double i1 = Math.sqrt(2 * r * i - i *i);
            for (int j = 0; j <(r-i1); j++) {
                System.out.print("  ");
            }
            for (int j = 0; j <=(2*i1); j++) {
                System.out.print(" *");
            }
            for (int j = 0; j <(r-i1); j++) {
                System.out.print("  ");
            }
            System.out.println("");
        }
        System.out.print("\n\n");
         */
    }
}
