package animales;

public interface IVolador {
    void volar();
    default int alturaMaxima() {return 200;}
}