/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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
public class InterviewController {
    IGeneralDAO<Interview> igdao;
    IGeneralDAO<Client> cldao;
    IGeneralDAO<Participant> prdao;

    public InterviewController(SessionFactory factory) {
        igdao = new GeneralDAO<>(factory,Interview.class);
        cldao = new GeneralDAO<>(factory,Client.class);
        prdao = new GeneralDAO<>(factory,Participant.class);
    }
    
    public List<Interview> getAll(){
        return igdao.getAll();
    }
    
    public Interview getById(String id){
        return igdao.getById(id);
    }
    
    public String save(String id, String date_time, String location, String department,String pic,String is_accepted, String participant, String client){
        String reesult ="";
        
        Participant participant_1 = prdao.getById(participant);
        Client client_1=cldao.getById(client);
        try {
            Date date= new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").parse(date_time);
            Interview interview = new Interview();
            interview.setId(id);
            interview.setDateTime(date);
            interview.setLocation(location);
            interview.setDepartment(department);
            interview.setPic(pic);
            interview.setIsAccepted(Boolean.FALSE);
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
}