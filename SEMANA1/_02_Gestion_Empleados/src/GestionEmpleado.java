import java.util.ArrayList;
import java.util.Scanner;

public class GestionEmpleado {
    ArrayList<Empleado> listaEmpleado;

    public GestionEmpleado() {
        this.listaEmpleado = new ArrayList<>();
    }

    public void agegarEmpleado(Empleado empleado){
        listaEmpleado.add(empleado);
        /*objSc.nextLine();
        System.out.println("Ingresa el nombre del empleado a ingresar: ");
        String nombre = objSc.nextLine();

        System.out.println("Ingresa la edad del empleado: ");
        int edad = objSc.nextInt();

        System.out.println("Ingresa el salario del empleado: ");
        double salario = objSc.nextDouble();*/
    };

    public boolean eliminarEmpleado(int idEmpleado){
        return this.listaEmpleado.removeIf(empleado -> empleado.getIdEmpleado() == idEmpleado);
        /*System.out.println("Ingresa el id del empleado: ");
        int idEmpleado = objSc.nextInt();

        boolean eliminado = this.listaEmpleado.removeIf(empleado -> empleado.getIdEmpleado() == idEmpleado);
        System.out.println(eliminado?"Empleado eliminado correctamente":"No se pudo eliminar el empleado");*/
    };

    public void listarEmpleado(){
        if (this.listaEmpleado.isEmpty()) {
            System.out.println("No hay empleados registrados");
        } else {
            for (Empleado empleado : this.listaEmpleado){
                System.out.println(empleado.toString());
            }
        }
    };
}
