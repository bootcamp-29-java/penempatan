/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.AccountController;
import controllers.EmployeeController;
import controllers.EmployeeRoleController;
import controllers.InterviewController;
import controllers.LoginRegisterController;
import controllers.ParticipantController;
import controllers.PlacementController;
import controllers.RoleController;
import daos.LoginRegisterDAO;
import daos.EmployeeRoleDAO;
import daos.GeneralDAO;
import icontrollers.IAccountController;
import icontrollers.IEmployeeController;
import icontrollers.IEmployeeRoleController;
import icontrollers.IInterviewController;
import icontrollers.ILoginRegisterController;
import icontrollers.IParticiantController;
import icontrollers.IRoleController;
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
import models.Participant;
import models.Placement;
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

//        IEmployeeController iec = new EmployeeController(factory);
//        System.out.println(iec.save("3", "Mus", "mus", "mus", "mus", "2010-10-10", "Male", "WNI", "kosongi", false));
//        System.out.println(iec.delete("3"));
//        show();
//          IEmployeeController iec = new EmployeeController(factory);
//          System.out.println(iec.save("2", "khrisna", "Khrisna", "accountgame607@gmail.com", "Klaten ", "2019-09-03", "Male", "WNI","image/default-image.png", false));
//        ILoginRegisterController ilrc = new LoginRegisterController(factory);
        //        System.out.println(ilrc.updateByToken("9ekeZyz0NRfzQ9LkohXI", "Mustofa98"));
//        IParticiantController ipc = new ParticipantController(factory);
//        for (Participant participant : ipc.getAll()) {
////            System.out.println(participant.getClass1().getId());
//            System.out.println((participant.getClass1() == null) ? "" : participant.getClass1().getId());
//        }
//        PlacementController erc = new PlacementController(factory);
//        for (Placement p : erc.getAll()) {
//            System.out.println(p.getParticipant().getEmployee().getFirstName());
//        }
//        IInterviewController intview = new InterviewController(factory);
//        intview.save(id, date, time, location, department, pic, is_accepted, participant, client)
//        IRoleController irc = new RoleController(factory);
//        System.out.println(irc.delete("5"));
//        IEmployeeRoleController irc = new EmployeeRoleController(factory);
//        System.out.println(irc.delete("39"));
//        IEmployeeRoleController ierc = new EmployeeRoleController(factory);
//        for (EmployeeRole employeeRole : ierc.getTrainer()) {
//            System.out.println(employeeRole.getEmployee().getFirstName());
//        }
//        IAccountController iac = new AccountController(factory);
//        System.out.println(iac.createAccount("105", "Mustofa98", "", "-1", ""));
//        GenerateId<EmployeeRole> generateId = new GenerateId<>(factory, EmployeeRole.class);
//        System.out.println(generateId.genId());
//        IInterviewController iic = new InterviewController(factory);
//        System.out.println(iic.save("3", "2017-10-11", "08:00", "Gedung pusat Mitsubishi Lantai 18", "Public Relation", "Bpk. Affan", "1", "132", "9"));
//        Date dates= new SimpleDateFormat("yyyy-MM-dd").parse("2017-10-11");
//        System.out.println(dates);
//        AllMethod.sendInterview("mustofaalisahid@gmail.com", "mus", "31");
        GenerateId<Employee> generateId = new GenerateId<>(factory, Employee.class);
        String id = generateId.genId();
        System.out.println(id);
    }

}
