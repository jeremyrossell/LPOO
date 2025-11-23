package animales;

public class Delfin extends Animal implements IAcuatico {
    public Delfin(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println(obtenerNombre() + " hace sonido");
    }

    @Override
    public void nadar() {
        System.out.println(obtenerNombre() + " nada");
    }

    @Override
    public int profundidadMaxima() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String respirar() {
        return obtenerNombre() + " respira";
    }
}
