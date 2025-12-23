public class Lux extends Champion{
    public Lux(String name, int level, int hp, int attackDamage, int defense) {
        super(name, level, hp, attackDamage+200, defense);
    }

    public boolean boomToken = false;  //럭스 패시브(상대가 스킬을 맞았을 경우 다른 공격을 수행 시 토큰 폭발데미지)
    public void boom(Champion champion, Champion target){
        if(boomToken == true){
            System.out.println("럭스 패시브 발동!!");
            target.takeDamage(champion, champion.getAttackDamage() + 100);
            boomToken = false;
        } else{
            target.takeDamage(champion, champion.getAttackDamage());
        }
    }

    @Override
    public void basicAttack(Champion champion, Champion target){
        System.out.println(champion.getName() + "의 기본 공격!");
        boom(champion, target);
    }

    @Override
    public void UseQ(Champion champion, Champion target) {
        checkAlive();
        target.checkAlive();
        System.out.println(getName() + "의 Q!");
        target.takeDamage(champion, getAttackDamage());
        boomToken = true;
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
        boomToken = true;
    }

    @Override
    public void UseR(Champion champion, Champion target) {
        checkAlive();
        target.checkAlive();
        System.out.println(getName() + "의 R!");
        target.takeDamage(champion, getAttackDamage()+500);
        boomToken = true;
    }
}
