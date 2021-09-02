package ir.maktab56.homework12.util.menu;

import ir.maktab56.homework12.domain.Student;
import ir.maktab56.homework12.service.StudentService;

public class EditInformationStudentMenu extends Menu {
    private final StudentService studentService;
    private final Long id;
    private final Student student;

    public EditInformationStudentMenu(StudentService studentService, Long id) {
        super(new String[]{"Edit first name", "Edit last name",
                "Edit student code ",
                "Edit birth day", "Back"});
        System.out.println("--------------------------------------\n " +
                "edit information of Teacher : \n");
        this.studentService = studentService;
        this.id = id;
        this.student = studentService.findById(id);
    }

    public void runMenuUpdate() {
        try {
            while (true) {
                printMenu();
                switch (chooseOperation()) {
                    case 1:
                        editFirstName();
                        break;
                    case 2:
                        editLastName();
                        break;
                    case 3:
                        editStudentCode();
                        break;
                    case 4:
                        editBirthDay();
                        break;
                    case 5:
                        return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void editBirthDay() {
        student.setBirthDay(getBirthDay());
        studentService.save(student);
    }

    private void editStudentCode() {
        student.setStudentCode(getCode());
        studentService.save(student);
    }

    private void editLastName() {
        student.setLastName(getLastName());
        studentService.save(student);

    }

    private void editFirstName() {
        student.setFirstName(getFirstName());
        studentService.save(student);
    }
}
