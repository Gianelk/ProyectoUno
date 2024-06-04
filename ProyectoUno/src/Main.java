import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void imprimir(Jugadores jugadores, Mazo mazo, Mesa mazoMesa){
        Baraja barajaBot;
        Baraja barajaJugador;
        LinkedList<Integer> posibilidades;
        barajaBot=jugadores.getJugadores(1).cartasDisponibles;
        barajaJugador=jugadores.getJugadores(0).getCartasDisponibles();
        posibilidades=barajaJugador.evaluarCarta(mazoMesa);
        barajaBot.imprimirBot();
        mazoMesa.mostrarPrimera();
        barajaJugador.mostrarMiBaraja(posibilidades);
    }
    public static void turno(Jugadores jugadores, Mazo mazo, Mesa mazoMesa) {
        Baraja baraja;
        baraja = jugadores.getJugadores(0).cartasDisponibles;
        Jugador jugadorJugando;
        String pasaTurno = Character.toString((char) 169);
        String numero;
        String uno;
        jugadorJugando = jugadores.getJugadores(0);
        mazoMesa.setColorMesa(mazoMesa.getPrimera().color);
        Scanner leer = new Scanner(System.in);
        int j=1;
        int i = -111;
        int barajaTamano;
        while (i != 0) {
            imprimir(jugadores,mazo,mazoMesa);
            if (!(jugadorJugando.nombre.equals("Joselito bot"))) {
                barajaTamano=baraja.tamanobaraja();
                baraja.jugadaJugador(mazoMesa, mazo,jugadorJugando.nombre);
                if(barajaTamano>baraja.tamanobaraja()){
                    j=1;
                }
                if (baraja.barajaVacia()) {
                    i = 0;
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
                if((mazoMesa.getPrimera().numeroCarta.equals("+2")||mazoMesa.getPrimera().numeroCarta.equals("+4")||mazoMesa.getPrimera().numeroCarta.equals("<>")||mazoMesa.getPrimera().numeroCarta.equals(pasaTurno))&&j!=0){
                    numero = mazoMesa.getPrimera().numeroCarta;
                    j=0;
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
                else{
                    jugadorJugando = jugadores.getJugadores(1);
                    baraja = jugadorJugando.getCartasDisponibles();
                }
            } else {
                barajaTamano=baraja.tamanobaraja();
                baraja.jugadaBot(mazoMesa, mazo);
                if(barajaTamano>baraja.tamanobaraja()){
                    j=1;
                }
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
                if((mazoMesa.getPrimera().numeroCarta.equals("+2")||mazoMesa.getPrimera().numeroCarta.equals("+4")||mazoMesa.getPrimera().numeroCarta.equals("<>")||mazoMesa.getPrimera().numeroCarta.equals(pasaTurno))&&j!=0){
                    numero = mazoMesa.getPrimera().numeroCarta;
                    j=0;
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
        if (!jugadorJugando.nombre.equals("Joselito bot")){
            System.out.println("\033[33m"+"Joselito bot HA SIDO EL GANADOR"+"\033[00m");
        }
        else{
            System.out.println("\033[33m"+jugadores.getJugadores(0).nombre+"  HAS GANADOOOOOOOO!"+"\033[00m");
        }
    }

    public static void main(String[] args) {
        int terminar = -111;
        while(terminar != 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(" _________________________________________________________");
            System.out.println("|                                                         |");
            System.out.println("|                       MENU JUGAR                        |");
            System.out.println("|_________________________________________________________|");
            System.out.println("|                                                         |");
            System.out.println("|                   _________________                     |");
            System.out.println("|                  |                 |                    |");
            System.out.println("|            [1]   |  Nueva Partida  |                    |");
            System.out.println("|                  |_________________|                    |");
            System.out.println("|                                                         |");
            System.out.println("|                   _________________                     |");
            System.out.println("|                  |                 |                    |");
            System.out.println("|            [2]   | Cargar Partida  |                    |");
            System.out.println("|                  |_________________|                    |");
            System.out.println("|                                                         |");
            System.out.println("|                   _________________                     |");
            System.out.println("|                  |                 |                    |");
            System.out.println("|            [3]   |   Informacion   |                    |");
            System.out.println("|                  |_________________|                    |");
            System.out.println("|                                                         |");
            System.out.println("|                   _________________                     |");
            System.out.println("|                  |                 |                    |");
            System.out.println("|            [0]   |      Salir      |                    |");
            System.out.println("|                  |_________________|                    |");
            System.out.println("|                                                         |");
            System.out.println("|                                                         |");
            System.out.println("|_________________________________________________________|");
            System.out.println("|                 |");
            System.out.print("| opcion ---->  ");
            int i = scanner.nextInt();
            switch (i) {
                case 0:
                    terminar = 0;
                    break;
                case 1:
                    Mazo mazo = new Mazo();
                    mazo.crearCartas();
                    mazo.barajar();
                    Jugadores jugadores = new Jugadores();
                    jugadores.crearJugador();
                    mazo.repartirCartas(jugadores);
                    Mesa mesa = new Mesa();
                    mesa.iniciarMesa(mazo);
                    turno(jugadores,mazo,mesa);
                    break;
                case 2:

                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }
    }


}