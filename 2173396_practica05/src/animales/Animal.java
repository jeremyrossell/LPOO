package animales;

public abstract class Animal {
    private String nombre;
    public Animal(String nombre) {this.nombre = nombre;}

    public abstract void hacerSonido();

    public void comer(){
        System.out.println(this.nombre + " comiendo");
    }

    public void despertar(){
        System.out.println(this.nombre + " despertando");
    }

    public String obtenerNombre() {
        return this.nombre;
    }
}
