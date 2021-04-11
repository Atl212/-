package 继承和多态;

import com.sun.source.tree.IfTree;

import java.util.Scanner;

/**
 * @ClassName Point3DV1
 * @Description TODO
 * @Author Atl212
 * @Date 2021/4/11 14:58
 * @Version 1.0
 **/
class Point2DV1{
    //他这个取浮点数会不会自己自动取精确位呢？
    protected double x, y;
    public Point2DV1(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Point2DV1() {
        this(0, 0);
    }
    //返回坐标形式的字符串
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    //判断两个二维点是否重合
    //public boolean equals(Point2DV1 p) {
    @Override
    public boolean equals(Object p) {
        //可不可以直接判断地址等不等？ 但是两个对象的话 似乎不能这么搞
        //如果对象是3D类 那么类型不同直接抛出否定
        if(p instanceof Point3DV1){
            return false;
        }
        //但是如果判断值得话 那前面相等就直接相等了 也没有屌用
        else{
            Point2DV1 pt = (Point2DV1)p;
            return x == pt.x && y == pt.y;
        }

    }
    //求到原点距离
    public double getDistance() {
        return Math.sqrt(x * x + y * y);
    }
    //判断是否是原点
    public boolean isZero() {
        return getDistance() == 0;
    }

}

public class Point3DV1 extends Point2DV1{
    protected double z;

    public Point3DV1(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public Point3DV1() {
    }

    //返回坐标形式的字符串
    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    //判断两个二维点是否重合
    //public boolean equals(Point3DV1 p) {
    @Override
    public boolean equals(Object p) {
        //如果是3D类 那就计算两个值是否相等 并抛出结果
        if(p instanceof Point3DV1){
            Point3DV1 pt = (Point3DV1)p;
            return x == pt.x && y == pt.y && z == pt.z;
        }
        //如果不是3D类 那么类型肯定不相同 那就直接抛出类型不等即可
        return false;
    }

    //求到原点距离
    @Override
    public double getDistance() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    //判断是否是原点
    @Override
    public boolean isZero() {
        return getDistance() == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //不能用数字开头 如2D
        Point2DV1 point2D1, point2D2;

        System.out.println("Please enter the coordinates of p21:");
        //如果输入的截取类型是int 但是输入却输入了double 那么就会超出精度而抛出错误
        //显然 int 4位 是比 double 8位精度是小的 自然就被八位给挤爆了
        //但是如果反过来容许8位的输出精度 但是却输入了4位 那么只要你没把我挤爆 那么久就没有任何问题
        point2D1 = new Point2DV1(sc.nextDouble(), sc.nextDouble());
        point2D2 = new Point2DV1();

        System.out.println("The distance from " + point2D1 + " to the origin is " + point2D1.getDistance());
        System.out.println("Is " + point2D1 + " the origin? -- " + point2D1.isZero());
        System.out.println("Is " + point2D2 + " the origin? -- " + point2D2.isZero());
        System.out.println("Does " + point2D1 + " coincide with " + point2D2 + "? -- " + point2D1.equals(point2D2));

        System.out.println("Please enter the coordinates of p31:");
        Point3DV1 point3D1, point3D2;
        point3D1 = new Point3DV1(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
        point3D2 = new Point3DV1();

        System.out.println("The distance from " + point3D1 + " to the origin is " + point3D1.getDistance());
        System.out.println("Is " + point3D1 + " the origin? -- " + point3D1.isZero());
        System.out.println("Is " + point3D2 + " the origin? -- " + point3D2.isZero());
        System.out.println("Does " + point3D1 + " coincide with " + point3D2 + "? -- " + point3D1.equals(point3D2));

    }

}
