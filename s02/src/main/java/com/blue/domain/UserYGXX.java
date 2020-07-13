package com.blue.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 员工信息
 */
public class UserYGXX {
    protected Integer enumber;
    protected String ename;
    protected String sex;
    protected String address;
    protected Date birthdate;
    protected String phone;
    protected String position;

    public Integer getEnumber() {
        return enumber;
    }

    @Override
    public String toString() {
        return "UserYGXX{" +
                "enumber=" + enumber +
                ", ename='" + ename + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", birthdate=" + birthdate +
                ", phone='" + phone + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    public void setEnumber(Integer enumber) {
        this.enumber = enumber;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getSexx(){

        int flag=0;
        if("男".equals(this.sex)){

            flag=1;
        }
        if ("女".equals(this.sex)){

            flag= 0;
        }
        return flag;
    }
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthdate() {

        return birthdate;
    }
    // 对date进行格式化，返回为字符串格式
    public String getDate(){

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd");
        String date = simpleDateFormat.format(this.birthdate);
        return date;

    }
    public void setDate(String date) {

        SimpleDateFormat simpleDateFormat=null;
        if(date.contains("/")) {
            simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        }
        else if (date.contains("-")){

            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        }
        Date parse=null;
        try {
            parse = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.birthdate = parse;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
