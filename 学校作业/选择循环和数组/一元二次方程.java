package 选择循环和数组;

import java.util.Scanner;

/**
 * @ClassName equation
 * @Description TODO
 * @Author Atl212
 * @Date 2021/3/5 20:22
 * @Version 1.0
 **/
public class 一元二次方程 {

    public static void main(String[] args) {
        int a, b, c;

        Scanner input = new Scanner(System.in);

        //a = input.nextInt(); why can't a attribute input?
        //Because u are not create a main!!
        a = input.nextInt();
        b = input.nextInt();
        c = input.nextInt();

        double triangle = b * b - 4 * a * c;

        if(a == 0 && b == 0){
            if(a == 0 && b == 0 && c == 0){
                System.out.printf("There are infinite solutions.\n\n");
            }
            else{
                System.out.printf("The equation has no solution.\n\n");
            }
        }
        else {
            //two roots
            if (triangle > 0) {
                double x1, x2;
                x1 = ((-b) + Math.pow(triangle, .5)) / (2. * a);
                x2 = ((-b) - Math.pow(triangle, .5)) / (2. * a);

                System.out.printf("The equation has real roots, x1 = %f,  x2 = %f\n",
                        x1, x2);
            }
            //one root
            else if (triangle == 0) {
                double x = ((-b) / (2. * a));

                System.out.printf("The equation has real roots, x1 = %f,  x2 = %f\n",
                        x, x);
            }
            //complex roots
            else if (triangle < 0) {
                double α, β;

                α = Math.abs((-b) / (2. * a));
                β = Math.abs(Math.pow(-triangle, .5) / (2. * a));

                String x1, x2;

                x1 = String.format("x1 = -%f + %fi", α, β);
                x2 = String.format("x2 = -%f - %fi", α, β);

                System.out.printf("The equation has complex roots, %s,  %s\n",
                        x1, x2);
            }
        }


    }

}
