package ir.maktab56.homework12.repository.impl;

import ir.maktab56.homework12.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktab56.homework12.domain.Student;
import ir.maktab56.homework12.repository.StudentRepository;
import ir.maktab56.homework12.service.StudentService;
import ir.maktab56.homework12.util.ApplicationContext;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentRepositoryImpl extends BaseEntityRepositoryImpl<Student, Long>
        implements StudentRepository {
    private final StudentService studentService = ApplicationContext.getStudentService();

    public StudentRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }


    @Override
    public String[] getStringCodes() {
        List<String> studentCodes = entityManager.createQuery(
                "select studentCode from Student", String.class).getResultList();
        return studentCodes.toArray(new String[0]);

    }
}
