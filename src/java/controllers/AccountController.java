/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author Lenovo
 */
import icontrollers.IAccountController;
import daos.GeneralDAO;
import idaos.IGeneralDAO;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import models.Account;
import models.Employee;
import models.Status;
import org.hibernate.SessionFactory;

/**
 *
 * @author hp
 */
public class AccountController implements IAccountController{

    private IGeneralDAO<Account> igdao;
    private IGeneralDAO<Employee> igdao2;

    public AccountController(SessionFactory factory) {
        igdao = new GeneralDAO<>(factory, Account.class);
        igdao2 = new GeneralDAO<>(factory, Employee.class);
    }

    
    @Override
    public String createAccount(String id, String password, String token, String status, String verif_time) {
        String result = "";
        Date date = new Date();
        Account account = new Account();
        Status status1 = new Status(status);
        Employee employee = igdao2.getById(id);
        try {
            account.setId(employee.getId());
            account.setPassword(password);
            account.setEmployee(employee);
            account.setToken(token);
            account.setVerifTime(date);
            account.setStatus(status1);
            if (igdao.saveOrDelete(account, true)) {
                result = "Berhasil";
            } else {
                result = "Gagal";
            }
        } catch (Exception e) {
            result = "Maaf id Employee tidak Terdaftar";
        }

        return result;
    }

    @Override
    public List<Account> getAll() {
        return igdao.getAll();
    }
    
    

}
