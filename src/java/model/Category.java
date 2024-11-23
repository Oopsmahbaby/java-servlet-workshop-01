/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Category {
    private int typeID;
    private String categoryName,memo;

    public Category() {
    }

    public Category(int typeID, String categoryName, String memo) {
        this.typeID = typeID;
        this.categoryName = categoryName;
        this.memo = memo;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "Category{" + "typeID=" + typeID + ", categoryName=" + categoryName + ", memo=" + memo + '}';
    }
    
    
}
