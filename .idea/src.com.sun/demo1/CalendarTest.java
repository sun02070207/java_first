package org.day.day2;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @Author SunYB
 * @Package：org.day.day2
 * @Project：DayN
 * @Date 2023/7/11 23:06
 * @Version
 */
public class CalendarTest {
    public static void main(String[] args) {
        //构造日历对象
        GregorianCalendar calendar = new GregorianCalendar(2023, 7, 11);
        //获取当时的日月
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);

        //设置初始日期
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        //得到当天是星期几
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        //得到一周的第一天
        int firstDayOfWeek = calendar.getFirstDayOfWeek();
        int indent = 0;
        //确定日历某月第一天的缩进距离
        while (week != firstDayOfWeek){
            indent++;
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            week = calendar.get(Calendar.DAY_OF_WEEK);
        }

        //打印星期几
        String[] shortWeekdays = new DateFormatSymbols().getShortWeekdays();
        do {
            System.out.printf("%4s", shortWeekdays[week]);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            week = calendar.get(Calendar.DAY_OF_WEEK);
        }
        while (week != firstDayOfWeek);
        System.out.println();
        for (int i = 1; i <= indent; i++){
            System.out.print(" ");
        }
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        do {
            //打印天
            int day1 = calendar.get(Calendar.DAY_OF_MONTH);
            System.out.printf("%3s", day1);
            //当天添加*
            if (day1 == day){
                System.out.print("*");
            }else {
                System.out.print(" ");
            }
            //将日期往前推
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            week = calendar.get(Calendar.DAY_OF_WEEK);

            if (week == firstDayOfWeek){
                System.out.println();
            }
        }while (calendar.get(Calendar.MONTH) == month);

        if (week != firstDayOfWeek){
            System.out.println();
        }
    }
}
