/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

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
 * @author Lenovo
 */
public class EmployeeDAO implements IEmployeeDAO {
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;
    private Query query;

    public EmployeeDAO(SessionFactory factory) {
        this.factory = factory;
    }
    
    
    @Override
    public String genId(){
        String emp="";
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Criteria cb =  session.createCriteria(Employee.class);
            ProjectionList projList = Projections.projectionList();
            projList.add(Projections.max("id"));
            //projList.add(Projections.countDistinct("description"));
            emp =(String) cb.setProjection(projList).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction!=null) {
                transaction.rollback();
            }
        }
        finally{
            session.close();
        }
        return emp;
    }
}
