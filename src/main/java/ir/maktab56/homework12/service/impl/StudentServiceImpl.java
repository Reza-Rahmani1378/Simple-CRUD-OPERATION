package ir.maktab56.homework12.service.impl;

import ir.maktab56.homework12.base.service.impl.BaseEntityServiceImpl;
import ir.maktab56.homework12.domain.Student;
import ir.maktab56.homework12.repository.StudentRepository;
import ir.maktab56.homework12.service.StudentService;
import ir.maktab56.homework12.service.dto.StudentDto;

public class StudentServiceImpl extends BaseEntityServiceImpl<ir.maktab56.homework12.domain.Student, Long, StudentRepository>
        implements StudentService {
    public StudentServiceImpl(StudentRepository repository) {
        super(repository);
    }


    @Override
    public Student getStudent(StudentDto studentDto) {
        return new Student(
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getStudentCode(),
                studentDto.getBirthDay());
    }

    @Override
    public String[] getStudentCodes() {
        return repository.getStringCodes();
    }
}
