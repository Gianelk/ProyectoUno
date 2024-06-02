
public class Main {
        public static void main(String[] args) {
            Mazo mazo = new Mazo();
            mazo.crearCartas();
            mazo.barajar();
            Jugadores jugadores = new Jugadores();
            jugadores.crearJugador();
            mazo.repartirCartas(jugadores);
            Mesa mesa = new Mesa();
            mesa.iniciarMesa(mazo);
            mesa.mostrarPrimera();
            Jugador jugador= new Jugador("PEPITO");
            jugador=jugadores.getJugadores(0);
            Baraja baraja=new Baraja();
            baraja=jugador.getCartasDisponibles();
            baraja.jugadaJugador(mesa,mazo);
            mesa.mostrarPrimera();
        }
        }
    }