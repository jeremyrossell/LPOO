import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Transporte> transportes = new ArrayList<>();

        // objetos con distintas capacidades
        Transporte mar = new TransporteMaritimo("BAR-01", 100);
        Transporte tierra = new TransporteTerrestre("BUS-22", 50);
        Transporte aire = new TransporteAereo("AV-777", 120);
        Transporte tren = new TransporteFerroviario("TRN-05", 200); // nuevo transporte

        // polimorfismo
        transportes.add(mar);
        transportes.add(tierra);
        transportes.add(aire);
        transportes.add(tren);

        int pasajeros = 60;

        for (Transporte t : transportes) {
            t.mover();
            try {
                t.transportar(pasajeros);
            } catch (CapacidadExcedidaException e) {
                System.out.println("[!] ERROR: " + e.getMessage());
            } finally {
                if (t instanceof Operable op) {
                    op.realizarMantenimiento();
                }
                System.out.println("--");
            }
        }
    }
}
