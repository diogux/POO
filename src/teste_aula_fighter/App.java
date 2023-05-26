package teste_aula_fighter;
import java.util.Random; 

class Boxer extends Fighter {
    private int range;

    public Boxer(String name, int range) {
        super(name);
        this.range = range;
    }

    public void attack(Fighter opponent) {
        int distance = new Random().nextInt(10) + 1;
        if (distance <= this.range) {
            int damage = new Random().nextInt(100) + 1;
            opponent.takeDamage(damage);
            System.out.println(this.getName() + " hit " + opponent.getName() + " for " + damage + " damage!");
        } else {
            System.out.println(this.getName() + " missed " + opponent.getName() + "!");
        }
    }

    public String toString() {
        return "Boxer " + super.toString();
    }
}

class Wrestler extends Fighter {
    private int speed;

    public Wrestler(String name, int speed) {
        super(name);
        this.speed = speed;
    }

    public void attack(Fighter opponent) {
        int distance = new Random().nextInt(10) + 1;
        if (this.speed > distance) {
            int damage = new Random().nextInt(100) + 1;
            opponent.takeDamage(damage);
            System.out.println(this.getName() + " hit " + opponent.getName() + " for " + damage + " damage!");
        } else {
            System.out.println(this.getName() + " missed " + opponent.getName() + "!");
        }
    }

    public String toString() {
        return "Wrestler " + super.toString();
    }
}
