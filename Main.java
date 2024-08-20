import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final Random random = new Random();

    // setting up the battlefield
    public static void main(String[] args) {
        List<Zombie> zombies = generateZombies();
        List<Survivor> survivors = generateSurvivors();
        List<Weapon> weapons = generateWeapons();
        assignWeaponsToSurvivors(survivors, weapons);
        Battle battle = new Battle(zombies, survivors);
        battle.simulateBattle();
    }

    // helper functions
    // weapons with name, attack power and accuracy
    public static List<Weapon> generateWeapons() {
        List<Weapon> weapons = new ArrayList<>();
        weapons.add(new Weapon("Shotgun", 50, 0.6));
        weapons.add(new Weapon("Submachine Gun", 30, 0.8));
        weapons.add(new Weapon("Assault Rifle", 40, 0.75));
        weapons.add(new Weapon("Pistol", 20, 0.9));
        weapons.add(new Weapon("Axe", 25, 0.7));
        weapons.add(new Weapon("Crowbar", 15, 0.85));
        weapons.add(new Weapon("Frying Pan", 10, 0.5));
        return weapons;
    }

    // assigning random weapons to survivors
    public static void assignWeaponsToSurvivors(List<Survivor> survivors, List<Weapon> weapons) {
        for (Survivor survivor : survivors) {
            survivor.setWeapon(weapons.get(random.nextInt(weapons.size())));
        }
    }

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