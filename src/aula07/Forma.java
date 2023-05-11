package aula07;
import java.util.ArrayList;
import java.util.List;

public abstract class Forma {
    private String color;
    public abstract double perimeter();
    public abstract double area();
    public abstract String toString();
    public abstract boolean equals(Forma f);

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Forma(String color) {
        this.color = color;
    }

    //menu para testar

    public static void main(String[] args) {
        List<Forma> formas = new ArrayList<>();
        formas.add(new Rectangle(2, 3, "red"));
        formas.add(new Rectangle(2, 3, "red"));
        formas.add(new Triangle(2, 3, 4, "blue"));
        formas.add(new Triangle(2, 3, 4, "blue"));

        for (Forma f : formas) {
            System.out.println(f);
        }
        System.out.println(formas.get(0).equals(formas.get(1)));
        System.out.println(formas.get(2).equals(formas.get(3)));

    
}
}

