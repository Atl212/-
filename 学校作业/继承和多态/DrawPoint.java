package 继承和多态;

import java.util.Scanner;

class Point2D {
	protected double x;
	protected double y;

	public Point2D() {
	}

	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return " (" + x + ", " + y + ")";
	}
}

class Point3D extends Point2D {
	protected double z;

	//如果子类要创建空的构造方法 那么父类也得创建一个空的构造方法
	public Point3D() {
		super();
	}

	public Point3D(double x, double y, double z) {
		super(x, y);
		this.z = z;
	}

	@Override
	public String toString() {
		//return String.format("(%f,%f,%f)", x, y, z); 直接格式化%f 就是六位小数定了
		return " (" + x + ", " + y + ", " + z + ")";
	}
}

public class DrawPoint {
	public static void draw(Point2D p[]) {

		for (int i = 0; i < p.length; ++i) {

			if (i % 2 == 0) {
				//System.out.printf("Draw a 2D point: (%.1f, %.1f)\n", p[i].x, p[i].y);
				//感觉这个字符串的输出写错了 如果要我用这样的格式化字符串的方式输出 还要重写toString干什么
				System.out.print("Draw a 2D point:"+ p[i] + "\n");

			}
			else {
				//这个似乎要强制转换吧
				//p[i] = (Point3D)p[i]; 好像不能自己转换给自己
				//可是这个数组的类型都是Point2D类型的

				//那这个都不需要这样写了 只需要声明一个对象 然后把数组中point的对象赋值给这个暂时的对象即可
				/*Point3D pt = new Point3D( );
				pt = (Point3D)p[i];*/

				Point3D pt = (Point3D)p[i];

				//子类转成父类随便转换？ 其实都是地址值如果储存的值的字节相同倒也没有太大问题
				//小推出大似乎确实没什么问题 比如int 到 double 都不会产生什么数据的截断
				//可是如果是 double 转成 int 不久产生截断了吗 那么子类转成父类不产生问题？
				//比如这里的3D 到 2D 能够完全显示
				Point2D ptt = new Point2D();
				System.out.print((ptt instanceof Point2D) + "\n");

				ptt = pt;
				System.out.print((ptt instanceof Point2D) + "\n");
				System.out.print((ptt instanceof Point3D) + "\n");

				System.out.print("Draw a 3D point:"+ pt + "\n");
				System.out.print("Draw a 3D point:"+ ptt + "\n");
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double x, y, z;
		Point2D p[] = new Point2D[4];

		for (int i = 0; i < p.length; ++i) {

			// if ((int) (Math.random() * 100) % 2 == 0) {
			if (i % 2 == 0) {
				System.out.println("Enter x y coordinates: ");
				x = sc.nextDouble();
				y = sc.nextDouble();
				p[i] = new Point2D(x, y);
			}
			else {
				System.out.println("Enter x y z coordinates: ");
				x = sc.nextDouble();
				y = sc.nextDouble();
				z = sc.nextDouble();
				p[i] = new Point3D(x, y, z);
			}
		}
		//不close会怎样
		sc.close();

		draw(p);
	}
}
