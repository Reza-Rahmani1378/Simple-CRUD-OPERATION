package ir.maktab56.homework12.util.menu;


import ir.maktab56.homework12.util.menu.input.Input;

public class Menu extends InputInformationMenu {
    String[] items;

    public Menu(String[] items) {
        this.items = items;
    }


    void printMenu() {
        for (int i = 1; i <= items.length; i++) {
            System.out.printf("%d - %s \n", i, items[i - 1]);
        }
    }

    public int chooseOperation() {
        return new Input
                ("Enter your Item :", items.length, 1, null).getInputInt();
    }
}
