package 继承和多态;

import java.util.Scanner;

/**
 * @ClassName TestPointV2
 * @Description TODO
 * @Author Atl212
 * @Date 2021/4/11 15:33
 * @Version 1.0
 **/
public class TestPointV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the coordinates of p23:");
        double p23x = sc.nextDouble();
        double p23y = sc.nextDouble();
        Point2DV1 p23 = new Point2DV1(p23x, p23y);

        System.out.println("Please enter the coordinates of p31:");
        double p31x = sc.nextDouble();
        double p31y = sc.nextDouble();
        double p31z = sc.nextDouble();
        Point3DV1 p33 = new Point3DV1(p31x, p31y, p31z);

        System.out.println("Please enter the coordinates of p24:");
        double p24x = sc.nextDouble();
        double p24y = sc.nextDouble();
        double p24z = sc.nextDouble();
        sc.close();
        // The reference of the parent class refers to the object of the subclass.
        //Point2DV1 p24 = new Point3DV1(p24x, p24y, p24z); 定义了一个2D类但是运行时不会判断实际类型的吗？
        Point3DV1 p24 = new Point3DV1(p24x, p24y, p24z);

        System.out.println("Does " + p23 + " coincide with " + p33 + "? -- " + p23.equals(p33));
        System.out.println("Does " + p33 + " coincide with " + p23 + "? -- " + p33.equals(p23));
        System.out.println("Does " + p33 + " coincide with " + p24 + "? -- " + p33.equals(p24));
        System.out.println("Does " + p24 + " coincide with " + p33 + "? -- " + p24.equals(p33));
        System.out.println("Does " + p23 + " coincide with " + p24 + "? -- " + p23.equals(p24));
        //为什么这东西会TM的跳到2D的equals方法里面？？ 这他妈不是实例方法吗 怎么变成静态的重载了
        //这也太魔幻了吧 重载方法的参数居然比实例方法的匹配优先级高？？
        System.out.println("Does " + p24 + " coincide with " + p23 + "? -- " +
                p24.equals(p23));
    }
}
