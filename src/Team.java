import java.util.*;

// T : 타입 / E : 원소(Element) / K : 키

public class Team<T extends Champion> {    //챔피언을 상속 받는 요소들만 올 수 있다. --> 상한 제한 적용
    private List<T> members = new ArrayList<>();

    private String name;

    public Team() {}

    public Team(String name) {
        this.name = name;
    }
    public String getTeamName() {
        return name;
    }
    public void setName(String name) {}

    public void add(T champion){   //매개변수 타입 제네릭
        members.add(champion);
    }
    public T get(int index){     //반환 타입 제네릭
        return members.get(index);
    }

    public List<T> getMembers() {
        return members;
    }

    public void addMember(T champion) {
        members.add(champion);
        System.out.println(champion.getName() + "이(가) " + name + " 팀에 합류!");
    }

    public int getTotalHp() {
        return members.stream()
                .mapToInt(Champion::getHp) //getHp 메서드를 통해 얻은 값을 int 로
                .sum();  //int로 얻은 값 합산
    }

    public static void printTeamMembers(List<? extends Champion> team){   //제네릭 와일드카드 적용해보기
        team.stream()
                .map(Champion::getName)     //이름만 뽑아내기
                .forEach(System.out::println);   //뽑아낸 데이터 각각 출력
    }

    public List<T> getMembersName() {    //팀원들의 이름 출력
        return members;
    }

    public Optional<T> findName(String name) {   //널값으로부터 안전하게 리스트에서 name 가져오기
        return members.stream()
                .filter(champion -> champion.getName().equals(name))
                .findFirst();
    }


}
