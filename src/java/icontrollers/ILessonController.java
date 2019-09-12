/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Lesson;

/**
 *
 * @author Reza
 */
public interface ILessonController {

    String delete(String id);

    Lesson getById(String id);

    List<Lesson> getall();

    String save(String id, String name);
    
}
