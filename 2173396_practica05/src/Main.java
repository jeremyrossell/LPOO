import animales.*;

public class Main {
    public static void main(String[] args) {
        Delfin d = new Delfin("Bananita Dolfinita");
        System.out.println(d.respirar());
        d.despertar();
        d.hacerSonido();
        d.comer();
        d.nadar();

        Aguila a = new Aguila("El Eaglo Bombeloro");
        System.out.println(a.respirar());
        a.despertar();
        a.hacerSonido();
        a.comer();
        a.volar();

        Leopardo l = new Leopardo("Leoparducci Grapefruitucci");
        System.out.println(l.respirar());
        l.despertar();
        l.hacerSonido();
        l.comer();
        l.correr();
    }
}
