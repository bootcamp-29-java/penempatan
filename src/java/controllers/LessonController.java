/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import idaos.IGeneralDAO;
import java.util.List;
import models.Batch;
import models.Lesson;
import org.hibernate.SessionFactory;

/**
 *
 * @author Reza
 */
public class LessonController {
    
    IGeneralDAO<Lesson>igdao;

    public LessonController(SessionFactory factory) {
        igdao = new GeneralDAO<>(factory,Lesson.class);
    }
    
    public List<Lesson> getall(){
        return igdao.getAll();
    }
    
    public Lesson getById(String id){
        return igdao.getById(id);
    }
    
    public String save(String id, String name){
        String result = "";
        Lesson lesson = new Lesson(id, name);
        if(igdao.saveOrDelete(lesson, true)){
            result = "Data Berhasil Disimpan";
        }
        else{
            result = "Data Gagal Disimpan";
        }
        
        return result;
    }
    
    public String delete(String id){
        String result = "";
        Lesson lesson = new Lesson(id);
        if(igdao.saveOrDelete(lesson, false)){
            result = "Data Berhasil Dihapus";
        }
        else{
            result = "Data Gagal Dihapus";
        }
        
        return result;
    } 
}
