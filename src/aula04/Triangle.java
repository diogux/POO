package aula04;
import java.util.Arrays;

public class Triangle {
    private double side1;
    private double side2;
    private double side3;
    private double perimeter;
    private double area;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        assert this.side1 > 0 && this.side2 > 0 && this.side3 > 0 : "Todos os sides têm de ser positivos!";

        

        

        if (this.side3 >= this.side1 + this.side2 || this.side2 >= this.side1 + this.side3 || this.side1 >= this.side2 + this.side3){
            System.out.println("Não é possível criar um triângulo com esses lados.");
        }
    }
        public double getPerimeter(){
            this.perimeter = side1 + side2 + side3;
            return this.perimeter;

        }
        public double getArea() {
            double p = this.perimeter / 2;
            this.area = Math.sqrt(p*(p - this.side1)*(p-this.side2)*(p-this.side3));
            return this.area;
        
        }

        public String toString(){
            return String.format("Lado 1: %.1f Lado 2: %.1f Lado 3: %.1f Perímetro: %.1f Área: %.1f", this.side1, this.side2, this.side3, this.getPerimeter(), this.getArea());
        }

        public boolean equals(Triangle t){
            if (t instanceof Triangle) {
                Triangle t1 = (Triangle) t;
                double[] sides = {side1, side2, side3};
                double[] sides1 = {t1.side1, t1.side2, t1.side3};
                Arrays.sort(sides);
                Arrays.sort(sides1);
                return Arrays.equals(sides, sides1);
            }      
            return false;
        }
}
