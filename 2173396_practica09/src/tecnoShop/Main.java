package tecnoShop;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        GestorArchivos.crearCarpetaDatos();
        Scanner sc = new Scanner(System.in);
        List<Producto> productos = new ArrayList<>();

        System.out.println("\n=== Registro de productos ===");
        System.out.print("[o] ¿Cuántos productos quieres agregar?: ");
        int cantidad = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= cantidad; i++) {
            System.out.println("\nProducto #" + i);
            System.out.print("[o] ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            String nombre;
            do {
                System.out.print("[o] Nombre: ");
                nombre = sc.nextLine().trim();
                if (nombre.isEmpty()) {
                    System.out.println("[⚠️] El nombre no puede estar vacío. Intenta nuevamente.");
                }
            } while (nombre.isEmpty());

            System.out.print("[o] Categoría: ");
            String categoria = sc.nextLine();

            productos.add(new Producto(id, nombre, categoria));
        }

        GestorArchivos.guardarProductos(productos);
        GestorArchivos.leerProductos();
        GestorArchivos.listarArchivos();
        GestorArchivos.guardarCategoriasUnicas();
        GestorArchivos.buscarProductoPorNombre("Laptop");
        System.out.println("\nTotal de productos registrados: " + GestorArchivos.contarProductos());
        GestorArchivos.crearRespaldo();
        GestorArchivos.borrarArchivo();
    }
}
