package com.qian.util;

import java.util.HashMap;

/**
 * 身份证号码校验码的计算 (1)十七位数字本体码 加权求和公式 S = Sum(Ai * Wi), i = 0, ... , 16 ，先对前 17
 * 位数字的权求和 Ai: 表示第 i 位置上的身份证号码数字值 Wi: 表示第 i 位置上的加权因子 Wi: 7 9 10 5 8 4 2 1 6 3 7
 * 9 10 5 8 4 2
 * 
 * S: =(4*7+5*9+2*10+1*5+2*8+4*4+1*2+9*1+8*6+3*3+0*7+7*9+0*10+3*5+0*8+3*4+9*2) =
 * 306;
 * 
 * (2)计算模 Y = mod(S, 11)
 * 
 * Y=306%11=9;
 * 
 * (3)通过模得到对应的校验码 Y: 0 1 2 3 4 5 6 7 8 9 10 校验码 : 1 0 X 9 8 7 6 5 4 3 2
 * 
 * @CertNoVerifyUtil.java
 * @author lizheng
 * @2014-5-23 下午3:42:50 www.gopay.com.cn Inc.All rights reserved.
 */
public class CertNoVerify {

    // wi =2(n-1)(mod 11)
    final static int[] wi = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
    // verify digit
    final static int[] vi = { 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 };
    private static String[] _areaCode = { "11", "12", "13", "14", "15", "21", "22", "23", "31", "32", "33", "34", "35",
            "36", "37", "41", "42", "43", "44", "45", "46", "50", "51", "52", "53", "54", "61", "62", "63", "64", "65",
            "71", "81", "82", "91" };
    private static HashMap<String, Integer> dateMap;
    private static HashMap<String, String> areaCodeMap;
    static {
        dateMap = new HashMap<String, Integer>();
        dateMap.put("01", 31);
        dateMap.put("02", null);
        dateMap.put("03", 31);
        dateMap.put("04", 30);
        dateMap.put("05", 31);
        dateMap.put("06", 30);
        dateMap.put("07", 31);
        dateMap.put("08", 31);
        dateMap.put("09", 30);
        dateMap.put("10", 31);
        dateMap.put("11", 30);
        dateMap.put("12", 31);
        areaCodeMap = new HashMap<String, String>();
        for (String code : _areaCode) {
            areaCodeMap.put(code, null);
        }
    }

    // 验证身份证位数,15位和18位身份证
    public static boolean verifyLength(String code) {
        int length = code.length();
        if (length == 15 || length == 18) {
            return true;
        } else {

            return false;
        }
    }

    // 判断地区码
    public static boolean verifyAreaCode(String code) {
        String areaCode = code.substring(0, 2);
        // Element child= _areaCodeElement.getChild("_"+areaCode);
        if (areaCodeMap.containsKey(areaCode)) {
            return true;
        } else {

            return false;
        }
    }

    // 判断月份和日期
    public static boolean verifyBirthdayCode(String code) {
        // 验证月份
        String month = code.substring(10, 12);
        if (!dateMap.containsKey(month)) {

            return false;
        }
        // 验证日期
        String dayCode = code.substring(12, 14);
        Integer day = dateMap.get(month);
        String yearCode = code.substring(6, 10);
        Integer year = Integer.valueOf(yearCode);

        // 非2月的情况
        if (day != null) {
            if (Integer.valueOf(dayCode) > day || Integer.valueOf(dayCode) < 1) {

                return false;
            }
        }
        // 2月的情况
        else {
            // 闰月的情况
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                if (Integer.valueOf(dayCode) > 29 || Integer.valueOf(dayCode) < 1) {

                    return false;
                }
            }
            // 非闰月的情况
            else {
                if (Integer.valueOf(dayCode) > 28 || Integer.valueOf(dayCode) < 1) {

                    return false;
                }
            }
        }
        return true;
    }

    // 验证身份除了最后位其他的是否包含字母
    public static boolean containsAllNumber(String code) {
        String str = "";
        if (code.length() == 15) {
            str = code.substring(0, 15);
        } else if (code.length() == 18) {
            str = code.substring(0, 17);
        }
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (!(ch[i] >= '0' && ch[i] <= '9')) {

                return false;
            }
        }
        return true;
    }

    // 验证身份证
    public static boolean verify(String idcard) {
        // 验证身份证位数,15位和18位身份证
        if (!verifyLength(idcard)) {
            return false;
        }
        // 验证身份除了最后位其他的是否包含字母
        if (!containsAllNumber(idcard)) {
            return false;
        }

        // 如果是15位的就转成18位的身份证
        String eifhteencard = "";
        if (idcard.length() == 15) {
            eifhteencard = uptoeighteen(idcard);
        } else {
            eifhteencard = idcard;
        }
        // 验证身份证的地区码
        if (!verifyAreaCode(eifhteencard)) {
            return false;
        }
        // 判断月份和日期
        if (!verifyBirthdayCode(eifhteencard)) {
            return false;
        }
        // 验证18位校验码,校验码采用ISO 7064：1983，MOD 11-2 校验码系统
        if (!verifyMOD(eifhteencard)) {
            return false;
        }
        return true;
    }

    // 验证18位校验码,校验码采用ISO 7064：1983，MOD 11-2 校验码系统
    public static boolean verifyMOD(String code) {
        String verify = code.substring(17, 18);
        if ("x".equals(verify)) {
            code = code.replaceAll("x", "X");
            verify = "X";
        }
        String verifyIndex = getVerify(code);
        if (verify.equals(verifyIndex)) {
            return true;
        }
        // int x=17;
        // if(code.length()==15){
        // x=14;
        // }

        return false;
    }

    // 获得校验位
    public static String getVerify(String eightcardid) {
        int remaining = 0;
        int[] ai = new int[18];

        if (eightcardid.length() == 18) {
            eightcardid = eightcardid.substring(0, 17);
        }

        if (eightcardid.length() == 17) {
            int sum = 0;
            for (int i = 0; i < 17; i++) {
                String k = eightcardid.substring(i, i + 1);
                ai[i] = Integer.parseInt(k);
            }

            for (int i = 0; i < 17; i++) {
                sum = sum + wi[i] * ai[i];
            }
            remaining = sum % 11;
        }

        return remaining == 2 ? "X" : String.valueOf(vi[remaining]);
    }

    // 15位转18位身份证
    public static String uptoeighteen(String fifteencardid) {
        String eightcardid = fifteencardid.substring(0, 6);
        eightcardid = eightcardid + "19";
        eightcardid = eightcardid + fifteencardid.substring(6, 15);
        eightcardid = eightcardid + getVerify(eightcardid);
        return eightcardid;
    }
}
