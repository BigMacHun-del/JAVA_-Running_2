import java.util.HashMap;
import java.util.Map;

public class ChampionPool {
    private Map<String, Champion> pool = new HashMap<>();

    public void addChampion(Champion champion) {
        pool.put(champion.getName(), champion);    //put 메소드: 해당 키에 맞는 값을 저장
    }

    public Champion get(String name) {
        return pool.get(name);   //이름을 반환
    }

    public boolean exists(String name) {
        return pool.containsKey(name);  //키가 존재하는지 안하는지 확인
    }

}
