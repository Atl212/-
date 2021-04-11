package 选择循环和数组;

import java.util.Scanner;

/**
 * @ClassName 输入一个3X4的矩阵求其转置及其与转置的乘积并输出
 * @Description TODO
 * @Author Atl212
 * @Date 2021/3/15 15:38
 * @Version 1.0
 **/
public class 输入一个3X4的矩阵求其转置及其与转置的乘积并输出 {
        public static void main(String[] args) {
            int row = 3, column = 4;
            Scanner input = new Scanner(System.in);

            int[][] originalMatrix = new int[row][column];
            int[][] transPose = new int[column][row];
            int[][] matrixMultiplication = new int[row][row];

            //input
            for (int r = 0; r < row; r++) {

                for (int c = 0; c < column; c++) {
                    originalMatrix[r][c] = input.nextByte();
                }
            }

            //output
            System.out.print("Original matrix:\n");
            for (int r = 0; r < row; r++) {

                for (int c = 0; c < column; c++) {
                    System.out.printf("%d\t", originalMatrix[r][c]);
                }

                System.out.print("\n");
            }

            //operation
            for (int r = 0; r < row; r++) {

                for (int c = 0; c < column; c++) {
                    transPose[c][r] = originalMatrix[r][c];
                }

            }

            //output
            System.out.print("Transpose:\n");
            for (int c = 0; c < column; c++) {

                for (int r = 0; r < row; r++) {
                    System.out.printf("%d\t", transPose[c][r]);
                }

                System.out.print("\n");
            }

            //operation
            System.out.print("Matrix multiplication:\n");
            for (int r1 = 0; r1 < row; r1++) {

                for (int r2 = 0; r2 < row; r2++) {
                    matrixMultiplication[r1][r2] = 0;

                    for (int c = 0; c < column; c++) {

                        matrixMultiplication[r1][r2] += originalMatrix[r1][c] * transPose[c][r2];

                    }
                    System.out.printf("%d\t", matrixMultiplication[r1][r2]);
                }

                System.out.print("\n");
            }
        }
    }
