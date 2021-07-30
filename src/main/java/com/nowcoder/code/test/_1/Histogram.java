package com.nowcoder.code.test._1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

/**
 * @author Pengfei Li
 * @date 2021/1/23
 */
public class Histogram implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * id
   */
  protected long id;

  /**
   * 统计对象的id
   * 例如coding problem id
   */
  protected long entityId;

  /**
   * 统计对象的类型
   */
  protected int entityType;

  /**
   * 0 正常 1 删除
   */
  protected int status;

  /**
   * 在所有区间中，总的数值个数
   */
  protected long total;

  /**
   * 区间个数
   */
  protected int intervalCount;

  /**
   * 区间宽度
   */
  protected int intervalWidth;

  /**
   * 所有区间数值的最小值
   */
  protected int minVal;

  /**
   * 所有区间数值的最大值
   */
  protected int maxVal;

  /**
   * 数组转化的字符串，保存每个区间的高度或数值个数
   */
  protected String heights;

  /**
   * 区间高度
   */
  private List<Integer> intervalHeights;

  /**
   * 创建时间
   */
  protected Date createTime;

  /**
   * 更新时间
   */
  protected Date updateTime;

  /**
   * 最小的区间宽度
   */
  public static final int minIntervalWidth = 1;

  /**
   * 最大区间个数
   */
  public static final int maxIntervalCount = 10;

  public Histogram() {
  }

  public Histogram(List<Integer> nums, long entityId, int entityType){
    if (nums.isEmpty()){
      throw new IllegalArgumentException("Illegal nums: cannot be initialized with empty list");
    }

    this.minVal = nums.get(0);
    this.maxVal = nums.get(0);
    for (int i = 1; i < nums.size(); i++){
      this.minVal = Math.min(this.minVal, nums.get(i));
      this.maxVal = Math.max(this.maxVal, nums.get(i));
    }

    if (Histogram.minIntervalWidth <= 0){
      throw new IllegalArgumentException("Illegal minIntervalWidth: " + Histogram.minIntervalWidth);
    }

    this.intervalCount = Math.min(maxIntervalCount, (maxVal - minVal) / minIntervalWidth + 1);

    if (this.intervalCount <= 0){
      throw new IllegalArgumentException("Illegal intervalCount: " + this.intervalCount);
    }
    //避免maxVal == minVal造成的错误
    this.intervalWidth = (int) Math.ceil((double) (maxVal - minVal + 1) / intervalCount);

    this.entityId = entityId;
    this.entityType = entityType;
    this.total = nums.size();

    int[] heights = new int[intervalCount];

    int index;
    for (int num : nums){
      index = (num - minVal) / intervalWidth;
      heights[index]++;
    }
    StringBuilder sb = new StringBuilder();
    for (int height : heights){
      sb.append(height).append(',');
    }
    sb.deleteCharAt(sb.length() - 1);
    this.heights = sb.toString();
    this.createTime = new Date();
    this.updateTime = new Date();
  }

  /**
   * 四舍五入并保留decimalPlaces位小数
   * @param val
   * @param decimalPlaces
   * @return
   */
  private double toTheNearest(double val, int decimalPlaces){
    BigDecimal bigDecimal = new BigDecimal(val);
    return bigDecimal.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP).doubleValue();
  }

  /**
   * 小于等于target的概率
   * 概率 = (小于等于target的总和) / total
   * @param target
   * @return
   */
  public double getProbabilityLessThanOrEqualTarget(int target){
    if (this.total == 0 || StringUtils.isBlank(this.heights) || target < this.minVal){
      return 0.0;
    }
    if (target >= this.maxVal){
      return 1.0;
    }
//    if (CollectionUtils.isEmpty(this.intervalHeights)){
//      this.intervalHeights = ConvertUtil.getIntsByDouhao(this.heights);
//    }
    if (CollectionUtils.isEmpty(this.intervalHeights)){
      return 0.0;
    }

    final int decimalPlace = 4;

    int left, right;
    // 高度和
    double heightSum = 0;
    for(int i = 0; i < intervalHeights.size(); i++){
      left = minVal + i * intervalWidth;
      right = minVal + (i + 1) * intervalWidth - 1;
      if (target > right){
        heightSum += this.intervalHeights.get(i);
      } else{
        // target - left + 1 是[left, target]的区间宽度
        // 假设每一个区间内数据均匀分布
        heightSum += intervalHeights.get(i) * ((double)(target - left + 1) / this.intervalWidth);
        break;
      }
    }
    return toTheNearest(heightSum / this.total, decimalPlace);
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getEntityId() {
    return entityId;
  }

  public void setEntityId(long entityId) {
    this.entityId = entityId;
  }

  public int getEntityType() {
    return entityType;
  }

  public void setEntityType(int entityType) {
    this.entityType = entityType;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public long getTotal() {
    return total;
  }

  public void setTotal(long total) {
    this.total = total;
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

  public String getHeights() {
    return heights;
  }

  public void setHeights(String heights) {
    this.heights = heights;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public static void main(String[] args) {
    List<Integer> nums = new ArrayList<>(Arrays.asList(0, 20, 30, 30, 40, 40, 40, 50, 60, 90));
    Histogram histogram = new Histogram(nums, 1, 1);
    System.out.println(histogram.heights);

    //因为coding_submission表有4600万行, 其中的id可能不连续，步长可以取大一些
    long stepLen = 1000000;
    long minId = 1585, maxId = 96783134;
    long startId = minId, endId = minId + stepLen - 1;
    //注意是startId，不能用endId <= maxId
    while (startId <= maxId){
      System.out.println(String.format("SELECT count(id) FROM coding_submission WHERE id BETWEEN %s "
          + " AND %s and status = 5 and tag_id = 0;", startId, endId));
      startId += stepLen;
      endId += stepLen;
    }
  }
}
