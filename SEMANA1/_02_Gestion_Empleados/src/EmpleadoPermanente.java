public class EmpleadoPermanente extends Empleado{
    public EmpleadoPermanente(String nombre, int edad, int idEmpleado, double salario) {
        super(nombre, edad, idEmpleado, salario);
    }

    @Override
    public String toString() {
        return "EmpleadoPermanente{" + super.toString() + "}";
    }
}
