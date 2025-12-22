public class Garen extends Champion{
    public Garen(String name, int level, int hp, int attackDamage, int defense) {
        super(name, level, hp, attackDamage, defense);
    }

    @Override
    public void UseQ(Champion target) {
        System.out.println(getName() + "의 Q!");
        target.takeDamage(getAttackDamage() + 100);
    }

    @Override
    public void UseW(Champion target) {
        System.out.println(getName() + "의 W!");
    }

    @Override
    public void UseE(Champion target) {
        System.out.println(getName() + "의 E!");
        for (int i = 0; i < 3; i++){
            target.takeDamage(getAttackDamage() - 50);
        }
    }

    @Override
    public void UseR(Champion target) {
        System.out.println(getName() + "의 R!");
        target.takeDamage(getAttackDamage()+(target.getHp()/100*5));   //현재 체력의 5퍼센트 고정피해
        if (target.getHp() <= 500){
            System.out.println("처헝!");
            target.setIsdead(true);
        }
    }
}
