package com.nowcoder.code.test.SubmissionIdCheck;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author Pengfei Li
 * @date 2021/1/27
 */
public class SubmissionIdCheck {

  public static final int SECOND = 1;

  public static final int MINUTE = SECOND * 60;

  public static final int HOUR = MINUTE * 60;

  public static final int DAY = HOUR * 24;

  public static final int MONTH = DAY * 30;

  public static final int YEAR = MONTH * 365;

  public static final long MILLISECOND = 1;

  public static final long SECOND_LONG = MILLISECOND * 1000;

  public static final long MINUTE_LONG = SECOND_LONG * 60;

  public static final long HOUR_LONG = MINUTE_LONG * 60;

  public static final long DAY_LONG = HOUR_LONG * 24;

  public static final long MONTH_LONG = DAY_LONG * 30;

  public static final long YEAR_LONG = MONTH_LONG * 365;

  public static List<Integer> loadNums(String filepath){
    try {
      List<Integer> nums = new ArrayList<>();
      FileReader fr = new FileReader(filepath);
      BufferedReader br = new BufferedReader(fr);
      String line;
      while ((line = br.readLine()) != null){
        int num = Integer.valueOf(line);
        nums.add(num);
      }
      br.close();
      fr.close();
      return nums;
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return Collections.emptyList();
  }

  public static void saveNums(List<Integer> nums, String filepath){
    Collections.sort(nums);
    FileWriter fw = null;
    try {
      fw = new FileWriter(filepath);
      BufferedWriter bw = new BufferedWriter(fw);
      for(int n : nums){
        bw.write(n + "\n");
      }
      bw.close();
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void findLoss(){
    List<Integer> ids1 = loadNums("/Users/lipengfei/Documents/temp code/13366题的提交online.txt");
    List<Integer> ids2 = loadNums("/Users/lipengfei/Documents/temp code/13366题提交记录offline.txt");
    ids1.removeAll(ids2);
    saveNums(ids1, "/Users/lipengfei/Documents/temp code/13366题提交记录offline缺少的submission id"
        + ".txt");
    System.out.println(ids1);
  }
  public static void main(String[] args) {

    long time = System.currentTimeMillis() + 10000 * DAY_LONG;
    Date expireDate = new Date(time);
    System.out.println(expireDate);
  }
}
