/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import idaos.IGeneralDAO;
import java.util.List;
import models.Client;
import org.hibernate.SessionFactory;

/**
 *
 * @author Reza
 */
public class ClientController {
    private IGeneralDAO<Client> igdao;

    public ClientController(SessionFactory factory) {
        igdao = new GeneralDAO<>(factory,Client.class);
    }
    
    public List<Client> getall(){
        return igdao.getAll();
    }
    
    public Client getById(String id){
        return igdao.getById(id);
    }
    
    public String save(String id, String name, String location){
        String result = "";
        Client client = new Client(id, name, location);
        if(igdao.saveOrDelete(client, true)){
            result = "Data Berhasil Disimpan";
        }
        else{
            result = "Data Gagal Disimpan";
        }
        
        return result;
    }
    
    public String delete(String id){
        String result = "";
        Client client = new Client(id);
        if(igdao.saveOrDelete(client, false)){
            result = "Data Berhasil Dihapus";
        }
        else{
            result = "Data Gagal Dihapus";
        }
        
        return result;
    } 
}
