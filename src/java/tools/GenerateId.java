/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.ArrayList;
import java.util.List;
import models.Employee;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

/**
 *
 * @author Reza
 */
public class GenerateId<T> {

    private Session session;
    private Transaction transaction;
    private SessionFactory factory;
    private T table;

    public GenerateId(SessionFactory factory, Class<T> table) {
        try {
            this.factory = factory;
            this.table = table.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String genId() {
        T t = null;
        String id = "";
        int generate = 0;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Query querry = session.createQuery("select max(id+0) from " + table.getClass().getSimpleName());
            t = (T) querry.uniqueResult();
            id = t.toString();
            generate = (Integer.parseInt(id))+1;
            id = String.valueOf(generate);
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return id;
    }
}
