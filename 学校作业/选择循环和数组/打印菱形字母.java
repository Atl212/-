package 选择循环和数组;

import java.util.Scanner;

/**
 * @ClassName 打印菱形字母
 * @Description TODO
 * @Author Atl212
 * @Date 2021/3/10 18:14
 * @Version 1.0

&&&A
&&BBB
&CCCCC
DDDDDDD
&CCCCC
&&BBB
&&&A

 **/
public class 打印菱形字母 {
    public static void main(String[] args) {
        //为什么上下三角形改变循环条件有些是 - 1 有些是等于
        //如何理解
        //assign
        int outChar, tempChar;
        int row, blank, temp;

        Scanner input = new Scanner(System.in);

        //如果输入的是D 从A开始 那么就减去A 预期为3 初始值为0
        tempChar = (int)input.next().charAt(0) - 'A';
        outChar = 0;

        //row = (int)input.next().charAt(0) - 'A' + 1;

        //blank = (int)tempChar - 'A' - 1;
        //字符是从1开始“A”，故减去一个不能代表他个数，只能代表他们之间的差值
        //如A到D是四个 D - A是3 即他们的差值
        //而blank并不需要他们的个数如：row 只需要他们的差值 即 - 1
        //但是原本就已经是 - 1了（个数） 所以不需要额外增加 - 1

        //blank = (int)tempChar - 'A';
        //因为前面已经从字符改成数字了 所以这里不需要再减去 'A'
        blank = tempChar;

        //output 上三角形
        //当小于等于D时 字符输出 0 1 2 3
        while(outChar <= tempChar){
            //因为c改为了数字做循环 为了匹配也从c = 'A' 改回数字
            int c = 0;
            temp = 0;

            while (temp != blank){

                System.out.print(" ");
                temp++;
            }

            //while ((int)c <= (int)outChar * 2 - 1)
            //字符的数字并不是从1 2 3 4开始 而是几十几十的
            //所以对字符做乘法 那么会乘得一百多得结果
            //最后一个个累加到指定数字会远远超过预期值

            //while ((int)c <= (int)outChar * 2 - 1)
            //因为第一个outChar = 0 所以2 * 0 = 0 再减去1 就不执行了
            //所以不需要减去1
            while (c <= outChar * 2){
                System.out.printf("%c", outChar + 'A');
                ++c;
            }

            //结束后对变量进行更改
            ++outChar;
            --blank;
            System.out.print("\n");
        }

        //下三角形 2 1 0
        //重新赋初值
        --tempChar;

        //blank = tempChar;
        //blank 应该是比tempChar少一个的
        blank = tempChar - 1;

        while (tempChar >= 0){
            //c = 0; 因为c是在循环内部定义属于局部变量
            //所以在另一个循环内使用需要重新定义
            //int c = tempChar * 2 - 1; 不需要 - 1？
            int c = tempChar * 2;

            //temp = blank;
            temp = blank;

            //while (temp >= 0)
            while (temp > 0){

                System.out.print(" ");
                temp--;
            }

            //while ((int)c >= 0) 2 1 0
            //如果这样写那么跟c >= 0 没有区别
            //因为每循环一次都c--了
            //所以把c的初始化放在循环最开始的地方了
            /**
                while ( c * 2 - 1 >= 0){
                    System.out.printf("%c", tempChar + 'A');
                    --c;
                }
             */
            while ( c >= 0){
                System.out.printf("%c", tempChar + 'A');
                --c;
            }

            //结束后对变量进行更改
            --tempChar;
            ++blank;
            System.out.print("\n");
        }

    }
}
