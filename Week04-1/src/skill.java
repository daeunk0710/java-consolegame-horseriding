public class skill {
    static int index;
    static String skillName;
    static int proficiencyNeed;
    static String expectedResponce;

    public skill(int index, String skillName, int proficiencyNeed){
        skill.index = index;
        skill.skillName = skillName;
        skill.proficiencyNeed = proficiencyNeed;
    }



    public int getIndex() {
        return index;
    }

    public String getSkillName() {
        return skillName;
    }

    public int getProficiencyNeed() {
        return proficiencyNeed;
    }

    public String getExpectedResponce() {
        return expectedResponce;
    }
}

class usingSkill extends skill {
    static int skillSuccessP; // 스킬 성공 확률(백분율) 상수
    static int skillKcalBurned; // 증가 운동량/턴
    static int skillEnergyUsed; // 체력 소모량/턴
    int riderSkillSuccessP;
    static boolean skillSuccess; // 스킬 성공 여부

    usingSkill(int index, String skillName, int proficiencyNeed, int skillSuccessP, int skillKcalBurned, int skillEnergyUsed){
        super(index, skillName, proficiencyNeed);
        usingSkill.skillSuccessP = skillSuccessP;
        usingSkill.skillKcalBurned = skillKcalBurned;
        usingSkill.skillEnergyUsed = skillEnergyUsed;
    }

    // 성공 여부 결정하는 메소드
    public boolean getSkillResult(){
        if(skillSuccessP>100){
            skillSuccess = true;
        } else {
            //100칸 배열 생성
            boolean[] possibilityBox = new boolean[100];
            //skillSuccessP 만큼 true 로 채우고
            for (int i = 0; i < skillSuccessP; i++) {
                possibilityBox[i] = true;
            }
            //나머지를 false로 채움
            for (int i = skillSuccessP; i < 100; i++) {
                possibilityBox[i] = false;
            }

            //랜덤함수로 랜덤 인덱스 생성
            int j = (int) (Math.random() * 100);
            skillSuccess = possibilityBox[j];
        }
        return skillSuccess;
    }

}
