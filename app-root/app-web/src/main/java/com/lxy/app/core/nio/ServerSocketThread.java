package com.lxy.app.core.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ServerSocketThread implements Runnable {

	private static Log logger = LogFactory.getLog(ServerSocketThread.class);

	private ServletContext sc;

	private ServerSocketChannel serverSocketChannel;

	private Selector selector;

	public ServerSocketThread(ServletContext sc) {
		logger.error("ServerSocketThread 初始化");
		this.sc = sc;
	}

	@Override
	public void run() {
		try {
			logger.error("serverSocketChannel 开始启动");
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.socket().bind(new InetSocketAddress(2002));
			serverSocketChannel.configureBlocking(false);
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			logger.error("serverSocketChannel 启动success");
			while (true) {
				SocketChannel socketChannel = serverSocketChannel.accept();
				if (socketChannel != null) {
					logger.error("有socket客户端连接");
					ByteBuffer buf = ByteBuffer.allocate(1024);
					buf.clear();
					int bytesRead = socketChannel.read(buf);
					logger.error("bytesRead数据" + bytesRead);
					/*
					 * while (bytesRead != -1) {
					 * 
					 * buf.flip(); // make buffer ready for read
					 * 
					 * while (buf.hasRemaining()) { System.out.print((char)
					 * buf.get()); // read 1 byte // at a time } buf.clear(); //
					 * make buffer ready for writing logger.error("bytesRead数据"
					 * + bytesRead); bytesRead = socketChannel.read(buf);
					 * logger.error("bytesRead数据" + bytesRead); }
					 */
					System.out.print(bytesRead + "====" + (char) buf.get());
					logger.error("socket数据" + bytesRead);
					buf.clear();
					String str = "success";
					buf.put(str.getBytes());
					buf.flip();
					while (buf.hasRemaining()) {
						socketChannel.write(buf);
					}
					socketChannel.close();
				}
			}
		} catch (IOException e) {
			logger.error("启动线程失败");
			e.printStackTrace();
		}

	}

	public void close() {
		if (serverSocketChannel != null) {
			try {
				logger.error("关闭serverSocketChannel");
				serverSocketChannel.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
