package 选择循环和数组;

import com.sun.tools.javac.Main;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

/**
 * @ClassName 输出空心的等腰三角形
 * @Description TODO
 * @Author Atl212
 * @Date 2021/3/8 14:36
 * @Version 1.0
 **/
/**

&&&&*
&&&*&*
&&*&&&*
&*&&&&&*
*********

  **/

public class 输出空心的等腰三角形 {
    public static void main(String[] args) {

        //assign
        int row, last, blank1, blank2 = 1, first;

        Scanner input = new Scanner(System.in);
        row = input.nextByte();
        last = row * 2 - 1;

        blank1 = row - 1;
        first = row;

        //output
        //first row
        if (row == first){

            while (blank1 != 0) {
                System.out.print(" ");
                blank1--;
            }

            System.out.print("*\n");
        }

        --row;

        //included blank row
        while (row != 1){

                blank1 = row - 1;

                //store blank2 int this time
                int temp = blank2;
                blank2 += 2;

                //blank1
                while (blank1 != 0){
                    System.out.print(" ");
                    blank1--;
                }

                //*
                System.out.print("*");

                //blank2
                while (temp != 0) {
                    System.out.print(" ");
                    temp--;
                }

                //*
                System.out.print("*\n");


            row--;
        }

        //last row
        while (last != 0){
            System.out.print("*");
            --last;
        }

    }
}
