public class LolSystem {
    public void start(){
        Garen garen1 = new Garen("가렌1", 200, 1000,200,200);
        Leesin leesin1 = new Leesin("리신1", 200, 800, 250, 150);
        Lux lux1 = new Lux("럭스1", 200, 600, 400, 100);

        garen1.basicAttack(leesin1);
        garen1.UseR(lux1);

    }
}
