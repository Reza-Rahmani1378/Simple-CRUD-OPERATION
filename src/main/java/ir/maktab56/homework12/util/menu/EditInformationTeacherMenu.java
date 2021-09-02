package ir.maktab56.homework12.util.menu;

import ir.maktab56.homework12.domain.Teacher;
import ir.maktab56.homework12.service.TeacherService;

public class EditInformationTeacherMenu extends Menu {
    private final TeacherService teacherService;
    private final Long id;
    private final Teacher teacher;

    public EditInformationTeacherMenu(TeacherService teacherService, Long id) {
        super(new String[]{"Edit first name", "Edit last name",
                "Edit teacher code ", "Edit salary ",
                "Edit birth day ", "Edit Address", "Back"});
        System.out.println("--------------------------------------\n " +
                "edit information of Teacher : \n");
        this.teacherService = teacherService;
        this.id = id;
        this.teacher = teacherService.findById(id);
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
                        editTeacherCode();
                        break;
                    case 4:
                        editSalary();
                        break;
                    case 5:
                        editBirthDay();
                        break;
                    case 6:
                        editAddress();
                    case 7:
                        return;

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void editAddress() {
        System.out.println("Edit information Address for Teacher : \n");
        new EditInformationAddressMenu(teacher, teacherService).runMenuUpdate();
    }

    private void editBirthDay() {
        teacher.setBirthDay(getBirthDay());
        teacherService.save(teacher);
    }

    private void editSalary() {
        teacher.setSalary(getSalary());
        teacherService.save(teacher);
    }

    private void editTeacherCode() {
        teacher.setTeacherCode(getCode());
        teacherService.save(teacher);
    }

    private void editLastName() {
        teacher.setLastName(getLastName());
        teacherService.save(teacher);

    }

    private void editFirstName() {
        teacher.setFirstName(getFirstName());
        teacherService.save(teacher);
    }
}
