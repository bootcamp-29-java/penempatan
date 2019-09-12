/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.EmployeeRoleDAO;
import icontrollers.IEmployeeRoleController;
import daos.GeneralDAO;
import idaos.IGeneralDAO;
import idaos.IRoleDAO;
import java.util.List;
import models.Employee;
import models.EmployeeRole;
import models.Role;
import org.hibernate.SessionFactory;

/**
 *
 * @author Lenovo
 */
public class EmployeeRoleController implements IEmployeeRoleController {
    private SessionFactory factory;
    private IGeneralDAO<EmployeeRole> igdao;
    private IGeneralDAO<Employee> empdao;
    private IGeneralDAO<Role> rldao;
    private IRoleDAO irdao;

    public EmployeeRoleController(SessionFactory factory) {
        igdao = new GeneralDAO(factory, EmployeeRole.class);
        empdao = new GeneralDAO(factory, Employee.class);
        rldao = new GeneralDAO(factory, Role.class);
        irdao = new EmployeeRoleDAO(factory);
    }
//    
//    public List<EmployeeRole> getById(String id){
//        return irdao.getByEmployee(id);
//    }
    @Override
    public List<EmployeeRole> getAll(){
        return igdao.getAll();
    }
    
    @Override
    public List<EmployeeRole> getById(String id){
        return irdao.getByEmployee(id);
    }
//    
//    @Override
//    public EmployeeRole getById(String id){
//        return igdao.getById(id);
//    }
    
    @Override
    public String save( String employee, String role){
        String result= "";
        Employee employee_1 = empdao.getById(employee);
        Role role_1 = rldao.getById(role);
        try {
            EmployeeRole employeeRole = new EmployeeRole();
            employeeRole.setEmployee(employee_1);
            employeeRole.setRole(role_1);
            
            if (igdao.saveOrDelete(employeeRole, true)) {
                result = "Data Berhasil Disimpan";
            } else {
                result = "Data Gagal Disimpan";
            }
        } catch (Exception e) {
            e.printStackTrace();
            result="Gagal dalam Menyimpan";
        }
        return result;
    }

    @Override
    public List<EmployeeRole> getTrainer() {
        return irdao.getTrainer();
    }
}
