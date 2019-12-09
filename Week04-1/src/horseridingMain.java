import java.util.ArrayList;
import java.util.Scanner;

public class horseridingMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 스캐너 객체 생성

        //게임 시작 화면
        display.logo100();
        display.blankLine(2);
        System.out.println("원형 마장에 입장했습니다. 엔터키를 누르면 게임이 시작됩니다.");
        String input = sc.nextLine();

        //말 선택
        display.line(100);
        display.blankLine(1);
        System.out.println("반갑습니다! 승마를 진행할 말을 선택해주세요.\n1. 쎄미\n2. 제국이\n3. 걸작이\n\n(해당 선택지의 번호를 숫자로 입력해주세요)");

        // 무한반복문으로 예외처리
        while (true) {
            String choice = sc.nextLine();

            // 선택값에 따라 말 객체 생성
            // 말 정보 출력;
            if (choice.equals("1")) {
                System.out.println("\n쎄미가 선택되었습니다.\n");
                horse ssemi = new horse("쎄미", 20, 10, 10);
                ssemi.showHorseInfo();
                break;

            } else if (choice.equals("2")) {
                System.out.println("\n제국이가 선택되었습니다.\n");
                horse empire = new horse("제국이", 30, 30, 20);
                empire.showHorseInfo();
                break;

            } else if (choice.equals("3")) {
                System.out.println("\n걸작이가 선택되었습니다.\n");
                horse masterpiece = new horse("걸작이", 10, 20, 30);
                masterpiece.showHorseInfo();
                break;

            } else {
                System.out.println("잘못된 입력입니다. 선택지에 있는 숫자를 입력해주세요.");
            }
        }

        // 승마 시작
        display.line(100);
        display.blankLine(1);
        System.out.println("승마를 시작합니다.");

        // 기승자 상태창
        rider rider = new rider();
        rider.showRiderInfo();

        // 스킬 객체 생성
        skill 평보 = new skill(1, "평보", 0);
        skill 경속보 = new skill(2, "경속보", 0);
        skill 좌속보 = new skill(3, "좌속보", 10);
        skill 전경속보 = new skill(4, "전경속보", 20);
        skill 구보 = new skill(5, "구보", 30);
        skill 전경구보 = new skill(6, "전경구보", 40);

        // PossibleSkill 리스트 업데이트
        riderSkill riderSkill = new riderSkill();
        riderSkill.addPossibleSkill(평보.index, 평보.skillName, 평보.proficiencyNeed);
        riderSkill.addPossibleSkill(경속보.index, 경속보.skillName, 경속보.proficiencyNeed);
        riderSkill.addPossibleSkill(좌속보.index, 좌속보.skillName, 좌속보.proficiencyNeed);
        riderSkill.addPossibleSkill(전경속보.index, 전경속보.skillName, 전경속보.proficiencyNeed);
        riderSkill.addPossibleSkill(구보.index, 구보.skillName, 구보.proficiencyNeed);
        riderSkill.addPossibleSkill(전경구보.index, 전경구보.skillName, 전경구보.proficiencyNeed);
        int n = riderSkill.skillNum;

        // 기승자 스킬창
        riderSkill.showPossibleSkill();

        // 스킬 선택창
        display.line(100);
        display.blankLine(1);
        System.out.println("시행할 스킬을 선택해주세요. \n(해당 선택지의 번호를 숫자로 입력해주세요)");

        // 무한 루프로 예외처리
        while (true) {
            String choice = sc.nextLine();
            if (choice.equals("1")) {
                //if (n < 1) continue; // n이 6보다 작은 경우도 사용할 수 있게 일반화
                //else {
                display.line(100);
                display.blankLine(1);
                System.out.println(평보.skillName + "를 시행합니다.\n");
                usingSkill skill1 = new usingSkill(90, 5, 5); // useSkill 객체 선언
                skill1.skillSuccessP += riderSkill.riderProficiency;
                if (skill1.getSkillResult() == true) {
                    riderSkill.skillSuccess(평보.skillName, skill1.skillKcalBurned, skill1.skillEnergyUsed);
                } else {
                    riderSkill.skillFail(평보.skillName, skill1.skillEnergyUsed);
                }
                rider.levelUp();
                rider.badEnd();
                rider.levelMaxEnd();
                break;

            } else if (choice.equals("2")) {
                //if (n < 2) continue;
                System.out.println(경속보.skillName + "를 시행합니다.\n");
                usingSkill skill2 = new usingSkill(70, 20, 15);
                skill2.skillSuccessP += riderSkill.riderProficiency;
                if (skill2.getSkillResult() == true) {
                    riderSkill.skillSuccess(경속보.skillName, skill2.skillKcalBurned, skill2.skillEnergyUsed);
                } else {
                    riderSkill.skillFail(경속보.skillName, skill2.skillEnergyUsed);
                }
                rider.levelUp();
                rider.badEnd();
                rider.levelMaxEnd();
                break;

            } else if (choice.equals("3")) {
                //if (n < 3) continue;
                System.out.println(좌속보.skillName + "를 시행합니다.\n");
                usingSkill skill3 = new usingSkill(50, 30, 25);
                if (skill3.getSkillResult() == true) {
                    riderSkill.skillSuccess(좌속보.skillName, skill3.skillKcalBurned, skill3.skillEnergyUsed);
                } else {
                    riderSkill.skillFail(좌속보.skillName, skill3.skillEnergyUsed);
                }
                rider.levelUp();
                rider.badEnd();
                rider.levelMaxEnd();
                break;

            } else if (choice.equals("4")) {
                //if (n < 4) continue;
                System.out.println(전경속보.skillName + "를 시행합니다.\n");
                usingSkill skill4 = new usingSkill(60, 25, 10);
                if (skill4.getSkillResult() == true) {
                    riderSkill.skillSuccess(전경속보.skillName, skill4.skillKcalBurned, skill4.skillEnergyUsed);
                } else {
                    riderSkill.skillFail(전경속보.skillName, skill4.skillEnergyUsed);
                }
                rider.levelUp();
                rider.badEnd();
                rider.levelMaxEnd();
                break;

            } else if (choice.equals("5")) {
                //if (n < 5) continue;
                System.out.println(구보.skillName + "를 시행합니다.\n");
                usingSkill skill5 = new usingSkill(40, 35, 15);
                if (skill5.getSkillResult() == true) {
                    riderSkill.skillSuccess(구보.skillName, skill5.skillKcalBurned, skill5.skillEnergyUsed);
                } else {
                    riderSkill.skillFail(구보.skillName, skill5.skillEnergyUsed);
                }
                rider.levelUp();
                rider.badEnd();
                rider.levelMaxEnd();
                break;

            } else if (choice.equals("6")) {
                //f (n < 6) continue;
                System.out.println(전경구보.skillName + "를 시행합니다.\n");
                usingSkill skill6 = new usingSkill(30, 45, 10);
                if (skill6.getSkillResult() == true) {
                    riderSkill.skillSuccess(전경구보.skillName, skill6.skillKcalBurned, skill6.skillEnergyUsed);
                } else {
                    riderSkill.skillFail(전경구보.skillName, skill6.skillEnergyUsed);
                }
                rider.levelUp();
                rider.badEnd();
                rider.levelMaxEnd();
                break;

            } else {
                System.out.println("잘못된 입력입니다. 선택지에 있는 숫자를 입력해주세요.");
            }
        }

        // 승마 진행 (기승자 상태/스킬 -> 스킬 선택 -> 성공/실패 -> 기승자 상태 업데이트)
        // 전체 무한루프로 반복
        while (true) {
            display.line(100);
            display.blankLine(1);
            System.out.println("승마를 진행합니다.");

            // 기승자 상태창
            rider.showRiderInfo();

            // PossibleSkill 리스트 업데이트
            riderSkill.possibleSkill = new ArrayList<skill>();
            riderSkill.addPossibleSkill(평보.index, 평보.skillName, 평보.proficiencyNeed);
            riderSkill.addPossibleSkill(경속보.index, 경속보.skillName, 경속보.proficiencyNeed);
            riderSkill.addPossibleSkill(좌속보.index, 좌속보.skillName, 좌속보.proficiencyNeed);
            riderSkill.addPossibleSkill(전경속보.index, 전경속보.skillName, 전경속보.proficiencyNeed);
            riderSkill.addPossibleSkill(구보.index, 구보.skillName, 구보.proficiencyNeed);
            riderSkill.addPossibleSkill(전경구보.index, 전경구보.skillName, 전경구보.proficiencyNeed);
            n = riderSkill.skillNum;

            // 기승자 스킬창
            riderSkill.showPossibleSkill();

            // 스킬 선택창
            display.line(100);
            display.blankLine(1);
            System.out.println("시행할 스킬을 선택해주세요. \n(해당 선택지의 번호를 숫자로 입력해주세요)");

            // 무한 루프로 예외처리
            while (true) {
                String choice = sc.nextLine();
                if (choice.equals("1")) {
                    //if (n < 1) continue; // n이 6보다 작은 경우도 사용할 수 있게 일반화
                    //else {
                    display.line(100);
                    display.blankLine(1);
                    System.out.println(평보.skillName + "를 시행합니다.\n");
                    usingSkill skill1 = new usingSkill(90, 5, 5); // useSkill 객체 선언
                    skill1.skillSuccessP += riderSkill.riderProficiency;
                    if (skill1.getSkillResult() == true) {
                        riderSkill.skillSuccess(평보.skillName, skill1.skillKcalBurned, skill1.skillEnergyUsed);
                    } else {
                        riderSkill.skillFail(평보.skillName, skill1.skillEnergyUsed);
                    }
                    rider.levelUp();
                    rider.badEnd();
                    rider.levelMaxEnd();
                    break;

                } else if (choice.equals("2")) {
                    //if (n < 2) continue;
                    System.out.println(경속보.skillName + "를 시행합니다.\n");
                    usingSkill skill2 = new usingSkill(70, 20, 15);
                    skill2.skillSuccessP += riderSkill.riderProficiency;
                    if (skill2.getSkillResult() == true) {
                        riderSkill.skillSuccess(경속보.skillName, skill2.skillKcalBurned, skill2.skillEnergyUsed);
                    } else {
                        riderSkill.skillFail(경속보.skillName, skill2.skillEnergyUsed);
                    }
                    rider.levelUp();
                    rider.badEnd();
                    rider.levelMaxEnd();
                    break;

                } else if (choice.equals("3")) {
                    //if (n < 3) continue;
                    System.out.println(좌속보.skillName + "를 시행합니다.\n");
                    usingSkill skill3 = new usingSkill(50, 30, 25);
                    skill3.skillSuccessP += riderSkill.riderProficiency;
                    if (skill3.getSkillResult() == true) {
                        riderSkill.skillSuccess(좌속보.skillName, skill3.skillKcalBurned, skill3.skillEnergyUsed);
                    } else {
                        riderSkill.skillFail(좌속보.skillName, skill3.skillEnergyUsed);
                    }
                    rider.levelUp();
                    rider.badEnd();
                    rider.levelMaxEnd();
                    break;

                } else if (choice.equals("4")) {
                    //if (n < 4) continue;
                    System.out.println(전경속보.skillName + "를 시행합니다.\n");
                    usingSkill skill4 = new usingSkill(60, 25, 10);
                    skill4.skillSuccessP += riderSkill.riderProficiency;
                    if (skill4.getSkillResult() == true) {
                        riderSkill.skillSuccess(전경속보.skillName, skill4.skillKcalBurned, skill4.skillEnergyUsed);
                    } else {
                        riderSkill.skillFail(전경속보.skillName, skill4.skillEnergyUsed);
                    }
                    rider.levelUp();
                    rider.badEnd();
                    rider.levelMaxEnd();
                    break;

                } else if (choice.equals("5")) {
                    //if (n < 5) continue;
                    System.out.println(구보.skillName + "를 시행합니다.\n");
                    usingSkill skill5 = new usingSkill(40, 35, 15);
                    skill5.skillSuccessP += riderSkill.riderProficiency;
                    if (skill5.getSkillResult() == true) {
                        riderSkill.skillSuccess(구보.skillName, skill5.skillKcalBurned, skill5.skillEnergyUsed);
                    } else {
                        riderSkill.skillFail(구보.skillName, skill5.skillEnergyUsed);
                    }
                    rider.levelUp();
                    rider.badEnd();
                    rider.levelMaxEnd();
                    break;

                } else if (choice.equals("6")) {
                    //f (n < 6) continue;
                    System.out.println(전경구보.skillName + "를 시행합니다.\n");
                    usingSkill skill6 = new usingSkill(30, 45, 10);
                    skill6.skillSuccessP += riderSkill.riderProficiency;
                    if (skill6.getSkillResult() == true) {
                        riderSkill.skillSuccess(전경구보.skillName, skill6.skillKcalBurned, skill6.skillEnergyUsed);
                    } else {
                        riderSkill.skillFail(전경구보.skillName, skill6.skillEnergyUsed);
                    }
                    rider.levelUp();
                    rider.badEnd();
                    rider.levelMaxEnd();
                    break;

                } else {
                    System.out.println("잘못된 입력입니다. 선택지에 있는 숫자를 입력해주세요.");
                }
            }
        }
    }
}
