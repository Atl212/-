package 类和对象;

import java.util.Scanner;

/**
 * @ClassName Cone
 * @Description TODO
 * @Author Atl212
 * @Date 2021/3/25 10:04
 * @Version 1.0
 **/
public class Cone {
    private double radius, height;

    //构造方法
    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public Cone() {
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    //圆锥的底面积
    public static double getArea(double radius){
        double area;

        area = Math.PI * radius * radius;

        return area;
    }

    //圆锥的体积
    public static double getVolume(double height, double area){
        double volume;

        volume = (1.0 / 3) * area * height;

        return  volume;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Cone c1 = new Cone(input.nextInt(), input.nextInt());

        System.out.printf("The floorage of c1 is %.3f, and the volume is %.3f\n"
                , getArea(c1.getRadius()), getVolume(c1.getHeight(), getArea(c1.getRadius())));

        Cone c2 = new Cone();

        c2.setRadius(c1.getRadius() + 1);
        c2.setHeight(c1.getHeight() + 2);

        System.out.printf("The floorage of c2 is %.3f, and the volume is %.3f\n"
                , getArea(c2.getRadius()), getVolume(c2.getHeight(), getArea(c2.getRadius())));
    }

}
