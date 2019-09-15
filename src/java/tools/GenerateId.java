/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import models.Employee;
import org.hibernate.Criteria;
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
    
    public String genId(){
        String emp= "";
        int id;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Criteria cb =  session.createCriteria(table.getClass());
            ProjectionList projList = Projections.projectionList();
            projList.add(Projections.max("id"));
            //projList.add(Projections.countDistinct("description"));
            emp =(String) cb.setProjection(projList).uniqueResult();
            id = Integer.parseInt(emp)+1;
            emp = String.valueOf(id);
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
