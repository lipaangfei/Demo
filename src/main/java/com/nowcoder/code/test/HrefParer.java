package com.nowcoder.code.test;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HrefParer {

    private static final String HREF_REGEX = "<a\\s+href\\s*=\\s*(\"|\')?(.*?)[\"|\'|>]";

    private static final Pattern HREF_PATTERN = Pattern.compile(HREF_REGEX,
            Pattern.CASE_INSENSITIVE);

    /**
     * 禁用leetcode相关超链接
     *
     * @param source
     * @return
     */
    public static List<String> findHref(String source) {
        List<String> hrefs = new ArrayList<>();
        if (StringUtils.isBlank(source)) {
            return hrefs;
        }
        try {
            Matcher m = HREF_PATTERN.matcher(source);
            while (m.find()) {
                source = source.replaceAll(HREF_REGEX, "");
                String href = m.group(2);
                hrefs.add(href);
            }
        } catch (Exception e) {
        }
        return hrefs;
    }

    public static void main(String[] args) {
        String source = "关于白板题目去哪里找：<a href=\"https://leetcode.com/problemset/database/\">Leetcode</a><a href=\"https://www.topcoder.com/\">TopCoder</a>, <a href=\"http://codeforces.com/\">Codeforces</a>, <a href=\"https://projecteuler.net/\">Project Euler</a> 都是不错的选择";
//        System.out.println(findHref(source));
        source = "<a href=\"https://leetcode-cn.com/?utm_source=LCUS&amp;utm_medium=ip_redirect&amp;"
                + "utm_campaign=transfer2china\" target=\"_blank\">https://leetcode-cn.com</a>"
                + "<a href=\"https://leetcode-cn.com/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china\" target=\"_blank\">https://leetcode-cn.com/?utm_source=LCUS&amp;utm_medium=ip_redirect&amp;utm_campaign=transfer2china</a><br />\n"
                + "<a href=\"https://leetcode-cn.com/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china\" target=\"_blank\"></a>";
        source = "<a href=\"https://leetcode-cn.com/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china\" target=\"_blank\"></a>";
        source = "<p><a  target=\"_blank\"  href=\"http://www.leetcode-cn.com\">力扣</a><br><a  target=\"_blank\"  href=\"http://www.leetcode.com\">LeetCode</a><br>士大夫</p>\n";

        System.out.println(findHref(source));
        System.out.println(new Date(1509593043632L));
//        StringBuilder sb = new StringBuilder(" helloworld");
//        System.out.println(sb.toString().replace(" ", "%20"));
    }

}