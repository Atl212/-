package 类和对象;

import java.io.Closeable;
import java.util.Scanner;

/**
 * @ClassName BMI
 * @Description TODO
 * @Author Atl212
 * @Date 2021/3/25 10:32
 * @Version 1.0
 **/
public class BMI {
    double height, weight;

    void BMI(){}

    public BMI(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    public static double getBMI(double height, double weight){
        double BMI;

        BMI = weight / (height * height);

        return BMI;
    }

    public static String assessBMI(double BMI){
        String[] type = new String[]
                {"Low weight", "Normal weight", "Overweight", "Fat or Obesity"};

        if(BMI < 18.5){
            return type[0];
        }
        else if (18.5 < BMI && BMI < 24){
            return type[1];
        }else if (24 < BMI && BMI < 28){
            return type[2];
        }else{
            return type[3];
        }

    }

    public static void show(double height, double weight){
        System.out.printf
                ("height %.1fm, weight %.1fkg, BMI is %.3f, %s\n",
                        height, weight,  getBMI(height, weight), assessBMI(getBMI(height, weight)));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner( System.in);
        double height, weight;
        System.out.print("Please enter height(m):\n");
        height = input.nextDouble();
        System.out.print("Please enter height(m):\n");
        weight = input.nextDouble();

        BMI bmi = new BMI(height, weight);

        show(bmi.height, bmi.weight);
    }

}
