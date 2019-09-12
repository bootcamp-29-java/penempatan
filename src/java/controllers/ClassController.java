/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import icontrollers.IClassController;
import daos.GeneralDAO;
import idaos.IGeneralDAO;
import java.util.List;
import models.Batch;
import models.Class;
import models.Employee;
import models.Lesson;
import org.hibernate.SessionFactory;

/**
 *
 * @author Reza
 */
public class ClassController implements IClassController {
    private IGeneralDAO<Class> igdao;
    private IGeneralDAO<Lesson> lessdao;
    private IGeneralDAO<Batch> batdao;
    private IGeneralDAO<Employee> empdao;
    

    public ClassController(SessionFactory factory) {
        igdao = new GeneralDAO<>(factory,Class.class);
        lessdao = new GeneralDAO<>(factory,Lesson.class);
        batdao = new GeneralDAO<>(factory,Batch.class);
        empdao = new GeneralDAO<>(factory,Employee.class);
        
    }
    
    @Override
    public List<Class> getall(){
        return igdao.getAll();
    }
    
    @Override
    public Class getById(String id){
        return igdao.getById(id);
    }
    
    @Override
    public String save(String id, String lesson, String batch, String trainer){
        String result = "";
        Class classes = new Class();
        Batch batch_1 = batdao.getById(batch);
        Lesson lesson_1 = lessdao.getById(lesson);
        Employee employee = empdao.getById(trainer);
//classes.setBatch(batch);
        try {
            classes.setId(id);
            classes.setLesson(lesson_1);
            classes.setBatch(batch_1);
            classes.setTrainer(employee);
            if(igdao.saveOrDelete(classes, true)){
                result = "Data Berhasil Disimpan";
            }
            else{
                result = "Data Gagal Disimpan";
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
            result = "Data Kelas Gagal";
        }
        
        return result;
    }
  
    public String delete(String id){
        String result = "";
        Class kelas = new Class(id);
        if(igdao.saveOrDelete(kelas, false)){
            result = "Data Berhasil Dihapus";
        }
        else{
            result = "Data Gagal Dihapus";
        }
        
        return result;
    }
}
