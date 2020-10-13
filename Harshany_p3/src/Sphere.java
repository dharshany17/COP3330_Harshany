public class Sphere extends Shape3D{

    private double sph;

    public Sphere(double v){
        this.sph = v;
    }

    public double getVolume() {
        double a = 4 * ((Math.PI *(this.sph * this.sph * this.sph))/3);
        return a;
    }


    public String getName() {
        String name = "sphere";
        return name;
    }


    public double getArea() {
        double b = 4 * (Math.PI *(this.sph * this.sph));
        return b;
    }
}
