import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
        LinkedList<Carta> barajaJugador;
        barajaJugador=jugadores.getJugadores(0).getCartasDisponibles().getBaraja();
        LinkedList<Carta> barajaBot;
        barajaBot=jugadores.getJugadores(1).getCartasDisponibles().getBaraja();
        String nombreJugador;
        nombreJugador= jugadorJugando.getNombre();
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
            guardarPartida(barajaJugador,barajaBot,mazoMesa.getMazoMesa(),mazo.getMazo(),nombreJugador);
        }
        if (!jugadorJugando.nombre.equals("Joselito bot")){
            System.out.println("\033[33m"+"Joselito bot HA SIDO EL GANADOR"+"\033[00m");
        }
        else{
            System.out.println("\033[33m"+jugadores.getJugadores(0).nombre+"  HAS GANADOOOOOOOO!"+"\033[00m");
        }
    }

    public static void guardarPartida(LinkedList<Carta> barajaJugador,LinkedList<Carta> barajaBot, LinkedList<Carta> mazoMesa, LinkedList<Carta> mazo, String nombreJugador){
        GuardarDatos guardarDatos= new GuardarDatos();
        guardarDatos.setBarajaJugador(barajaJugador);
        guardarDatos.setBarajaBot(barajaBot);
        guardarDatos.setMazoMesa(mazoMesa);
        guardarDatos.setMazo(mazo);
        guardarDatos.setNombreJugador(nombreJugador);
        escribirJson(guardarDatos,"guardarPartida.json"); // Se guardará de una vez en la carpeta donde está el programa
    }

    public static void escribirJson(GuardarDatos datos, String rutaArchivo) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(datos, writer);
            System.out.println("Archivo JSON actualizado: " + rutaArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leerJsonYActualizar(String rutaArchivo, LinkedList<Carta> barajaJugador, LinkedList<Carta> barajaBot, LinkedList<Carta> mazoMesa, LinkedList<Carta> mazo, String nombreJugador) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(rutaArchivo)) {
            GuardarDatos datos = gson.fromJson(reader, GuardarDatos.class);

            barajaJugador.clear();
            barajaJugador.addAll(datos.getBarajaJugador());

            barajaBot.clear();
            barajaBot.addAll(datos.getBarajaBot());

            mazoMesa.clear();
            mazoMesa.addAll(datos.getMazoMesa());

            mazo.clear();
            mazo.addAll(datos.getMazo());

            nombreJugador = datos.getNombreJugador();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static LinkedList<Carta> polimorfismo(LinkedList<Carta> baraja){
        Carta carta;
        String numero;
        for(int i=0;i<baraja.size();i++){
            carta=baraja.get(i);
            numero= carta.numeroCarta;
                switch (numero) {
                    case "+2":
                        Carta cartaNueva2 = new Toma2(numero, carta.color);
                        baraja.remove(i);
                        baraja.add(i, cartaNueva2);
                        break;
                    case "+4":
                        Carta cartaNueva4 = new Toma4(numero, carta.color);
                        baraja.remove(i);
                        baraja.add(i, cartaNueva4);
                        break;
                    case "#":
                        Carta cartaNuevaCambiaColor = new Comodin(numero, carta.color);
                        baraja.remove(i);
                        baraja.add(i, cartaNuevaCambiaColor);
                        break;
                    case "<>":
                        Carta cartaNuevaCambiaSentido = new Comodin(numero, carta.color);
                        baraja.remove(i);
                        baraja.add(i, cartaNuevaCambiaSentido);
                        break;
                    case "©":
                        Carta cartaNuevaPasaTurno = new Comodin(numero, carta.color);
                        baraja.remove(i);
                        baraja.add(i, cartaNuevaPasaTurno);
                        break;
                }
        }
        return baraja;
    }

    public static void main(String[] args) {
        int terminar = -111;
        Mazo mazo = new Mazo();
        Jugadores jugadores = new Jugadores();
        Mesa mesa = new Mesa();
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
                    mazo.crearCartas();
                    mazo.barajar();
                    jugadores.crearJugador();
                    mazo.repartirCartas(jugadores);
                    mesa.iniciarMesa(mazo);
                    turno(jugadores,mazo,mesa);
                    break;
                case 2:
                    LinkedList<Carta> barajaJugador=new LinkedList<>();
                    LinkedList<Carta> barajaBot=new LinkedList<>();
                    LinkedList<Carta> mazoMesaLeer=new LinkedList<>();
                    LinkedList<Carta> mazoLeer=new LinkedList<>();
                    String nombreJugador="";
                    leerJsonYActualizar("guardarPartida.json",barajaJugador,barajaBot,mazoMesaLeer,mazoLeer,nombreJugador);
                    jugadores.crearJugadorLeer(nombreJugador);
                    barajaJugador=polimorfismo(barajaJugador);
                    barajaBot=polimorfismo(barajaBot);
                    jugadores.getJugadores(0).getCartasDisponibles().setBaraja(barajaJugador);
                    jugadores.getJugadores(1).getCartasDisponibles().setBaraja(barajaBot);
                    mazoLeer=polimorfismo(mazoLeer);
                    mazoMesaLeer=polimorfismo(mazoMesaLeer);
                    mesa.setMazoMesa(mazoMesaLeer);
                    mazo.setMazo(mazoLeer);
                    turno(jugadores,mazo,mesa);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }
    }


}