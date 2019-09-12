/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Participant;

/**
 *
 * @author Reza
 */
public interface IParticiantController {

    List<Participant> getAll();

    Participant getById(String id);

    String save(String id, String grade, String classes);
    
}
