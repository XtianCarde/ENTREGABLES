public class EmpleadoTemporal extends Empleado{
    public EmpleadoTemporal(String nombre, int edad, int idEmpleado, double salario) {
        super(nombre, edad, idEmpleado, salario);
    }

    @Override
    public String toString() {
        return "EmpleadoTemporal{" + super.toString() + "}";
    }
}
