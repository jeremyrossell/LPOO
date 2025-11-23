import transporte.Vehiculo;
import java.util.Arrays;
import java.util.List;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {

        // Hibrido
        AutoHibrido BYD = new AutoHibrido("byd", "dolphin", 200.00);
        System.out.println(BYD.tipo());
        BYD.setVelocidad(200.00);
        System.out.println(BYD.getVelocidad());
        BYD.acelerar();
        BYD.cargar(5000);
        BYD.cargarGas(20);
        System.out.println("----------\n");

        // Eléctrico
        AutoElectrico Tesla = new AutoElectrico("tesla", "B3", 400.00);
        System.out.println(Tesla.tipo());
        Tesla.setVelocidad(200.00);
        System.out.println(Tesla.getVelocidad());
        Tesla.acelerar();
        Tesla.cargar(7000);
        System.out.println("----------\n");

        // Combustión
        AutoCombustion Toyota = new AutoCombustion("toyota", "corolla", 120.00);
        System.out.println(Toyota.tipo());
        Toyota.setVelocidad(200.00);
        System.out.println(Toyota.getVelocidad());
        Toyota.acelerar();
        Toyota.cargarGas(45);
        System.out.println("----------\n");

        // Volador
        AutoVolador Boeing = new AutoVolador("boeing", "ct-70", 740.00);
        System.out.println(Boeing.tipo());
        Boeing.setVelocidad(200.00);
        System.out.println(Boeing.getVelocidad());
        Boeing.acelerar();
        Boeing.cargarDiesel(450);
        System.out.println("----------\n");

        List<Vehiculo> flota = Arrays.asList(BYD, Tesla, Toyota, Boeing);
        for(Vehiculo v : flota) {
            Class<?> ClaseVehiculo = v.getClass();
            System.out.println("\n------------------------------------------");
            System.out.println("Tipo de vehiculo: " + ClaseVehiculo.getSimpleName());
            Method[] metodos = ClaseVehiculo.getMethods();
            System.out.println("Metodos disponibles: ");

            for(Method metodo : metodos) {
                if (!metodo.getDeclaringClass().equals(Object.class)) {
                    System.out.println("- " + metodo.toGenericString());
                }
            }
        }

    }
}