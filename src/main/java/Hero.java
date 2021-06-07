import java.util.ArrayList;
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
}