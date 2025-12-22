public class LolSystem {
    public void start(){
        Garen garen1 = new Garen("가렌1", 10, 1000,200,200);
        Leesin leesin1 = new Leesin("리신1", 10, 800, 250, 150);
        Lux lux1 = new Lux("럭스1", 10, 600, 400, 100);

        garen1.basicAttack(garen1, leesin1);
        garen1.UseR(garen1, lux1);
        garen1.UseE(garen1, lux1);
        leesin1.UseQ(leesin1, garen1);
        garen1.levelUp();

    }
}
