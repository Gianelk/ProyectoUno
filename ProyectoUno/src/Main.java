import java.util.Scanner;
public class Main {
    public static void turno(Jugadores jugadores,Mazo mazo, Mesa mazoMesa){
        Baraja baraja;
        baraja=jugadores.getJugadores(0).cartasDisponibles;
        Jugador jugadorJugando;
        String pasaTurno = Character.toString((char) 169);
        String numero;
        String uno;
        jugadorJugando=jugadores.getJugadores(0);
        mazoMesa.setColorMesa(mazoMesa.getPrimera().color);
        Scanner leer = new Scanner(System.in);
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
                if (baraja.tamanobaraja()==1){
                    System.out.println("Te queda una carta, di 'uno' para poder ganar");
                    uno = leer.next();
                    if(uno.equals("uno")){
                        System.out.println("UNOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO!");
                    }else {
                        System.out.println("No djiste uno :'c , dijiste" + uno);
                        baraja.agregarCarta(mazo.getPrimeraMazo(0));
                        mazo.eliminarPrimeraCarta();
                    }
                }
                if(mazoMesa.getPrimera().numeroCarta.equals("+2")||mazoMesa.getPrimera().numeroCarta.equals("+4")||mazoMesa.getPrimera().numeroCarta.equals("<>")||mazoMesa.getPrimera().numeroCarta.equals(pasaTurno)){
                    numero = mazoMesa.getPrimera().numeroCarta;
                    switch (numero) {
                        case "+2":
                            Toma2 toma2;
                            toma2 = mazoMesa.getToma2();
                            toma2.tomar2Cartas( jugadores.getJugadores(1),mazo);
                            break;
                        case "+4":
                            Toma4 toma4;
                            toma4 = mazoMesa.getToma4();
                            toma4.tomar4Cartas(jugadores.getJugadores(1),mazo);
                            break;
                    }
                    System.out.println("El bot pierde el turno");
                }
                else {
                    jugadorJugando = jugadores.getJugadores(1);
                    baraja = jugadorJugando.getCartasDisponibles();
                }
            }
            else {
                baraja.jugadaBot(mazoMesa, mazo);
                if (baraja.barajaVacia()) {
                    i = 0;
                }
                if (mazoMesa.evaluarMesa() == 1) {
                    mazoMesa.setColorMesa(baraja.elegirColor());
                }
                if (baraja.tamanobaraja()==1){
                    System.out.println("UNOOOO!");
                    System.out.println("A "+jugadorJugando.nombre+" le queda una carta");

                }
                if(mazoMesa.getPrimera().numeroCarta.equals("+2")||mazoMesa.getPrimera().numeroCarta.equals("+4")||mazoMesa.getPrimera().numeroCarta.equals("<>")||mazoMesa.getPrimera().numeroCarta.equals(pasaTurno)){
                    numero = mazoMesa.getPrimera().numeroCarta;
                    switch (numero) {
                        case "+2":
                            Toma2 toma2;
                            toma2 = mazoMesa.getToma2();
                            toma2.tomar2Cartas( jugadores.getJugadores(0),mazo);
                            break;
                        case "+4":
                            Toma4 toma4;
                            toma4 = mazoMesa.getToma4();
                            toma4.tomar4Cartas(jugadores.getJugadores(0),mazo);
                            break;

                    }
                    System.out.println("Usted pierde el turno");
                }
                else {
                    jugadorJugando = jugadores.getJugadores(0);
                    baraja = jugadorJugando.getCartasDisponibles();
                }
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