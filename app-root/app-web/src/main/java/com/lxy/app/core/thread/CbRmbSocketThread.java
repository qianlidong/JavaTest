package com.lxy.app.core.thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @ClassName: CbRmbSocketThread 
 * @Description: 单独启动一个线程去等待客户端连接 
 * @author gd.cui 
 * @date 2016年7月11日 上午11:44:49 ww.gopay.com.cn Inc.All rights reserved.
 */
public class CbRmbSocketThread extends Thread {
    
    private static Log logger = LogFactory.getLog(CbRmbServerSocketListener.class);

    private ServletContext servletContext;

    private ServerSocket serverSocket;

    public CbRmbSocketThread(ServerSocket serverSocket, ServletContext servletContext) {
        this.servletContext = servletContext;
        if (serverSocket == null) {
            try {
                this.serverSocket = new ServerSocket(2001);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void run() {
        logger.error("********** cbrmb service start CbRmbSocketThread ");
        while (!this.isInterrupted()) {
            try {
                Socket socket = serverSocket.accept();
                 logger.error("测试socket:*******"+socket.toString());
                if (socket != null) {
                    new CbRmbProcessSocketData(socket, this.servletContext).start();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void closeServerSocket() {

        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
