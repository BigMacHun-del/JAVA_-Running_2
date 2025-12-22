import java.util.List;
import java.util.Random;

public class Battle {
    private static Random random = new Random();
    public static void oneVsOne(Team<Champion> t1, Team<Champion> t2) {
        Champion c1 = randomPick(t1.getMembers());   //랜덤으로 각 팀의 챔피언 선택
        Champion c2 = randomPick(t2.getMembers());

        System.out.println("\n===== 1:1 전투 시작 =====");
        System.out.println(c1.getName() + " vs " + c2.getName());
        System.out.println("========================");

        try {
            c1.basicAttack(c1, c2);
            c2.basicAttack(c2, c1);

            c1.UseQ(c1,c2);
            c2.UseQ(c2,c1);
            c1.UseR(c1,c2);
            c2.UseR(c2,c1);
        }catch (DeadChampionActionException e){
            System.out.println(e.getMessage());
        }
        System.out.println("========================");

        if (c1.getHp() > c2.getHp()) {
            System.out.println(c1.getName() + " 승!");
        } else if (c1.getHp() < c2.getHp()) {
            System.out.println(c2.getName() + " 승!");
        } else{
            System.out.println("무승부!");
        }

        System.out.println("========================");

    }

    private static Champion randomPick(List<Champion> list) {  //리스트 중 랜덤으로 뽑기
        return list.get(random.nextInt(list.size()));
    }
}
