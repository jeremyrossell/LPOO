package animales;

public class Animal {
    String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public String mostrarNombre(){
        return nombre;
    }

    public void hacerSonido(){
        System.out.println("*El " + nombre + " hace un sonido*");
    }

    public String comer(){
        return "*El " + nombre + " comiendo*";
    }
}
