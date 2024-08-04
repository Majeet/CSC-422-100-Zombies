import java.util.List;
import java.util.Random;

public class Battle {
    private List<Zombie> zombies; // list of zombies
    private List<Survivor> survivors; // list of survivors
    private Random random = new Random();

    public Battle(List<Zombie> zombies, List<Survivor> survivors) {
        this.zombies = zombies;
        this.survivors = survivors;
    }

    public void simulateBattle() {
        System.out.println("We have " + survivors.size() + " survivors trying to make it to safety.");
        System.out.println("But there are " + zombies.size() + " zombies waiting for them.");

        // continuing battle if atleast one of survior and a zombie is alive
        while (anyAlive(survivors) && anyAlive(zombies)) {
            // looping through survivor
            for (Survivor survivor : survivors) {
                // if selected survivor is alive and if there are still any zombies left
                if (survivor.isAlive() && anyAlive(zombies)) {
                    // selecting random zombie since and attacking it
                    Zombie target = getRandomAliveZombie();
                    if (target != null) {
                        target.receiveDamage(survivor.getAttack());
                    }
                }
            }

            // repeating the same steps that we did for surviors, just looping throught the zombies now and they attack random survivors
            for (Zombie zombie : zombies) {
                if (zombie.isAlive() && anyAlive(survivors)) {
                    Survivor target = getRandomAliveSurvivor();
                    if (target != null) {
                        target.receiveDamage(zombie.getAttack());
                    }
                }
            }
        }
        // printed in case survivor still survived
        if (anyAlive(survivors)) {
            int survivorCount = countAlive(survivors);
            System.out.println("It seems " + survivorCount + " have made it to safety.");
        } else {
            System.out.println("None of the survivors made it.");
        }
    }

    // helper functions used above
    private boolean anyAlive(List<? extends Character> characters) {
        return characters.stream().anyMatch(Character::isAlive);
    }

    private int countAlive(List<? extends Character> characters) {
        return (int) characters.stream().filter(Character::isAlive).count();
    }

    private Zombie getRandomAliveZombie() {
        List<Zombie> aliveZombies = zombies.stream().filter(Character::isAlive).toList();
        return aliveZombies.isEmpty() ? null : aliveZombies.get(random.nextInt(aliveZombies.size()));
    }

    private Survivor getRandomAliveSurvivor() {
        List<Survivor> aliveSurvivors = survivors.stream().filter(Character::isAlive).toList();
        return aliveSurvivors.isEmpty() ? null : aliveSurvivors.get(random.nextInt(aliveSurvivors.size()));
    }

}