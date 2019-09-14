/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import icontrollers.IPlacementController;
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
public class PlacementController implements IPlacementController {
    IGeneralDAO<Placement> igdao;
    IGeneralDAO<Participant>pardao;
    IGeneralDAO<Client>cldao;

    public PlacementController(SessionFactory factory) {
        igdao = new GeneralDAO<>(factory,Placement.class);
        pardao = new GeneralDAO<>(factory,Participant.class);
        cldao = new GeneralDAO<>(factory,Client.class);
    }
    
    @Override
    public List<Placement> getAll(){
        return igdao.getAll();
    }
    
    @Override
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
            placement.setId(id);
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

    @Override
    public String delete(String id) {
        String result = "";
        
        Placement placement = igdao.getById(id);
        
        if(igdao.saveOrDelete(placement, false)){
            result = "Data Berhasil Dihapus";
        }else{
            result = "Data Gagal Dihapus";
        }
        
        return result;
    }
}
