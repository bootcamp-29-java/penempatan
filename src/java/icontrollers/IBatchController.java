/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Batch;

/**
 *
 * @author Reza
 */
public interface IBatchController {

    String delete(String id);

    Batch getById(String id);

    List<Batch> getall();

    String save(String id);
    
}
