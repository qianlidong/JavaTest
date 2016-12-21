<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.security.*"%>
<%@ page import="java.io.UnsupportedEncodingException"%>
<%@ page import="java.io.PrintWriter"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>后台管理系统登录</title>
	</head>

	
	
	<body > 
	
<form action="login1.do">
    username1:<input type="text" name="username1" onfocus="aa()"><br/>
    password1:<input type="password" name="pwd1"><br/>
    <input type="submit" value="提交1">
    </form>
<hr />

	<form action="login.do">
    username2:<input type="text" name="username2"><br>
    password2:<input type="password" name="pwd2"><br>
    <input type="submit" value="提交2">
    </form>
    
   <hr/>
   
 <% PrintWriter out1 = response.getWriter();
 out1.println("aaaaaaaaa");
 out1.flush();
 out1.close(); %>

    
    	<form  method="post" action="sign.jsp" target="_blank">
		<table width="100%">
		<tr><td width="40%" align=right>版本号:     </td><td align=center><input type="text" id="version" name="version" value="1.0" size="50"/></td></tr>
		<tr><td width="40%" align=right>交易代码:     </td><td align=center><input type="text" id="tranCode" name="tranCode" value="4025" size="50"/></td></tr>
		<tr><td width="40%" align=right>企业ID:      </td><td align=center><input type="text" id="customerId" name="customerId" value="0000047106" size="50"/></td></tr>
		<tr><td width="40%" align=right>订单号:       </td><td align=center><input type="text" id="merOrderNum" name="merOrderNum" value="" size="50"/></td></tr>
		<tr><td width="40%" align=right>交易金额:     </td><td align=center><input type="text" id="tranAmt" name="tranAmt" value="100" size="50"/></td></tr>
		<tr><td width="40%" align=right>企业URL:     </td><td align=center><input type="text" id="merURL" name="merURL" value="http://webtestgray.gopay.com.cn/webtest/result/webclient/front/recv.do" size="50" /></td></tr>
		<tr><td width="40%" align=right>收款方银行开户名:     </td><td align=center><input type="text" id="recvBankAcctName" name="recvBankAcctName" value="银行开户名" size="50" /></td></tr>
		<tr><td width="40%" align=right>收款方银行所在省份:   </td><td align=center><input type="text" id="recvBankProvince" name="recvBankProvince" value="省份" size="50" /></td></tr>
		<tr><td width="40%" align=right>收款方银行所在城市:   </td><td align=center><input type="text" id="recvBankCity" name="recvBankCity" value="城市" size="50" /></td></tr>
		<tr><td width="40%" align=right>收款方银行名称:     </td><td align=center><input type="text" id="recvBankName" name="recvBankName" value="银行名称" size="50" /></td></tr>
		<tr><td width="40%" align=right>收款方银行网点名称:     </td><td align=center><input type="text" id="recvBankBranchName" name="recvBankBranchName" value="银行网点名称" size="50" /></td></tr>
		<tr><td width="40%" align=right>收款方银行帐号:     </td><td align=center><input type="text" id="recvBankAcctNum" name="recvBankAcctNum" value="456564546545646546465" size="50" /></td></tr>
		<tr><td width="40%" align=right>公私标识:     </td><td align=center><input type="text" id="corpPersonFlag" name="corpPersonFlag" value="1" size="50" /></td></tr>
		<tr><td width="40%" align=right>交易时间:     </td><td align=center><input type="text" id="tranDateTime" name="tranDateTime" value="20120820144254" size="50"/></td></tr>
		<tr><td width="40%" align=right>交易备注:  </td><td align=center><input type="text"  id="description" name="description" value="" size="50"/></td></tr>
		<tr><td width="40%" align=right>企业编码方式:  </td><td align=center><input type="text"  id="merchantEncode" name="merchantEncode" value="1" size="50"/></td></tr>
		<tr><td colspan=2>&nbsp;</td></tr>
		<tr><td colspan=2 width="100%"><center><input type="submit" name="submit" id="submit" value="开始测试"/></center></td></tr>
		
		</table>
		</form>
    
	</body>

</html>
