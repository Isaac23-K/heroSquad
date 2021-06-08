import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Hero {
    private String hero_name;
    private int age;
    private String powers;
    private String weakness;
    private static List<Hero> instance = new ArrayList<>();

    public Hero(String name, int age, String powers, String weakness) {
        this.hero_name = name;
        this.age = age;
        this.powers = powers;
        this.weakness = weakness;
    }

    public static Collection<Object> getAll() {
        return getAll();
    };

    public String getHero_name() {
        return hero_name;
    }

    public int getAge() {
        return age;
    }

    public String getPowers() {
        return powers;
    }

    public String getWeakness() {
        return weakness;
    }

    public static List<Hero> getInstance() {
        return instance;
    }
    public void deleteHero(){
        instance.remove(-1);
    }
}
