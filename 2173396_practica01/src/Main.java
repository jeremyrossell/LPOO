import com.ejemplo.operaciones.Calculadora;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("[!] Ingresa el primer número:");
        int num1 = scanner.nextInt();
        System.out.println("[!] Ingresa el segundo número:");
        int num2 = scanner.nextInt();

        Calculadora objCalculadora = new Calculadora();

        int suma = objCalculadora.sumar(num1, num2);
        int producto = objCalculadora.multiplicar(num1, num2);

        System.out.println("Suma: " + suma);
        System.out.println("Mutiplicación: " + producto);
    }
}