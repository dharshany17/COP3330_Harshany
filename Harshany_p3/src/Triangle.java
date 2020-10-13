public class Triangle extends Shape2D{

    private double tri;

    public Triangle(double t, double r){
        this.tri = t * r;
    }
    public double getArea() {
        double a = this.tri / 2;
        return a;
    }


    public String getName() {
        String name = "triangle";
        return name;
    }
}
