package 类和对象;

import java.text.Format;
import java.util.Objects;
import java.util.Scanner;

/**
 * @ClassName Complex
 * @Description TODO
 * @Author Atl212
 * @Date 2021/3/31 18:56
 * @Version 1.0
 **/
public class Complex {
    //好像虽然它private 但是调用的时候会自动写成 this.real.getReal
    //看下面的代码都没有用到get或set方法
    private double real, img;

    public Complex(double real, double img) {
        this.real = real;
        this.img = img;
    }

    public Complex() {
        this(0, 0);
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImg(double img) {
        this.img = img;
    }

    public double getReal() {
        return real;
    }

    public double getImg() {
        return img;
    }

    public void reset(double real, double img) {
        this.real = real;
        this.img = img;
    }

    @Override
    public String toString() {

        //实根复根都为零
        if(real == 0 && img == 0){
            return "(0.0)";
        }
        //复根为零输出实根
        else if(img == 0){
            return String.format("(%.1f)", real);
        }
        //实根为零输出复根
        else if (real == 0){
            return String.format("(%.1fi)", img);
        }
        //如果没有根为零 判断不同地复根符号并输出
        //好像不知道为什么它不能像eclipse那样if elseif 后解 if else
        //只能像现在这样都是else if 平行下来
        //不过本质上 eclipse那种分割后接if else的用法跟else if用法都是平行的类似的
        else if (img > 0){
            return String.format("(%.1f%+.1fi)", real, img);
        }
        else {
            return String.format("(%.1f%.1fi)", real, img);
        }
    }

    public String toSpecialString() {

        //如果结果是未定式
        if (Double.isNaN(real) && Double.isNaN(img)){
            return "(NaN)";
        }
        //实根复根都为零
        else if(real == 0 && img == 0){
            return "(0.000)";
        }
        //复根为零输出实根
        else if(img == 0){
            return String.format("(%.3f)", real);
        }
        //实根为零输出复根
        else if (real == 0){
            return String.format("(%.3fi)", img);
        }
        else if (img > 0){
            return String.format("(%.3f%+.3fi)", real, img);
        }
        else {
            return String.format("(%.3f%.3fi)", real, img);
        }
    }

    @Override
    public boolean equals(Object o) {
        if(this == o){
             return true;
        }
        if(!(o instanceof Complex)){
        return false;
        }
        Complex complex = (Complex) o;
        return Double.compare(complex.real, real) == 0 &&
                Double.compare(complex.img, img) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(real, img);
    }

    // (a+bi)+(c+di)=(a+c)+(b+d)i
    public Complex add(Complex c) {
        double real = this.real + c.real;
        double img = this.img + c.img;
        return new Complex(real, img);
    }

    // (a+bi)-(c+di)=(a-c)+(b-d)i
    public Complex sub(Complex c) {
        double real = this.real - c.real;
        double img = this.img - c.img;
        return new Complex(real, img);
    }

    // (a+bi)*(c+di)=(a*c-b*d)+(b*c+a*d)i
    public Complex mul(Complex c) {
        double real = this.real * c.real - this.img * c.img;
        double img = this.real * c.img + this.img * c.real;
        return new Complex(real, img);
    }

    // (a+bi)/(c+di)=(a*c+b*d)/(c*c+d*d) +((b*c-a*d)/(c*c+d*d))i
    public Complex div(Complex c) {
        Complex ret = new Complex();
        ret.real = this.real * c.real + this.img * c.img;
        ret.img = this.img * c.real - this.real * c.img;
        ret.real /= Math.pow(c.getModulus(),2);
        ret.img /= Math.pow(c.getModulus(),2);
        return ret;
    }

    // get |a+bi|
    public double getModulus() {
        double result;
        result = Math.pow(this.real * this.real + this.img * this.img, 1./2);
        return result;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Complex c1, c2, c3, ret;
        c1 = new Complex(0, 0);
        c2 = new Complex(0, 0);

        double r1, i1, r2, i2, r3, i3;
        System.out.println("Enter complex c1:");
        r1 = sc.nextDouble();
        i1 = sc.nextDouble();
        c1.reset(r1, i1);

        System.out.println("Enter complex c2:");
        r2 = sc.nextDouble();
        i2 = sc.nextDouble();
        c2.reset(r2, i2);

        System.out.println("Enter complex c3:");
        r3 = sc.nextDouble();
        i3 = sc.nextDouble();
        c3 = new Complex(r3, i3);

        ret = c1.add(c2);
        System.out.println(c1 + " + " + c2 + " = " + ret.toSpecialString());

        ret = c1.sub(c2);
        System.out.println(c1 + " - " + c2 + " = " + ret.toSpecialString());

        ret = c1.mul(c2);
        System.out.println(c1 + " * " + c2 + " = " + ret.toSpecialString());

        ret = c1.div(c2);
        System.out.println(c1 + " / " + c2 + " = " + ret.toSpecialString());

        System.out.println(c1 + " == " + c2 + " ? " + c1.equals(c2));
        System.out.println(c1 + " == " + c3 + " ? " + c1.equals(c3));
        System.out.println(c2 + " == " + c3 + " ? " + c2.equals(c3));

        sc.close();

    }
}
