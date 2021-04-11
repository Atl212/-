package 类和对象;

import java.util.Scanner;

/**
 * @ClassName Cylinder
 * @Description TODO
 * @Author Atl212
 * @Date 2021/4/3 12:18
 * @Version 1.0
 **/
public class Cylinder {
    double x, y, z, radius, height;

    public double getX() {
        return x;
    }

    public Cylinder(double x, double y, double z, double radius, double height) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.radius = radius;
        this.height = height;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
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

    public double getFloorage(){
        return Math.PI * radius * radius;
    }

    public double getSuperficialArea(){
        return getFloorage() * 2 + 2 * Math.PI * radius * height;
    }

    public double getVolume(){
        return getFloorage() * height;
    }

    public double getCylinderCenter(){
        return height / 2 + z;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the x, y and z coordinates of the floor circle center, the radius and height of the cylinder:");
        Cylinder c = new Cylinder
                (sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());

        System.out.printf("Floorage=%.3f\n", c.getFloorage());
        System.out.printf("Superficial area=%.3f\n", c.getSuperficialArea());
        System.out.printf("Volume=%.3f\n", c.getVolume());
        System.out.printf("Cylinder center coordinates are (%.3f,%.3f,%.3f)\n", c.getX(), c.getY(), c.getCylinderCenter());
    }
}
