import java.util.ArrayList;

public class Inventario {
    private ArrayList<ProductoEspecifico> listaProductos;

    public Inventario(){
        this.listaProductos = new ArrayList<>();
    }

    public void agregarProductos(ProductoEspecifico producto){
        this.listaProductos.add(producto);
    }

    public boolean eliminarProducto(int id){
       return this.listaProductos.removeIf(producto -> producto.getId() == id);
    }

    public void listarProductos(){
        for (ProductoEspecifico iterador : this.listaProductos){
            System.out.println(iterador.toString());
        }
    }

    public ProductoEspecifico buscarProductoPorNombre (String nombreBuscar){
        for(ProductoEspecifico iterador : this.listaProductos){
            if (iterador.getNombre().equalsIgnoreCase(nombreBuscar)) {
                return iterador;
            }
        }
        return null;
    }

    public ProductoEspecifico buscarProductoPorCategoria (String categoriaBuscar){
        for(ProductoEspecifico iterador : this.listaProductos){
            if (iterador.getCategoria().equalsIgnoreCase(categoriaBuscar)) {
                return iterador;
            }
        }
        return null;
    }
}
