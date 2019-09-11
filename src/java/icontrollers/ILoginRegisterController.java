/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

/**
 *
 * @author Lenovo
 */
public interface ILoginRegisterController {

    String login(String email, String password);
    String updateByToken(String token, String newPassword);
}
