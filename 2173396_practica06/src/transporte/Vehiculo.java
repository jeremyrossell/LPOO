package transporte;

public abstract class Vehiculo {
    private double velocidad;
    protected String marca;
    protected String modelo;

    public Vehiculo() {

    }

    public Vehiculo(String marca, String modelo) {
        this(marca, modelo, 0.0);
    }

    public Vehiculo(String marca, String modelo, double velocidad) {
        this.marca = marca;
        this.modelo = modelo;
        setVelocidad(velocidad);
    }

    public double getVelocidad() {
        return this.velocidad;
    }

    public final double setVelocidad(double v) {
        if (v >= 0) {
            this.velocidad = v;
        }
        return v;
    }

    public void acelerar() {
        setVelocidad(getVelocidad() + 10);
    }

    public void acelerar(double incremento) {
        setVelocidad(getVelocidad() + Math.max(0, velocidad));
    }

    public abstract String tipo();
}
