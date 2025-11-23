package animales;

public class Pajaro extends Animal implements Descarga {
    public Pajaro(String nombre){
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println("*El " + nombre + " canta*");
    }

    @Override
    public void descarga() {
        System.out.println("*El " + nombre + " hace una descarga eléctrica*");
    }
}
