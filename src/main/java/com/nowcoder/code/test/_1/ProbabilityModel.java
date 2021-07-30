package com.nowcoder.code.test._1;

import com.alibaba.fastjson.JSONObject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang.StringUtils;

/**
 * https://blog.csdn.net/weixin_38533896/article/details/80356598
 * s
 * @author Pengfei Li
 * @date 2021/1/6
 */
public class ProbabilityModel {
    int total;
    int intervalCount;
    int intervalWidth;
    int minVal;
    int maxVal;
    int[] counters;
    public ProbabilityModel(List<Integer> nums, int intervalWidth){
        assert intervalWidth > 0;
        this.intervalWidth = intervalWidth;
        this.total = nums.size();
        this.minVal = nums.get(0);
        this.maxVal = nums.get(0);
        for (int num : nums){
            this.minVal = Math.min(minVal, num);
            this.maxVal = Math.max(maxVal, num);
        }

        intervalCount = (int) Math.floor((maxVal - minVal) / intervalWidth) + 1;
        this.counters = new int[intervalCount];
        int index;

        for (int num : nums){
            index = (int) Math.floor((num - minVal) / intervalWidth);
            this.counters[index]++;
        }
        System.out.println(intervalCount);
        printCounters();
    }

    public static List<Integer> getIntsByDouhao(String tags) {
        List<Integer> tagInts = new ArrayList<>();
        if (StringUtils.isEmpty(tags)) {
            return tagInts;
        }
        try {
            String[] tagArray = tags.split(",");

            for (String tag : tagArray) {
                if (!StringUtils.isEmpty(tag)) {
                    tagInts.add(Integer.parseInt(StringUtils.trim(tag)));
                }
            }
        } catch (Exception e) {
        }
        return tagInts;
    }

    public ProbabilityModel(JSONObject json){
        System.out.println(json);
        this.intervalWidth = (Integer) json.get("intervalWidth");
        this.total = (Integer) json.get("total");
        assert this.total > 0 && this.intervalWidth > 0;
        this.minVal = (Integer) json.get("minVal");
        this.maxVal = (Integer) json.get("maxVal");
        String countersJSON = (String) json.get("counters");
        this.counters = new int[intervalCount];
        List<Integer> counterList =  getIntsByDouhao(countersJSON);
        assert counterList.size() == counters.length;
        for (int i = 0; i < intervalCount; i++){
            counters[i] = counterList.get(i);
        }
        System.out.println(intervalCount);
        printCounters();
    }

    private void printCounters(){
        System.out.println("counters: ");
        for (int count : counters){
            System.out.print(count + " ");
        }
        System.out.println();
    }
    private double toTheNearest(double val, int fractions){
        BigDecimal bigDecimal = new BigDecimal(val);
        return bigDecimal.setScale(fractions, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 小于等于target的概率
     * @param target
     * @return
     */
    public double getProbabilityLessOrEqualTarget(int target){
        final int decimalPlace = 4;
        if (this.total == 0 || target < minVal){
            return toTheNearest(0.0, decimalPlace);
        }
        if (target >= maxVal){
            return toTheNearest(1.0, decimalPlace);
        }
        int left, right;
        int count = 0;
        for(int i = 0; i < counters.length; i++){
            left = minVal + i * intervalWidth;
            right = minVal + (i + 1) * intervalWidth - 1;
//            System.out.println("[" + left + ", " + right + "]");
            //概率 = 密度 * 区间宽度
            if (target > right){
                count += this.counters[i];
            }
            else{
                // target - left + 1 是[left, target]的区间宽度
                // 假设每一个区间内数据均匀分布
                count += counters[i] * ((target - left + 1) / this.intervalWidth);
                break;
            }
        }
//        System.out.println("count = " + count + ", total = " + total);
        return toTheNearest((double) count / this.total, decimalPlace);
    }

    public Object toJSON(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("total", total);
        jsonObject.put("minVal", minVal);
        jsonObject.put("maxVal", maxVal);
        jsonObject.put("intervalCount", intervalCount);
        jsonObject.put("intervalWidth", intervalWidth);
        if (counters == null || counters.length == 0){
            jsonObject.put("counters", "");
        } else{
            StringBuilder sb = new StringBuilder();
            for (int count : counters){
                sb.append(count).append(',');
            }
            sb.deleteCharAt(sb.length() - 1);
            jsonObject.put("counters", sb.toString());
        }
        return jsonObject;
    }

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

    public static void saveSortedNums(List<Integer> nums, String filepath){
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

    public static void saveJSON(JSONObject jsonObject, String filepath){
        FileWriter fw = null;
        try {
            fw = new FileWriter(filepath);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(jsonObject.toJSONString());
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<Integer> times = loadNums("/Users/lipengfei/Documents/temp code/time.txt");
        int timeIntervalWidth = 1;
        ProbabilityModel timeProbabilityModel = new ProbabilityModel(times, timeIntervalWidth);
        JSONObject timeProbabilityJSON = new JSONObject();
        timeProbabilityJSON.put("probabilityModel", timeProbabilityModel.toJSON());
        saveJSON(timeProbabilityJSON, "/Users/lipengfei/Documents/temp code/time_model.txt");
        System.out.println(timeProbabilityJSON);
        int targetTime = 10;
        System.out.println(targetTime + "超过" + timeProbabilityModel.getProbabilityLessOrEqualTarget(targetTime) + "的时间");
        saveSortedNums(times, "/Users/lipengfei/Documents/temp code/time_ascend.txt");

        List<Integer> memories = loadNums("/Users/lipengfei/Documents/temp code/memory.txt");
        int memoryIntervalWidth = 50;
        ProbabilityModel memoryProbabilityModel = new ProbabilityModel(memories,
            memoryIntervalWidth);
        JSONObject memoryProbabilityJSON = new JSONObject();
        memoryProbabilityJSON.put("probabilityModel", memoryProbabilityModel.toJSON());
        saveJSON(memoryProbabilityJSON, "/Users/lipengfei/Documents/temp code/memory_model.txt");
        int memoryTarget = 100000;
        System.out.println(memoryTarget + "超过" + memoryProbabilityModel.getProbabilityLessOrEqualTarget(memoryTarget) + "的内存");
        saveSortedNums(memories, "/Users/lipengfei/Documents/temp code/memory_ascend.txt");

        int minIntervalWidth = 4;
        int maxVal = 12, minVal = 1;
        int intervalCount = (maxVal - minVal) / minIntervalWidth + 1;
        System.out.println(intervalCount);
        intervalCount = 4;
        int intervalWidth = (int) Math.ceil((double) (maxVal - minVal + 1) / intervalCount);
        System.out.println(intervalWidth);
        List<Long> list = new LinkedList<>();
        for (long i = 0; i < Integer.MAX_VALUE; i++){
            list.add(i);
        }
        System.out.println(list.size());
    }
}
