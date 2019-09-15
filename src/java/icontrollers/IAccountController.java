/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Account;

/**
 *
 * @author Lenovo
 */
public interface IAccountController {

    String createAccount(String id, String password, String token, String status, String verif_time);
    List<Account> getAll();
}
