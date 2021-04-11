package 类和对象;

import java.util.Objects;
import java.util.Scanner;

/**
 * @ClassName Fraction
 * @Description TODO
 * @Author Atl212
 * @Date 2021/3/28 17:24
 * @Version 1.0
 **/
public class Fraction {
    //成员
    int numer, deno;

    public Fraction(int numer, int deno) {
        this.numer = numer;
        this.deno = deno;
    }

    public Fraction() {
    }

    //辗转相除法 得到最大公约数
    public static int 辗转相除法(int m, int n){
        int temp;

        if (m < n){
            temp = m;
            m = n;
            n = temp;
        }

        temp = m % n ;

        while (temp != 0){
            //temp = m % n; 这个怎么会放在前面呢，这贴着前面的不就约分两次了吗

            m = n;

            n = temp;

            temp = m % n;
        }

        return n;
    }

    //约分 分子分母同时除以最大公约数
    public static void reduce(Fraction frac){

        //约分前先决定分数的负号
        isMinus(frac);

        //如果分子为0直接跳过
        if(frac.numer == 0){
            return;
        }

        //得到分子分母的最大公约数
        int n = 辗转相除法(frac.deno, frac.numer);

        //java的求余会保留负号
        //如果求余得个负数 那么会约分后结果和原结果的负号相反
        //所以要对最大公约数取绝对值
        n = Math.abs(n);

        //分别对分子分母约分
        frac.deno /= n;
        frac.numer /= n;

    }

    //判断分数负号
    public static void isMinus(Fraction frac){
        int sign = 1;

        //当分子分母异号时记录负号
        if (frac.numer * frac.deno < 0){
            sign = -1;
        }

        //对分子分母同时取绝对值
        frac.deno = Math.abs(frac.deno);
        frac.numer = Math.abs(frac.numer);

        //决定分子的符号
        frac.numer *= sign;
    }

    //加法
    //方法头定义了另外的指针或引用指向了内存中同样的地址
    //所以无论时调用主函数还是副函数的引用 都对同一个地址上面的进行了改变
    public static void add(Fraction frac1, Fraction frac2){

        //如果没有参数调入要用无参构造方法初始化对象
        Fraction result = new Fraction();

        //分子的运算 两个分子分别乘以对方的分母再相加
        result.numer = frac1.numer * frac2.deno + frac2.numer * frac1.deno;
        result.deno = frac1.deno * frac2.deno;

        //运算后调用函数对结果进行约分
        reduce(result);

        System.out.print(frac1 +
                " + " + frac2 +
                " = " + result + "\n");

    }

    //减法旧有的写法
    /**
    public static void minus(Fraction frac1, Fraction frac2){
        //得到两个分数分母的公约数和公倍数
        int gongYue = 辗转相除法(frac1.deno, frac2.deno);
        int gongBei = frac1.deno * frac2.deno / gongYue;

        //对分数约分
        reduce(frac1);
        reduce(frac2);

        //化为最简形式后输出运算前的数值
        System.out.print(frac1.numer + "/" + frac1.deno +
                " - " + frac2.numer + "/" + frac2.deno +" = ");

        //分子乘以分母增加的倍数
        frac1.numer = frac1.numer * (gongBei / frac1.deno);
        frac2.numer = frac2.numer * (gongBei / frac2.deno);

        //将数据相加后输出
        //定义并运算相加后的分子数值
        Fraction result = new Fraction(frac1.numer - frac2.numer, gongBei);
        reduce(result);

        System.out.print(result.numer + "/" + result.deno + "\n");

    }*/

    public static void minus(Fraction frac1, Fraction frac2){
        Fraction result = new Fraction();

        //分子的运算 两个分子分别乘以对方的分母再相加
        result.numer = frac1.numer * frac2.deno - frac2.numer * frac1.deno;
        result.deno = frac1.deno * frac2.deno;

        //运算后调用函数对结果进行约分
        reduce(result);

        System.out.print(frac1 +
                " - " + frac2 +
                " = " + result + "\n");
    }

    public static void multiply(Fraction frac1, Fraction frac2){
        Fraction result = new Fraction();

        //分子的运算 两个分子分别乘以对方的分母再相加
        result.numer = frac1.numer * frac2.numer;
        result.deno = frac1.deno * frac2.deno;

        //运算后调用函数对结果进行约分
        reduce(result);

        System.out.print(frac1 +
                " * " + frac2 +
                " = " + result + "\n");
    }

    public static void divide(Fraction frac1, Fraction frac2){
        Fraction result = new Fraction();

        //分子的运算 两个分子分别乘以对方的分母再相加
        result.numer = frac1.numer * frac2.deno;
        result.deno = frac1.deno * frac2.numer;

        //运算后调用函数对结果进行约分
        reduce(result);

        System.out.print(frac1 +
                " / " + frac2 +
                " = " + result + "\n");
    }

    //判断分母不为零
    public static void denoNotAZero(Fraction frac){
        if (frac.deno == 0){
            System.out.print("The denominator cannot be zero!");
            System.exit(-1);
        }
    }

    //除法时分子不为零
    public static void divideNumerNotAZero(Fraction frac2){
        if (frac2.numer == 0){
            System.out.print("Cannot be divided by zero!");
            System.exit(-1);
        }
    }

    //重写toString();
    @Override
    public String toString() {
        if (numer == deno){
            return "1";
        }
        else if(numer == 0){
            return numer + "";
        }
        else {
            return numer + "/" + deno;
        }
    }

    @Override
    //重写的方法类型必须和父类中的方法类型一致
    //不过就算它有返回值 我们随便返回一个也行
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Fraction)) {
            return false;
        }

        Fraction fraction = (Fraction) o;

        return numer == fraction.numer &&
                deno == fraction.deno;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner( System.in);

        System.out.print("Please enter fraction f1:\n");
        Fraction frac1 = new Fraction(input.nextInt(), input.nextInt());
        //denoNotAZero(frac1); 原题目要非常神秘地一个一个判断才算通过

        System.out.print("Please enter fraction f2:\n");
        Fraction frac2 = new Fraction(input.nextInt(), input.nextInt());

        //应该先完成判断再进行后续约分或运算
        //判断分母不能为零
        denoNotAZero(frac1);
        denoNotAZero(frac2);
        //判断除数时分子不能为零
        divideNumerNotAZero(frac2);

        System.out.print(frac1 + " / " + frac2 + "\n");

        //先化简分数为最简形式
        reduce(frac1);
        reduce(frac2);

        //运算并输出
        add(frac1, frac2);
        minus(frac1, frac2);
        multiply(frac1, frac2);
        divide(frac1, frac2);

        //判断两个分数是否相等
        System.out.println(frac1 + " equals " + frac2 +" ? "+frac1.equals(frac2));
    }


}
