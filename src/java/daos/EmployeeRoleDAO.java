/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IRoleDAO;
import java.util.ArrayList;
import java.util.List;
import models.Employee;
import models.EmployeeRole;
import models.Role;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Lenovo
 */
public class EmployeeRoleDAO implements IRoleDAO{
    private SessionFactory factory;
    private Transaction transaction;
    private Session session;
    private Query query;
    
    public EmployeeRoleDAO(SessionFactory factory) {
        this.factory = factory;
    }
    
    @Override
    public List<EmployeeRole> getByEmployee(String id){
        List<EmployeeRole> roles = new ArrayList<>();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            query = session.createQuery("FROM EmployeeRole WHERE employee.id=:id");
            query.setParameter("id", id);
            roles = query.list();
        } catch (Exception e) {
            e.getStackTrace();
            if (transaction!=null) {
                transaction.rollback();
            }
        }finally{
            session.close();
        }
        return roles;
    }

    @Override
    public List<EmployeeRole> getTrainer() {
        List<EmployeeRole> reg = new ArrayList<>();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            reg = session.createQuery("from EmployeeRole where role = 2").list();
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
    public List<EmployeeRole> getParticipant() {
        List<EmployeeRole> reg = new ArrayList<>();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            reg = session.createQuery("from EmployeeRole where role = 3").list();
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
