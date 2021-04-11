package 选择循环和数组;

import java.util.Scanner;

/**
 * @ClassName two2
 * @Description TODO
 * @Author Atl212
 * @Date 2021/3/8 14:11
 * @Version 1.0
 **/
public class 求余弦函数cosx的近似值 {
    public static void main(String[] args) {
        double x, cos, item = 1;
        int  minus = -1, deno = 2, temp;

        Scanner input = new Scanner(System.in);
        x = input.nextDouble();

        cos = item;

        while(item > 1e-5){

            //reset item
            item = 1;
            temp = deno;

            while(temp > 0) {

                item *= x / temp;

                temp--;
            }

            //assign and change arg
            cos += minus * item;

            minus *= -1;
            deno += 2;
        }

        System.out.printf("%.6f", cos);
    }
}
