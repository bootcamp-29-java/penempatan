/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import icontrollers.IBatchController;
import daos.GeneralDAO;
import idaos.IGeneralDAO;
import java.util.List;
import models.Account;
import models.Batch;
import org.hibernate.SessionFactory;

/**
 *
 * @author Reza
 */
public class BatchControler implements IBatchController {
    private IGeneralDAO<Batch> igdao;

    public BatchControler(SessionFactory factory) {
        igdao = new GeneralDAO<>(factory,Batch.class);
    }
    
    
    @Override
    public List<Batch> getall(){
        return igdao.getAll();
    }
    
    @Override
    public Batch getById(String id){
        return igdao.getById(id);
    }
    
    @Override
    public String save(String id){
        String result = "";
        Batch batch = new Batch(id);
        if(igdao.saveOrDelete(batch, true)){
            result = "Data Berhasil Disimpan";
        }
        else{
            result = "Data Gagal Disimpan";
        }
        
        return result;
    }
    
    public String delete(String id){
        String result = "";
        Batch batch = new Batch(id);
        if(igdao.saveOrDelete(batch, false)){
            result = "Data Berhasil Dihapus";
        }
        else{
            result = "Data Gagal Dihapus";
        }
        
        return result;
    } 
}
