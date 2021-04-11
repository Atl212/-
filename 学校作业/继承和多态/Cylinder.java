package 继承和多态;

import java.awt.*;
import java.util.Scanner;

/**
 * @ClassName Cylinder
 * @Description TODO
 * @Author Atl212
 * @Date 2021/4/9 12:19
 * @Version 1.0
 **/

class circle{
    double radius;

    public circle() {
    }

    public circle(double radius) {
        this.radius = radius;
    }

    double getPerimeter(){
        return Math.PI * 2 * radius;
    }

    double getArea(){
        return Math.PI * radius * radius;
    }


}

public class Cylinder extends circle {
    double height;

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    double getSurfaceArea(){
        return 2 * getArea() + getPerimeter() * height;
    }

    double getVol(){
        return getArea() * height;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner( System.in);

        //当输出没有输出提示的时候会就不需要打印字符串提示
        System.out.print("Please enter the coordinates of p1:\n");
        circle cir = new circle(input.nextDouble());
        System.out.print("Please enter the coordinates of p2:\n");
        Cylinder cy = new Cylinder(input.nextDouble(), input.nextDouble());

        System.out.printf("Perimeter:%.3f\n", cir.getPerimeter());
        System.out.printf("Area:%.3f\n", cir.getArea());
        System.out.printf("Surface area:%.3f\n", cy.getSurfaceArea());
        System.out.printf("Volume:%.3f\n", cy.getVol());
    }
}


