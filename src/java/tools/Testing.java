/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.EmployeeController;
import controllers.LoginRegisterController;
import daos.LoginRegisterDAO;
import daos.EmployeeRoleDAO;
import daos.GeneralDAO;
import icontrollers.IEmployeeController;
import idaos.IGeneralDAO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import models.Account;
import models.Employee;
import models.EmployeeRole;
import models.Role;
import org.hibernate.SessionFactory;

/**
 *
 * @author Reza
 */
public class Testing {

    public static void show() {
        GeneralDAO<Employee> gdao = new GeneralDAO<>(HibernateUtil.getSessionFactory(), Employee.class);
        for (Employee employee : gdao.getAll()) {
            System.out.println(employee.getId() + " - " + employee.getFirstName());
        }
    }

    public static void main(String[] args) throws ParseException, FileNotFoundException {
        SessionFactory factory = HibernateUtil.getSessionFactory();
//        LoginRegisterDAO dao = new LoginRegisterDAO(factory);
//        Account account = dao.getByEmail("mii.bootcamp29@gmail.com");
//        EmployeeRoleDAO rdao = new EmployeeRoleDAO(factory);
//        List<String> session = new ArrayList<>();
//        System.out.println(account.getId());
//        for (EmployeeRole role : rdao.getByEmployee(account.getId())) {
//            session.add(role.getRole().getName());
//            System.out.println(role.getRole().getName());
//        }
//        System.out.println(session.contains("Super Admin"));
//        if (session.contains("Super Admin")) {
//            System.out.println("Session Berhasil");
//        }else{
//            System.out.println("Session Gagal");
//            
//        }
//        System.out.println(factory);
//        GeneralDAO<Employee> gdao = new GeneralDAO<>(HibernateUtil.getSessionFactory(), Employee.class);
//        Employee e = new Employee();
//        e.setId("2");
//        e.setFirstName("Lord");
//        e.setLastName("Khrisna");
//        e.setEmail("akungame607@gmail.com");
//        e.setBirthPlace("Klaten");
//        String date = "1997-03-11";
//        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
//        Date d = df.parse(date);
//        e.setBirthDate(d);
//        e.setGender("Male");
//        e.setNationality("WNI");
//        e.setPhoto("web/image/default-image.jpg");
//        e.setIsDelete(false);
//        System.out.println(gdao.saveOrDelete(e, true));

        IEmployeeController iec = new EmployeeController(factory);
        System.out.println(iec.save("3", "Mus", "mus", "mus", "mus", "2010-10-10", "Male", "WNI", "kosongi", false));
        System.out.println(iec.delete("3"));
        show();

    }

}
