package animales;

public interface IAcuatico {
    void nadar();
    default int profundidadMaxima() {return 200;}

}
