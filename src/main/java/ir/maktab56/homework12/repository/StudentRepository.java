package ir.maktab56.homework12.repository;

import ir.maktab56.homework12.base.repository.BaseEntityRepository;
import ir.maktab56.homework12.domain.Student;

public interface StudentRepository extends BaseEntityRepository<Student, Long> {


    String[] getStringCodes();

}
