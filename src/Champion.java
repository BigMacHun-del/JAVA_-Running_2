public abstract class Champion {
    private String name;
    private int level, hp, attackDamage, defense;
    public static int createdCount = 0;
    private boolean isdead = false;

    public Champion(String name, int level, int hp, int attackDamage, int defense) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.attackDamage = attackDamage;
        this.defense = defense;
        createdCount++;
    }

    //게터 세터
    public String getName(){return this.name;}
    public int getAttackDamage(){return this.attackDamage;}
    public int getHp(){return this.hp;}
    public boolean getIsDead(){return this.isdead;}
    public void checkIsDead(){
        if (isdead){
            System.out.println(this.name + "은 이미 죽었습니다.");
        }
    }
    public void setIsdead(boolean isdead){
        System.out.println(this.name + "이(가) 죽었습니다!");
        this.isdead = isdead;
    }

    //기본공격 메서드
    public void basicAttack(Champion champion, Champion target){
        System.out.println(this.name + "의 기본 공격!");
        target.takeDamage(champion, this.attackDamage);

    }

    //방어력 계산 실제 받는 데미지 메서드
    public void takeDamage(Champion champion, int damage){
        if (isdead){
            checkIsDead();
            return;
        }
        int actDamage = damage - this.defense;
        if (actDamage < 0){
            actDamage = 0;
        }
        System.out.println(name + "이(가)" + actDamage + "만큼의 피해를 입었습니다.");
        hp = hp - actDamage;
        if (hp > 0){
            System.out.println("남은 체력" + hp);
        } else if (hp < 0) {
            setIsdead(true);
            champion.levelUp(); //죽였을 경우 죽인 챔피언 레벨업
        }
    }

    public void levelUp(){
        if (GameConstants.MAX_LEVEL < this.level){
            System.out.println("이미 최대레벨입니다.");
            return;
        }
        System.out.println(name + " 레벨업!!");
        this.level++;
        hp = hp + 100;
        attackDamage = attackDamage + 100;
        defense = defense + 100;
    }

    public abstract void UseQ(Champion champion, Champion target);
    public abstract void UseW(Champion champion, Champion target);
    public abstract void UseE(Champion champion, Champion target);
    public abstract void UseR(Champion champion, Champion target);

}
