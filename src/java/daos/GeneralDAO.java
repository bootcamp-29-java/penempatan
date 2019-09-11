/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IGeneralDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author asus
 */
public class GeneralDAO<T> implements IGeneralDAO<T> {

    private Transaction transaction;
    private Session session;
    private SessionFactory factory;
    private T table;

    public GeneralDAO(SessionFactory factory, Class<T> table) {
        try {
            this.factory = factory;
            this.table = table.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<T> getAll() {
        List<T> reg = new ArrayList<>();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            reg = session.createQuery("from " + table.getClass().getSimpleName()).list();
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

    @Override
    public T getById(Object id) {
        T t = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Query querry = session.createQuery("FROM " + table.getClass().getSimpleName() + " where id =:id");
            querry.setParameter("id", id);
            t = (T) querry.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return t;
    }

    @Override
    public boolean saveOrDelete(T model, boolean issave) {
        boolean result = false;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            if (issave) {
                session.saveOrUpdate(model);
            } else {
                session.delete(model);
            }
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

}
