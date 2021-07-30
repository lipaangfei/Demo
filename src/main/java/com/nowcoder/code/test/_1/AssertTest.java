package com.nowcoder.code.test._1;

import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;

import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Pengfei Li
 * @date 2021/1/22
 */
public class AssertTest {

  public static boolean isLeapYear(int year){
    if(year % 4 != 0){
      return false;
    }
    else if(year % 100 != 0){//注意year % 100 != 0
      return true;
    }
    else if(year % 400 != 0){
      return false;
    }
    return true;
  }
  public static String dayOfTheWeek(int day, int month, int year) {
    //1971年1月1日是星期五
    String[] weeks = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    int[] daysOfMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
    int dayCount = 0;
    for(int y = 1971; y < year; y++){
      if(isLeapYear(y)){
        dayCount += 366;
      }
      else{
        dayCount += 365;
      }
    }
    if(isLeapYear(year)){
      daysOfMonth[1] = 29;
    }
    for(int m = 0; m < month - 1; m++){//注意month - 1，因为不算第month月的天数
      dayCount += daysOfMonth[m];
    }
    dayCount += day - 1;//注意减一
    return weeks[(dayCount + 5)%7];//因为Friday = weeks[5],所以加5
  }

  public static void main(String[] args) {

    int y = 1999, m = 7, d = 18;
    System.out.println(System.currentTimeMillis());
  }
}
