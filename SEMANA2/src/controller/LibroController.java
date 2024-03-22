package controller;

import entity.Autor;
import entity.Libro;
import model.AutorModel;
import model.LibroModel;

import javax.swing.*;
import java.util.List;

public class LibroController {
    public static void create(){
        LibroModel objLibroModel = new LibroModel();

        String titulo = JOptionPane.showInputDialog("Insert the title");
        String anioPublicacion = JOptionPane.showInputDialog("Insert year of publication");
        int fk_id_autor = Integer.parseInt(JOptionPane.showInputDialog(AutorController.getAllString()+"Insert ID author"));
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Insert price"));

        Libro objLibro = new Libro();

        objLibro.setTitulo(titulo);
        objLibro.setAnioPublicacion(anioPublicacion);
        objLibro.setFk_id_autor(fk_id_autor);
        objLibro.setPrecio(precio);

        objLibro = (Libro) objLibroModel.insert(objLibro);

        JOptionPane.showMessageDialog(null,objLibro.toString());

    }

    public static void getAll(){
        LibroModel objLibroModel = new LibroModel();
        String listBooks = "LIST BOOKS\n";

        for (Object iterator : objLibroModel.findAll()){
            Libro objLibro = (Libro) iterator;
            listBooks += objLibro.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null,listBooks);
    }

    public static String getAllString(){
        LibroModel objLibroModel = new LibroModel();

        String listBooks = "LIST BOOKS\n";

        for (Object iterator : objLibroModel.findAll()){
            Libro objLibro = (Libro) iterator;
            listBooks += objLibro.toString() + "\n";
        }
        return listBooks;
    }

    public static void delete(){
        String listBooks = getAllString();
        LibroModel objLibroModel = new LibroModel();
        int idDeleted = Integer.parseInt(JOptionPane.showInputDialog(listBooks + "\nInsert the ID of the book to delete"));
        Libro objLibro = objLibroModel.findById(idDeleted);
        int confirmed = 1;

        System.out.println(objLibro.toString());
        if (objLibro == null){
            JOptionPane.showMessageDialog(null,"Book not found");
        } else {
            confirmed = JOptionPane.showConfirmDialog(null,"Are you sure want to delete this book?" + objLibro.toString());
            if (confirmed == 0){
                objLibroModel.delete(objLibro);
            }
        }

    }

    public static void update(){
        String listBooks = getAllString();
        LibroModel objLibroModel = new LibroModel();
        int idUpdated = Integer.parseInt(JOptionPane.showInputDialog(listBooks + "\nInsert the ID of the book to update"));
        Libro objLibro = objLibroModel.findById(idUpdated);

        if (objLibro == null){
            JOptionPane.showMessageDialog(null,"Book not found");
        } else {
            String titulo = JOptionPane.showInputDialog(null, "Insert the title",objLibro.getTitulo());
            String anioPublicacion = JOptionPane.showInputDialog(null,"Insert year of publication",objLibro.getAnioPublicacion());
            int fk_id_autor = Integer.parseInt(JOptionPane.showInputDialog(null,AutorController.getAllString()+"Insert ID author",objLibro.getFk_id_autor()));
            double precio = Double.parseDouble(JOptionPane.showInputDialog(null,"Insert price",objLibro.getPrecio()));

            objLibro.setTitulo(titulo);
            objLibro.setAnioPublicacion(anioPublicacion);
            objLibro.setFk_id_autor(fk_id_autor);
            objLibro.setPrecio(precio);

            objLibroModel.update(objLibro);
        }
    }

    public static void getByName(){
        LibroModel objLibroModel = new LibroModel();
        String titulo = JOptionPane.showInputDialog("Insert title to search");

        String listBooks = "LIST BOOKS BY TITTLE\n";
        for (Libro iterator:objLibroModel.findByTitle(titulo)){
            listBooks += iterator.toString() + "\n";
        }
         JOptionPane.showMessageDialog(null,listBooks);
    }

    public static void getByIdAuthor(){
        LibroModel objLibroModel = new LibroModel();
        AutorModel objAutorModel = new AutorModel();

        List<Object> list = objAutorModel.findAll();
        Autor[] arrAutor = new  Autor[list.size()];

        int index = 0;
        for (Object ite : list){
            Autor objAutor = (Autor) ite;
            arrAutor[index] = objAutor;
            index++;
        }

        Autor idSearch = (Autor) JOptionPane.showInputDialog(null,
                "Insert Authors ID to search",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                arrAutor,
                arrAutor[0]);

        String listBooks = "LIST BOOKS BY TITTLE\n";
        for (Libro iterator:objLibroModel.findBooksByIdAuthor(idSearch.getId())){
            listBooks += iterator.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null,listBooks);
    }
}
