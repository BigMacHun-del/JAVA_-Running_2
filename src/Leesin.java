public class Leesin extends Champion {
    public Leesin(String name, int level, int hp, int attackDamage, int defense) {
        super(name, level, hp+200, attackDamage+100, defense);
    }

    @Override
    public void UseQ(Champion champion, Champion target) {
        checkAlive();
        target.checkAlive();
        System.out.println(getName() + "의 Q!");
        target.takeDamage(champion, getAttackDamage());
        System.out.println("Q 2타!");
        target.takeDamage(champion, getAttackDamage());
    }

    @Override
    public void UseW(Champion champion, Champion target) {
        checkAlive();
        target.checkAlive();
        System.out.println(getName() + "의 W!");
    }

    @Override
    public void UseE(Champion champion, Champion target) {
        checkAlive();
        target.checkAlive();
        System.out.println(getName() + "의 E!");
        target.takeDamage(champion, getAttackDamage());
    }

    @Override
    public void UseR(Champion champion, Champion target) {
        checkAlive();
        target.checkAlive();
        System.out.println(getName() + "의 R!");
        target.takeDamage(champion, getAttackDamage()+200);
    }
}
