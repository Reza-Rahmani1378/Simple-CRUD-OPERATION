package ir.maktab56.homework12.util.menu;

import ir.maktab56.homework12.service.dto.AddressDto;
import ir.maktab56.homework12.service.dto.StudentDto;
import ir.maktab56.homework12.service.dto.TeacherDto;

public class ShowAndRunMenu extends Menu {
    private final TeacherDto teacherDto = new TeacherDto();
    private final StudentDto studentDto = new StudentDto();
    private final AddressDto addressDto = new AddressDto();
    private final EntityMenu entityMenu = new EntityMenu(teacherDto, addressDto, studentDto);

    public ShowAndRunMenu() {
        super(new String[]{"Operation create", "Operation update", "Operation read", "Operation delete", "Exit"});
    }


    public void runMenu() {
        while (true) {
            printMenu();
            switch (chooseOperation()) {
                case 1:
                    entityMenu.runMenuCreate();
                    break;
                case 2:
                    entityMenu.renMenUpdate();
                    break;
                case 3:
                    entityMenu.runMenuRead();
                    break;
                case 4:
                    entityMenu.runMenuDelete();
                    break;
                case 5:
                    return;

            }
        }
    }
}
