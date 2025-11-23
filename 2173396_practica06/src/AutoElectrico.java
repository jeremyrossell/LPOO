import tipoDeMotor.IElectrico;
import transporte.Vehiculo;

public class AutoElectrico extends Vehiculo implements IElectrico {

    public AutoElectrico(String marca, String modelo, double velocidad) {
        super(marca, modelo, velocidad);
    }

    @Override
    public void cargar(double KWh) {
        System.out.println("Cargando vehículo modo eléctrico...");
        System.out.println("Batería: " + KWh);
    }

    @Override
    public String tipo() {
        return "Auto Eléctrico";
    }
}
