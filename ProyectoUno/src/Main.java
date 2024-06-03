
public class Main {
    public static void turno(Jugadores jugadores,Mazo mazo, Mesa mazoMesa){
        Baraja baraja;
        baraja=jugadores.getJugadores(0).cartasDisponibles;
        Jugador jugadorJugando;
        jugadorJugando=jugadores.getJugadores(0);
        int i=-111;
        while(i!=0){
            mazoMesa.mostrarPrimera();
            if(!(jugadorJugando.nombre.equals("Joselito bot"))) {
                baraja.jugadaJugador(mazoMesa, mazo);
                if (baraja.barajaVacia()){
                    i=0;
                }
                if (mazoMesa.evaluarMesa() == 1) {
                    Comodin comodin;
                    comodin = mazoMesa.getComodin();
                    comodin.cambiaColor(mazoMesa);
                }
                jugadorJugando=jugadores.getJugadores(1);
                baraja=jugadorJugando.getCartasDisponibles();
            }
            else {
                baraja.jugadaBot(mazoMesa, mazo);
                if (baraja.barajaVacia()) {
                    i = 0;
                }
                if (mazoMesa.evaluarMesa() == 1) {
                    mazoMesa.setColorMesa(baraja.elegirColor());
                }
                jugadorJugando=jugadores.getJugadores(0);
                baraja=jugadorJugando.getCartasDisponibles();
            }
        }
    }
        public static void main(String[] args) {
            Mazo mazo = new Mazo();
            mazo.crearCartas();
            mazo.barajar();
            Jugadores jugadores = new Jugadores();
            jugadores.crearJugador();
            mazo.repartirCartas(jugadores);
            Mesa mesa = new Mesa();
            mesa.iniciarMesa(mazo);
            turno(jugadores,mazo,mesa);
        }
        }
    }