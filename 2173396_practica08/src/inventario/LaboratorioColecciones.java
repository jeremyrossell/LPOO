package inventario;

import java.util.*;

public class LaboratorioColecciones {
    public static void main(String[] args) {

        // A. ArrayList
        System.out.println("== ArrayList: Exhibición ==");

        ArrayList<Producto> listaExhibicion = new ArrayList<>();
        listaExhibicion.add(new Producto(1, "Teclado", "Perifericos"));
        listaExhibicion.add(new Producto(2, "Mouse", "Perifericos"));
        listaExhibicion.add(new Producto(3, "Monitor", "Pantallas"));
        listaExhibicion.add(new Producto(4, "Cable HDMI", "Oferta"));

        for (Producto p : listaExhibicion) {
            System.out.println(p);
        }

        // B. LinkedList
        System.out.println("\n== LinkedList: Reabastecer ==");

        LinkedList<Producto> colaReabastecer = new LinkedList<>();
        colaReabastecer.addFirst(new Producto(6, "Webcam", "Perifericos"));
        colaReabastecer.addLast(new Producto(5, "Laptop", "Computo"));

        for (Producto p : colaReabastecer) {
            System.out.println(p);
        }

        // C. HashSet
        System.out.println("\n== HashSet: Categorías únicas ==");

        HashSet<String> categorias = new HashSet<>();
        for (Producto p : listaExhibicion) {
            categorias.add(p.getCategoria());
        }
        for (Producto p : colaReabastecer) {
            categorias.add(p.getCategoria());
        }

        System.out.println(categorias);  // El orden puede variar

        // D. HashMap
        System.out.println("\n== HashMap: Consulta por id ==");

        HashMap<Integer, Producto> mapaPorId = new HashMap<>();

        // insertar todos los productos (de ambas listas)
        for (Producto p : listaExhibicion) {
            mapaPorId.put(p.getId(), p);
        }
        for (Producto p : colaReabastecer) {
            mapaPorId.put(p.getId(), p);
        }

        // consulta individual
        int buscarId = 3;
        System.out.println("id=" + buscarId + " -> " + mapaPorId.get(buscarId));

        // recorrido completo del mapa
        System.out.println("\nRecorriendo HashMap (entrySet):");
        for (Map.Entry<Integer, Producto> entry : mapaPorId.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // E. Iterator
        System.out.println("\n== Iterator: eliminar categoría 'Oferta' en listaExhibicion ==");

        Iterator<Producto> iter = listaExhibicion.iterator();
        while (iter.hasNext()) {
            Producto p = iter.next();
            if (p.getCategoria().equals("Oferta")) {
                iter.remove(); // eliminación segura
            }
        }

        System.out.println("Después de eliminar:");
        for (Producto p : listaExhibicion) {
            System.out.println(p);
        }
    }
}
