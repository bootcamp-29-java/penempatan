/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Interview;

/**
 *
 * @author Reza
 */
public interface IInterviewController {

    List<Interview> getAll();

    Interview getById(String id);

    String save(String id, String date, String time, String location, String department, String pic, String is_accepted, String participant, String client);
    
    String delete(String id);
}
