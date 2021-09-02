package ir.maktab56.homework12.util.menu;

import ir.maktab56.homework12.domain.Address;
import ir.maktab56.homework12.domain.Student;
import ir.maktab56.homework12.domain.Teacher;
import ir.maktab56.homework12.service.AddressService;
import ir.maktab56.homework12.service.StudentService;
import ir.maktab56.homework12.service.TeacherService;
import ir.maktab56.homework12.service.dto.AddressDto;
import ir.maktab56.homework12.service.dto.StudentDto;
import ir.maktab56.homework12.service.dto.TeacherDto;
import ir.maktab56.homework12.util.ApplicationContext;
import ir.maktab56.homework12.util.menu.input.Input;

import java.util.List;

public class EntityMenu extends Menu {
    private final TeacherService teacherService = ApplicationContext.getTeacherService();
    private final StudentService studentService = ApplicationContext.getStudentService();
    private final AddressService addressService = ApplicationContext.getAddressService();
    private final String DELETE_BY_ID = "insert id for delete : ";
    private final String UPDATE_BY_ID = "insert id for update : ";
    private TeacherDto teacherDto;
    private AddressDto addressDto;
    private StudentDto studentDto;

    public EntityMenu(TeacherDto teacherDto, AddressDto addressDto,
                      StudentDto studentDto) {
        super(new String[]{"on Table Teacher", "on Table Student", "Back"});
        this.teacherDto = teacherDto;
        this.studentDto = studentDto;
        this.addressDto = addressDto;

    }

    private Long selectId(String message) {
        return new Input(
                message,
                Long.MAX_VALUE,
                1L).getInputLong();
    }

    /*private void delete(BaseEntity<Long>) {
        te
    }*/


    public void runMenuCreate() {
        try {
            while (true) {
                printMenu();
                switch (chooseOperation()) {
                    case 1:
                        saveTeacher();
                        break;
                    case 2:
                        saveStudent();
                        break;
                    case 3:
                        return;

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void saveStudent() {
        System.out.println("Enter information of Student :");
        studentDto = getStudentDto();
        Student student = studentService.getStudent(studentDto);
        System.out.println("Enter information of Address(es) Student :");
        studentDto = setAddressDtoForStudentDto(studentDto, addressService);
        student.setAddresses(studentDto.getAddresses());
        System.out.println("Enter information of Teacher(s) Student :");
        studentDto = setTeacherDtoForStudentDto(studentDto, teacherService, addressService);
        student.setTeachers(studentDto.getTeachers());
        studentService.save(student);
    }

    private void saveTeacher() {
        System.out.println("Enter information of Teacher :");
        teacherDto = getTeacherDto();
        System.out.println("Enter information of Address Teacher :");
        addressDto = getAddressDto();
        System.out.println("Enter information of Student(s) Teacher :");
        Address address = addressService.getAddress(addressDto);
        Teacher teacher = teacherService.getTeacher(teacherDto);
        teacher.setAddress(address);
        teacherDto = setStudentDtoForTeacherDto(teacherDto, studentDto, studentService, addressService);
        teacher.setStudents(teacherDto.getStudents());
//                        teacherService.createTeacher(teacherDto,addressDto);
        teacherService.save(teacher);
    }

    public void runMenuRead() {
        try {
            while (true) {
                printMenu();
                switch (chooseOperation()) {
                    case 1:
                        List<Teacher> teachers = teacherService.findAll();
                        teachers.forEach(System.out::println);
                        break;
                    case 2:
                        studentService.findAll().forEach(System.out::println);
                        System.out.println("\n \n Addresses of Students :");
                        addressService.findAll().forEach(System.out::println);
                        break;
                    case 3:
                        return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void renMenUpdate() {
        try {
            while (true) {
                printMenu();
                switch (chooseOperation()) {
                    case 1:

                        Long idTeacher = selectId(UPDATE_BY_ID);
                        new EditInformationTeacherMenu(teacherService, idTeacher).runMenuUpdate();
                        break;
                    case 2:

                        Long idStudent = selectId(UPDATE_BY_ID);
                        new EditInformationStudentMenu(studentService, idStudent).runMenuUpdate();
                        break;
                    case 3:
                        return;

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void runMenuDelete() {
        try {
            while (true) {
                printMenu();
                switch (chooseOperation()) {
                    case 1:
                        Long idTeacher = selectId(DELETE_BY_ID);
                        Teacher teacher = teacherService.findById(idTeacher);
                        addressService.delete(teacher.getAddress());

                        teacherService.delete(teacher);
                        System.out.println("Your teacher is deleted by id");
                        break;
                    case 2:

                        Long idStudent = selectId(DELETE_BY_ID);
                        Student student = studentService.findById(idStudent);
                        studentService.delete(student);
                        break;
                    case 3:
                        return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
