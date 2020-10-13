public class Circle extends Shape2D{

    private double circ;

    public Circle(double c){
        this.circ = c;
    }
    public double getArea() {
        double a = Math.PI * (this.circ * this.circ);
        return a;
    }


    public String getName() {
        String name = "circle";
        return name;
    }
}
