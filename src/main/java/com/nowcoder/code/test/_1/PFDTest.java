package com.nowcoder.code.test._1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://blog.csdn.net/weixin_38533896/article/details/80356598
 * s
 * @author Pengfei Li
 * @date 2021/1/6
 */
public class PFDTest {
    /**
     * 统计序列的概率密度返回横纵坐标
     * @param frames 序列
     * @param intervalCount 区间个数
     * @return
     */
    public static double[][] statisticPD(int[] frames, int intervalCount) {
        int framenum = frames.length;
        // 概率密度
        double Pd;

        // 区间上下界和中间值
        int upInterval, downInterval, middleValue;
        // 每个区间内的帧数量
        int count = 0;

        // 横纵坐标保存数组
        double[][] frameArray = new double[intervalCount][2];

        Arrays.sort(frames);

        int minFrame = frames[0];
        int maxFrame = frames[framenum - 1];
        // 区间宽度
        int interval = (maxFrame - minFrame + intervalCount - 1) / intervalCount;
        System.out.println("区间宽度: " + interval);
        System.out.println("Min=" + minFrame + " " + "Max=" + maxFrame);

        for (int k = 0; k < intervalCount; k++) {

            upInterval = minFrame + (k + 1) * interval - 1;
            downInterval = minFrame + k * interval;
            // 中点值（每一个横坐标
            middleValue = downInterval + interval / 2;

            for (int i = 0; i < framenum; i++) {
                if (frames[i] < upInterval && frames[i] >= downInterval) {
                    count++;
                }
            }
            // 纵坐标
            Pd = (double) count / framenum / interval;
            System.out.println("pd" + Pd);
            frameArray[k][0] = middleValue;
            frameArray[k][1] = Pd;
            count = 0;
        }

        return frameArray;
    }

    public static double[][] getPdf(List<Integer> nums, int intervalWidth){
        assert intervalWidth > 0;
        int minVal = nums.get(0);
        int maxVal = nums.get(0);
        for (int num : nums){
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
        }

        int intervalCount = (int) Math.floor((maxVal - minVal) / intervalWidth) + 1;
        List<List<Integer>> intervals = new ArrayList(intervalCount);
        for(int i = 0; i < intervalCount; i++){
            intervals.add(new ArrayList<>());
        }
        int index;
        for (int num : nums){
            index = (int) Math.floor((num - minVal) / intervalWidth);
            intervals.get(index).add(num);
        }
        int left, right;
        int mid;
        // 概率密度
        double pd;
        int n = nums.size();
        // 横纵坐标保存数组
        double[][] pdf = new double[n][2];

        for(int i = 0; i < intervalCount; i++){
            Collections.sort(intervals.get(i));
            left = minVal + i * intervalWidth;
            right = minVal + (i + 1) * intervalWidth - 1;
            // 中点值（每一个横坐标
            mid = left + intervalWidth / 2;
            // 纵坐标
            // 概率 = 每个区间内的序列数/序列总数；概率密度 = 概率/区间宽度，概率密度作为当前区间的纵坐标
            pd = (double) intervals.get(i).size() / n / intervalWidth;
            pdf[i] = new double[]{(double) mid, pd};
            System.out.println(left + " " + right + " " + intervals.get(i).size() + " " + mid +
                " " + pd);
        }
        return pdf;
    }
    public static double getP(double[][] pdf, int minVal, int intervalWidth, int num){
        if (num < minVal){
            return 0;
        }
        double p = 0;
        int left, right;
        for(int i = 0; i < pdf.length; i++){
            left = minVal + i * intervalWidth;
            right = minVal + (i + 1) * intervalWidth - 1;
            System.out.println("[" + left + ", " + right + "]");
            //概率 = 密度 * 区间宽度
            if (num > right){
                p += pdf[i][1] * intervalWidth;
            }
            else{
                // num - left + 1 是[left, num]的区间宽度
                p += pdf[i][1] * (num - left + 1);
                break;
            }
        }
        return p;
    }

    public static void main(String[] args) {
        /*
        int[] nums = {1, 1, 2, 3, 4, 5, 6, 7, 8, 9 , 10, 10};
        int intervalWidth = 1;
        double[][] pdf = getPdf(nums, intervalWidth);
        int num = 11;
        System.out.println(num + "超过" + (1 - getP(pdf, 1, intervalWidth, num)) + "的数据");
         */
        try {
            List<Integer> nums = new ArrayList<>();
            FileReader fr = new FileReader("/Users/lipengfei/Documents/temp code/time.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;
            int minVal = Integer.MAX_VALUE;
            while ((line = br.readLine()) != null){
                int num = Integer.valueOf(line);
                nums.add(num);
                minVal = Math.min(minVal, num);
            }
            System.out.println("最小值" + minVal);
            int intervalWidth = 1;
            double[][] pdf = getPdf(nums, intervalWidth);
            int num = 10;
            System.out.println(num + "超过" + (1 - getP(pdf, minVal, intervalWidth, num)) + "的数据");

            Collections.sort(nums);
            FileWriter fw = new FileWriter("/Users/lipengfei/Documents/temp code/time_ascend.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for(int n : nums){
                bw.write(n + "\n");
            }

            br.close();
            fr.close();
            bw.close();
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
