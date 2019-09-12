/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Role;

/**
 *
 * @author Reza
 */
public interface IRoleController {

    String delete(String id);

    List<Role> getAll();

    Role geyById(String id);

    String save(String id, String name);
    
}
