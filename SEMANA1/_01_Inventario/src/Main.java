import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        /*ProductoEspecifico objProducto = new ProductoEspecifico(1,"Lapiz",2000,"Papeleria","Big");
        ProductoEspecifico objProducto2 = new ProductoEspecifico(2,"Cuaderno",6000,"Cuaderno","Norma");

        Inventario objInventario = new Inventario();
        objInventario.agregarProductos(objProducto);
        objInventario.agregarProductos(objProducto2);
        System.out.println("Antes de eliminar");
        objInventario.listarProductos();

        objInventario.eliminarProducto(2);
        System.out.println("Despues de eliminar");
        objInventario.listarProductos();

        System.out.println(objInventario.buscarProductoPorNombre("Lapiz"));*/

        /*
        * 1. Agregar
        * 2. Eliminar
        * 3. Buscar por nombre
        * 4. Buscar por categoria
        * 5. Listar inventario
        * 6. Salir
        * */

        String option="";

        do {
            JOptionPane.showInputDialog("MENÚ PRODUCTOS\n" +
                    "1. Agregar\n" +
                    "2. Eliminar\n" +
                    "3. Buscar por nombre\n" +
                    "4. Buscar por categoria\n" +
                    "5. Listar inventario\n" +
                    "6. Salir\n" +
                    "Ingresa una opción");
            
        } while (!option.equals("6"));
    }
}