import tipoDeMotor.ICombustion;
import tipoDeMotor.IElectrico;
import transporte.Vehiculo;

public class AutoHibrido extends Vehiculo implements IElectrico, ICombustion {

    public AutoHibrido(String marca, String modelo, double velocidad) {
        super(marca, modelo, velocidad);
    }

    @Override
    public void cargar(double KWh) {
        System.out.println("Cargando vehículo modo eléctrico...");
        System.out.println("Batería: " + KWh);
    }

    @Override
    public void cargarGas(double litrosGas) {
        System.out.println("Cargando vehículo modo gasolina...");
        System.out.println("Gas: " + litrosGas);
    }

    @Override
    public String tipo() {
        return "Auto Híbrido";
    }
}
