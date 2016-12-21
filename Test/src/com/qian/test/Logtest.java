package com.qian.test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qian.user.User;

/**
 * 测试日志的记录功能
 * @author qld
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) 
public class Logtest {
	
	
	@Test
	public void test() throws IOException {
		
		User u=new User(1, "qian", "abc");
		
		String result=toObjectString(u, u);
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println("结果是:"+sdf.format(cal.getTime()));
		
	}
	
	
	/**
	 * 
	 * 转换输入输出参数<br>
	 *
	 * @param o
	 * @param dep
	 * @return  String
	 */
		
		private static String toObjectString(Object o, Object dep) {
			if (null == o) {
				return null;
			}

			StringBuffer c = new StringBuffer(500);

			Class<?> clazz = o.getClass();
			Method[] methods = clazz.getMethods();

			c.append(o.getClass().getSimpleName()).append(" {").append("\r\n");

			for (Method method : methods) {
				String mname = method.getName();
				Class<?> type = method.getReturnType();
				if (mname.length() <= 3 || mname.equals("getClass")) {
					continue;
				}

				if (mname.substring(0, 3).equals("get")) {
					try {
						Object returnO = method.invoke(o, new Object[] {});
						mname = mname.replaceFirst("get", "");
						mname = String.valueOf(mname.charAt(0) + "").toLowerCase() + mname.substring(1);
						c.append("    ").append(type.getSimpleName()).append(" ").append(mname);

						if (null == type.getPackage() || type.getPackage().equals(Package.getPackage("java.lang")) || type.getPackage().equals(Package.getPackage("java.math"))) {
							c.append(" = ").append(String.valueOf(returnO));
						} else if(returnO instanceof java.util.Calendar) {
							if(null != returnO) {
								c.append(" = ").append(new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS").format(((java.util.Calendar) returnO).getTime()));
							} else {
								c.append(" = ").append("null");
							}
						} else if(returnO instanceof java.util.Date) {
							if(null != returnO) {
								c.append(" = ").append(new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS").format((java.util.Date) returnO));
							} else {
								c.append(" = ").append("null");
							}
						}else if(returnO instanceof java.util.List){
							c.append("={");
							//循环获得list对象的值
							Object re=null;
							User user=null;;
//							RoleInfo role=null;
//							DptInfo dpt=null;
							if(returnO!=null){
								if(((java.util.List) returnO).get(0) instanceof User){
									user=(User) ((java.util.List) returnO).get(0);
								}
							
							
							if(user!=null){
						     re=user;
							}
							Class<?> clazzlist = re.getClass();
							Method[] methodlist = clazzlist.getMethods();
							for (Method method2 : methodlist) {
								String namelist=method2.getName();
								Class<?> typelist = method2.getReturnType();
								if (namelist.length() <= 3 || namelist.equals("getClass")) {
									continue;
								}
							//复制代码的开始	
								
								if (namelist.substring(0, 3).equals("get")) {
									try {
										Object returnlist = method2.invoke(re, new Object[] {});
										namelist = namelist.replaceFirst("get", "");
										namelist = String.valueOf(namelist.charAt(0) + "").toLowerCase() + namelist.substring(1);
										c.append("    ").append(typelist.getSimpleName()).append(" ").append(namelist);

										if (null == typelist.getPackage() || typelist.getPackage().equals(Package.getPackage("java.lang")) || typelist.getPackage().equals(Package.getPackage("java.math"))) {
											c.append(" = ").append(String.valueOf(returnlist));
										} else if(returnlist instanceof java.util.Calendar) {
											if(null != returnlist) {
												c.append(" = ").append(new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS").format(((java.util.Calendar) returnlist).getTime()));
											} else {
												c.append(" = ").append("null");
											}
										} else if(returnlist instanceof java.util.Date) {
											if(null != returnlist) {
												c.append(" = ").append(new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS").format((java.util.Date) returnlist));
											} else {
												c.append(" = ").append("null");
											}	
										}else{
										c.append("=").append("null");	
										}
										c.append(";").append("\r\n");
										}catch (Exception e) {
										e.printStackTrace();
										}
								}
							}
							//结束的代码	
							}
							c.append("}");
						} 
						else {
							c.append(" = ").append("null");
						}
						c.append(";").append("\r\n");
					} catch (Exception e) {
						//e.printStackTrace();
					}
				}
			}
			c.append("}");
			return c.toString();
		}

}
