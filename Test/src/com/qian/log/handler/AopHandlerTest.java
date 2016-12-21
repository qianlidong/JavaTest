package com.qian.log.handler;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;


public class AopHandlerTest {

	private Map actions;
	
	public Map getActions() {
		return actions;
	}


	public void setActions(Map actions) {
		this.actions = actions;
	}


	//名称必须是这个
	public void log(JoinPoint pjp){
		
		String className=pjp.getTarget().getClass().toString();
		
		String methodName=pjp.getSignature().getName();
		
		//String action=getAction(methodName);
		
		System.out.println(className+"类名"+methodName+"方法名");
	}
	
	
	private String getAction(String acn)
	{
		String res="";
		Iterator iter=actions.keySet().iterator();
		while (iter.hasNext()) {
			String elem = (String) iter.next();
			if(acn.toLowerCase().startsWith(elem.toLowerCase())
					&&(!acn.equals("saveLog")))
				res=(String) actions.get(elem);
		}
		return res;
	}
	
	
	@SuppressWarnings("finally")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable
	{
		// start stopwatch
		Signature signature = pjp.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method method = methodSignature.getMethod();
		String methodName = method.getName();
		Object retVal = null;
		try
		{
			retVal = pjp.proceed();
			// 不是DDL操作 不需要事物
			if (methodName.startsWith("select")
					|| methodName.startsWith("query")
					|| methodName.startsWith("get")
					|| methodName.startsWith("find"))
			{
				DBContextHolder.rollbackAllTransaction();
			}
			else DBContextHolder.commitAllTransaction();

		}
		catch (Throwable ab)
		{
			if (ab != null && retVal == null)
			{
				DBContextHolder.rollbackAllTransaction();
				throw ab.getCause();
			}
		}
		finally
		{
			DBContextHolder.releaseAllTransaction();
			return retVal;
		}

	}

}
