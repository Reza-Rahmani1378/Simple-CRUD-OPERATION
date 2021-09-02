package ir.maktab56.homework12.util.menu;

public class CheckMenu extends Menu {
    public CheckMenu() {
        super(new String[]{"YES", "NO"});
    }


    public boolean runMenu() {
        printMenu();
        return chooseOperation() == 1;
    }
}
