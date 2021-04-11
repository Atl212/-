package 选择循环和数组;

import java.util.Calendar;
import java.util.Scanner;

/**
 * @ClassName 输入一个日期_输出该日期的生肖_月历和星期
 * @Description TODO
 * @Author Atl212
 * @Date 2021/3/17 11:40
 * @Version 1.0
 **/
public class 输入一个日期_输出该日期的生肖_月历和星期 {
        public static void main(String[] args) {
            //value assign
            int year, month, day;

            String[] zodiac = new String[]
                    {"Monkey", "Rooster", "Dog", "Pig", "Rat", "OX", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Sheep"};
            String[] week = new String[]
                    {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

            Scanner input = new Scanner(System.in);

            //String [] number = new String[3];
            //分割后的数组自动在堆内创建了对象 所以不需要额外地创建新对象
            String [] number = input.next().split("-");

            year = Integer.parseInt(number[0]);
            month = Integer.parseInt(number[1]);
            day = Integer.parseInt(number[2]);


            //%S大写会让字符串都大写
            System.out.printf("The Chinese Zodiac of %d is %s\n", year, zodiac[year % 12]);

            //创造月历的实例
            Calendar cal = Calendar.getInstance();

            //设定当前的日期
            cal.set(year,month - 1,1);

            //得到当前月份的第一天的星期数值
            int firstDay = cal.get(Calendar.DAY_OF_WEEK);

            //得到输入月份的天数
            int dayOfMonth;

            //如果是二月则要判断是否是闰年
            if(month == 2) {
                //判断闰年 29
                if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
                    dayOfMonth = 29;
                }
                //非闰年28
                else {
                    dayOfMonth = 28;
                }
            }
            //非二月
            else {
                //当月份小于等于7时
                if(month <= 7) {
                    //奇数月31
                    if (month % 2 == 1) {
                        dayOfMonth = 31;
                    }
                    //偶数月30
                    else {
                        dayOfMonth = 30;
                    }
                }
                //大于7时
                else {
                    //奇数月31
                    if (month % 2 == 1) {
                        dayOfMonth = 30;
                    }
                    //偶数月30
                    else {
                        dayOfMonth = 31;
                    }
                }
            }

            //打印标题 宽度为8 52个减号
            //在格式化输出符号前面加减号是左对齐
            System.out.print("The monthly calendar is:\n");
            System.out.printf("%-8s%-8s%-8s%-8s%-8s%-8s%-8s\n", "Sun.", "Mon.", "Tues.", "Wed.", "Thurs.", "Fri.", "Sat.");
            System.out.print("----------------------------------------------------\n");

            //通过获得的第一天的星期值制作每月第一天前面的空格
            for (int t = 0; t < firstDay - 1; ++t){
                System.out.print("\t\t");
            }

            //循环输出月份的天数 当天数的统计小于月份的天数时继续循环
            for (int t = 0; t < dayOfMonth; t++, ++firstDay) {

                System.out.printf("%-8d", t + 1);

                //如果当前星期数值为7（星期六）则换行 1是星期天
                if (firstDay % 7 == 0){
                    System.out.print("\n");
                }

            }

            //输出输入的天数时星期几
            //重设日历对象的数据
            cal.set(year, month - 1, day);

            //获取新的对象的星期数值
            firstDay = cal.get(Calendar.DAY_OF_WEEK);

            //System.out.printf("\nToday is %s\n", week[firstDay - 1].substring(0, 3));
            System.out.printf("\nToday is %s\n", week[firstDay - 1]);

            //时分秒（系统时间） 年月日（输入时间）
            System.out.printf("The date is " + cal.getTime());
        }
}
