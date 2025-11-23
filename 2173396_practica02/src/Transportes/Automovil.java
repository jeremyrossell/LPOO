package Transportes;

public class Automovil {
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getKilometraje(){
        return kilometraje;
    }
    public void setKilometraje(String kilometraje){
        this.kilometraje = kilometraje;
    }

    public void encenderMotor(){
        System.out.println("Encendiendo motor");
    }

    public void apagarMotor() {
        System.out.println("Apagando motor");
    }

    public String avanzar() {
        return "Automovil avanzando";
    }

    private String marca;
    private String modelo;
    private String matricula;
    private String kilometraje;
}
