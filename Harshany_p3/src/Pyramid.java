public class Pyramid extends Shape3D{

    private double p;
    private double y;
    private double r;

    public Pyramid(double l, double w, double h){
        this.p = l;
        this.y = w;
        this.r = h;
    }

    public double getVolume() {
        double a = (this.p * this.y * this.r)/3;
        return a;
    }


    public String getName() {
        String name = "pyramid";
        return name;
    }


    public double getArea() {
        double b = (this.p * this.y);
        double c = (this.p * (Math.sqrt((Math.pow(this.y/2, 2)) + (Math.pow(this.r, 2)))));
        double d = (this.y * (Math.sqrt((Math.pow(this.p/2, 2)) + (Math.pow(this.r, 2)))));
        double e = b + c + d;

        return e;
    }
}
