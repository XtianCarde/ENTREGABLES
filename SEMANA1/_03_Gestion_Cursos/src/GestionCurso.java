import java.util.ArrayList;
import java.util.Scanner;
public class GestionCurso {

    private ArrayList<Curso> listaCursos;

    public GestionCurso(){
        this.listaCursos = new ArrayList<>();
    }

    public void agregarCurso(Scanner objScan){
        objScan.nextLine();
        System.out.println("Ingresa el nombre del nuevo curso: ");
        String nombre = objScan.nextLine();

        System.out.println("Ingresa el codigo del nuevo curso: ");
        String codigo = objScan.nextLine();

        //Validamos que el codigo del curso sea unico
        if (this.buscarCursoPorCodigo(codigo) != null){
            System.out.println("7" +
                    "\n Ya existe un curso con este código");
        } else {
            Curso objCurso = new Curso(codigo,nombre);
            if (this.listaCursos.add(objCurso)) {
                System.out.println("Curso agregado correctamente");
            } else {
                System.out.println("No se pudo agregar el curso correctamente");
            }

        }

    }

    public void listarTodosLosCursos (){

        if (this.listaCursos.isEmpty()) {
            System.out.println("No hay cursos registrados");
        } else {
            for (Curso iterator : this.listaCursos){
                System.out.println(iterator.toString());
            }
        }

    }

    public Curso buscarCursoPorCodigo (String codigoBuscar) {
        for (Curso temporal : this.listaCursos) {
            if (temporal.getCodigo().equalsIgnoreCase(codigoBuscar)) {
                return temporal;
            }
        }
            return null;
    }
}
