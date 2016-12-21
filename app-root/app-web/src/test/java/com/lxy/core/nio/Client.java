package com.lxy.core.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
	public static void main(String args[]) throws Exception {
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.connect(new InetSocketAddress("127.0.0.1", 2002));
		String newData = "New String to write to file..." + System.currentTimeMillis();
		ByteBuffer buf = ByteBuffer.allocate(1024);
		buf.clear();
		buf.put(newData.getBytes());
		buf.flip();
		while (buf.hasRemaining()) {
			socketChannel.write(buf);
		}
		buf.clear();
		
		int bytesRead = socketChannel.read(buf);
		while (bytesRead != -1) {

			buf.flip(); // make buffer ready for read

			while (buf.hasRemaining()) {
				System.out.print((char) buf.get()); // read 1 byte at a time
			}
			buf.clear(); // make buffer ready for writing
			bytesRead = socketChannel.read(buf);
		}
		System.out.print((char) buf.get());

		socketChannel.close();
	}
}
