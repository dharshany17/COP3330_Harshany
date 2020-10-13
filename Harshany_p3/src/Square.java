public class Square extends Shape2D{

    private double squa;

    public Square(double sq){
        this.squa = sq;
    }
    public double getArea() {
      double a = this.squa * this.squa;
        return a;
    }


    public String getName() {
        String name = "square";
        return name;
    }
}
