public class skill {
    int index;
    String skillName;
    int proficiencyNeed;
    int skillSuccessP; // 스킬 성공 확률(백분율) 상수
    int skillKcalBurned; // 증가 운동량/턴
    int skillEnergyUsed; // 체력 소모량/턴

    skill(int index, String skillName, int proficiencyNeed, int skillSuccessP, int skillKcalBurned, int skillEnergyUsed){
        this.index = index;
        this.skillName = skillName;
        this.proficiencyNeed = proficiencyNeed;
        this.skillSuccessP = skillSuccessP;
        this.skillKcalBurned = skillKcalBurned;
        this.skillEnergyUsed = skillEnergyUsed;
    }

    public int getSkillSuccessP() {
        return skillSuccessP;
    }

    public String getSkillName() {
        return skillName;
    }

    public int getProficiencyNeed() {
        return proficiencyNeed;
    }

    public int getSkillEnergyUsed() {
        return skillEnergyUsed;
    }

    public void setSkillEnergyUsed(int skillEnergyUsed) {
        this.skillEnergyUsed = skillEnergyUsed;
    }

    public int getSkillKcalBurned() {
        return skillKcalBurned;
    }
}
