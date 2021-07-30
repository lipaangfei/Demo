package com.nowcoder.code.test._1;

/**
 * @author Pengfei Li
 * @date 2021/1/20
 */
public class SubmissionProbabilityModel {
  private long problemId;
  int type;
  private int totalCount;
  private int intervalCount;
  private int intervalWidth;
  private int minVal;
  private int maxVal;
  private String counters;

  public long getProblemId() {
    return problemId;
  }

  public void setProblemId(long problemId) {
    this.problemId = problemId;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public int getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(int totalCount) {
    this.totalCount = totalCount;
  }

  public int getIntervalCount() {
    return intervalCount;
  }

  public void setIntervalCount(int intervalCount) {
    this.intervalCount = intervalCount;
  }

  public int getIntervalWidth() {
    return intervalWidth;
  }

  public void setIntervalWidth(int intervalWidth) {
    this.intervalWidth = intervalWidth;
  }

  public int getMinVal() {
    return minVal;
  }

  public void setMinVal(int minVal) {
    this.minVal = minVal;
  }

  public int getMaxVal() {
    return maxVal;
  }

  public void setMaxVal(int maxVal) {
    this.maxVal = maxVal;
  }

  public String getCounters() {
    return counters;
  }

  public void setCounters(String counters) {
    this.counters = counters;
  }
}
