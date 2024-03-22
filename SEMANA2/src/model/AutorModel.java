package model;

import database.CRUD;
import database.ConfigDb;
import entity.Autor;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutorModel implements CRUD {
    @Override
    public Object insert(Object obj) {

        //Abrimos la conexión
        Connection objConnection = ConfigDb.openConnection();
        //Convertir el objeto que llega a autor
        Autor objAutor = (Autor) obj;

        try{
            String sql = "INSERT INTO autores (nombre,nacionalidad) VALUE (?,?);";

            PreparedStatement objPrepare =objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1,objAutor.getNombre());
            objPrepare.setString(2,objAutor.getNacionalidad());

            //Ejecutamos el Query
            objPrepare.execute();

            //Recibimos el resultado con las llaves generadas
            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()){
                objAutor.setId(objResult.getInt(1));
            }

            JOptionPane.showMessageDialog(null,"Autor insertion was successful");

        } catch (SQLException error){
            JOptionPane.showMessageDialog(null,error.getMessage());
        }
        ConfigDb.closeConnection();
        return objAutor;
    }

    @Override
    public List<Object> findAll() {
        List<Object> listAutores = new ArrayList<>();
        Connection objConnection = ConfigDb.openConnection();
        try{
            String sql = "SELECT * FROM autores;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()){
                Autor objAutor = new Autor();

                objAutor.setId(objResult.getInt("id"));
                objAutor.setNombre(objResult.getString("nombre"));
                objAutor.setNacionalidad(objResult.getString("nacionalidad"));

                listAutores.add(objAutor);
            }

        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        ConfigDb.closeConnection();
        return listAutores;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDb.openConnection();
        Autor objAutor = (Autor) obj;
        boolean isUpdate = false;
        try {
            String sql = "UPDATE autores SET nombre = ?, nacionalidad = ? WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1,objAutor.getNombre());
            objPrepare.setString(2,objAutor.getNacionalidad());
            objPrepare.setInt(3,objAutor.getId());

            int totalRowAffected = objPrepare.executeUpdate();

            if (totalRowAffected>0){
                isUpdate = true;
                JOptionPane.showMessageDialog(null,"The update was successful");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally {
            ConfigDb.closeConnection();
        }
        return isUpdate;
    }

    @Override
    public boolean delete(Object obj) {
        Connection objConnection = ConfigDb.openConnection();

        Autor objAutor = (Autor) obj;

        boolean isDeleted = false;

        try {
            String sql = "DELETE FROM autores WHERE id = ?";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1,objAutor.getId());
            int totalAffectedRow = objPrepare.executeUpdate();

            if (totalAffectedRow>0){
                isDeleted = true;
                JOptionPane.showMessageDialog(null,"The author "+objAutor.toString()+" was deleted");
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally {
            ConfigDb.closeConnection();
        }
        return isDeleted;
    }

    public Autor findById(int id){
        //1. Abrimos la conexión
        Connection objConnection = ConfigDb.openConnection();
        //2. Crear el coder que vamos a retornar
        Autor objAutor = null;

        try {
            //3. Sentencia SQL
            String sql = "SELECT * FROM autores WHERE id = ?;";

            //4. Preparamos el statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            //5. Darle valor al parametro de query
            objPrepare.setInt(1,id);

            //6. Ejecutamos el Query
            ResultSet objResult = objPrepare.executeQuery();

            if (objResult.next()) {
                objAutor = new Autor();
                objAutor.setNombre(objResult.getString("nombre"));
                objAutor.setNacionalidad(objResult.getString("nacionalidad"));
                objAutor.setId(objResult.getInt("id"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        //7. Cerrar la conexión
        ConfigDb.closeConnection();
        return objAutor;
    }
}
