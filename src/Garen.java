public class Garen extends Champion{
    public Garen(String name, int level, int hp, int attackDamage, int defense) {
        super(name, level, hp, attackDamage, defense);
    }

    @Override
    public void UseQ(Champion champion, Champion target) {
        System.out.println(getName() + "의 Q!");
        target.takeDamage(champion,getAttackDamage() + 100);
    }

    @Override
    public void UseW(Champion champion, Champion target) {
        System.out.println(getName() + "의 W!");
    }

    @Override
    public void UseE(Champion champion, Champion target) {
        System.out.println(getName() + "의 E!");
        for (int i = 0; i < 3; i++){
            target.takeDamage(champion, getAttackDamage() - 50);
            if (target.getIsDead()){
                break;
            }
        }
    }

    @Override
    public void UseR(Champion champion, Champion target) {
        System.out.println(getName() + "의 R!");
        target.takeDamage(champion,getAttackDamage()+(target.getHp()/100*5));   //현재 체력의 5퍼센트 고정피해
        if (target.getHp() <= 500){
            System.out.println("처헝!");
            levelUp();
            target.setIsdead(true);
        }
    }
}
