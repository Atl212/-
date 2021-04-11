
import java.util.Scanner;
/**
 * @ClassName one5
 * @Description TODO
 * @Author Atl212
 * @Date 2021/3/4 10:34
 * @Version 1.0
 **/
public class 求圆锥体的底面积和体积 {
    /**
     double r, h, S, V;
     String string;

     Scanner input = new Scanner(System.in);

     r = Double.valueOf(input.next());
     h = Double.valueOf(input.next());

     S = Math.PI * Math.pow(r, 2);
     V = (1.0 / 3) * h * S;

     System.out.printf("basearea=%f,volume=%f", S, V);
     **/
    public static void main(String[] args) {
        double r, h, S, V;

        Scanner input = new Scanner(System.in);

        r = input.nextDouble();
        h = input.nextDouble();
        S = Math.PI * Math.pow(r, 2);
        V = (1.0 / 3) * h * S;

        System.out.printf("basearea=%f,volume=%f", S, V);
    }
}
