/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagement.dal;

import employeemanagement.entity.Employee;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alecm
 */
public class EmployeeDB {
    public List<Employee> getAllEmployee() {
        List<Employee> listOfEmployees = new ArrayList<>();
        try {
            Connection conn = ConnectionUtil.getConnection();
            CallableStatement cstmt = conn.prepareCall("{call getAllEmployee()}");
            ResultSet rs = cstmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("Id");
                String name = rs.getString("Name");
                int age = rs.getInt("Age");
                String address = rs.getString("Address");
                Employee e = new Employee(id, name, age, address);
                listOfEmployees.add(e);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listOfEmployees;
    }
    
    public boolean addEmployee(Employee e) {
        try {
            Connection conn = ConnectionUtil.getConnection();
            CallableStatement cstmt = conn.prepareCall("{call insertEmployee(?, ?, ?}");
            cstmt.setString("name", e.getName());
            cstmt.setInt("age", e.getAge());
            cstmt.setString("address", e.getAddress());
            int rowsAffected = cstmt.executeUpdate();
            conn.close();;
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean removeEmployee(int id) {
        try {
            Connection conn = ConnectionUtil.getConnection();
            CallableStatement cstmt = conn.prepareCall("{call removeEmployee(?)");
            cstmt.setInt("id", id);
            int rowsAffected = cstmt.executeUpdate();
            conn.close();
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

public boolean updateEmployee(Employee e) {
        try {
            Connection conn = ConnectionUtil.getConnection();
            CallableStatement cstmt = conn.prepareCall("{call updateEmployee(?, ?, ?, ?, ?)}");
            cstmt.setInt("id", e.getId());
            cstmt.setString("name", e.getName());
            cstmt.setInt("age", e.getAge());
            cstmt.setString("address", e.getAddress());
            int rowsAffected = cstmt.executeUpdate();
            conn.close();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
}
}