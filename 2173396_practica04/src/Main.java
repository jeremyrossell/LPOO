// extend es para heredar clase
import animales.*;

public class Main {
    public static void main(String[] args) {
        Animal a = new Animal("Pikachu");
        Gato g = new Gato("NyanCat");
        Pajaro p = new Pajaro("Krakatua");

        System.out.println("-- -- -- -- --");
        System.out.println("[Fusufumdex]: " + a.mostrarNombre());
        System.out.println("[Sonido]: PIIKAAAAA-CHUUUUUUUUUU");
        a.hacerSonido();
        System.out.println("[Alimentación]: Basada en carne");
        System.out.println(a.comer());
        System.out.println("-- -- -- -- --\n");

        System.out.println("-- -- -- -- --");
        System.out.println("[Fusufumdex]: " +  g.mostrarNombre());
        System.out.println("[Sonido]: NYAM NYAM NYARANYAMNYAM NYARARARANYANYA");
        a.hacerSonido();
        System.out.println("[Alimentación]: Basada en carne");
        System.out.println(g.comer());
        System.out.println("-- -- -- -- --\n");

        System.out.println("-- -- -- -- --");
        System.out.println("[Fusufumdex]: " + p.mostrarNombre());
        System.out.println("[Sonido]: KIKIRIKIIIIIII");
        a.hacerSonido();
        System.out.println("[Alimentación]: Basada en semillas ");
        System.out.println(p.comer());
        System.out.println("-- -- -- -- --\n");
    }
}
