/*
선택지를 입력받는 클래스
예외처리하여 선택지에 없는 값 입력시 반복
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class selection {
    static void pass(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
    }

    // 문자열 입력받는 메소드
    static String textinput() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();
            return input;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    // A 부터 F 까지 알파벳만 입력받는 메소드
    static String getAtoF() {
        try {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            if (input.equals("A") || input.equals("B") || input.equals("C") || input.equals("D") || input.equals("E") || input.equals("F")) {
                return input;
            } else {
                return repeatAtoF();
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    // 잘못 입력시 재입력
    static String repeatAtoF() {
        try {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            if (input.equals("A") || input.equals("B") || input.equals("C") || input.equals("D") || input.equals("E") || input.equals("F")) {
                return input;
            } else {
                return repeatAtoF();
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
    }
        return null;
    }

    // 1부터 num 까지 선택지 입력받는 메소드
    static int getchoice(int num) {
        try {
            System.out.println("원하는 선택지의 번호를 숫자로 입력해주세요. ex) 1");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String[] choices = new String[num];
            for (int i = 0; i < num; i++) {
                choices[i] = Integer.toString(i+1);
            }

            // choices 배열 출력
            // System.out.println("getchoice choices[]: "+Arrays.toString(choices));

            String choice = br.readLine();

            // choice 출력
            // System.out.println("getchoice choice: "+choice);

            if (Arrays.asList(choices).contains(choice)) {
                // return choice 출력
                // System.out.println("getchoice return choice: "+Integer.parseInt(choice));
                return Integer.parseInt(choice);
            } else {
                // return choice 로
                // System.out.println("getchoice to repeatchoice");
                return repeatchoice(num);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 10;
    }

    // 잘못 입력시 재입력
    static int repeatchoice(int num) {
        try {
            System.out.println("\n잘못된 입력입니다. 다시 입력해주세요.");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String[] choices = new String[num];
            for (int i = 0; i < num; i++) {
                choices[i] = Integer.toString(i+1);
            }

            // choices 배열 출력
            // System.out.println("repeatchoice choices[]: "+Arrays.toString(choices));

            String choice = br.readLine();

            // choice 출력
            // System.out.println("repeatchoice choice: "+choice);

            if (Arrays.asList(choices).contains(choice)) {
                // return choice 출력
                // System.out.println("repeatchoice return choice: "+Integer.parseInt(choice));
                return Integer.parseInt(choice);
            } else {
                // System.out.println("repeatchoice");
                return repeatchoice(num);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 20;
    }

    // 0. 돌아가기 선택지 포함하여 1부터 num 까지 선택받는 메소드
    static int getchoice0(int num) {
        try {
            System.out.println("원하는 선택지의 번호를 숫자로 입력해주세요. ex) 1\n* 0. 돌아가기");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String[] choices = new String[num+1];
            for (int i = 0; i <= num; i++) {
                choices[i] = Integer.toString(i);
            }

            // choices 배열 출력
            // System.out.println("getchoice choices[]: "+Arrays.toString(choices));

            String choice = br.readLine();

            // choice 출력
            // System.out.println("getchoice choice: "+choice);

            if (Arrays.asList(choices).contains(choice)) {
                // return choice 출력
                // System.out.println("getchoice return choice: "+Integer.parseInt(choice));
                return Integer.parseInt(choice);
            } else {
                // return choice 로
                // System.out.println("getchoice to repeatchoice");
                return repeatchoice0(num);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 10;
    }

    static int repeatchoice0(int num) {
        try {
            System.out.println("\n잘못된 입력입니다. 다시 입력해주세요.");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String[] choices = new String[num+1];
            for (int i = 0; i <= num; i++) {
                choices[i] = Integer.toString(i);
            }

            // choices 배열 출력
            // System.out.println("repeatchoice choices[]: "+Arrays.toString(choices));

            String choice = br.readLine();

            // choice 출력
            // System.out.println("repeatchoice choice: "+choice);

            if (Arrays.asList(choices).contains(choice)) {
                // return choice 출력
                // System.out.println("repeatchoice return choice: "+Integer.parseInt(choice));
                return Integer.parseInt(choice);
            } else {
                // System.out.println("repeatchoice");
                return repeatchoice0(num);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 20;
    }

    static int getNum(){
        try {
            System.out.println("원하는 수량을 자연수로 입력해주세요. ex) 5");
            Scanner sc = new Scanner(System.in);

            int num = sc.nextInt();

            if (num>0){
                return num;
            } else {
                return repeatNum();
            }

        } catch (Exception e){
            return repeatNum();
        }
    }

    static int repeatNum(){
        try {
            System.out.println("잘못된 입력입니다. 자연수로 입력해주세요. ex) 5");
            Scanner sc = new Scanner(System.in);

            int num = sc.nextInt();

            if (num>0){
                return num;
            } else {
                return repeatNum();
            }

        } catch (Exception e){
            return repeatNum();
        }
    }
    /* public static void main(String[] args){
        getchoice(5);
    }

     */
}


