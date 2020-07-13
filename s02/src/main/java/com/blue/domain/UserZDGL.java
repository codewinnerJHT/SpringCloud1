package com.blue.domain;

/**
 * 账单功能
 */
public class UserZDGL {

    protected String billid;
    protected String billacount;
    protected String billtime;
    protected String billtransactionamount;
    protected String payment;

    public String getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid;
    }

    public String getBillacount() {
        return billacount;
    }

    public void setBillacount(String billacount) {
        this.billacount = billacount;
    }

    public String getBilltime() {
        return billtime;
    }

    public void setBilltime(String billtime) {
        this.billtime = billtime;
    }

    public String getBilltransactionamount() {
        return billtransactionamount;
    }

    public void setBilltransactionamount(String billtransactionamount) {
        this.billtransactionamount = billtransactionamount;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}
