package ir.maktab56.homework12.service;

import ir.maktab56.homework12.base.service.BaseEntityService;
import ir.maktab56.homework12.domain.Teacher;
import ir.maktab56.homework12.service.dto.TeacherDto;

public interface TeacherService extends BaseEntityService<Teacher, Long> {


    String[] getTeacherCodes();

    Teacher getTeacher(TeacherDto teacherDto);
}
