/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Placement;

/**
 *
 * @author Reza
 */
public interface IPlacementController {

    List<Placement> getAll();

    Placement getById(String id);

    String save(String id, String start_date, String end_date, String position, String department, String client, String participant);
    String delete(String id);
}
