/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import idaos.IGeneralDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;
import models.Client;
import models.Participant;
import models.Placement;
import org.hibernate.SessionFactory;

/**
 *
 * @author Reza
 */
public class PlacementController {
    IGeneralDAO<Placement> igdao;
    IGeneralDAO<Participant>pardao;
    IGeneralDAO<Client>cldao;

    public PlacementController(SessionFactory factory) {
        igdao = new GeneralDAO<>(factory,Placement.class);
        pardao = new GeneralDAO<>(factory,Participant.class);
        cldao = new GeneralDAO<>(factory,Client.class);
    }
    
    public List<Placement> getAll(){
        return igdao.getAll();
    }
    
    public Placement getById(String id)
    {
        return igdao.getById(id);
    }
    
    public String save(String id, String start_date,String end_date, String position, String department, String client, String participant){
        String result = "";
        Placement placement = new Placement();
        Client cl = cldao.getById(client);
        Participant pr = pardao.getById(participant);
        
        try {
            Date date_start = new SimpleDateFormat("YYYY-MM-dd").parse(start_date);
            Date date_end = new SimpleDateFormat("YYYY-MM-dd").parse(end_date);
            placement.setId(Integer.parseInt(id));
            placement.setStartDate(date_start);
            placement.setEndDate(date_end);
            placement.setPosition(position);
            placement.setDepartment(department);
            placement.setClient(cl);
            placement.setParticipant(pr);
            if (igdao.saveOrDelete(placement, true)) {
                result = "Data Berhasil Disimpan";
            } else {
                result = "Data Gagal Disimpan";
            }
        } catch (Exception e) {
                result = "Kesalahan saat Simpan";
        }
        
        
        return result;
    }
}
