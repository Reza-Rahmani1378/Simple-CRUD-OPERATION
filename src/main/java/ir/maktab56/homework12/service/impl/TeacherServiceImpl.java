package ir.maktab56.homework12.service.impl;

import ir.maktab56.homework12.base.service.impl.BaseEntityServiceImpl;
import ir.maktab56.homework12.domain.Teacher;
import ir.maktab56.homework12.repository.TeacherRepository;
import ir.maktab56.homework12.service.TeacherService;
import ir.maktab56.homework12.service.dto.TeacherDto;

public class TeacherServiceImpl extends BaseEntityServiceImpl<Teacher, Long, TeacherRepository>
        implements TeacherService {
    public TeacherServiceImpl(TeacherRepository repository) {
        super(repository);
    }


    @Override
    public String[] getTeacherCodes() {
        return repository.getTeacherCodes();
    }

    @Override
    public Teacher getTeacher(TeacherDto teacherDto) {
        return new Teacher(
                teacherDto.getFirstName(),
                teacherDto.getLastName(),
                teacherDto.getTeacherCode(),
                teacherDto.getSalary(),
                teacherDto.getBirthDay()
        );
    }

}
