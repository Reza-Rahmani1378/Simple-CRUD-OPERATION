package ir.maktab56.homework12;

import ir.maktab56.homework12.util.HibernateUtil;
import ir.maktab56.homework12.util.menu.ShowAndRunMenu;

import javax.persistence.EntityManager;

public class CrudApplication {
    public static void main(String[] args) {
      /*  TeacherService teacherService = ApplicationContext.getTeacherService();
        AddressService addressService = ApplicationContext.getAddressService();
        StudentService studentService = ApplicationContext.getStudentService();*/
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        new ShowAndRunMenu().runMenu();


    }
}
