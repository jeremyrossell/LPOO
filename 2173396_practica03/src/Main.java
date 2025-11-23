import Banco.CuentaBancaria;

public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuentaBBVA = new CuentaBancaria();
        cuentaBBVA .setNumeroCuenta("8734949534358");
        cuentaBBVA .setTitularCuenta("Ramón Valdéz");
        cuentaBBVA.setSaldo(5000000);

        System.out.println("Saldo inicial: " + cuentaBBVA.getSaldo());

        cuentaBBVA.depositar(500);
        System.out.println("Saldo final: " + cuentaBBVA.getSaldo());
        cuentaBBVA.retirar(250);
        System.out.println("Saldo final: " + cuentaBBVA.getSaldo());
    }

}
