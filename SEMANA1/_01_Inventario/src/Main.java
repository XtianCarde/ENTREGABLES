import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        /*Ejercicio 1: Sistema de Control de Inventarios

        Objetivo: Crear un sistema para manejar el inventario de un almacén, aplicando
        encapsulamiento y herencia, y utilizando ArrayList para almacenar los productos.

        Principios de POO aplicados: Encapsulamiento, Herencia.

                Requisitos:

        Clase Producto: Base para todos los productos, con propiedades como id, nombre, y
        precio. Implementa getters y setters para aplicar el encapsulamiento.
        Clase ProductoEspecifico: Hereda de Producto y añade propiedades específicas, como
        categoria o marca.

        Clase Inventario: Utiliza un ArrayList de objetos Producto para gestionar el inventario.
        Implementa métodos para añadir, eliminar, y listar productos, además de buscar productos
        por nombre o categoría.*/

        String option = "";
        int id = 0;
        Inventario objInventario = new Inventario();
        ProductoEspecifico productoEncontrado;


        do {
            option = JOptionPane.showInputDialog("MENU\n" +
                    "1.Agregar Producto \n" +
                    "2. Eliminar por id \n" +
                    "3. Bucar por nombre \n" +
                    "4. Buscar por Categoria \n" +
                    "5. Listar inventario \n" +
                    "6. Salir \n"
            );

            switch (option){


                case "1":
                    id ++;
                    String nombre = JOptionPane.showInputDialog("Ingrese nombre del producto: ");
                    double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto"));
                    String categoria = JOptionPane.showInputDialog("Ingrese categoria: ");
                    String marca = JOptionPane.showInputDialog("Ingrese marca: ");

                    ProductoEspecifico objProducto = new ProductoEspecifico(id,nombre,precio,categoria,marca);
                    objInventario.agregarProducto(objProducto);
                    objInventario.listarProductos();

                    break;

                case "2":
                    int idEliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese id del producto a eliminar: "));
                    objInventario.eliminarProducto(idEliminar);
                    objInventario.listarProductos();
                    break;

                case "3":
                    String nombreBuscar = JOptionPane.showInputDialog("Ingrese nombre del producto a buscar: ");
                    productoEncontrado = objInventario.buscarPorNombre(nombreBuscar);

                    if (productoEncontrado != null){
                        JOptionPane.showMessageDialog(null,"Producto encontrado: \n" + productoEncontrado.toString());
                    }else{
                        JOptionPane.showMessageDialog(null,"El producto no fue encontrado.");
                    };
                    break;

                case "4":
                    String categoriaBuscar = JOptionPane.showInputDialog("Ingrese Categoria a buscar: ");
                    productoEncontrado = objInventario.buscarPorCategoria(categoriaBuscar);

                    if (productoEncontrado != null){
                        JOptionPane.showMessageDialog(null,"Producto encontrado: \n" + productoEncontrado.toString());
                    }else{
                        JOptionPane.showMessageDialog(null,"El producto no fue encontrado.");
                    };

                    break;

                case "5":
                    objInventario.listarProductos();
                    //En consola sin JOptionPane :(
                    break;
            };

        }while (!option.equals("6"));




    }


}