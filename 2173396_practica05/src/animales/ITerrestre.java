package animales;

public interface ITerrestre {
    void correr();
    default int distanciaMaxima() {return 200;}
}