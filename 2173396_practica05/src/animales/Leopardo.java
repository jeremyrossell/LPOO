package animales;

public class Leopardo extends Animal implements ITerrestre {
    public Leopardo(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println(obtenerNombre() + " hace sonido");
    }

    @Override
    public void correr() {
        System.out.println(obtenerNombre() + " corre");
    }

    @Override
    public int distanciaMaxima() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String respirar() {
        return obtenerNombre() + " respira";
    }
}
