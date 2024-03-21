import controller.AutorController;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        String option = "";

        do {
            option = JOptionPane.showInputDialog("""
                    1. List Authors.
                    2. Insert Authors.
                    3. Update Authors.
                    4. Delete Authors.
                    5. Search Authors by ID.
                    6. Exit
                    """);

            switch (option){
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


    }
}