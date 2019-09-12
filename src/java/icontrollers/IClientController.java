/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Client;

/**
 *
 * @author Reza
 */
public interface IClientController {

    String delete(String id);

    Client getById(String id);

    List<Client> getall();

    String save(String id, String name, String location);
    
}
