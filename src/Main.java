import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

class User implements Listener{
    private String name;
    private List<Group> groupList;

    public User(String name) {
        this.name = name;
        this.groupList = new ArrayList<>();
    }

    public void subscribe(Group group) {
        groupList.add(group);
        group.subscribe(this);
    }

    public void unsubscribe(Group group) {
        groupList.remove(group);
        group.unsubscribe(this);
    }

    @Override
    public void update(String str) {
        System.out.println(this.name + ": " + str);
    }
}
public class Main {
    public static void main(String[] args) {

        User user1 = new User("Саша");
        User user2 = new User("Коля");

        Group group1 = new Group("Милые фотки животных");
        Group group2 = new Group("Мемы");
        Group group3 = new Group("Охота и рыбалка");
        Group group4 = new Group("Кино");

        user1.subscribe(group1);
        user1.subscribe(group2);
        user1.subscribe(group3);

        user2.subscribe(group1);
        user2.subscribe(group2);
        user2.subscribe(group3);
        user2.subscribe(group4);

        group1.informUsers("Сегодня пукнула панда");
        group2.informUsers("Сообщество удалено");
        group3.informUsers("В 18.00 новый выпуск");
        group4.informUsers("Матрицу хапретили");

    }
}