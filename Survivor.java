// // abstract class survivor extended from character, but they now can have weapon (setWeapon), take out the weapons (getWeapon), and attack a zombie with the weapon (attackZombie)
public abstract class Survivor extends Character {
    private Weapon weapon;

    public Survivor(int health, int attack) {
        super(health, attack);
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public boolean attackZombie(Zombie zombie) {
        if (weapon != null && Math.random() <= weapon.getAccuracy()) {
            zombie.receiveDamage(weapon.getDamage());
            return true;
        }
        return false;
    }
}
