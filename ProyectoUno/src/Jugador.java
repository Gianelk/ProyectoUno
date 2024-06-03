public class Jugador {
    String nombre;
    Baraja cartasDisponibles;

    public Jugador(String nombre, Baraja cartasDisponibles) {
        this.nombre = nombre;
        this.cartasDisponibles = cartasDisponibles;
    }

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.cartasDisponibles= new Baraja();
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Baraja getCartasDisponibles() {
        return cartasDisponibles;
    }

    public void setCartasDisponibles(Baraja cartasDisponibles) {
        this.cartasDisponibles = cartasDisponibles;
    }
}
