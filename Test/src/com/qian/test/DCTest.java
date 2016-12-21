package com.qian.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dynamicode.invoked.Standard;
import com.dynamicode.parsereturncode.ParseReturnCode;
import com.dynamicode.parsereturncode.TokenInfoBean;
import com.dynamicode.parsereturncode.UserInfoBean;


public class DCTest {
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		List<HashMap<String, String>> serverList = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> server1 = new HashMap<String, String>();
		server1.put("host", "211.88.2.77");
		server1.put("port", "8888");//dcsrv有关的
		server1.put("key", "20080808");
		serverList.add(server1);
		Standard standard = new Standard(serverList);
		ParseReturnCode returnMsg = null;
		System.out.println(new Date(System.currentTimeMillis()));
		//获取激活码
//		returnMsg  = standard.getActiveCodeAndActiveToken("zh_CN", 1, "4151407768");
//		System.out.println("Retcode:"+returnMsg .getRetcode());
//		System.out.println("Retdesc:"+returnMsg .getRetdesc());
//		System.out.println("Retdesc:"+returnMsg .getResponsecode());
		
//		//令牌序列号验证 mschap v1
//		returnMsg  = standard.CheckMsChap1("zh_CN", 1, "4270000001", //引擎编号，令牌序列号
//				"1234567800000000",//认证端挑战码，应该16字节，实用8字节，字符串，内部转二进制； 
//				"BF447D7C8FC78E603BF59A386BA39E0424FB096CB03EC5B5",//NTPassword的Response，字符串48字节，字符串，内部转二进制；
//				"123456",//共享密钥，预先配置的；
//				"12345678901234567890123456789012"//请求挑战码，在RadiusPacket的头字段中，16字节，32字符串，内部转二进制；
//				);
//		System.out.println("Retcode:"+returnMsg .getRetcode());
//		System.out.println("Retdesc:"+returnMsg .getRetdesc());
//		//responsecode MPPE字符串，外部至少提供至少67长度，返回值类似0x9B95BEBF853F601282543D9C11C20F3C7B4CE53943DD13B0031E431417A8B359，需要自行转换二进制。
//		System.out.println("Responsecode:"+returnMsg .getResponsecode());
		
//		//用户名验证 mschap v1
//		returnMsg  = standard.CheckMsChap1ByUserName("zh_CN", 57, "changqiao_liu",//应用编号，用户名 
//				"0dbbf2a0aea702b8",//认证端挑战码，应该16字节，实用8字节，字符串，内部转二进制； 
//				"82e0df332e1140b89d4ba493f9d50e2b9a900993c8e1f920",//NTPassword的Response，字符串48字节，字符串，内部转二进制；
//				"kingdee01",//共享密钥，预先配置的；
//				"baa3691a430577635342f6dfa3ca7571"//请求挑战码，在RadiusPacket的头字段中，16字节，32字符串，内部转二进制；
//				);
//		System.out.println("Retcode:"+returnMsg .getRetcode());
//		System.out.println("Retdesc:"+returnMsg .getRetdesc());
//		System.out.println("Responsecode:"+returnMsg .getResponsecode());

		
		//绑定
//		returnMsg  = standard.AppBind("zh_CN",57/*应用编号*/, "donglai"/*账户名*/, 1/*引擎编号*/, "4151407770"/*令牌序列号*/);
//		System.out.println("Retcode:"+returnMsg .getRetcode());
//		System.out.println("Retdesc:"+returnMsg .getRetdesc());
//		
		//解绑
//		returnMsg  = standard.AppUnbind("zh_CN",57/*应用编号*/, "donglai"/*账户名*/, 1/*引擎编号*/, "4290000307"/*令牌序列号*/);
//		System.out.println("Retcode:"+returnMsg .getRetcode());
//		System.out.println("Retdesc:"+returnMsg .getRetdesc());
		
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyymmdd hhmmss");
//		System.out.println("现在时间:"+sdf.format(new Date()));
//		
//		//验证密码
//		returnMsg  = standard.CheckDynamicPwdByToken("zh_CN", 1/*引擎编号*/, "4151407768"/*令牌序列号*/, "453471"); 
//		System.out.println("Retcode:"+returnMsg .getRetcode());
//		System.out.println("Retdesc:"+returnMsg .getRetdesc());
//		
//		//验证密码
//		returnMsg  = standard.CheckDynamicPwdByToken("zh_CN", 1/*引擎编号*/, "4151407768"/*令牌序列号*/, "453471"); 
//		System.out.println("Retcode:"+returnMsg .getRetcode());
//		System.out.println("Retdesc:"+returnMsg .getRetdesc());
		
		//
//		 returnMsg = standard. TokenSync ("zh_CN",1, "4151407768","453999");
//		 returnMsg = standard. TokenSync ("zh_CN",1, "4151407768","453999");

		
		
		
//		 returnMsg = standard.getActiveTokenCode("zh_CN",1, "4151407768"); 
//		System.out.println(returnMsg.getRetcode());//返回代码，0表示操作成功，非0表示未成功。
//		System.out.println(returnMsg.getRetdesc());//返回码描述信息
//         System.out.println(returnMsg.getResponsecode());//返回令牌激活码
		
		//验证密码
//		returnMsg  = standard.CheckDynamicPwdByUser("zh_CN", 57/*应用编号*/, "donglai"/*账户名*/, "888888"); 
//		System.out.println("Retcode:"+returnMsg .getRetcode());
//		System.out.println("Retdesc:"+returnMsg .getRetdesc());
		//解锁
//		returnMsg=standard.TokenUnlock("zh_CN",1, "4151407768");
//		
//		System.out.println("解锁结果："+returnMsg.getRetdesc());
		
		 returnMsg = standard.TokeEnable("zh_CN", 1, "4151407765");
		//standard.tokenQuery ("zh_CN",57, "",1,tokensn);
		System.out.println("启用结果"+returnMsg.getRetdesc()+returnMsg.getRetcode());
		
		//查询
		returnMsg  = standard.tokenQuery("zh_CN", -1, null, 1, "4151407770");
		System.out.println("sss"+returnMsg.getTokenList());
		System.out.println("Retcode:"+returnMsg .getRetcode());
		System.out.println("Retdesc:"+returnMsg .getRetdesc());
		int tokenSize = Integer.parseInt(returnMsg.getTokensize());//
		if(tokenSize>0){
			List list = returnMsg.getTokenList();
			for(int i=0;i<tokenSize;i++){
				TokenInfoBean tokenInfoBean = (TokenInfoBean)list.get(i);
				tokenInfoBean.getEngineid();
				tokenInfoBean.getTokensn();
				System.out.println("令牌开始时间:"+tokenInfoBean.getBirthtime());
				System.out.println("令牌结束时间:"+tokenInfoBean.getDeathtime());
			}
		}
		int userSize = Integer.parseInt(returnMsg.getUsersize());
		if(userSize>0){
			List list = returnMsg.getUserList();
			for(int i=0;i<userSize;i++){
				UserInfoBean userInfoBean = (UserInfoBean)list.get(i);
				userInfoBean.getAppid();
				userInfoBean.getUsername();
			}
		}
	}
}
