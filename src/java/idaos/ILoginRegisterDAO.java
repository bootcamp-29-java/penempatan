/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import models.Account;

/**
 *
 * @author Lenovo
 */
public interface ILoginRegisterDAO {

    Account getByEmail(String email);
    Account getByToken(String token);
    boolean updateAccount(Account account);
}
