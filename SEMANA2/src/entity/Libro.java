package entity;

public class Libro {
    private int id;
    private String titulo;
    private String anioPublicacion;
    private double precio;
    private int fk_id_autor;

    private Autor autor;


    public Libro() {
    }

    public Libro(int id, String titulo, String anioPublicacion, double precio, int fk_id_autor,Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.precio = precio;
        this.fk_id_autor = fk_id_autor;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(String anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getFk_id_autor() {
        return fk_id_autor;
    }

    public void setFk_id_autor(int fk_id_autor) {
        this.fk_id_autor = fk_id_autor;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libros{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", año publicacion='" + anioPublicacion + '\'' +
                ", precio=" + precio +
                ", fk_id_autor=" + fk_id_autor +
                '}';
    }
}
