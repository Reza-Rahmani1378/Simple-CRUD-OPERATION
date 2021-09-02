package ir.maktab56.homework12.util;

import ir.maktab56.homework12.repository.AddressRepository;
import ir.maktab56.homework12.repository.StudentRepository;
import ir.maktab56.homework12.repository.TeacherRepository;
import ir.maktab56.homework12.repository.impl.AddressRepositoryImpl;
import ir.maktab56.homework12.repository.impl.StudentRepositoryImpl;
import ir.maktab56.homework12.repository.impl.TeacherRepositoryImpl;
import ir.maktab56.homework12.service.AddressService;
import ir.maktab56.homework12.service.StudentService;
import ir.maktab56.homework12.service.TeacherService;
import ir.maktab56.homework12.service.impl.AddressServiceImpl;
import ir.maktab56.homework12.service.impl.StudentServiceImpl;
import ir.maktab56.homework12.service.impl.TeacherServiceImpl;

import javax.persistence.EntityManager;

public class ApplicationContext {

    private static final TeacherRepository teacherRepository;

    private static final TeacherService teacherService;

    private static final StudentRepository studentRepository;

    private static final StudentService studentService;

    private static final AddressRepository addressRepository;

    private static final AddressService addressService;


    static {
        EntityManager entityManager =
                HibernateUtil.getEntityManagerFactory().createEntityManager();
        teacherRepository = new TeacherRepositoryImpl(entityManager);
        teacherService = new TeacherServiceImpl(teacherRepository);

        studentRepository = new StudentRepositoryImpl(entityManager);
        studentService = new StudentServiceImpl(studentRepository);

        addressRepository = new AddressRepositoryImpl(entityManager);
        addressService = new AddressServiceImpl(addressRepository);
    }

    static {

    }

    public static TeacherService getTeacherService() {
        return teacherService;
    }

    public static StudentService getStudentService() {
        return studentService;
    }

    public static AddressService getAddressService() {
        return addressService;
    }
}