/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import icontrollers.ILoginRegisterController;
import daos.LoginRegisterDAO;
import idaos.ILoginRegisterDAO;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import models.Account;
import models.Status;
import org.hibernate.SessionFactory;
import tools.BCrypt;
import tools.AllMethod;

/**
 *
 * @author Lenovo
 */
public class LoginRegisterController implements ILoginRegisterController {

    private SessionFactory factory;
    private ILoginRegisterDAO ilrdao;

    public LoginRegisterController(SessionFactory factory) {
        ilrdao = new LoginRegisterDAO(factory);
    }

    @Override
    public String login(String email, String password) {
        String result = "";
            Account account = ilrdao.getByEmail(email);
            String name = account.getEmployee().getFirstName()+" "+account.getEmployee().getLastName();
            AllMethod.sendEmail(account.getEmployee().getEmail(), name, account.getToken());
            boolean isTrue = BCrypt.checkpw(password, account.getPassword());
            if (isTrue) {
                result = "Login Berhasil";
            } else {
                result = "Login Gagal";
            }
        return result;
    }

    @Override
    public String updateByToken(String token, String newPassword) {
        Account account = ilrdao.getByToken(token);
        String pass = BCrypt.hashpw(newPassword, BCrypt.gensalt());
        account.setPassword(pass);
        
        Status status = new Status("0");
        account.setStatus(status);
        account.setToken("");
        String result;
        try {
        if (ilrdao.updateAccount(account)) {
            result = "Password Sudah Dirubah";
        } else {
            result = "Password Gagal Dirubah";
        }
        } catch (Exception e) {
            result = "Error Ke Catch";
        }
        return result;
    }

}
