public class Cube extends Shape3D{

    private double cub;

    public Cube(double v){
        this.cub = v;
    }

    public double getVolume() {
        double a = Math.pow(this.cub, 3);
        return a;
    }


    public String getName() {
        String name = "cube";
        return name;
    }


    public double getArea() {
        double b = 6 * (this.cub * this.cub);
        return b;
    }
}
