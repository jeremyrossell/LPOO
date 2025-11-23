package animales;

public class Gato extends Animal {
    public Gato(String nombre){
        super(nombre);
    }

    public void hacerSonido(){
        System.out.println("*El " + nombre + " maulla*");
    }

    public String comer(){
        return "*El " + nombre + " come carne*";
    }
}
