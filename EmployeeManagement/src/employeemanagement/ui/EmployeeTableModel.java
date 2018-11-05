/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagement.ui;

import employeemanagement.entity.Employee;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alecm
 */
public class EmployeeTableModel extends AbstractTableModel {
    private List<Employee> listOfEmployees;

    public EmployeeTableModel(List<Employee> listOfEmployees) {
        this.listOfEmployees = listOfEmployees;
    } 
    
    public void addEmployee(Employee e) {
        this.listOfEmployees.add(e);
        fireTableDataChanged();
    }
    
    public void removeEmployee(int index) {
        this.listOfEmployees.remove(index);
        fireTableDataChanged();
    }
    
    public Employee getEmployee(int index) {
        return this.listOfEmployees.get(index);
    }
    
    @Override
    public int getRowCount() {
        return listOfEmployees.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employee e = listOfEmployees.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return e.getName();
            case 1:
                return e.getAge();
            case 2:
                return e.getAddress();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Name";
            case 1:
                return "Age";
            case 2:
                return "Address";
            default:
                return "";
                
        }
    }
    
    
    
}
