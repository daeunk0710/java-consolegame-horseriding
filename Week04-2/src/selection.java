/*
선택지를 입력받는 클래스
예외처리하여 선택지에 없는 값 입력시 반복
 */
import java.util.Scanner;

public class selection {
    static void pass(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
    }

    static String textinput(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        return input;
    }

    static String getAtoF(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.equals("A")||input.equals("B")||input.equals("C")||input.equals("D")||input.equals("E")||input.equals("F")){
            return input;
        } else {
            repeatAtoF();
        }
        return "";
    }

    static String repeatAtoF(){
        System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.equals("A")||input.equals("B")||input.equals("C")||input.equals("D")||input.equals("E")||input.equals("F")){
            return input;
        } else {
            repeatAtoF();
        }
        return "";
    }

    public static String getchoice(int num){
        System.out.println("원하는 선택지의 번호를 숫자로 입력해주세요. ex) 1");
        Scanner sc = new Scanner(System.in);

        String numselection = "";
        for(int i =1; i<=num; i++){
            numselection = numselection+i+"    ";
        }

        String choice = sc.nextLine();

        if (choice.isBlank()||choice.isEmpty()) {
            repeatchoice(num);
        }
        else if (numselection.contains(choice)){
            return choice;
        } else {
            repeatchoice(num);
        }
        return "";
    }

    public static String repeatchoice(int num){
        System.out.println("\n잘못된 입력입니다. 다시 입력해주세요.");
        Scanner sc = new Scanner(System.in);

        String numselection = "";
        for(int i =1; i<=num; i++){
            numselection = numselection+i+"    ";
        }
        String choice = sc.nextLine();

        if (choice.isBlank()||choice.isEmpty()) {
            repeatchoice(num);
        }
        else if (numselection.contains(choice)){
            return choice;
        } else {
            repeatchoice(num);
        }
        return "";
    }
}


