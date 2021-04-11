package 选择循环和数组;

import java.util.Scanner;

/**
 * @ClassName 求一批数据的最大值_最小值_以及掐头去尾之后的平均值
 * @Description TODO
 * @Author Atl212
 * @Date 2021/3/8 15:13
 * @Version 1.0
 **/
public class 求一批数据的最大值_最小值_以及掐头去尾之后的平均值 {
    public static void main(String[] args) {
        int n, t = 0, max, min, plus = 0;
        double ave;

        //assign
        Scanner input = new Scanner(System.in);
        n = input.nextByte();

        //数组的数据是在堆内存内生产 再赋值地址给数组
        //不存在栈内存内建立数组
        int [] group = new int[n];

        while (t != n){
            group[t] = input.nextByte();
            t++;
        }

        //find max and min
        //reset
        max = group[0];
        min = group[0];

        t = 0;
        while(t != n){
            if(max < group[t]){
                max = group[t];
            }
            ++t;
        }

        t = 0;
        while(t != n){
            if(min > group[t]){
                min = group[t];
            }
            ++t;
        }

        //compute
        t = 0;
        while (t != n){
            //
            plus += group[t];
            ++t;
        }

        plus -= (max + min);

        //ave = (plus * .0) / (n - 2);
        ave = (plus * 1.0) / (n - 2);

        System.out.printf("max = %d\n" +
                          "min = %d\n" +
                          "ave = %f\n", max, min, ave);


    }
}
