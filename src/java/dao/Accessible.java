/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface Accessible<T> {
    int insertRec(T obj);
    int updateRec(T obj);
    int deleteRec(T obj) throws SQLException;
    T getObjByID(String id);
    List<T> listAll();
}
