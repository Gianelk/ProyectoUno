public class Jugador {
    String nombre;
    Mazo cartasDisponlibles;

    public Jugador(String nombre, Mazo cartasDisponlibles) {
        this.nombre = nombre;
        this.cartasDisponlibles = cartasDisponlibles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Mazo getCartasDisponlibles() {
        return cartasDisponlibles;
    }

    public void setCartasDisponlibles(Mazo cartasDisponlibles) {
        this.cartasDisponlibles = cartasDisponlibles;
    }
}
