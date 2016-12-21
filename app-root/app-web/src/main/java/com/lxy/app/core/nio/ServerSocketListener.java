package com.lxy.app.core.nio;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ServerSocketListener implements ServletContextListener {

	private static Log logger = LogFactory.getLog(ServerSocketListener.class);

	private ServerSocketThread serverSocketThread;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("===init Server socket thread");
		ServletContext sc = sce.getServletContext();
		if (sc != null) {
			serverSocketThread = new ServerSocketThread(sc);
			new Thread(serverSocketThread).start();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		logger.info("===destroy Server socket thread");
		if (serverSocketThread != null) {
			logger.info("===destroy Server socket thread");
			serverSocketThread.close();
		}
	}

}
