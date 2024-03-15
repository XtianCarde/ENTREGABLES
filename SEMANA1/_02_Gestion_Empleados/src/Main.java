
public class Main {
    public static void main(String[] args) {

        GestionEmpleado objGestion = new GestionEmpleado();
        Empleado empleado1 = new EmpleadoPermanente("Cristian",22,1000295757,5000000);
        Empleado empleado2 = new EmpleadoTemporal("Juan",19,1001223629,2000000);
        objGestion.agegarEmpleado(empleado1);
        objGestion.agegarEmpleado(empleado2);

        objGestion.listarEmpleado();

        objGestion.eliminarEmpleado(1001223629);

        System.out.println("\nDespués de eliminar");
        objGestion.listarEmpleado();
    }
}