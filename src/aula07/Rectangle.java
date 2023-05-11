package aula07;

class Rectangle extends Forma {
    private double side1;
    private double side2;
    private double perimeter;
    private double area;

    public Rectangle (double side1, double side2, String color) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        assert this.side1 > 0: "O comprimento deve ser positivo!";
        assert this.side2 > 0: "A largura deve ser positivo!";
    }

    public double perimeter (){
        this.perimeter = side1*2 + side2*2;
        return this.perimeter;

    }
    public double area() {
        this.area = side1*side2;
        return this.area;
    
    }

    public String toString(){
        return String.format("Comprimento: %.1f Largura: %.1f Perímetro: %.1f Área: %.1f Cor: %s", side1, side2, perimeter(), area(), getColor());
    }

    public boolean equals(Forma r){
        if (this == r) return true;
        if (r == null) return false;
        if (getClass() != r.getClass()) return false;
        if (r instanceof Rectangle) {
            Rectangle r1 = (Rectangle) r;
            return side1 == r1.side1 && side2 == r1.side2 && getColor() == r1.getColor();
        }      
        return false;
    }
    
}
