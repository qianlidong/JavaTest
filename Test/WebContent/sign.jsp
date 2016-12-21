<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.security.*"%>
<%@ page import="java.io.UnsupportedEncodingException"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>后台管理系统登录</title>
	</head>
	  <script type="text/javascript">
     function aa(){
    	 var firstDate = new Date(2015,4,5);
    	 var sDate = new Date(2015,9,5);
    	 alert(firstDate.setFullYear(firstDate.getFullYear() + 0.5)<sDate);
    		var merName='中国abc(北京)';
    		alert(isCheckmerName(merName));
    		if(!isCheckmerName(merName)){
    			alert("企业客户名称格式不正确，请重新输入！");
    			   return false;
    		
    		}
	
}
  
   //查询字段，包括字母中文还有中英文括号支持
     function isCheckmerName(str)
     {
     	var regex = "^[A-Za-z\u4e00-\u9fa5()（）]+$"; 
     	var reg=new RegExp(regex);
     	return reg.test(str);
     }
   </script> 
<%!
// MD5加密方法
public static final String sign(String src) throws UnsupportedEncodingException, NoSuchAlgorithmException{
	final int i4 = 4;
	final int i0xf = 0xf;
	char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9','a', 'b', 'c', 'd', 'e', 'f' };

	byte[] strTemp = src.getBytes("UTF-8");
	MessageDigest mdTemp = MessageDigest.getInstance("MD5");
	mdTemp.update(strTemp);
	byte[] md = mdTemp.digest();
	/* 转换为16进制 */
	int j = md.length;
	char[] str = new char[j * 2];
	int k = 0;
	for (int i = 0; i < j; i++) {
		byte byte0 = md[i];
		str[k++] = hexDigits[byte0 >>> i4 & i0xf];
		str[k++] = hexDigits[byte0 & i0xf];
	}
	return new String(str);
}
%>


<%
request.setCharacterEncoding("UTF-8");
    String version = request.getParameter("version"); 
	String tranCode = request.getParameter("tranCode");
	String customerId = request.getParameter("customerId");
	String merOrderNum = request.getParameter("merOrderNum");
	String tranAmt = request.getParameter("tranAmt");
	String merURL = request.getParameter("merURL");
	String tranDateTime = request.getParameter("tranDateTime");
	String recvBankAcctName = request.getParameter("recvBankAcctName");
	String recvBankProvince = request.getParameter("recvBankProvince");
	String recvBankCity = request.getParameter("recvBankCity");
	String recvBankName = request.getParameter("recvBankName");
	String recvBankBranchName = request.getParameter("recvBankBranchName");
	String recvBankAcctNum = request.getParameter("recvBankAcctNum");
	String corpPersonFlag = request.getParameter("corpPersonFlag");
	String description = request.getParameter("description");
	String merchantEncode = request.getParameter("merchantEncode");
	;

	// 组织加密明文
	String plain = "version=[" + version + "]tranCode=[" + tranCode + "]customerId=[" + customerId + "]merOrderNum=[" + merOrderNum + "]tranAmt=[" + tranAmt + "]feeAmt=[]totalAmount=[]merURL=[" + merURL + "]recvBankAcctNum=[" + recvBankAcctNum + "]tranDateTime=[" + tranDateTime + "]orderId=[]respCode=[]VerficationCode=[87654321]";
	
	String signValue = sign(plain);
	
%>	
	
	
	<body > 
   <form action="https://gateway.gopay.com.cn/Trans/WebClientAction.do" method="post" target="_blank">
<table width="100%">
<tr>
<th>登录起止时间：</th>
					<td>
						<input type="text" placeholder="点击选取" name="beginTimeRegister" value="" id="dateBegin"  class="Wdate" onfocus="WdatePicker({errDealMode:0})"><span>至</span><input
							type="text" placeholder="点击选取" name="endTimeRegister" value="" id="dateEnd"
							class="Wdate"
							onfocus="WdatePicker({errDealMode:0})" >
					</td>

<td width="40%" align=right>版本号:     </td><td align=center><input type="text" id="version" name="version" value="<%=version%>" size="50"/></td></tr>
		<tr><td width="40%" align=right>交易代码:     </td><td align=center><input type="text" id="tranCode" name="tranCode" value="<%=tranCode%>" size="50"  onblur="aa()" /></td></tr>
		<tr><td width="40%" align=right>企业ID:      </td><td align=center><input type="text" id="customerId" name="customerId" value="<%=customerId%>" size="50"/></td></tr>
		<tr><td width="40%" align=right>订单号:       </td><td align=center><input type="text" id="merOrderNum" name="merOrderNum" value="<%=merOrderNum%>" size="50"/></td></tr>
		<tr><td width="40%" align=right>交易金额:     </td><td align=center><input type="text" id="tranAmt" name="tranAmt" value="<%=tranAmt%>" size="50"/></td></tr>
		<tr><td width="40%" align=right>企业URL:     </td><td align=center><input type="text" id="merURL" name="merURL" value="<%=merURL%>" size="50" /></td></tr>
		<tr><td width="40%" align=right>收款方银行开户名:     </td><td align=center><input type="text" id="recvBankAcctName" name="recvBankAcctName" value="<%=recvBankAcctName%>" size="50" /></td></tr>
		<tr><td width="40%" align=right>收款方银行所在省份:   </td><td align=center><input type="text" id="recvBankProvince" name="recvBankProvince" value="<%=recvBankProvince%>" size="50" /></td></tr>
		<tr><td width="40%" align=right>收款方银行所在城市:   </td><td align=center><input type="text" id="recvBankCity" name="recvBankCity" value="<%=recvBankCity%>" size="50" /></td></tr>
		<tr><td width="40%" align=right>收款方银行名称:     </td><td align=center><input type="text" id="recvBankName" name="recvBankName" value="<%=recvBankName%>" size="50" /></td></tr>
		<tr><td width="40%" align=right>收款方银行网点名称:     </td><td align=center><input type="text" id="recvBankBranchName" name="recvBankBranchName" value="<%=recvBankBranchName%>" size="50" /></td></tr>
		<tr><td width="40%" align=right>收款方银行帐号:     </td><td align=center><input type="text" id="recvBankAcctNum" name="recvBankAcctNum" value="<%=recvBankAcctNum%>" size="50" /></td></tr>
		<tr><td width="40%" align=right>公私标识:     </td><td align=center><input type="text" id="corpPersonFlag" name="corpPersonFlag" value="<%=corpPersonFlag%>" size="50" /></td></tr>
		<tr><td width="40%" align=right>交易时间:     </td><td align=center><input type="text" id="tranDateTime" name="tranDateTime" value="<%=tranDateTime%>" size="50"/></td></tr>
		<tr><td width="40%" align=right>交易备注:  </td><td align=center><input type="text"  id="description" name="description" value="<%=description%>" size="50"/></td></tr>
		<tr><td width="40%" align=right>企业编码方式:  </td><td align=center><input type="text"  id="merchantEncode" name="merchantEncode" value="1" size="50"/></td></tr>
	        <tr>
		<td width="40%" align=right>MD5加密报文(signValue):</td>
		<td align=center><input type="text" id="signValue"
			name="signValue" value="<%=signValue%>" size="50"
			readonly="readonly" /></td>
	</tr>
	<tr>
		<td colspan=2>&nbsp;</td>
	</tr>
	<tr>
		<td colspan=2 width="100%">
		<center><input type="submit" name="submit" id="submit"  value="提交网关" /></center>
		</td>
	</tr>
</table>
</form>
    
   
    
	</body>
</html>
