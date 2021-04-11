package 选择循环和数组;

import java.util.Scanner;

/**
 * @ClassName 输入一个矩阵_输出其中的鞍点及其位置
 * @Description TODO
 * @Author Atl212
 * @Date 2021/3/11 10:45
 * @Version 1.0
 **/
public class 输入一个矩阵_输出其中的鞍点及其位置 {
    public static void main(String[] args) {

        //有些东西最好在草稿纸写一写
        //工作记忆是有限的！

        //关于断点可以先判断是哪一个部分有问题，再对具体的部位进行单步步入
        //而没有必要一进去就单步步入

        //赋初值
        int row, column, r, c, number = 0;
        Boolean findOut;

        Scanner input = new Scanner( System.in);
        row = input.nextByte();
        column = input.nextByte();

        int[][] group = new int[row][column];


        for(r = 0; r < row; r++){

            for(c = 0; c < column; c++){
                group[r][c] = input.nextByte();
            }
        }

        System.out.printf("%d %d\n", row, column);
        for(r = 0; r < row; r++){

            for(c = 0; c < column; c++){
                System.out.printf("%d ", group[r][c]);
            }

            System.out.print("\n");
        }

        //找出鞍点
        for(r = 0; r < row; r++){
            //findOut = true; 每次重新赋值应该放在双重循环内的每次循环内
            //所以重新赋值应该判断是哪一层重新赋值 是在外循环重新赋值 还是每次子循环都要重新赋值

            for(c = 0; c < column; c++){
                findOut = true;

                findOut = chuli(group, row, column, r, c);

                if (findOut){
                    System.out.printf("mat[%d][%d]=%d is saddle point!\n", r, c, group[r][c]);
                    ++number;
                }
            }

            /*
            应该每判断一个点就决定是否输出一次，所以应该放在双重循环的内部
            双重循环的最后一次c会变成 4 所以如果放在后面就会导致越界
            if (findOut){
                System.out.printf("mat[%d][%d]=%d is saddle point\n", r, c, group[r][c]);
            }*/
        }

        if(number == 0){
            System.out.print("There is no saddle point in the matrix!\n");
        }

    }

    public static boolean chuli(int [][]group,int row,int column, int r, int c){

        for(int t = 0; t < column; ++t){

            //if(group[r][c] < group[r][t])如果遍历到属于自己的元素 例如 8 < 8 则
            if(group[r][c] < group[r][t]){
                return false;
            }

        }

        for(int t = 0; t < row; ++t) {

            //if (group[r][c] > group[t][r]) 感觉复制粘贴不带脑子
            if (group[r][c] > group[t][c]) {
                return false;
            }

        }

        return true;
    }
}
