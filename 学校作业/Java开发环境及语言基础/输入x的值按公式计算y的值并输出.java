package Java开发环境及语言基础;

/**
 * @ClassName one2
 * @Description TODO
 * @Author Atl212
 * @Date 2021/3/4 10:05
 * @Version 1.0
 **/
public class 输入x的值按公式计算y的值并输出 {
    public static void main(String[] args) {
        double x = 4, y;

        y = ((1 - Math.pow(x, 3)) / ( (-1 - Math.pow(x, 3)) * (- Math.pow(x, 2) + Math.pow(x, 0.5) + 10))) * 2 * x * x;

        //System.out.println("x=%.1f, y=%f", x, y);
        System.out.printf("x=%.1f,y=%.15f", x, y);
    }
}
