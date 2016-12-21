package com.qian.test;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import javax.servlet.http.HttpServletResponse;

import org.quartz.impl.jdbcjobstore.FiredTriggerRecord;


import com.qian.model.UserInfo;

public class Test1203 {


    public static void main(String[] args) {
        // CorpInfo c=new CorpInfo();
        // CorpInfo cc=(CorpInfo) sign(c);
        // System.out.println(cc);
         Calendar cal=Calendar.getInstance();
        // SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");

        // System.out.println(cal.getTime().getHours());
//         Date nowTime=cal.getTime();
//         SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//         Date date430=new Date(nowTime.getYear(), nowTime.getMonth(),
//         nowTime.getDate(),11, 00);
//         System.out.println(sdf.format(date430)<=);
        // System.out.println(date430);
        // DecimalFormat formatter = new DecimalFormat("0.00");
       
        // System.out.println(sdf.format(cal.getTime()));
        // BigDecimal big=new BigDecimal("614.0500").divide(new
        // BigDecimal(100));
        // System.out.println(new BigDecimal("1.0047").divide(new
        // BigDecimal("1"),2,BigDecimal.ROUND_UP));
        //
        // RmbSettleAndSaleReqMsg rmbMsg = new RmbSettleAndSaleReqMsg();
        // rmbMsg.setCnyExAmt("0.3");
        // String xmlReq=XmlBeanUtil.toXml(rmbMsg);
        // System.out.println("【退款结汇请求报文：】" + xmlReq);
        // Date nowTime = cal.getTime();
        // System.out.println("20".substring(0,1));
        // System.out.println(nowTime.getMinutes()==30);
        // Pattern pattern = Pattern.compile("\\d+\\.\\d+$|-\\d+\\.\\d+$");
        // System.out.println(pattern.matcher(new
        // BigDecimal("15.02").toString()).find());

        // BigDecimal amt=new BigDecimal("20.00");
        // String re="0"+amt.toString().substring(amt.toString().indexOf("."));
        // System.out.println(new BigDecimal(re).compareTo(BigDecimal.ZERO));
        // System.out.print(getWGJrateTime());
        // sign(new UserInfo());
//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.DAY_OF_MONTH, 100);
//        Date date = cal.getTime();
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//        System.out.println(sdf.format(date));
//        String str = null;
//        try {
//            System.out.println(str.equals(null));
//        } catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//            logger.info("111", e);
//        }
        Integer a=100,b=100,c=1000,d=1000;
        //List<Object[]> list=new ArrayList<>(2);
        //BigDecimal totalAmt=new BigDecimal(list.toString()); 
        System.out.println(      cal.get(Calendar.MONTH)+1);
    System.out.println(new Integer(100).equals(new Integer(100)));
    System.out.println(c.equals(d));    
        
//        try {
//            LinkedBlockingQueue<String> queue=new LinkedBlockingQueue(2);
//            
//            queue.offer("hello");
//            queue.offer("world");
//            System.out.println("一直在等待了");
//            queue.offer("yes");
//            
//            System.out.println("yes"+queue.toString());
//        } catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        }
       System.out.println("第一个是："+ FirstUniqueChar("ywegrwyqfh"));
        
    }

    
   public static String FirstUniqueChar(String str) {
        for (int i=0; i<str.length(); i++) {
            String subStr=str.substring(i,i+1);
            if (str.indexOf(subStr,i+1) == -1) 
                return subStr.charAt(0)+"";
        }
        return "";
    }
    
    public static final String sign(String src) {
        final int i4 = 4;
        final int i0xf = 0xf;
        char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            byte[] strTemp = src.getBytes("UTF-8");
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            /* 转换为16进制 */
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> i4 & i0xf];
                str[k++] = hexDigits[byte0 & i0xf];
            }
            return new String(str);
        } catch (Exception e) {
            
            return null;
        }
    }
    
    
    public static UserInfo sign(UserInfo u) {
        // CorpInfo c=(CorpInfo)u;
        //
        // c.setCorp_name("qian");
        try {
            Date date = new Date();
            String str = null;
            str.charAt(0);
        } catch (Exception e) {
            System.err.println("抓住");
            e.printStackTrace();

        } finally {
            System.out.println("我肯定执行");

            Date date = new Date();
            String str = null;
            str.charAt(0);

            System.out.println("继续吗");

        }
        System.out.println("dd");

        return new UserInfo();
    }

    public static String getWGJrateTime() {

        Calendar c = Calendar.getInstance();
        int month = c.get(Calendar.MONTH);
        int date = c.get(Calendar.DATE);
        int hour = c.get(Calendar.HOUR_OF_DAY);

        String time = "";
        if (date != 1) {
            // 如果不是1号，取当前月
            time = c.get(Calendar.YEAR) + "-" + (month + 1);
        } else {
            if (hour >= 7) {
                // 如果是7点以后取当前月
                time = c.get(Calendar.YEAR) + "-" + (month + 1);
            } else if (hour < 7) {
                // 如果是7点以前，取上个月
                time = c.get(Calendar.YEAR) + "-" + (month);
            }
        }
        return time;

    }

}
