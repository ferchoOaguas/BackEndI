package dh.backend.model;

public class Odontologo {
    private Integer numeroMatricula;
    private String nombre;
    private String apellido;

    public Odontologo(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Odontologo(Integer numeroMatricula, String nombre, String apellido) {
        this.numeroMatricula = numeroMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getNumeroMatricula() {
        return numeroMatricula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setNumeroMatricula(Integer numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "odontologo{" +
                "numeroMatricula=" + numeroMatricula +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
