import java.util.LinkedList;

public class Jugador {
    String nombre;
    Baraja cartasDisponibles;

    public Jugador(String nombre, Baraja cartasDisponlibles) {
        this.nombre = nombre;
        this.cartasDisponibles = cartasDisponlibles;
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

    public int cartasJugables(Carta cartaEnJuego){
        Baraja baraja =getCartasDisponibles();
        int cartasJugables=0;
        for (int i=0;i<baraja.size();i++){
        }
        return cartasJugables;
    }

}

