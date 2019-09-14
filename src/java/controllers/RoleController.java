/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import icontrollers.IRoleController;
import daos.GeneralDAO;
import idaos.IGeneralDAO;
import java.util.List;
import models.Role;
import org.hibernate.SessionFactory;

/**
 *
 * @author Reza
 */
public class RoleController implements IRoleController {
    IGeneralDAO<Role> igdao;

    public RoleController(SessionFactory factory) {
        igdao = new GeneralDAO<>(factory,Role.class);
    }
    
    @Override
    public List<Role> getAll(){
        return igdao.getAll();
    }
    
    @Override
    public Role geyById(String id){
        return igdao.getById(id);
    }
    
    @Override
    public String save(String id, String name){
        String result = "";
        Role role = new Role(id, name);
        if (igdao.saveOrDelete(role, true)) {
            result="Data Berhasil Disimpan";
        } else {
            result="Data Gagal Disimpan";
        }
        return result;
    }
    
    @Override
    public String delete(String id){
        String result = "";
        Role role = igdao.getById(id);
        if (igdao.saveOrDelete(role, false)) {
            result="Data Berhasil Dihapus";
        } else {
            result="Data Gagal Dihapus";
        }
        return result;
    }
}
