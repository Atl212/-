package Java开发环境及语言基础;

import java.util.Scanner;

/**
  * @ClassName one6
  * @Description TODO
  * @Author Atl212
  * @Date 2021/3/4 11:15
  * @Version 1.0
  **/
public class 输出姓名的Unicode编码值 {
    public static void main(String[] args) {
        //input string and split
        Scanner input = new Scanner(System.in);

        String name = input.next();
        int number = input.nextInt();

        int i = name.length();
        int j = 0;
        while (j != i) {
            //character convert to Unicode and print
            System.out.printf("the unicode value of %c is %d\n",
                    name.charAt(j), (int) name.charAt(j));
            j++;
        }

        i = name.length();
        j = 0;
        while (j != i) {
            //Unicode plus number. Put new Unicode character
            System.out.printf("the new character is %c = %d\n",
                    name.charAt(j) + number, name.charAt(j) + number );
            j++;
        }
        /**
          * @author Atl212
          * @Description
          * @Date 2021/3/5 17:34
          * @Param [args]
          * @Return one6
         while()循环条件内部必须是布尔值 所以必须通过逻辑判断符号来转换成boolean类型
         while(j-- != 0){ }
         while(j != 0){ j--}
        上面两式的循环变量的运算时刻是两个的差别 可以总结为
         判断 循环条件运算 表达式执行
         判断 表达式执行 循环条件运算
         可以看到 第二个可以让循环内的表达式先一步执行
          **/

    }
}
