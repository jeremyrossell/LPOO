package tecnoShop;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class GestorArchivos {

    private static final String CARPETA_DATOS = "datos";
    private static final String ARCHIVO_PRODUCTOS = CARPETA_DATOS + File.separator + "productos.txt";
    private static final String ARCHIVO_CATEGORIAS = CARPETA_DATOS + File.separator + "categorias.txt";

    // crea la carpeta si no existe
    public static void crearCarpetaDatos() {
        File carpeta = new File(CARPETA_DATOS);
        if (carpeta.exists()) {
            System.out.println("[📁] Carpeta 'datos' ya existe.");
        } else {
            if (carpeta.mkdir()) {
                System.out.println("[📁] Carpeta 'datos' creada correctamente.");
            } else {
                System.out.println("[⚠️] No se pudo crear la carpeta 'datos'.");
            }
        }
    }

    // guarda los productos en productos.txt
    public static void guardarProductos(List<Producto> productos) {
        File archivo = new File(ARCHIVO_PRODUCTOS);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) { // "true" para agregar
            for (Producto p : productos) {
                bw.write(p.toString());
                bw.newLine();
            }
            System.out.println("[✅] Productos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("[❌] Error al guardar productos: " + e.getMessage());
        }
    }

    // lee e imprime todo el contenido del archivo
    public static void leerProductos() {
        System.out.println("=== Lectura del archivo ===");
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_PRODUCTOS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("[❌] Error al leer archivo: " + e.getMessage());
        }
    }

    // muestra todos los archivos dentro de la carpeta datos
    public static void listarArchivos() {
        System.out.println("\n=== Archivos en la carpeta 'datos' ===");
        File carpeta = new File(CARPETA_DATOS);
        File[] archivos = carpeta.listFiles();
        if (archivos != null) {
            for (File f : archivos) {
                System.out.println("📃 " + f.getName());
            }
        } else {
            System.out.println("[!] No hay archivos en la carpeta.");
        }
    }

    // busca productos por nombre dentro del archivo
    public static void buscarProductoPorNombre(String nombre) {
        System.out.println("\n[🔎] Buscando productos con nombre que contiene '" + nombre + "':");
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_PRODUCTOS))) {
            String linea;
            boolean encontrado = false;
            while ((linea = br.readLine()) != null) {
                if (linea.toLowerCase().contains(nombre.toLowerCase())) {
                    System.out.println(linea);
                    encontrado = true;
                }
            }
            if (!encontrado) System.out.println("[!] No se encontró ningún producto con ese nombre.");
        } catch (IOException e) {
            System.out.println("[❌] Error al buscar producto: " + e.getMessage());
        }
    }

    // crea un archivo categorias.txt con categorías únicas
    public static void guardarCategoriasUnicas() {
        HashSet<String> categorias = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_PRODUCTOS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    categorias.add(partes[2].trim());
                }
            }
        } catch (IOException e) {
            System.out.println("[❌] Error al leer productos para categorías: " + e.getMessage());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_CATEGORIAS))) {
            for (String cat : categorias) {
                bw.write(cat);
                bw.newLine();
            }
            System.out.println("[✅] Archivo categorias.txt generado correctamente.");
        } catch (IOException e) {
            System.out.println("[❌] Error al escribir categorías: " + e.getMessage());
        }
    }

    // borra el archivo productos.txt tras confirmación
    public static void borrarArchivo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n[o] ¿Seguro que deseas eliminar 'productos.txt'? (s/n): ");
        String respuesta = sc.nextLine().trim().toLowerCase();
        if (respuesta.equals("s")) {
            File archivo = new File(ARCHIVO_PRODUCTOS);
            if (archivo.exists() && archivo.delete()) {
                System.out.println("[🗑️] Archivo productos.txt eliminado correctamente.");
            } else {
                System.out.println("[⚠️] No se pudo eliminar el archivo o no existe.");
            }
        } else {
            System.out.println("[❎] Operación cancelada.");
        }
    }

    // cuenta cuántas líneas tiene productos.txt
    public static int contarProductos() {
        int contador = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_PRODUCTOS))) {
            while (br.readLine() != null) contador++;
        } catch (IOException e) {
            System.out.println("[❌] Error al contar productos: " + e.getMessage());
        }
        return contador;
    }

    // realiza una copia de respaldo del archivo productos.txt
    public static void crearRespaldo() {
        try {
            Path origen = Paths.get(ARCHIVO_PRODUCTOS);
            Path destino = Paths.get(CARPETA_DATOS + File.separator + "productos_backup.txt");
            Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("[✅] Respaldo creado: productos_backup.txt");
        } catch (IOException e) {
            System.out.println("[❌] Error al crear respaldo: " + e.getMessage());
        }
    }
}
