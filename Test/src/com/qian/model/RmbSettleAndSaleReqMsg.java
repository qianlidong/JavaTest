package com.qian.model;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 定额人民币集中结售汇
 * 请求报文xml封装对象
 * 
 */
@XStreamAlias("stream")
public class RmbSettleAndSaleReqMsg implements Serializable {

    private static final long serialVersionUID = 1791100280160473767L;

    @XStreamAlias("e3rdPayNo")
    private String gopayNo = ""; // 第三方支付机构号
    private String transTime = ""; // 第三方发起时间

    @XStreamAlias("e3rdTranNo")
    private String gopayTranNo = ""; // 第三方支付交易流水号
    
    private String exType = ""; //结售汇类型

    @XStreamAlias("cnyExAmt")
    private String cnyExAmt = ""; // 结售汇金额（人民币）

    private String currencyID = ""; // 结售汇币别

    private String tranSort = ""; // 交易属性

    private String billNo = ""; // 外汇局批件号/备案表号/业务编号

    private String exUse = ""; // 结汇用途

    private String exUseDet = ""; // 结汇详细用途

    private String txCode = ""; // 交易编码

    public String getGopayNo() {
        return gopayNo;
    }

    public void setGopayNo(String gopayNo) {
        this.gopayNo = gopayNo;
    }

    public String getTransTime() {
        return transTime;
    }

    public void setTransTime(String transTime) {
        this.transTime = transTime;
    }

    public String getGopayTranNo() {
        return gopayTranNo;
    }

    public void setGopayTranNo(String gopayTranNo) {
        this.gopayTranNo = gopayTranNo;
    }

    
    public String getExType() {
        return exType;
    }

    public void setExType(String exType) {
        this.exType = exType;
    }

    
    public String getCnyExAmt() {
		return cnyExAmt;
	}

	public void setCnyExAmt(String cnyExAmt) {
		this.cnyExAmt = cnyExAmt;
	}

	public String getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(String currencyID) {
        this.currencyID = currencyID;
    }

    public String getTranSort() {
        return tranSort;
    }

    public void setTranSort(String tranSort) {
        this.tranSort = tranSort;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getExUse() {
        return exUse;
    }

    public void setExUse(String exUse) {
        this.exUse = exUse;
    }

    public String getExUseDet() {
        return exUseDet;
    }

    public void setExUseDet(String exUseDet) {
        this.exUseDet = exUseDet;
    }

    public String getTxCode() {
        return txCode;
    }

    public void setTxCode(String txCode) {
        this.txCode = txCode;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
