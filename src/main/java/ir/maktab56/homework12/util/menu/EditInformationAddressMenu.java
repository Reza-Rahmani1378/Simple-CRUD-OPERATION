package ir.maktab56.homework12.util.menu;

import ir.maktab56.homework12.domain.Teacher;
import ir.maktab56.homework12.service.TeacherService;

public class EditInformationAddressMenu extends Menu {
    private final Teacher teacher;
    private final TeacherService teacherService;

    public EditInformationAddressMenu(Teacher teacher, TeacherService teacherService) {
        super(new String[]{"Edit number", "Edit state", "Edit city", "Edit postalAddress", "Edit postalCode", "Back"});
        this.teacher = teacher;
        this.teacherService = teacherService;
    }


    public void runMenuUpdate() {
        try {
            while (true) {
                switch (chooseOperation()) {
                    case 1:
                        editNumber();
                        break;
                    case 2:
                        editState();
                        break;
                    case 3:
                        editCity();
                        break;
                    case 4:
                        editPostalAddress();
                        break;
                    case 5:
                        editPostalCode();
                        break;
                    case 6:
                        return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void editPostalCode() {
        teacher.getAddress().setPostalCode(getPostalCode());
        teacherService.save(teacher);
    }

    private void editPostalAddress() {
        teacher.getAddress().setPostalAddress(getPostalAddress());
        teacherService.save(teacher);
    }

    private void editCity() {
        teacher.getAddress().setCity(getCity());
        teacherService.save(teacher);
    }

    private void editState() {
        teacher.getAddress().setState(getState());
        teacherService.save(teacher);
    }

    private void editNumber() {
        teacher.getAddress().setNumber(getPhoneNumber());
        teacherService.save(teacher);
    }
}
