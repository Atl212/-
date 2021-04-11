package 类和对象;

/**
 * @ClassName Fraction
 * @Description TODO
 * @Author Atl212
 * @Date 2021/3/25 11:02
 * @Version 1.0
 **/
public class FenShu {
    private long molecular;// 分子
    private long denominator;// 分母

    public long getMolecular() {
        return molecular;
    }

    public long getDenominator() {
        return denominator;
    }

    //首先判断输入是否合法，然后调用gaibian()这个方法求取最大公约数
    public FenShu(long molecular, long denominator) {
        this.molecular = molecular;
        if (denominator == 0) {
            System.out.print("分母不能为零");
        } else {
            this.denominator = denominator;
        }
        gaibian();
    }

    //求最大公约数
    private FenShu gaibian() {
        long gcd = this.gYueShu(this.molecular, this.denominator);
        //这里进行约分
        this.molecular /= gcd;
        this.denominator /= gcd;
        //返回约分后的分数
        return this;
    }

    /**
     * 最大公约数
     *
     * @param a
     * @param b
     * @return
     */
    private static long gYueShu(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        long gyueshu = a;
        return gyueshu;
    }

    /**
     * 加法
     *
     * @param second
     * @return
     */
    public FenShu add(FenShu fenShu) {
        //返回两个分数相加的结果
        return new FenShu(this.molecular * fenShu.denominator
                + fenShu.molecular * this.denominator, this.denominator
                * fenShu.denominator);
    }

    /**
     * 减法
     *
     * @param second
     * @return
     */
    public FenShu subtraction(FenShu fenShu) {
        return new FenShu(this.molecular * fenShu.denominator
                - fenShu.molecular * this.denominator, this.denominator
                * fenShu.denominator);
    }

    /**
     * 乘法
     *
     * @param second
     * @return
     */
    public FenShu multiplication(FenShu fenShu) {
        return new FenShu(this.molecular * fenShu.molecular, this.denominator
                * fenShu.denominator);
    }

    /**
     * 除法
     * @param fenShu
     * @return
     */
    public FenShu division(FenShu fenShu){
        return new FenShu(this.molecular * fenShu.denominator,
                this.denominator * fenShu.molecular);

    }
    /**
     * toString()方法打印输出
     */
    @Override
    public String toString() {
        return "运算结果 [" + molecular + "/" + denominator + "]";
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FenShu a = new FenShu(1, 2);
        FenShu b = new FenShu(2, 4);
        System.out.println("加法"+a.add(b));
        System.out.println("减法"+a.subtraction(b));
        System.out.println("乘法"+a.multiplication(b));
        System.out.println("除法"+a.division(b));
    }
}
