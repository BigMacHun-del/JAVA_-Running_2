import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LolSystem {
    public void start(){
        Garen garen1 = new Garen("가렌1", 10, GameConstants.BASIC_HP,GameConstants.BASIC_ATTACK_DAMAGE,GameConstants.BASIC_DEFENSE);
        Leesin leesin1 = new Leesin("리신1", 10, GameConstants.BASIC_HP,GameConstants.BASIC_ATTACK_DAMAGE,GameConstants.BASIC_DEFENSE);
        Lux lux1 = new Lux("럭스1", 10, GameConstants.BASIC_HP,GameConstants.BASIC_ATTACK_DAMAGE,GameConstants.BASIC_DEFENSE);
        Garen garen2 = new Garen("가렌2", 10, GameConstants.BASIC_HP,GameConstants.BASIC_ATTACK_DAMAGE,GameConstants.BASIC_DEFENSE);
        Leesin leesin2 = new Leesin("리신2", 10, GameConstants.BASIC_HP,GameConstants.BASIC_ATTACK_DAMAGE,GameConstants.BASIC_DEFENSE);
        Lux lux2 = new Lux("럭스2", 10, GameConstants.BASIC_HP,GameConstants.BASIC_ATTACK_DAMAGE,GameConstants.BASIC_DEFENSE);

        //List
        List<Champion> list = new ArrayList<>();   //객체의 정보를 담겠다
        list.add(garen1);  //삽입
        list.add(garen2);
        list.add(leesin1);
        list.add(leesin2);
        list.add(lux1);
        list.add(lux2);

        // 챔피언 Pool 구성
        ChampionPool pool = new ChampionPool();
        pool.addChampion(garen1);
        pool.addChampion(garen2);
        pool.addChampion(leesin1);
        pool.addChampion(leesin2);
        pool.addChampion(lux1);
        pool.addChampion(lux2);

        // 팀 생성
        Team<Champion> blue = new Team<>("블루");
        Team<Champion> red = new Team<>("레드");

        // 팀 배치
        blue.addMember(pool.get("가렌1"));
        blue.addMember(pool.get("리신1"));
        blue.addMember(pool.get("럭스1"));

        red.addMember(pool.get("가렌2"));
        red.addMember(pool.get("리신2"));
        red.addMember(pool.get("럭스2"));

        System.out.println("생성된 챔피언의 수: " + Champion.createdCount);

        // 팀 구성원 출력
        System.out.println("===" + "블루 팀 구성원 ===");
        Team.printTeamMembers(blue.getMembersName());
        System.out.println("블루팀 전체 체력: " + blue.getTotalHp());

        System.out.println("===" + "레드 팀 구성원 ===");
        Team.printTeamMembers(red.getMembersName());
        System.out.println("레드팀 전체 체력: " + red.getTotalHp());

        System.out.println("========================");

        Scanner sc = new Scanner(System.in);
        System.out.print("챔피언 명 검색: ");
        String campName = sc.nextLine();

        serchCamp(red, campName);
        serchCamp(blue, campName);

//        while (true){
//            System.out.println("팀명 검색 레드: 1 / 블루: 2를 입력해주세요.: ");
//            int teamNum = sc.nextInt();
//            sc.nextLine();
//            if (teamNum == 1) {
//                serchCamp(red, campName);
//                break;
//            } else if (teamNum == 2) {
//                serchCamp(blue, campName);
//                break;
//            } else {
//                System.out.println("입력 오류");
//            }
//        }

        Battle.oneVsOne(red, blue);    //1대 1 랜덤 뽑기 대결
        sc.close();
    }
    public void serchCamp(Team<Champion> team, String name){  //팀에 존재하는 챔피언인지 검색
        team.findName(name)
                .ifPresentOrElse(
                        c -> System.out.println(c.getName() +"은 " + team.getTeamName() + "팀 입니다."),
                        () -> System.out.println(team.getTeamName() +" 팀에 존재하지 않는 챔피언입니다.")
                );
    }
}
