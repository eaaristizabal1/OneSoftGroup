package udea.edu.main.model;

public class Empleado {
    private String nombre_empleado;
    private String correo;
    private String empresa_pertenece;
    private String rol;

    public Empleado(String nombre_empleado, String correo, String empresa_pertenece, String rol) {
        this.nombre_empleado = nombre_empleado;
        this.correo = correo;
        this.empresa_pertenece = empresa_pertenece;
        this.rol = rol;

    }

    public String getNombre_empleado() {return nombre_empleado;}

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getCorreo() {return correo;}

    public void setCorreo(String correo) {this.correo = correo;}

    public String getEmpresa_pertenece() {return empresa_pertenece;}

    public void setEmpresa_pertenece(String empresa_pertenece) {this.empresa_pertenece = empresa_pertenece;}

    public String getRol() {return rol;}

    public void setRol(String rol) {this.rol = rol;}
}
