/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.EmployeeRole;

/**
 *
 * @author Reza
 */
public interface IEmployeeRoleController {

    //
    //    public List<EmployeeRole> getById(String id){
    //        return irdao.getByEmployee(id);
    //    }
    List<EmployeeRole> getAll();
    List<EmployeeRole> getTrainer();

    public List<EmployeeRole> getById(String id);

    String save(String employee, String role);
    
}
