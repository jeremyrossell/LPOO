package animales;

public class Aguila extends Animal implements IVolador {
    public Aguila(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println(obtenerNombre() + " hace sonido");
    }

    @Override
    public void volar() {
        System.out.println(obtenerNombre() + " vuela");
    }

    @Override
    public int alturaMaxima() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String respirar() {
        return obtenerNombre() + " respira";
    }
}
