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
public class Account {
    private String account,pass,lastName,firstName,phone;
    private Date birthday;
    private boolean gender,isUse;
    private int roleInSystem;

    public Account() {
    }

    public Account(String account, String pass, String lastName, String firstName, String phone, Date birthday, boolean gender, boolean isUse, int roleInSystem) {
        this.account = account;
        this.pass = pass;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.birthday = birthday;
        this.gender = gender;
        this.isUse = isUse;
        this.roleInSystem = roleInSystem;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public boolean isIsUse() {
        return isUse;
    }

    public void setIsUse(boolean isUse) {
        this.isUse = isUse;
    }

    public int getRoleInSystem() {
        return roleInSystem;
    }

    public void setRoleInSystem(int roleInSystem) {
        this.roleInSystem = roleInSystem;
    }

    @Override
    public String toString() {
        return "Account{" + "account=" + account + ", pass=" + pass + ", lastName=" + lastName + ", firstName=" + firstName + ", phone=" + phone + ", birthday=" + birthday + ", gender=" + gender + ", isUse=" + isUse + ", roleInSystem=" + roleInSystem + '}';
    }
    
    
}
