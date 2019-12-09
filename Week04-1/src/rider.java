import java.util.ArrayList;

public class rider {
    static int riderLevel = 1; // 기승자 레벨 초기값
    static int riderProficiency = 0; // 기승자 숙련도 초기값

    private static int[][] arrayLevelStat = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, // 레벨
            {50, 60, 70, 80, 90, 120, 150, 180, 240, 300}, // 레벨에 따른 최대 체력
            {20, 40, 80, 160, 320, 640, 1280, 2560, 5120, 10240}}; //레벨업 하기 위해 필요한 운동량

    private static int levelEnergy = arrayLevelStat[1][(riderLevel-1)]; //레벨에 따른 최대 체력
    private static int riderEnergy = levelEnergy; //체력 초기값

    void setRiderEnergy(int riderEnergy) {
        rider.riderEnergy = riderEnergy;
    }

    int getRiderEnergy() {
        return riderEnergy;
    }

    private static int levelKcalBurned = arrayLevelStat[2][(riderLevel-1)]; //레벨업 하기 위해 필요한 운동량
    private static int riderKcalBurned = 0; //운동량 초기값

    void setRiderKcalBurned(int riderKcalBurned) {
        rider.riderKcalBurned = riderKcalBurned;
    }

    int getRiderKcalBurned() {
        return riderKcalBurned;
    }

    void showRiderInfo(){
        display.boxUpper(20);
        System.out.println("  기승자 상태");
        System.out.println("  레벨: "+riderLevel);
        System.out.println("  체력: "+riderEnergy+"/"+levelEnergy);
        System.out.println("  운동량: "+riderKcalBurned+"/"+levelKcalBurned);
        display.boxLower(20);
    }

    void levelUp(){
        if(riderKcalBurned>=levelKcalBurned){
            riderLevel = (riderLevel +1);
            riderProficiency = (riderProficiency + 5);
            riderEnergy = levelEnergy;
            riderKcalBurned = 0;
            display.line(100);
            System.out.println("레벨업! 축하합니다.");
        }
      }

    void badEnd(){
        if(riderEnergy<=0){
            display.line(100);
            display.line(100);
            display.line(100);
            display.badEnd100();
            display.blankLine(1);
            System.out.println("체력이 모두 소모되었습니다. 안전이 제일 중요해요~\n푹 쉬고 다음에 만나요.\n");
            System.exit(0);
        }
    }

    void levelMaxEnd(){
        if(riderLevel>=10){
            display.line(100);
            display.blankLine(1);
            display.horseImg100();
            System.out.println("축하합니다!!! 마왕의 칭호를 획득하셨습니다.");
            System.exit(0);
        }
    }
}

class riderSkill extends rider{
    ArrayList <skill> possibleSkill = new ArrayList<skill>();
    int skillNum = possibleSkill.size();

    void addPossibleSkill(int index, String skillName, int proficiencyNeed){
        if (riderProficiency >= proficiencyNeed) {
            this.possibleSkill.add(new skill(index, skillName, proficiencyNeed));
        }
    }

    public ArrayList<skill> getPossibleSkill() {
        return possibleSkill;
    }

    public int riderSkillPossibleP(){

    }
    void showPossibleSkill(){
        display.boxUpper(20);
        System.out.println("  기승자 스킬\n"+
                "  (현재 숙련도: "+riderProficiency+ ")");
        String result = " ";
        for (skill skill: this.possibleSkill){
            result +=("\n  "+skill.index+". "+skill.skillName);
        }
        System.out.println(result);
        display.boxLower(20);
    }

    void skillSuccess(String skillName, int skillKcalBurned, int skillEnergyUsed){
        System.out.println(skillName+"를 성공했습니다!");
        int temp;
        temp = getRiderKcalBurned();
        setRiderKcalBurned(temp+skillKcalBurned);
        System.out.println("운동량을 "+skillKcalBurned+"Kcal 소모했습니다.");
        temp = getRiderEnergy();
        setRiderEnergy(temp-skillEnergyUsed);
        System.out.println("체력이 "+skillEnergyUsed+"만큼 감소했습니다.");
    }

    void skillFail(String skillName, int skillEnergyUsed){
        System.out.println(skillName+"에 실패했습니다. 역시 "+skillName+"은 쉽지 않네요.");
        int temp;
        temp = getRiderEnergy();
        setRiderEnergy(temp-skillEnergyUsed);
        System.out.println("체력이 "+skillEnergyUsed+"만큼 감소했습니다.");
    }

}
