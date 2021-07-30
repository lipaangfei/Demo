package com.nowcoder.code.test._1;

import java.util.TreeMap;

/**
 * @author Pengfei Li
 * @date 2021/3/4
 */
public class ExcelParser {

  class Solution {
    public int oddEvenJumps(int[] arr) {
      int n = arr.length;
      TreeMap<Integer, Integer> treeMap = new TreeMap<>();
      treeMap.put(arr[n - 1], n - 1);
      boolean[] isHigher = new boolean[n];
      boolean[] isLower = new boolean[n];
      isHigher[n - 1] = isLower[n - 1] = true;
      int ans = 1;
      for (int i = n - 2; i >= 0; i--) {
        Integer higherVal = treeMap.ceilingKey(arr[i]);
        if (higherVal != null) {
          isHigher[i] = isLower[treeMap.get(higherVal)];
        }

        Integer lowerVal = treeMap.floorKey(arr[i]);
        if (lowerVal != null) {
          isLower[i] = isHigher[treeMap.get(lowerVal)];
        }
        if (isHigher[i]) {
          ans += 1;
        }
        treeMap.put(arr[i], i);
      }
      return ans;
    }
  }
}
