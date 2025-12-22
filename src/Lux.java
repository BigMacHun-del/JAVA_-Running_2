public class Lux extends Champion{
    public Lux(String name, int level, int hp, int attackDamage, int defense) {
        super(name, level, hp, attackDamage, defense);
    }

    @Override
    public void UseQ(Champion target) {
        System.out.println(getName() + "의 Q!");
    }

    @Override
    public void UseW(Champion target) {
        System.out.println(getName() + "의 W!");
    }

    @Override
    public void UseE(Champion target) {
        System.out.println(getName() + "의 E!");
    }

    @Override
    public void UseR(Champion target) {
        System.out.println(getName() + "의 R!");
    }
}
