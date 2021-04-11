package Java开发环境及语言基础;

/**
 * @ClassName one3
 * @Description TODO
 * @Author Atl212
 * @Date 2021/3/4 10:20
 * @Version 1.0
 **/
public class 摄氏度与华氏度的转换 {
    public static void main(String[] args) {
        double c;
        double f = 100;

        c = (5.0 / 9) * (f - 32);

        System.out.printf("%.1f fahrenheit degree equal %.14f centigrade\n", f, c);
    }
}
