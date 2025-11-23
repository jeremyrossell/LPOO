import tipoDeMotor.ICombustion;
import transporte.Vehiculo;

public class AutoCombustion extends Vehiculo implements ICombustion {

    public AutoCombustion(String marca, String modelo, double velocidad) {
        super(marca, modelo, velocidad);
    }

    @Override
    public void cargarGas(double litrosGas) {
        System.out.println("Cargando vehículo con gasolina...");
        System.out.println("Combustible: " + litrosGas);
    }

    @Override
    public String tipo() {
        return "Auto Combustion";
    }
}
