package com.nowcoder.code.test.lc;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class _1188_DesignBoundedBlockingQueue {
  public static Pattern emailPattern = Pattern
          .compile("^([a-zA-Z0-9_\\+\\.-])+@(([a-zA-Z0-9-])+\\.)+([a-zA-Z0-9]{2,8})");

  /**
   * 方法3-3 参考
   * https://leetcode.com/problems/design-bounded-blocking-queue/discuss/402284/Java-2-semaphores-and-thread-safe-queue/519493
   *
   */
  public static int findLatestStep(int[] A, int m) {
    int res = -1, n = A.length;
    int[] length = new int[n + 2], count = new int[n + 1];
    for (int i = 0; i < n; ++i) {
      int a = A[i], left = length[a - 1], right = length[a + 1];
      length[a] = length[a - left] = length[a + right] = left + right + 1;
      count[left]--;
      count[right]--;
      count[length[a]]++;
      if (count[m] > 0)
        res = i + 1;
    }
    return res;
  }

  /**
   * return k numbers from nums randomly
   */
  public static List<Integer> getRandomIntegers(List<Integer> nums, int k) {
    List<Integer> randomNums = new ArrayList<>();
    int size = 0;
    while (size < k && CollectionUtils.isNotEmpty(nums)) {
      Collections.shuffle(nums);
      randomNums.add(nums.get(0));
      size += 1;
      nums = nums.subList(1, nums.size());
    }
    return randomNums;
  }

  private static String EnterpriseEmailDomainPattern = ".*(?<!(@163.com|@126.com|@qq.com|@hotmail.com|@gmail.com|@sina.com.cn|@outlook.com|@netease.com|@yeah.net|@yahoo.com|@foxmail.com|@tom.com|@sohu.com|@21cn.com|@icloud.com|@aol.com|@139.com))";

  public static boolean isEnterpriseEmail(String email) {
    return StringUtils.isNoneBlank(email) && email.matches(EnterpriseEmailDomainPattern) && email.contains("@");
  }

  private static Boolean checkEmail(String email) {
    if (email.matches("^[a-z0-9A-Z]+[- |a-z0-9A-Z._]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-z]{2,}$")) {
      return true;
    } else {
      return false;
    }
  }

  public static boolean isEmail(String email) {
    if (StringUtils.length(email) > 40 || StringUtils.length(email) <= 0) {
      return false;
    }

    Matcher matcher = emailPattern.matcher(email);
    return matcher.matches();

  }

  private static String replaceSlash(String html) {
    return html.replace("/", "\\/");
  }

  public static void main(String[] args) {
//    int[] A = {14, 86, 57, 47, 99, 64, 41, 77, 58, 2, 54, 89, 26, 99, 54, 64, 37, 41, 82, 50, 93, 99, 49, 53, 44, 65, -1, 88,
//        71, 42, 30, 65, 98, 13, 58, 13, 27, 59, 35, 28, 34, 75, 1, 47, 91, 66, 76, 49, 65, 98, 77, 90, 31, 8, -1};
//    int B = 9;

    Integer[] arr = {3,5,1,2,4};
    int m = 1;
    List<Integer> nums = new ArrayList<Integer>(Arrays.asList(arr));
    System.out.println(getRandomIntegers(nums, 3));
    System.out.println(isEmail("1@qcom"));
    String html = "#时长：50min,平台：腾讯会议\n" +
            "上来四道题半小时完成\n" +
            "## 请写出以下代码的输出结果顺序\n" +
            "\n" +
            "```js\n" +
            "async function async1() {\n" +
            "    console.log('async1 start');\n" +
            "    await async2().then(() => {\n" +
            "        console.log(\"async2 end!\")\n" +
            "    });\n" +
            "    console.log('async1 end');\n" +
            "}\n" +
            "\n" +
            "async function async2(){\n" +
            "    console.log('async2');\n" +
            "}\n" +
            "\n" +
            "console.log('script start');\n" +
            "\n" +
            "setTimeout(function(){\n" +
            "    console.log('setTimeout');\n" +
            "},0)\n" +
            "\n" +
            "async1();\n" +
            "\n" +
            "new Promise(function(resolve) {\n" +
            "    console.log('promise1');\n" +
            "    resolve();\n" +
            "}).then(function(){\n" +
            "    console.log('promise2');\n" +
            "})\n" +
            "```\n" +
            "\n" +
            "\n" +
            "\n" +
            "## 实现5分钟倒计时功能\n" +
            "\n" +
            "```html\n" +
            "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <title>Count down</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<div id=\"time\">5:00</div>\n" +
            "</body>\n" +
            "<script>\n" +
            "<!-- 在此处实现 -->\n" +
            "\n" +
            "</script>\n" +
            "</html> \n" +
            "```\n" +
            "\n" +
            "## 给定一个数字，按以下规则转换为字符串。\n" +
            "\n" +
            "leetcode 168 \n" +
            "\n" +
            "\u200B\t\n" +
            "\n" +
            "##  根据二叉树创建字符串\n" +
            "\n" +
            "\u200B\tleetcode 606\n" +
            "\n" +
            "\n" +
            "---\n" +
            "\n" +
            "1. 树的遍历有哪几种方式\n" +
            "2. 哪一种遍历方式的结果是升序\n" +
            "3. 栈跟队列的区别\n" +
            "4. TCP和UDP的差别\n" +
            "5. TCP怎么保证传输是准确的\n" +
            "6. TCP怎么保证数据是完整的\n" +
            "7. TCP为什么要三次握手\n" +
            "8. TCP拥塞控制的实现\n" +
            "9. HTTP的请求方式有哪些\n" +
            "10. GET、POST的区别\n" +
            "11. HTTP响应码\n" +
            "12. HTTPS握手过程\n" +
            "13. 登陆功能怎么实现的\n" +
            "14. 在浏览器存数据有哪些方式\n" +
            "15. localStorage有上限吗\n" +
            "16. 用Vue和用原生JS有什么区别\n" +
            "17. 数据双向绑定\n" +
            "18. 商品搜索功能怎么实现的\n" +
            "19. 有十万条数据，都存在前端，前端如何实现搜索功能\n" +
            "20. 怎么实现像百度一样边输入边搜索\n" +
            "21. 项目中一些比较难的点\n" +
            "22. 最近在学的新东西是什么\n" +
            "23. 反问\n" +
            "\n" +
            "---";
    System.out.println(replaceSlash(html));
  }
}

