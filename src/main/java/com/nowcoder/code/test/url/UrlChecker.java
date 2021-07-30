package com.nowcoder.code.test.url;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;

/**
 * @author Pengfei Li
 * @date 2021/2/5
 */
public class UrlChecker {
  public static String getLiveRecordUrl(boolean isMobile, String liveRecordUrl){
    if (StringUtils.isBlank(liveRecordUrl)){
      return "";
    }
    try{
      String[] urlSegments = liveRecordUrl.split("/");
      print(urlSegments);
      if (urlSegments.length < 3){
        return "";
      }
      urlSegments[2] = isMobile? "m" : "www";
      return StringUtils.join(urlSegments, "/");
    } catch (Exception e){
      System.out.println("LiveCourseNewController#getLiveRecordUrl, wrong liveRecordUrl = "
              + liveRecordUrl + " " +  e);
    }
    // bad liveRecordUrl, return ""
    return "";
  }

  public static String getLiveRecordUrl2(boolean isMobile, String liveRecordUrl){
    // if bad url, return ""
    String resUrl = "";
    if (StringUtils.isNotBlank(liveRecordUrl)){
      try{
        String[] urlSegments = liveRecordUrl.split("/");
        if (urlSegments.length >= 3){
          StringBuilder suffix = new StringBuilder();
          for (int i = 3; i < urlSegments.length; i++){
            suffix.append(urlSegments[i]);
            if (i < urlSegments.length - 1){
              suffix.append("/");
            }
          }
          String domain = isMobile? "https://m.nowcoder.com" : "https://www.nowcoder.com";
          resUrl = domain;
          if (suffix.length() > 0){
            resUrl += "/" + suffix.toString();
          }
        }
      } catch (Exception e){
        System.out.println("LiveCourseNewController#getLiveRecordUrl, wrong liveRecordUrl = "
            + liveRecordUrl + " " +  e);
      }
    }
    return resUrl;
  }

  public static void print(String[] strs){
    if (strs == null || strs.length == 0){
      System.out.println("empty strs" + strs);
    }
    System.out.println("length: " + strs.length);
    for (String s : strs){
      System.out.print(s + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    System.out.println("res: " + getLiveRecordUrl2(false, "https://www.nowcoder.com"));
    System.out.println("res: " + getLiveRecordUrl2(true,"https://www.nowcoder.com/study/live/120/1/1"));

    System.out.println("res: " + getLiveRecordUrl2(false, "https://m.nowcoder.com/study/live/120/1/1"));
    System.out.println("res: " + getLiveRecordUrl2(true,"https://m.nowcoder.com/study/live/120/1/1"));
//    String[] segs = "https://www.nowcoder.com".split("/");
//    segs[2] = "asdf";
//    System.out.println(StringUtils.join(segs, "/"));
  }

}
