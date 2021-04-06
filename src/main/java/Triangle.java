import static java.lang.Math.sqrt;

public class Triangle {
    public Double d;

    public Triangle(double a, double b, double c) {
        if ((a + b > c) && (a + c > b) && (c + b > a)) {
            d = calculateTriangleSquare(a, b, c);
        }
    }

    public Double calculateTriangleSquare(double a, double b, double c) {
        Double p = (a + b + c) / 2;
        Double s = sqrt(p * (p - a) * (p - b) * (p - c));
        return s;
    }
}
