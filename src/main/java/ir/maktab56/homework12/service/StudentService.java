package ir.maktab56.homework12.service;

import ir.maktab56.homework12.base.service.BaseEntityService;
import ir.maktab56.homework12.domain.Student;
import ir.maktab56.homework12.service.dto.StudentDto;

public interface StudentService extends BaseEntityService<ir.maktab56.homework12.domain.Student, Long> {


    Student getStudent(StudentDto studentDto);

    String[] getStudentCodes();

}
