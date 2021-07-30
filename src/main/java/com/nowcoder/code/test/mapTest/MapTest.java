package com.nowcoder.code.test.mapTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang.StringUtils;

/**
 * @author Pengfei Li
 * @date 2021/2/20
 */
public class MapTest {

  public static void main(String[] args) {
    List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3));
    Map<Integer, String> map =
        nums.stream().collect(Collectors.toMap(num -> num * 2, num -> String.valueOf(num + 100),
            (a, b) -> a));
    System.out.println(map);
    List<String> list = new ArrayList<>();
    list.add("zhangsan");
    list.add("lisi");
    list.add("zhangsan");

    //1 stream 流式判断是否 x1和x2相同，相同则取x1
    Map<String, String> collect = list.stream().collect(Collectors.toMap(x -> x, x -> "xx", (x1,
        x2) -> x1));
    System.out.println(collect);

    Set<Integer> userIds = new HashSet<>();
    nums = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3));
    nums = nums.stream().filter(n -> userIds.add(n)).collect(Collectors.toList());
    System.out.println(nums);

    String info = String.format("RecommendBiz#renderRecommendMoments: discussPostId=%s, momentCnt"
            + " = %d,  momentIds = [%s]", 1000000, nums.size(),
        StringUtils.join(nums, ", "));
    System.out.println(info);

    List<String> errorInfo = new ArrayList<>();
    System.out.println("errorInfo=" + StringUtils.join(errorInfo, "\n"));
  }
}
