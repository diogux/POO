package aula04;

public class Rectangle {
    private double lenght;
    private double width;
    private double perimeter;
    private double area;

    public Rectangle(double lenght, double width) {
        this.lenght = lenght;
        this.width = width;
        assert this.lenght > 0 && this.width > 0 : "A largura e o comprimento têm de ser positivos!";
    }

    public double perimeter (){
        this.perimeter = 2 * width + 2 * lenght;
        return this.perimeter;

    }
    public double area() {
        this.area = width * lenght;
        return this.area;
    }

    public String toString(){
        return String.format("Comprimento: %.1f Largura: %.1f Perímetro: %.1f Área: %.1f", this.lenght, this.width, this.perimeter(), this.area());
    }

    public boolean equals(Rectangle r){
        if (r instanceof Rectangle) {
            Rectangle r1 = (Rectangle) r;
            return area == r1.area && perimeter == r1.perimeter;
        }      
        return false;
    }
}
