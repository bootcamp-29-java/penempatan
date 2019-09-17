/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import idaos.IGeneralDAO;
import java.util.ArrayList;
import java.util.List;
import models.Batch;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Reza
 */
public class GenId<T> {
    private Session session;
    private Transaction transaction;
    private SessionFactory factory;
    private T table;
    
    public GenId(SessionFactory factory, Class<T> table) {
        try {
            this.factory = factory;
            this.table = table.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<T> getAll() {
        List<T> reg = new ArrayList<>();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            reg = session.createQuery("select max(id+0) from " + table.getClass().getSimpleName()).list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return reg;
    }
    
}
