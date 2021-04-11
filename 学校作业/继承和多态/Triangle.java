package 继承和多态;

import java.awt.*;
import java.util.Scanner;

/**
 * @ClassName Triangle
 * @Description TODO
 * @Author Atl212
 * @Date 2021/4/5 13:01
 * @Version 1.0
 **/
public class Triangle extends Point{

    //定义父类的对象会怎么用构造方法初始化x y？
    Point T1, T2, T3;

    public boolean isTri(Point T1, Point T2, Point T3){

        //这个继承后调用父类不需要加super的吗
        double distance1 = T1.distance(T2);
        double distance2 = T1.distance(T3);
        double distance3 = T2.distance(T3);


        if((distance1 + distance2 > distance3) &&
                (distance1 + distance3 > distance2) &&
                (distance2 + distance3 > distance1)){
            return true;
        }
        else {
            return false;
        }

    }

    public double getPerimeter(Point T1, Point T2, Point T3){
        double distance1 = T1.distance(T2);
        double distance2 = T1.distance(T3);
        double distance3 = T2.distance(T3);

        return distance1 + distance2 + distance3;
    }

    public double getArea(Point T1, Point T2, Point T3){

        //海伦公式
        double Area, p;
        double distance1 = T1.distance(T2);
        double distance2 = T1.distance(T3);
        double distance3 = T2.distance(T3);

        p = (distance1 + distance2 + distance3) / 2;

        Area = Math.pow((p * (p - distance1) * (p - distance2) * (p - distance3)), 1.0/2);

        return Area;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner( System.in);
        Triangle Tri = new Triangle();

        //也就是说定义了什么对象就用什么构造方法，而不是看它在哪个类里面
        System.out.print("Please enter the coordinates of p1:\n");
        Tri.T1 = new Point(input.nextByte(), input.nextByte());
        System.out.print("Please enter the coordinates of p2:\n");
        Tri.T2 = new Point(input.nextByte(), input.nextByte());
        System.out.print("Please enter the coordinates of p3:\n");
        Tri.T3 = new Point(input.nextByte(), input.nextByte());

        if(Tri.isTri(Tri.T1, Tri.T2, Tri.T3)){
            System.out.printf("Perimeter=%.3f\n", Tri.getPerimeter(Tri.T1, Tri.T2, Tri.T3));
            System.out.printf("Area=%.3f\n", Tri.getArea(Tri.T1, Tri.T2, Tri.T3));
        }
        else {
            System.out.print("Can't form a triangle!\n");
        }
    }
}

