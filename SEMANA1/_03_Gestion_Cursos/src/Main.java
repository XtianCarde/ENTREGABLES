import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Instancias
        Scanner sc = new Scanner(System.in);
        GestionCurso objGestion = new GestionCurso();

        int option = 0;
        do {
            System.out.println("""
                    MENU DE OPCIONES
                    1. Administrar estudiantes
                    2. Administrar cursos
                    3. Salir
                    Ingrese una opción                    
                    """);
            option = sc.nextInt();
            switch (option){
                case 1:
                    int option3 = 0;
                    do {
                        System.out.println("""
                                1. Agregar estudiantes a curso
                                2. Listar estudiantes del curso
                                3. Eliminar estudiantes de un curso
                                4. Salir
                                Ingrese una opción
                                """);
                        option3 = sc.nextInt();

                        switch (option3){
                            case 1:
                                System.out.println("Estos son los cursos actualmente disponibles");
                                objGestion.listarTodosLosCursos();
                                System.out.println("Ingresa el código del curso donde ingresarás el nuevo estudiante");
                                String codigo = sc.next();
                                Curso objCurso = objGestion.buscarCursoPorCodigo(codigo);

                                if (objCurso == null){
                                    System.out.println("El código no pertenece a un curso");
                                } else {
                                    objCurso.agregarEstudiante(sc);
                                }
                                break;

                            case 2:

                                objGestion.listarTodosLosCursos();
                                System.out.println("Ingresa el código del curso para listar los estudiantes");
                                codigo = sc.next();
                                objCurso = objGestion.buscarCursoPorCodigo(codigo);

                                if (objCurso == null){
                                    System.out.println("El código no pertenece a un curso");
                                } else {
                                    objCurso.listarEstudiantes();
                                }
                                break;

                            case 3: //Eliminar estudiantes a un curso en específico

                            //1. Listar cursos
                                objGestion.listarTodosLosCursos();
                            //2. preguntar codigo del curso
                                sc.nextLine();
                                System.out.println("Ingrese el codigo del curso del estudiante a eliminar");
                                codigo = sc.nextLine();
                            //3. Buscar el curso por codigo
                                 objCurso = objGestion.buscarCursoPorCodigo(codigo);
                            //4. Eliminar el estudiante de ese curso
                                if (objCurso == null) {
                                    System.out.println("El código ingresado no coincide con ningún curso");
                                } else {
                                    objCurso.eliminarEstudiante(sc);
                                }
                        }
                    } while (option3!= 4);
                    break;
                case 2:
                    int option2 = 0;
                        do {
                            System.out.println("""
                                    MENU DE CURSOS
                                    1. Agregar curso
                                    2. Listar curso
                                    3. Buscar por código
                                    4. Salir
                                    Ingrese una opción
                                    """);
                            option2 = sc.nextInt();

                            switch (option2){
                                case 1:
                                    objGestion.agregarCurso(sc);
                                    break;

                                case 2:
                                    objGestion.listarTodosLosCursos();
                                    break;

                                case 3:
                                    System.out.println("Ingresa el código del curso a buscar");
                                    String codigo = sc.next();
                                    Curso objCurso = objGestion.buscarCursoPorCodigo(codigo);
                                    if (objCurso == null){
                                        System.out.println("No existe ningún curso por este código");
                                    } else {
                                        System.out.println(objCurso.toString());
                                    }
                                    break;
                            }
                        } while (option2 != 4);
                        break;
                case 3:

                    break;
            }
        } while (option != 3);
    }
}