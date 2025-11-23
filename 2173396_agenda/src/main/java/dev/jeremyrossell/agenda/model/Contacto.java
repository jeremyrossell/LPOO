package dev.jeremyrossell.agenda.model;

public class Contacto {
    private Integer id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String sexo;        // 'M','F','O'
    private String telefono;
    private String direccion;
    private String tipoContacto; // 'CASA','TRABAJO'

    // constructor vacío
    public Contacto() {}

    // constructor con campos
    public Contacto(Integer id, String nombre, String apellidoPaterno, String apellidoMaterno, String sexo, String telefono, String direccion, String tipoContacto) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.sexo = sexo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tipoContacto = tipoContacto;
    }

    // constructor sin ID (para insertar nuevos)
    public Contacto(String nombre, String apellidoPaterno, String apellidoMaterno, String sexo, String telefono, String direccion, String tipoContacto) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.sexo = sexo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tipoContacto = tipoContacto;
    }

    // getters y setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidoPaterno() { return apellidoPaterno; }
    public void setApellidoPaterno(String apellidoPaterno) { this.apellidoPaterno = apellidoPaterno; }

    public String getApellidoMaterno() { return apellidoMaterno; }
    public void setApellidoMaterno(String apellidoMaterno) { this.apellidoMaterno = apellidoMaterno; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTipoContacto() { return tipoContacto; }
    public void setTipoContacto(String tipoContacto) { this.tipoContacto = tipoContacto; }
}