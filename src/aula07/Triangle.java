package aula07;
import java.util.Arrays;

class Triangle extends Forma {
    private double side1;
    private double side2;
    private double side3;
    private double perimeter;
    private double area;

    public Triangle (double side1, double side2, double side3, String color) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        assert this.side1 > 0: "O lado 1 deve ser positivo!";
        assert this.side2 > 0: "O lado 2 deve ser positivo!";
        assert this.side3 > 0: "O lado 3 deve ser positivo!";
    }

    public double perimeter (){
        this.perimeter = side1 + side2 + side3;
        return this.perimeter;

    }
    public double area() {
        double p = perimeter()/2;
        this.area = Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
        return this.area;
    
    }

    public String toString(){
        return String.format("Lado 1: %.1f Lado 2: %.1f Lado 3: %.1f Perímetro: %.1f Área: %.1f Cor: %s", side1, side2, side3, perimeter(), area(), getColor());
    }

    public boolean equals(Forma r){
        if (this == r) return true;
        if (r == null) return false;
        if (getClass() != r.getClass()) return false;
        if (r instanceof Triangle) {
            Triangle t1 = (Triangle) r;
            double[] sides = {side1, side2, side3};
            double[] sides1 = {t1.side1, t1.side2, t1.side3};
            Arrays.sort(sides);
            Arrays.sort(sides1);
            return Arrays.equals(sides, sides1);
        }      
        return false;
    }
    
    
}
