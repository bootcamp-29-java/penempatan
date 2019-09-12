/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import idaos.IGeneralDAO;
import java.util.List;
import models.Participant;
import models.Employee;
import models.Class;
import org.hibernate.SessionFactory;

/**
 *
 * @author Reza
 */
public class ParticipantController {
    IGeneralDAO<Participant> igdao;
    IGeneralDAO<Employee>empdao;
    IGeneralDAO<Class>cladao;

    public ParticipantController(SessionFactory factory) {
        igdao = new GeneralDAO<>(factory,Participant.class);
        empdao = new GeneralDAO<>(factory,Employee.class);
        cladao = new GeneralDAO<>(factory,Class.class);
    }
        
    public List<Participant> getAll(){
        return igdao.getAll();
    }
    
    public Participant getById(String id){
        return igdao.getById(id);
    }
    
    public String save (String id, String grade,String classes){
        String result="";
        
        Employee employee = empdao.getById(id);
        Class kelas = cladao.getById(classes);
        Participant participant = new Participant();
        try {
            participant.setId(employee.getId());
            participant.setGrade(grade);
            participant.setClass1(kelas);
            if (igdao.saveOrDelete(participant, true)) {
                result = "Data Berhasil Disimpan";
            } else {
                result = "Data Gagal Disimpan";
            }
        } catch (Exception e) {
            result ="Kesalahan Dalam Data";
        }
        
        return result;
    }
}
