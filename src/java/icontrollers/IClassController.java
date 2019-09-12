/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Class;

/**
 *
 * @author Reza
 */
public interface IClassController {

    String delete(String id);

    Class getById(String id);

    List<Class> getall();

    String save(String id, String lesson, String batch, String trainer);
    
}
