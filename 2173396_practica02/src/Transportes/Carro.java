package Transportes;

public class Carro {
    String marca;
    String modelo;
    String matricula;
    String kilometraje;

    public Carro(){

    }

    public Carro(String marca, String modelo, String matricula, String kilometraje) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.kilometraje = kilometraje;
    }

    public void displayInfo(){
        System.out.println("Marca +" + marca + ", Modelo: " + modelo + ", Matrícula: " + matricula + ", Kilometraje: " + kilometraje);
    }

    public void encenderMotor(){
        System.out.println("Carro encendido");
    }

    public void chocarCarroParaSacarleDineroAlSeguro(){
        System.out.println("FIUUUUUUUUUMMMMMMMM!! PSSSSSHHHHHHHHHHH!! Carro chocado, llamando al seguro para que cubra los gastos");
    }
}
