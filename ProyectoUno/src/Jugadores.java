import java.util.LinkedList;
import java.util.Scanner;

public class Jugadores extends LinkedList<Jugador>{

    LinkedList<Jugador> jugadores;

    public LinkedList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(LinkedList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Jugadores() {
    }
    public Jugadores(LinkedList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    public void crearJugador(){
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el nombre del jugador");
        String nombreJugador = leer.toString();
        Jugador jugador = new Jugador(nombreJugador);
        jugadores.add(jugador);
        jugador = new Jugador("Joselito bot");
    }
}
