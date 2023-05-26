package teste_aula_fighter;

public abstract class Fighter {
    private String name;
    private int life;
    private int wins;
    private int losses;

    public Fighter(String name) {
        this.name = name;
        this.life = 100;
        this.wins = 0;
        this.losses = 0;
    }

    public boolean isAlive() {
        return this.life > 0;
    }

    public abstract void attack(Fighter opponent);

    public void takeDamage(int damage) {
        this.life -= damage;
        if (this.life < 0) {
            this.life = 0;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getWins() {
        return this.wins;
    }

    public int getLosses() {
        return this.losses;
    }

    public void addWin() {
        this.wins++;
    }

    public void addLoss() {
        this.losses++;
    }

    public String toString() {
        return this.name + " (Life: " + this.life + ")";
    }
}
