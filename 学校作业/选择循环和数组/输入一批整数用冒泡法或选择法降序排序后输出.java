package 选择循环和数组;

import java.util.Scanner;

/**
 * @ClassName 输入一批整数用冒泡法或选择法降序排序后输出
 * @Description TODO
 * @Author Atl212
 * @Date 2021/3/8 15:38
 * @Version 1.0
 **/
public class 输入一批整数用冒泡法或选择法降序排序后输出 {
    public static void main(String[] args) {
        Scanner input = new Scanner( System.in);
        int n = input.nextInt(), t = 0;

        int[] group = new int[n];

        while (t != n){
            group[t] = input.nextInt();
            ++t;
        }

        //reset
        t = 0;

        //Before
        System.out.printf("Before ordering:\n");
        while (t != n){
            System.out.printf("%d ", group[t]);
            ++t;
        }
        System.out.print("\n");


        //reset
        t = 0;

        //After
        //Sort
        bubbleSort(n, group);

        //output
        System.out.printf("After ordering:\n");
        while (t != n){
            System.out.printf("%d ", group[t]);
            ++t;
        }
        System.out.print("\n");
    }

    public static void bubbleSort(int n, int[] g) {

        for (int j = 0; j < n; ++j){


            //for (int k = j; k < n - 1; ++k)冒泡的下一次初始位置还是从0号位置开始的
            for (int k = 0; k < n - 1; ++k){

                if (g[k] < g[k+1]){
                    int t = g[k];
                    g[k] =g[k+1];
                    g[k+1] = t;
                }

            }

            /*int t = 0;
            while ( t != n){
                System.out.printf("%d ", g[t]);
                ++t;
            }
            System.out.print("\n");*/
        }


    }
}
