public abstract class Champion {
    private String name;
    private int level, hp, attackDamage, defense;

    public Champion(String name, int level, int hp, int attackDamage, int defense) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.attackDamage = attackDamage;
        this.defense = defense;
    }

    public String getName(){
        return this.name;
    }

    public void basicAttack(Champion target){
        int afterHp = target.hp - this.attackDamage;
        System.out.println(this.name + "의 기본 공격!");
        System.out.println(target.name + "의 체력이" + target.hp + "에서 " + afterHp + "이 되었습니다.");
        target.hp =  afterHp;
    }

    public void takeDamage(int damage, Champion target){
        System.out.println(target.name+"이(가)" + damage + "만큼의 피해를 입었습니다.");
        target.hp -= damage;
    }

    public void levelUp(){
        this.level++;
    }

    public abstract void UseQ();
    public abstract void UseW();
    public abstract void UseE();
    public abstract void UseR();

}
