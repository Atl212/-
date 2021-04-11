package 类和对象;

import java.util.Scanner;

/**
 * @ClassName Rectangle
 * @Description TODO
 * @Author Atl212
 * @Date 2021/3/17 11:39
 * @Version 1.0
 **/
public class Rectangle {
    private double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public Rectangle(double length) {
        this.length = length;
        this.width = this.length;
    }

    //public Rectangle() {} 当没有其他构造方法时会系统默认一个初始化的构造方法
    //但如果已经存在其他构造方法 就不会默认一个无参的构造方法
    public Rectangle() {
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if(length < 0){
            System.out.print("NMSL\n");
            System.exit(-1);
        }
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if(width < 0){
            System.out.print("NMSL\n");
            //return; 下面这个才是退出程序的函数
            System.exit(-1);
        }
        this.width = width;
    }

}

class TestRectangle{
    public static void main(String[] args) {
        double len, wid, side;

        Scanner input = new Scanner( System.in);

        //也许next()可以理解成c语言中的格式化输入
        //而知识需要先创建一个Scanner类的对象 才能使用这个函数
        System.out.print("Please enter the length and width of rectangle r1:\n");
        len = input.nextDouble();
        wid = input.nextDouble();

        System.out.print("Please enter the side length of square r2:\n");
        side = input.nextDouble();

        Rectangle r1 = new Rectangle(len, wid);

        Rectangle r2 = new Rectangle(side);

        Rectangle r3 = new Rectangle();

        //因为类成员为私有 不能直接用成员运算符获取 需要get()方法
        System.out.printf("The perimeter of r1 is %.1f\n", perimeter(r1.getLength(), r1.getWidth()));
        System.out.printf("The perimeter of r2 is %.1f\n", perimeter(r2.getLength(), r2.getWidth()));
        System.out.printf("The perimeter of r3 is %.1f\n", perimeter(r3.getLength(), r3.getWidth()));

        //convert
        r3.setLength(r1.getLength());
        r3.setWidth(r1.getWidth());

        System.out.printf("After modification, the perimeter of r3 is %.1f\n", perimeter(r3.getLength(), r3.getWidth()));

    }

    public static double perimeter(double l, double w){
        double p;

        p = (l + w) * 2;

        return p;
    }
}
