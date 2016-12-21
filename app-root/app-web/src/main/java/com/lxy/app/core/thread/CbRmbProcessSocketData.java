package com.lxy.app.core.thread;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 
 * @ClassName: CbRmbProcessSocketData
 * @Description: 客户端数据处理
 * @author gd.cui
 * @date 2016年7月11日 上午11:45:50 ww.gopay.com.cn Inc.All rights reserved.
 */
public class CbRmbProcessSocketData extends Thread {

    

    private static Log logger = LogFactory.getLog(CbRmbProcessSocketData.class);

    private Socket socket;

    private ServletContext servletContext;

    public void init() {
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
 
    }

    public CbRmbProcessSocketData() {
        super();
    }

    public CbRmbProcessSocketData(Socket socket, ServletContext servletContext) {
        this.socket = socket;
        this.servletContext = servletContext;
        init();
    }

    @Override
    public void run() {
        logger.error("******* cbrmb socket server start CbRmbProcessSocketData ");
        InetAddress remoteAddress = socket.getInetAddress();
        String remoteIp = remoteAddress.getHostAddress();
        logger.error("remote ip :" + remoteIp);
        /*
         * if (!CbRmbBankConstants.PERMIT_IP.equalsIgnoreCase(remoteIp)) {
         * logger.debug("接受信息时IP不合法"); }
         */
        OutputStream os = null;
        InputStream is = null;
        try {
            os = socket.getOutputStream();
            is = socket.getInputStream();
            logger.debug("*****回盘-接受socket数据流信息");
            byte[] source = toByteArray(is);
            os.write("sss".getBytes());
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != socket) {
                logger.info(" *********release connect socket");
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            /**
             * 此处可能会有问题：如果回盘信息接收成功，在读取或更新以下文件时有部分失败，可能会造成数据无法完全解析。
             * 现想到修改方法：算了先不写了， 还是记下吧 ，在通知里增加表示 
             */
           
        } catch (Exception e) {
            logger.info("*********文件处理异常"+e);
        }
    }
    
    
    public static byte[] toByteArray(InputStream input) throws Exception {
        try {
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int n = 0;
            while (-1 != (n = input.read(buffer))) {
                output.write(buffer, 0, n);
            }
            return output.toByteArray();
        } catch (Exception e) {
        	 throw new Exception(e.getMessage());
        }
    }

}
