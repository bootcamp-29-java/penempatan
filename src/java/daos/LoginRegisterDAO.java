/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.ILoginRegisterDAO;
import java.util.List;
import models.Account;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Lenovo
 */
public class LoginRegisterDAO implements ILoginRegisterDAO{

    private SessionFactory factory;
    private Session session;
    private Transaction transaction;
    private Query query;

    public LoginRegisterDAO(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Account getByEmail(String email) {
        Account account = new Account();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            query = session.createQuery("FROM Account WHERE employee.email=:email");
            query.setParameter("email", email);
            account = (Account) query.uniqueResult();
        } catch (Exception e) {
            e.getStackTrace();
            if (transaction !=null) {
                transaction.rollback();
            }
        }finally{
            session.close();
        }
        return account;
    }

    @Override
    public Account getByToken(String token) {
        Account account = new Account();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            query = session.createQuery("FROM Account WHERE token=:token");
            query.setParameter("token", token);
            account = (Account) query.uniqueResult();
        } catch (Exception e) {
            e.getStackTrace();
            if (transaction !=null) {
                transaction.rollback();
            }
        }finally{
            session.close();
        }
        return account;
    }

    @Override
    public boolean updateAccount(Account account) {
        boolean result = false;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(account);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }finally{
            session.close();
        }
        return result;
    }
}
