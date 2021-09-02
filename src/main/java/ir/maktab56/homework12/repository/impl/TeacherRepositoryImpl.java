package ir.maktab56.homework12.repository.impl;

import ir.maktab56.homework12.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktab56.homework12.domain.Teacher;
import ir.maktab56.homework12.repository.TeacherRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class TeacherRepositoryImpl extends BaseEntityRepositoryImpl<Teacher, Long>
        implements TeacherRepository {
    /*    private final AddressService addressService = ApplicationContext.getAddressService();
        private final TeacherService teacherService  = ApplicationContext.getTeacherService();*/
    public TeacherRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Teacher> getEntityClass() {
        return Teacher.class;
    }

    @Override
    public String[] getTeacherCodes() {
        List<String> teacherCodes = entityManager.createQuery(
                "select teacherCode from Teacher ", String.class).getResultList();
        return teacherCodes.toArray(new String[0]);
    }
}
