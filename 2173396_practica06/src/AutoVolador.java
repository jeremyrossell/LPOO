import tipoDeMotor.IVolador;
import transporte.Vehiculo;

public class AutoVolador extends Vehiculo implements IVolador {

    public AutoVolador(String marca, String modelo, double velocidad) {
        super(marca, modelo, velocidad);
    }

    @Override
    public void cargarDiesel(double litrosDiesel) {
        System.out.println("Cargando vehículo volador con diesel...");
        System.out.println("Tanque: " + litrosDiesel);
    }

    @Override
    public String tipo() {
        return "Auto Volador";
    }
}
