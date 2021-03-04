package com.kiba.k_framework.utility;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHelper {

    /**
     * 判断字符串是否为空
     *
     * @param str 字符串
     * @return 是否为空
     */
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }

    /**
     * 判断字符串是否不为空
     *
     * @param str 字符串
     * @return 是否不为空
     */
    public static boolean isNotEmpty(String str) {
        return str != null && !"".equals(str);
    }

    /**
     * 截断字符串两侧的逗号
     *
     * @param str 字符串
     * @return 字符串
     */
    public static String trimComma(String str) {
        if (str.startsWith(",")) {
            str = str.substring(1);
        }
        if (str.endsWith(",")) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }
    /**
     * 字节数组转换为字符串
     *
     * @return
     */
    public static String byteToStr(byte[] byt) throws UnsupportedEncodingException {
        String strRead = new String(byt, "UTF-8");
        return strRead;
    }
    /**
     * 字符串转换为字节数组
     * @param str
     * @return
     */
    public static byte[] strToByte(String str) {
        byte[] byBuffer = new byte[200];
        String strInput = str;
        byBuffer = strInput.getBytes();
        return byBuffer;
    }
    /**
     * 将URL编码转化为字符串
     * @param str
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String strToDecoder(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }

    /**
     * 将字符串转化为URL编码
     * @param str
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String strToEncoder(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, "UTF-8");
    }
    /**
     * 将Object转换为String
     * @param o
     * @return
     */
    public static String objToString(Object o) {
        if (o == null) {
            return "";
        }
        return o.toString();
    }
    /**
     * 根据某个字符对字符串进行分割
     * @param str
     * @return
     */
    public static String[] spilt(String str, String reg) {
        str = replaceBlank(str);
        String[] spilt = str.split(reg);
        return spilt;
    }
    /**
     * 去掉字符串中的空格、回车、换行符、制表符
     * @param str
     * @return
     */
    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n|");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
            // 将ASCII的值为160的替换为空字符串
            dest = dest.replace(backStr(160), "");
        }
        return dest;
    }
    /**
     * ASC转字符串
     * @param
     */
    public static String backStr(int backnum) {
        char strChar = (char) backnum;
        return String.valueOf(strChar);
    }

    /**
     * 按长度把字符串前补0
     *
     * @param s
     *            需要补位字符串对象
     * @return len 该字符串的长度
     */
    public static String len(String s, int len) {

        if (isEmpty(s))
            s = "";

        int length = len - s.length();
        for (int i = 0; i < length; i++) {
            s = "0" + s;
        }
        return s;
    }
    /**
     * 替换source中的str1为str2
     *
     * @param source
     *            待替换的字符串
     *
     * @param str1
     *            待替换的字符
     * @param str2
     *            替换的字符
     *
     * @return java.lang.String 替换后的字符串
     */
    public static String replace(String source, String str1, String str2) {
        return replace(source, str1, str2);
    }
    /**
     * 对double数据进行取精度.
     * <p>
     * For example: <br>
     * double value = 100.345678; <br>
     * double ret = round(value,4,BigDecimal.ROUND_HALF_UP); <br>
     * ret为100.3457 <br>
     *
     * @param value
     *            double数据.
     * @param scale
     *            精度位数(保留的小数位数).
     * @param roundingMode
     *            精度取值方式.
     * @return 精度计算后的数据.
     */
    public static double round(double value, int scale, int roundingMode) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(scale, roundingMode);
        double d = bd.doubleValue();
        bd = null;
        return d;
    }
    /**
     * 得到文件名的后缀
     *
     * @param args
     */
    public static String getFileExtension(String args) {
        int t = args.lastIndexOf(".");
        String str = args.substring(t + 1);
        return str;
    }

}
