/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class Product {
    private String productID,productName,productImage,brief,unit;
    private Date postedDate;
    private Category typeId;  
    private Account account;    
    private int price,discount;

    public Product() {
    }

    public Product(String productID, String productName, String productImage, String brief, String unit, Date postedDate, Category typeId, Account account, int price, int discount) {
        this.productID = productID;
        this.productName = productName;
        this.productImage = productImage;
        this.brief = brief;
        this.unit = unit;
        this.postedDate = postedDate;
        this.typeId = typeId;
        this.account = account;
        this.price = price;
        this.discount = discount;
    }

    

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public Category getTypeId() {
        return typeId;
    }

    public void setTypeId(Category typeId) {
        this.typeId = typeId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName=" + productName + ", productImage=" + productImage + ", brief=" + brief + ", unit=" + unit + ", postedDate=" + postedDate + ", typeId=" + typeId + ", account=" + account + ", price=" + price + ", discount=" + discount + '}';
    }
    
    
    
}
