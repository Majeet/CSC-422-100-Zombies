public abstract class Character {
    protected int health;
    protected int attack;

    public Character(int health, int attack) {
        // a character has health and attack as attributes
        this.health = health;
        this.attack = attack;
    }

    public boolean isAlive() {
        // dead if health is equal to or less than 0
        return health >= 0; 
    }

    public void receiveDamage(int damage) {
        // reduce the damage from health
        health -= damage;
    }

    public int getAttack() {
        // returns attack score
        return attack;
    }
}
