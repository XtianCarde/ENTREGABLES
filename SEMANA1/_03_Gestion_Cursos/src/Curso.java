import java.util.ArrayList;
import java.util.Scanner;

public class Curso {
    private String codigo;
    private String nombre;

    private ArrayList<Estudiante> listaEstudiantes;

    private static int index = 1;

    public Curso(String codigo, String nombre){
        this.nombre = nombre;
        this.codigo = codigo;
        this.listaEstudiantes = new ArrayList<>();
    }


    public void agregarEstudiante(Scanner scanner){
        scanner.nextLine();
        System.out.println("Ingresa el nombre del estudiante");
        String nombre = scanner.nextLine();
        System.out.println("Ingresa el email del estudiante");
        String email = scanner.nextLine();

        Estudiante objEstudiante = new Estudiante(index,nombre,email);
        index++;
        this.listaEstudiantes.add(objEstudiante);
        System.out.println("Estudiante agregado correctamente!");

    }

    public void listarEstudiantes(){
        if (this.listaEstudiantes.isEmpty()) {
            System.out.println("No hay estudiantes en el curso ".concat(this.nombre));
        }else {
            System.out.println("Lista de estudiantes del curso ".concat(this.nombre));
            for (Estudiante estudiante : this.listaEstudiantes) {
                System.out.println(estudiante.toString());
            }
        }
    }

    public void eliminarEstudiante (Scanner objScanner){
        this.listarEstudiantes();

        System.out.println("Ingrese el id del estudiante a eliminar");
        int idEliminar = objScanner.nextInt();

        //Eliminamos el estudiante si su id coincide con el id que se desea eliminar
        boolean eliminado = this.listaEstudiantes.removeIf(estudiante -> estudiante.getId() == idEliminar);
        System.out.println(eliminado
                ? "Estudiante eliminado correctamente"
                : "No se pudo eliminar correctamente");
    }
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
