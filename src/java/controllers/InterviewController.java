/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import icontrollers.IInterviewController;
import com.mysql.jdbc.Util;
import daos.GeneralDAO;
import idaos.IGeneralDAO;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import models.Client;
import models.Interview;
import models.Participant;
import org.hibernate.SessionFactory;

/**
 *
 * @author Reza
 */
public class InterviewController implements IInterviewController {
    IGeneralDAO<Interview> igdao;
    IGeneralDAO<Client> cldao;
    IGeneralDAO<Participant> prdao;

    public InterviewController(SessionFactory factory) {
        igdao = new GeneralDAO<>(factory,Interview.class);
        cldao = new GeneralDAO<>(factory,Client.class);
        prdao = new GeneralDAO<>(factory,Participant.class);
    }
    
    @Override
    public List<Interview> getAll(){
        return igdao.getAll();
    }
    
    @Override
    public Interview getById(String id){
        return igdao.getById(id);
    }
    
    public String save(String id, String date, String time, String location, String department,String pic,String is_accepted, String participant, String client){
        String reesult ="";
        boolean acc=false;
        
        Participant participant_1 = prdao.getById(participant);
        Client client_1=cldao.getById(client);
        if(is_accepted.contains("1")){
            acc = true;
        }else {
            acc = false;
        }
        
        try {
            Date dates= new SimpleDateFormat("yyyy-MM-dd").parse(date);
            Date times = new SimpleDateFormat("HH:mm").parse(time);
            Interview interview = new Interview();
            interview.setId(id);
            interview.setDate(dates);
            interview.setTime(times);
            interview.setLocation(location);
            interview.setDepartment(department);
            interview.setPic(pic);
            interview.setIsAccepted(acc);
            interview.setParticipant(participant_1);
            interview.setClient(client_1);
            if (igdao.saveOrDelete(interview, true)) {
                reesult = "Data Berhasil Disimpan";
            } else {
                reesult = "Data Gagal Disimpan";
            }
        } catch (Exception e) {
            e.printStackTrace();
            reesult = "Kesalahan Data";
        }
        
        return reesult;
    }

    @Override
    public String delete(String id) {
        String result = "";
        Interview interview = igdao.getById(id);
        if(igdao.saveOrDelete(interview, false)){
            result = "Data Berhasil Dihapus";
        }else{
            result = "Data Gagal Dihapus";
        }
        
        return result;
    }
}
