package model;

import database.CRUD;
import database.ConfigDb;
import entity.Autor;
import entity.Libro;

import javax.swing.*;
import java.io.ObjectInputFilter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibroModel implements CRUD {
    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDb.openConnection();
        Libro objLibro = (Libro) obj;

        try{
            String sql = "INSERT INTO libros (titulo,anioPublicacion,precio,fk_id_autor) VALUE (?,?,?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1,objLibro.getTitulo());
            objPrepare.setString(2,objLibro.getAnioPublicacion());
            objPrepare.setDouble(3,objLibro.getPrecio());
            objPrepare.setInt(4,objLibro.getFk_id_autor());

            objPrepare.execute();

            ResultSet objResult =objPrepare.getGeneratedKeys();

            while (objResult.next()){
                objLibro.setId(objResult.getInt(1));
            }
            JOptionPane.showMessageDialog(null,"Book insertion was successful");
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally {
            ConfigDb.closeConnection();
        }
        return objLibro;
    }

    @Override
    public List<Object> findAll() {
        Connection objConnection = ConfigDb.openConnection();
        List<Object> listBooks = new ArrayList<>();

        try {
            String sql = "SELECT * FROM libros;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()){
                Libro objLibro = new Libro();
                objLibro.setTitulo(objResult.getString("titulo"));
                objLibro.setId(objResult.getInt("id"));
                objLibro.setFk_id_autor(objResult.getInt("fk_id_autor"));
                objLibro.setAnioPublicacion(objResult.getString("anioPublicacion"));
                objLibro.setPrecio(objResult.getDouble("precio"));

                listBooks.add(objLibro);
            }
        } catch (SQLException e)  {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ConfigDb.closeConnection();
        }

        return listBooks;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDb.openConnection();
        Libro objLibro = (Libro) obj;
        boolean isUpdated = false;
        try {
            String sql = "UPDATE libros SET titulo = ?, anioPublicacion = ?, precio = ?, fk_id_autor = ? WHERE id = ?;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1,objLibro.getTitulo());
            objPrepare.setString(2,objLibro.getAnioPublicacion());
            objPrepare.setDouble(3,objLibro.getPrecio());
            objPrepare.setInt(4,objLibro.getFk_id_autor());
            objPrepare.setInt(5,objLibro.getId());

            int totalRowsAffected = objPrepare.executeUpdate();

            if (totalRowsAffected>0){
                isUpdated = true;
                JOptionPane.showMessageDialog(null,"The update was successful");
            }

        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ConfigDb.closeConnection();
        }
        return isUpdated;
    }

    @Override
    public boolean delete(Object obj) {
        Connection objConnection = ConfigDb.openConnection();
        Libro objLibro = (Libro) obj;

        boolean isDeleted = false;

        try{
            String sql = "DELETE FROM libros WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1,objLibro.getId());

            int totalRowsAffected = objPrepare.executeUpdate();

            if (totalRowsAffected>0) {
                isDeleted = true;
                JOptionPane.showMessageDialog(null,"The book was deleted successful");
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally {
            ConfigDb.closeConnection();
        }
        return isDeleted;
    }

    public Libro findById(int id){
        Connection objConnection = ConfigDb.openConnection();
        Libro objLibro = null;

        try {
            String sql = "SELECT * FROM libros WHERE id = ?;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1,id);

            ResultSet objResult = objPrepare.executeQuery();

            if (objResult.next()){
                objLibro = new Libro();
                objLibro.setTitulo(objResult.getString("titulo"));
                objLibro.setAnioPublicacion(objResult.getString("anioPublicacion"));
                objLibro.setId(objResult.getInt("id"));
                objLibro.setPrecio(objResult.getDouble("precio"));
                objLibro.setFk_id_autor(objResult.getInt("fk_id_autor"));
            }

        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally {
            ConfigDb.closeConnection();
        }
        return objLibro;
    }

    public List<Libro> findByTitle(String titulo){
        List<Libro> listLibros = new ArrayList<>();
        Connection objConnection = ConfigDb.openConnection();
        Libro objLibro = null;

        try {
            String sql = "SELECT * FROM libros WHERE titulo LIKE ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1,"%"+titulo+"%");

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()){
                objLibro = new Libro();
                objLibro.setTitulo(objResult.getString("titulo"));
                objLibro.setId(objResult.getInt("id"));
                objLibro.setFk_id_autor(objResult.getInt("fk_id_autor"));
                objLibro.setPrecio(objResult.getDouble("precio"));
                objLibro.setAnioPublicacion(objResult.getString("anioPublicacion"));

                listLibros.add(objLibro);
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally {
            ConfigDb.closeConnection();
        }

        return listLibros;
    }

    public List<Libro> findBooksByIdAuthor(int id) {
        List<Libro> listLibros = new ArrayList<>();
        Connection objConnection = ConfigDb.openConnection();
        Libro objLibro = null;


        try {
            String sql = "SELECT * FROM libros INNER JOIN autores ON libros.fk_id_autor = autores.id WHERE autores.id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, id);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                objLibro = new Libro();
                objLibro.setTitulo(objResult.getString("libros.titulo"));
                objLibro.setId(objResult.getInt("libros.id"));
                objLibro.setFk_id_autor(objResult.getInt("libros.fk_id_autor"));
                objLibro.setPrecio(objResult.getDouble("libros.precio"));
                objLibro.setAnioPublicacion(objResult.getString("libros.anioPublicacion"));

                Autor objAutor = new Autor();
                objAutor.setNombre(objResult.getString("autores.nombre"));
                objAutor.setNacionalidad(objResult.getString("autores.nacionalidad"));
                objAutor.setId(objLibro.getFk_id_autor());

                objLibro.setAutor(objAutor);

                listLibros.add(objLibro);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ConfigDb.closeConnection();
        }

        return listLibros;

    }
}
