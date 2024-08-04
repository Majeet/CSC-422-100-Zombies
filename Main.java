import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final Random random = new Random();

    // setting up the battlefield
    public static void main(String[] args) {
        List<Zombie> zombies = generateZombies();
        List<Survivor> survivors = generateSurvivors();
        Battle battle = new Battle(zombies, survivors);
        battle.simulateBattle();
    }

    // helper functions
    // generating random number of each type of zombie
    public static List<Zombie> generateZombies() {
        List<Zombie> zombies = new ArrayList<>();
        int commonInfectedCount = random.nextInt(10) + 1;
        int tankCount = random.nextInt(3) + 1;

        for (int i = 0; i < commonInfectedCount; i++) {
            zombies.add(new CommonInfected());
        }
        for (int i = 0; i < tankCount; i++) {
            zombies.add(new Tank());
        }

        return zombies;
    }

    // generating random number of each type of survivor
    public static List<Survivor> generateSurvivors() {
        List<Survivor> survivors = new ArrayList<>();
        int soldierCount = random.nextInt(5) + 1;
        int scientistCount = random.nextInt(3) + 1;
        int civilianCount = random.nextInt(7) + 1;

        for (int i = 0; i < soldierCount; i++) {
            survivors.add(new Soldier());
        }
        for (int i = 0; i < scientistCount; i++) {
            survivors.add(new Scientist());
        }
        for (int i = 0; i < civilianCount; i++) {
            survivors.add(new Civilian());
        }

        return survivors;
    }
}