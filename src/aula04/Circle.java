package aula04;

public class Circle {
    private double radius;
    private double perimeter;
    private double area;

    public Circle (double radius) {
        this.radius = radius;
        assert this.radius > 0: "O raio deve ser positivo!";
    }

    public double perimeter (){
        this.perimeter = 2*Math.PI * radius;
        return this.perimeter;

    }
    public double area() {
        this.area = Math.PI*Math.pow(radius,2);
        return this.area;
    
    }

    public String toString(){
        return String.format("Raio: %.1f Perímetro: %.1f Área: %.1f", this.radius, this.perimeter(), this.area());
    }

    public boolean equals(Circle c){
        if (c instanceof Circle) {
            Circle c1 = (Circle) c;
            return radius == c1.radius;
        }      
        return false;
    }
}
