package controller;

import database.ConfigDb;
import entity.Autor;
import entity.Libro;
import model.AutorModel;

import javax.swing.*;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutorController {
    public static void create() {
        AutorModel objAutorModel = new AutorModel();

        String nombre = JOptionPane.showInputDialog("Insert name");
        String nacionalidad = JOptionPane.showInputDialog("Insert nationality");

        Autor objAutor = new Autor();

        objAutor.setNombre(nombre);
        objAutor.setNacionalidad(nacionalidad);

        objAutor = (Autor) objAutorModel.insert(objAutor);
        JOptionPane.showMessageDialog(null, objAutor.toString());
    }

    public static void getAll() {
        AutorModel objAutorModel = new AutorModel();
        String listAuthors = "LIST AUTHORS\n";
        for (Object iterator : objAutorModel.findAll()) {
            Autor objAutor = (Autor) iterator;
            listAuthors += objAutor.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, listAuthors);
    }

    public static String getAllString() {
        AutorModel objAutorModel = new AutorModel();
        String listAuthors = "LIST AUTHORS\n";
        for (Object iterator : objAutorModel.findAll()) {
            Autor objAutor = (Autor) iterator;
            listAuthors += objAutor.toString() + "\n";
        }
        return listAuthors;
    }

    public static void delete() {
        String listAuthors = getAllString();
        AutorModel objAutorModel = new AutorModel();
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listAuthors + "\nInsert ID author to delete"));
        Autor objAutor = objAutorModel.findById(idDelete);
        int confirm = 1;
        if (objAutor == null) {
            JOptionPane.showMessageDialog(null, "Coder not found");
        } else {
            confirm = JOptionPane.showConfirmDialog(null, "Are you sure want to delete the author?");
            if (confirm == 0) {
                objAutorModel.delete(objAutor);
            }
        }
    }

    public static void update() {
        AutorModel objAutorModel = new AutorModel();
        String listAuthors = getAllString();

        int idUpdate = Integer.parseInt(JOptionPane.showInputDialog(listAuthors + "\nEnter ID of the author to update"));
        Autor objAutor = objAutorModel.findById(idUpdate);

        if (objAutor == null) {
            JOptionPane.showMessageDialog(null, "Coder not found");
        } else {
            String nombre = JOptionPane.showInputDialog(null, "Enter new name", objAutor.getNombre());
            String nacionalidad = JOptionPane.showInputDialog(null, "Enter new nationality", objAutor.getNacionalidad());

            objAutor.setNombre(nombre);
            objAutor.setNacionalidad(nacionalidad);

            objAutorModel.update(objAutor);
        }
    }
}