package Banco;

public class CuentaBancaria {
    private String numeroCuenta;
    private String titularCuenta;
    private double saldo;

    public CuentaBancaria() {

    }

    //
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    //
    public String getTitularCuenta() {
        return titularCuenta;
    }
    public void setTitularCuenta(String titularCuenta) {
        this.titularCuenta = titularCuenta;
    }
    //
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            System.out.println("Saldo insuficiente");
        }
    }
    //
    public void depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
        } else {
            System.out.println("Monto inválido");
        }
    }
    public void retirar(double monto) {
        if (monto > 0 && monto <= this.saldo) {
            this.saldo += monto;
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

}