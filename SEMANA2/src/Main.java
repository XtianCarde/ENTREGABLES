import controller.AutorController;
import controller.LibroController;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {


        String optionMain = "";
        do {
            optionMain = JOptionPane.showInputDialog("""
                    Choose the option to admin
                    1. Author
                    2. Books
                    0. Exit
                    """);

            switch (optionMain) {
                case "1":
                    String option = "";
                    do {
                        option = JOptionPane.showInputDialog("""
                                1. List Authors.
                                2. Insert Authors.
                                3. Update Authors.
                                4. Delete Authors.
                                6. Exit
                                """);

                        switch (option) {
                            case "1":
                                AutorController.getAll();
                                break;

                            case "2":
                                AutorController.create();
                                break;

                            case "3":
                                AutorController.update();
                                break;

                            case "4":
                                AutorController.delete();
                                break;

                        }

                    } while (!option.equals("6"));

                    break;

                case "2":
                    String option2 = "";
                    do {
                        option2 = JOptionPane.showInputDialog("""
                                1. List Books.
                                2. Insert Books.
                                3. Update Books.
                                4. Delete Books.
                                5. List Books by title.
                                6. List Books by author.
                                7. Exit
                                """);

                        switch (option2) {
                            case "1":
                                LibroController.getAll();
                                break;

                            case "2":
                                LibroController.create();
                                break;

                            case "3":
                                LibroController.update();
                                break;

                            case "4":
                                LibroController.delete();
                                break;

                            case "5":
                                LibroController.getByName();
                                break;
                            case "6":
                                LibroController.getByIdAuthor();
                                break;

                        }

                    } while (!option2.equals("7"));
                    break;
            }
        } while (!optionMain.equals("0"));


    }
}