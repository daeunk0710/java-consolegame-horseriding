import java.util.ArrayList;
import java.util.Scanner;

public class horseriding {
    Scanner sc = new Scanner(System.in); // 스캐너 객체 생성
    riderSkill riderSkill = new riderSkill();
    rider rider = new rider();

    // 스킬 객체 생성
    skill 평보 = new skill(1, "평보", 0, 90, 5, 5);
    skill 경속보 = new skill(2, "경속보", 0, 70, 20, 15);
    skill 좌속보 = new skill(3, "좌속보", 10, 50, 30, 25);
    skill 전경속보 = new skill(4, "전경속보", 20, 60, 25, 20);
    skill 구보 = new skill(5, "구보", 30, 40, 35, 15);
    skill 전경구보 = new skill(6, "전경구보", 40, 30, 45, 10);




    // 승마 진행 1회 (기승자 상태/스킬 -> 스킬 선택 -> 성공/실패 -> 기승자 상태 업데이트)
    void doOneRide() {
        // 기승자 상태창
        display.line(100);
        display.blankLine(1);
        System.out.println("승마를 시작합니다.");

        while (true) {
            rider.showRiderInfo();

            // PossibleSkill 리스트 업데이트
            riderSkill.setPossibleSkill(new ArrayList<skill>());
            riderSkill.addPossibleSkill(평보.index, 평보.skillName, 평보.proficiencyNeed, 평보.skillSuccessP, 평보.skillKcalBurned, 평보.skillEnergyUsed);
            riderSkill.addPossibleSkill(경속보.index, 경속보.skillName, 경속보.proficiencyNeed, 경속보.skillSuccessP, 경속보.skillKcalBurned, 경속보.skillEnergyUsed);
            riderSkill.addPossibleSkill(좌속보.index, 좌속보.skillName, 좌속보.proficiencyNeed, 좌속보.skillSuccessP, 좌속보.skillKcalBurned, 좌속보.skillEnergyUsed);
            riderSkill.addPossibleSkill(전경속보.index, 전경속보.skillName, 전경속보.proficiencyNeed, 전경속보.skillSuccessP, 전경속보.skillKcalBurned, 전경속보.skillEnergyUsed);
            riderSkill.addPossibleSkill(구보.index, 구보.skillName, 구보.proficiencyNeed, 구보.skillSuccessP, 구보.skillKcalBurned, 구보.skillEnergyUsed);
            riderSkill.addPossibleSkill(전경구보.index, 전경구보.skillName, 전경구보.proficiencyNeed, 전경구보.skillSuccessP, 전경구보.skillKcalBurned, 전경구보.skillEnergyUsed);

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
                    riderSkill.setRiderSkillPossibleP((평보.skillSuccessP + rider.riderProficiency));

                    if (riderSkill.getSkillResult() == true) {
                        riderSkill.skillSuccess(평보.skillName, 평보.skillKcalBurned, 평보.skillEnergyUsed);
                    } else {
                        riderSkill.skillFail(평보.skillName, 평보.skillEnergyUsed);
                    }
                    rider.levelUp(5, 100);
                    rider.badEnd(100);
                    rider.levelMaxEnd(10, 100);
                    break;

                } else if (choice.equals("2")) {
                    //if (n < 2) continue;
                    display.line(100);
                    display.blankLine(1);
                    System.out.println(경속보.skillName + "를 시행합니다.\n");
                    riderSkill.setRiderSkillPossibleP((경속보.skillSuccessP + rider.riderProficiency));

                    if (riderSkill.getSkillResult() == true) {
                        riderSkill.skillSuccess(경속보.skillName, 경속보.skillKcalBurned, 경속보.skillEnergyUsed);
                    } else {
                        riderSkill.skillFail(경속보.skillName, 경속보.skillEnergyUsed);
                    }
                    rider.levelUp(5, 100);
                    rider.badEnd(100);
                    rider.levelMaxEnd(10, 100);
                    break;

                } else if (choice.equals("3")) {
                    //if (n < 3) continue;
                    display.line(100);
                    display.blankLine(1);
                    System.out.println(좌속보.skillName + "를 시행합니다.\n");
                    riderSkill.setRiderSkillPossibleP((좌속보.skillSuccessP + rider.riderProficiency));

                    if (riderSkill.getSkillResult() == true) {
                        riderSkill.skillSuccess(좌속보.skillName, 좌속보.skillKcalBurned, 좌속보.skillEnergyUsed);
                    } else {
                        riderSkill.skillFail(좌속보.skillName, 좌속보.skillEnergyUsed);
                    }
                    rider.levelUp(5, 100);
                    rider.badEnd(100);
                    rider.levelMaxEnd(10, 100);
                    break;

                } else if (choice.equals("4")) {
                    //if (n < 4) continue;
                    display.line(100);
                    display.blankLine(1);
                    System.out.println(전경속보.skillName + "를 시행합니다.\n");
                    riderSkill.setRiderSkillPossibleP((전경속보.skillSuccessP + rider.riderProficiency));

                    if (riderSkill.getSkillResult() == true) {
                        riderSkill.skillSuccess(전경속보.skillName, 전경속보.skillKcalBurned, 전경속보.skillEnergyUsed);
                    } else {
                        riderSkill.skillFail(전경속보.skillName, 전경속보.skillEnergyUsed);
                    }
                    rider.levelUp(5, 100);
                    rider.badEnd(100);
                    rider.levelMaxEnd(10, 100);
                    break;

                } else if (choice.equals("5")) {
                    //if (n < 5) continue;
                    display.line(100);
                    display.blankLine(1);
                    System.out.println(구보.skillName + "를 시행합니다.\n");
                    riderSkill.setRiderSkillPossibleP((구보.skillSuccessP + rider.riderProficiency));

                    if (riderSkill.getSkillResult() == true) {
                        riderSkill.skillSuccess(구보.skillName, 구보.skillKcalBurned, 구보.skillEnergyUsed);
                    } else {
                        riderSkill.skillFail(구보.skillName, 구보.skillEnergyUsed);
                    }
                    rider.levelUp(5, 100);
                    rider.badEnd(100);
                    rider.levelMaxEnd(10, 100);
                    break;

                } else if (choice.equals("6")) {
                    //f (n < 6) continue;
                    display.line(100);
                    display.blankLine(1);
                    System.out.println(전경구보.skillName + "를 시행합니다.\n");
                    riderSkill.setRiderSkillPossibleP((전경구보.skillSuccessP + rider.riderProficiency));

                    if (riderSkill.getSkillResult() == true) {
                        riderSkill.skillSuccess(전경구보.skillName, 전경구보.skillKcalBurned, 전경구보.skillEnergyUsed);
                    } else {
                        riderSkill.skillFail(전경구보.skillName, 전경구보.skillEnergyUsed);
                    }
                    rider.levelUp(5, 100);
                    rider.badEnd(100);
                    rider.levelMaxEnd(10, 100);
                    break;

                } else {
                    System.out.println("잘못된 입력입니다. 선택지에 있는 숫자를 입력해주세요.");
                }
            }
        }
    }
}
