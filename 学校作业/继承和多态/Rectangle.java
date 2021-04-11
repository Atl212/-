package 继承和多态;

import java.awt.*;
import java.util.Scanner;

/**
 * @ClassName Rectangle
 * @Description TODO
 * @Author Atl212
 * @Date 2021/4/8 10:01
 * @Version 1.0
 **/
class Rectangle extends Line {
    int width;

    public Rectangle(int length, char symbol, int width) {
        super(length, symbol);
        this.width = width;
    }

    @Override
    public void show() {
        //第一行
        for (int i = 0; i < length; ++i) {
            System.out.print(symbol);
        }
        System.out.println();

        //中间行
        //width决定有多少竖列 length决定有多少横列
        for (int w = 0; w < width - 2; ++w){

            for (int i = 0; i < length; ++i) {
                //当每行的初始和最后一个字符时输出symbol 中间输出空格
                if (i == 0 || i == length - 1){
                    System.out.print(symbol);
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        //末尾行
        for (int i = 0; i < length; ++i) {
            System.out.print(symbol);
        }
        System.out.println();
    }


}

class Line {
    int length;
    char symbol = '*';

    public Line(int length, char symbol) {
        this.length = length;
        this.symbol = symbol;
    }

    public void show() {
        for (int i = 0; i < length; ++i) {
            System.out.print(symbol);
        }
        System.out.println();
    }
}

class TestDrawShape{
    public static void main(String[] args) {
        //这东西要new四个 line 然后再具体赋值实际类型的引用？
        Scanner input = new Scanner( System.in);
        Line[] line = new Line[4];

        System.out.print("Please enter the length and symbol for the first line:\n");
        line[0] = new Line(input.nextByte(), input.next().charAt(0));
        System.out.print("Please enter the length, symbol and width for the first rectangle:\n");
        line[1] = new Rectangle(input.nextByte(), input.next().charAt(0), input.nextByte());
        System.out.print("Please enter the length and symbol for the second line:\n");
        line[2] = new Line(input.nextByte(), input.next().charAt(0));
        System.out.print("Please enter the length, symbol and width for the second rectangle:\n");
        line[3] = new Rectangle(input.nextByte(), input.next().charAt(0), input.nextByte());

        line[0].show();
        line[1].show();
        line[2].show();
        line[3].show();
    }
}