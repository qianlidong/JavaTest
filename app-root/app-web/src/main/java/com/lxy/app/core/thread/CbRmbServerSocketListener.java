package com.lxy.app.core.thread;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @ClassName: CbRmbServerSocketListener 
 * @Description: 建行SocketServer启动监听  
 * @author gd.cui
 * @date 2016年7月11日 上午11:44:11 ww.gopay.com.cn Inc.All rights reserved.
 */
public class CbRmbServerSocketListener implements ServletContextListener {

    private static Log logger = LogFactory.getLog(CbRmbSocketThread.class);
    private CbRmbSocketThread cbRmbSocketThread;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.error("********** cbrmb socket listerner start");
        ServletContext servletContext = sce.getServletContext();
        if (cbRmbSocketThread == null) {
            cbRmbSocketThread = new CbRmbSocketThread(null, servletContext);
            cbRmbSocketThread.start();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.error("********** cbrmb socket listerner destroy");
        if (cbRmbSocketThread != null && cbRmbSocketThread.isInterrupted()) {
            cbRmbSocketThread.closeServerSocket();
            cbRmbSocketThread.interrupt();
        }

    }

}
