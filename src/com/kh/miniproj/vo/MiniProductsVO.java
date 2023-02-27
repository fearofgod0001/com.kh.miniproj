package com.kh.miniproj.vo;

public class MiniProductsVO {
    private String pID;
    private String pName;
    private String color;
    private String pSize;
    private int price;
    private int stkQuan;

    public MiniProductsVO(String pID, String pName, String color, String pSize, int price, int stkQuan) {
        this.pID = pID;
        this.pName = pName;
        this.color = color;
        this.pSize = pSize;
        this.price = price;
        this.stkQuan = stkQuan;
    }

    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getpSize() {
        return pSize;
    }

    public void setpSize(String pSize) {
        this.pSize = pSize;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStkQuan() {
        return stkQuan;
    }

    public void setStkQuan(int stkQuan) {
        this.stkQuan = stkQuan;
    }
}
