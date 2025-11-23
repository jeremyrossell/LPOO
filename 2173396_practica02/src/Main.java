import Transportes.Automovil;
import Transportes.Carro;

public class Main {
    public static void main(String[] args) {

        System.out.println("----------Carro Nissan-----------");
        Automovil automovil = new Automovil();
        automovil.setMarca("Nissan");
        System.out.println("El automovil marca: " + automovil.getMarca());
        automovil.encenderMotor();
        System.out.println(automovil.avanzar());
        automovil.setKilometraje("40000");
        System.out.println("El automovil inició su trayecto con un kilometraje de: " + automovil.getKilometraje());
        automovil.setMatricula("QSF-666-A");
        System.out.println("Automovil con matrícula vigente: " + automovil.getMatricula());

        System.out.println("----------Carro taurus-----------");
        Carro taurus = new Carro();
        taurus.encenderMotor();
        taurus.displayInfo();
        taurus.chocarCarroParaSacarleDineroAlSeguro();

        System.out.println("----------Carro topaz-----------");
        Carro topaz = new Carro("Ford", "2025", "KRG-873-A", "40000");
        topaz.displayInfo();
        topaz.encenderMotor();
    }
}
