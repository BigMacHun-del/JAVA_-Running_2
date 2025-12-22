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

    public String getName(){return this.name;}
    public int getAttackDamage(){return this.attackDamage;}
    public int getHp(){return this.hp;}
    public void setIsdead(boolean isdead){
        System.out.println(this.name + "이(가) 죽었습니다!");
        this.isdead = isdead;
    }

    //기본공격 메서드
    public void basicAttack(Champion target){
        System.out.println(this.name + "의 기본 공격!");
        target.takeDamage(this.attackDamage);

    }

    //방어력 계산 실제 받는 데미지 메서드
    public void takeDamage(int damage){
        int actDamage = damage - this.defense;
        System.out.println(name + "이(가)" + actDamage + "만큼의 피해를 입었습니다.");
        hp = hp - actDamage;
        if (hp > 0){
            System.out.println("남은 체력" + hp);
        } else if (hp < 0) {
            setIsdead(true);
        }
    }

    public boolean isDead(){
        return this.isdead;
    }

    public void levelUp(){
        this.level++;
    }

    public abstract void UseQ(Champion target);
    public abstract void UseW(Champion target);
    public abstract void UseE(Champion target);
    public abstract void UseR(Champion target);

}
