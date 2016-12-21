package com.qian.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * 
 * @Description xml-bean转换
 * @author hougn
 * @date 2015年11月23日
 *
 */
public class XmlBeanUtil {

    public static String toXml(Object obj) {
        // XStream xstream=new XStream();
        // XStream xstream=new XStream(new DomDriver()); //直接用jaxp dom来解释
        // 指定编码解析器,直接用jaxp dom来解释
        XStream xstream = new XStream(new DomDriver("GBK"));

        xstream.processAnnotations(obj.getClass());
        return xstream.toXML(obj);
    }

    /**
     *  将传入xml文本转换成Java对象
     * @Title: toBean
     * @param xmlStr
     * @param cls  xml对应的class类
     * @return T   xml对应的class类的实例对象
     *
     */
    public static <T> T toBean(String xmlStr, Class<T> cls) {
        XStream xstream = new XStream(new DomDriver("GBK"));
        xstream.processAnnotations(cls);
        T obj = (T) xstream.fromXML(xmlStr);
        return obj;
    }

}
