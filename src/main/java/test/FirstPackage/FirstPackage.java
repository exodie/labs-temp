package test.FirstPackage;

public class FirstPackage {
    private int a1;
    private int a2;

    public int getA1() {
        return a1;
    }

    public void setA1(int a1) {
        this.a1 = a1;
    }

    public int getA2() {
        return a2;
    }

    public void setA2(int a2) {
        this.a2 = a2;
    }

    public FirstPackage() {
        System.out.println("FirstPackage constructor initialization success");
    }

    public int sum() {
        return this.a1 + this.a2;
    }
}
