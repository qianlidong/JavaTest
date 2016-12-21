package com.lxy.app.core.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableTest {
	public static void main(String args[]) throws Exception {
		UserSer user = new UserSer("1", "张三", 18, 0);
		serializable(user);
		UserSer u1 = (UserSer) reSerializable();
		System.out.println(u1.toString());
	}

	public static void serializable(Object obj) throws Exception {
		FileOutputStream os = new FileOutputStream(new File("D:/ser.txt"));
		ObjectOutputStream oo = new ObjectOutputStream(os);
		oo.writeObject(obj);
		oo.close();
		os.close();
	}

	public static Object reSerializable() throws Exception {
		FileInputStream is = new FileInputStream(new File("D:/ser.txt"));
		ObjectInputStream ois = new ObjectInputStream(is);
		Object obj = ois.readObject();
		ois.close();
		is.close();
		return obj;
	}
}
