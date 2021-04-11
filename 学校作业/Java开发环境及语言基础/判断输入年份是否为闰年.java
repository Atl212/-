package Java开发环境及语言基础;

import java.util.Scanner;

/**
 * @ClassName one4
 * @Description TODO
 * @Author Atl212
 * @Date 2021/3/4 10:25
 * @Version 1.0
 **/
public class 判断输入年份是否为闰年 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int year = input.nextInt();

        if(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            System.out.println(year + " is leap year!");
        }
        else{
            System.out.println(year + " is not leap year!");
        }
    }
}
