// weapon class
public class Weapon {
    private String name;
    private int damage;
    private double accuracy;

    public Weapon(String name, int damage, double accuracy) {
        this.name = name;
        this.damage = damage;
        this.accuracy = accuracy;
    }

    public int getDamage() {
        return damage;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (Damage: " + damage + ", Accuracy: " + accuracy + ")";
    }
}
