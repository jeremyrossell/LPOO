public abstract class Transporte {
    private String id;
    private int capacidad;

    public Transporte(String id, int capacidad) {
        setId(id);
        setCapacidad(capacidad);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("[!] El ID no puede estar vacío");
        }
        this.id = id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("[!] La capacidad debe ser mayor que 0");
        }
        if (capacidad > 500) {
            // para evitar valores ilógicos o irreales
            throw new IllegalArgumentException("[!!] Capacidad no válida (>500). Revisa el modelo de transporte.");
        }
        this.capacidad = capacidad;
    }

    public abstract String tipo();
    public abstract void mover();

    public void transportar(int pasajeros) throws CapacidadExcedidaException {
        if (pasajeros > capacidad) {
            throw new CapacidadExcedidaException(
                    "[!] Pasajeros (" + pasajeros + ") exceden capacidad (" + capacidad + ") en " + tipo()
            );
        } else {
            System.out.println("[!] Transportando " + pasajeros + " pasajeros en " + tipo() + " [" + id + "]");
        }
    }
}
