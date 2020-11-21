package com.nowcoder.code.commons.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author lipf
 * @version 1.0
 * @date 2020/10/29
 */
public class NowcoderWebUtils {
    private static Logger LOG = Logger.getLogger(NowcoderWebUtils.class);

    public static <T> T parseRequestBodyOfJson(HttpServletRequest request, Class<T> clazz) throws IllegalAccessException, InstantiationException {
        try {
            String readerString = IOUtils.toString(request.getReader());
            return (T) JSON.parseObject(readerString, clazz);
        } catch (IOException e) {
            return clazz.newInstance();
        }
    }

    /**
     * 设置返回值类型为json
     *
     * @param response
     */
    public static void setResponseJson(HttpServletResponse response) {
        response.setContentType("application/json");
    }

    /**
     * 对字符串md5加密
     * 这个轮子有BUG，会忽略前导零
     *
     *
     * @param str
     * @return
     */
    @Deprecated
    public static String getMD5Bad(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            //bug
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            LOG.error("MD5 error");
            return null;
        }
    }

    /**
     * use apache common code
     *
     * @param str
     * @return
     */
    public static String getMD5(String str) {
        return DigestUtils.md5Hex(str);
    }
}
