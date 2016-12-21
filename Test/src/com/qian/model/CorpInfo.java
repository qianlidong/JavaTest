package com.qian.model;

public class CorpInfo extends UserInfo{
	
	private String cust_id;
	
	private String corp_name;
	
    private String corp_type;

    public CorpInfo(){
    	
    	System.out.println("没有参数的");
    }
    
    public CorpInfo(String name){
    	
    	System.out.println("有参数的name:"+name);
    }
    
	public String getCust_id() {
		return cust_id;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public String getCorp_name() {
		return corp_name;
	}

	public void setCorp_name(String corp_name) {
		this.corp_name = corp_name;
	}

	public String getCorp_type() {
		return corp_type;
	}

	public void setCorp_type(String corp_type) {
		this.corp_type = corp_type;
	}
	
	
	

}
