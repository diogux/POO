package aula07;

class Circle extends Forma{
    private double radius;
    private double perimeter;
    private double area;

    public Circle (double radius, String color) {
        super(color);
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
        return String.format("Raio: %.1f Perímetro: %.1f Área: %.1f Cor: %s", radius, perimeter(), area(), getColor());
    }

    public boolean equals(Forma c){
        if (this == c) return true;
        if (c == null) return false;
        if (getClass() != c.getClass()) return false;
        if (c instanceof Circle) {
            Circle c1 = (Circle) c;
            return radius == c1.radius && getColor() == c1.getColor();
        }      
        return false;
    }

}
