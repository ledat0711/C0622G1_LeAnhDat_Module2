package quadratic_equation;

//[Bài tập] Xây dựng lớp QuadraticEquation (Phương trình bậc hai)
public class QuadraticEquationClass {
    double aNumber;
    double bNumber;
    double cNumber;
    double delta;

    public QuadraticEquationClass() {
    }

    public QuadraticEquationClass(double aNumber, double bNumber, double cNumber) {
        this.aNumber = aNumber;
        this.bNumber = bNumber;
        this.cNumber = cNumber;
        this.delta = Math.pow(this.bNumber, 2) - 4 * this.aNumber * this.cNumber;
    }

    private double getANumber() {
        return this.aNumber;
    }

    private double getBNumber() {
        return this.bNumber;
    }

    private double getCNumber() {
        return this.cNumber;
    }

    public double getDiscriminant() {
        return this.delta;
    }

    public double getRoot1() {
        return (-this.bNumber + Math.sqrt(this.delta)) / (2 * this.aNumber);
    }

    public double getRoot2() {
        return (-this.bNumber - Math.sqrt(Math.sqrt(this.delta))) / (2 * this.aNumber);
    }
}
