import java.util.LinkedList;
import java.util.Random;

public class Mazo extends LinkedList<Carta>{
    LinkedList<Carta> mazo;

    public Mazo(LinkedList<Carta> mazo) {
        this.mazo = mazo;
    }

    public Mazo() {
        this.mazo = new LinkedList<Carta>();
    }

    public void setMazo(LinkedList<Carta> mazo) {
        this.mazo = mazo;
    }
    public void barajar(){
        Random random = new Random();
        Carta cartaAuxiliar=new Carta();
        for(int  i= 0;i<mazo.size(); i++) {
            int numero = random.nextInt(mazo.size());
            if (i != numero) {
                cartaAuxiliar=mazo.get(i);
                mazo.remove(i);
                mazo.add(numero, cartaAuxiliar);
            }
        }
    }
    public  void mostrarMiLista() {
        System.out.println("Los Elementos de la lista son: ");
        System.out.println();
        for(int  i= 0;i<mazo.size(); i++) {
            System.out.println(mazo.get(i).numeroCarta);
            System.out.println(mazo.get(i).color);
        }

    }
    public  void crearCartas() {
        String numeroCarta;
        String color;
        for (int j=0; j<4;j++) {
            switch (j) {
                case 0:
                    color = "azul";
                    break;
                case 1:
                    color ="amarillo";
                    break;
                case 2:
                    color ="rojo";
                    break;
                case 3:
                    color ="verde";
                    break;
                default:
                    throw new IllegalStateException("LOL: " + j);
            }
            for (int i = 0; i < 10; i++) {
                String pasaTurno = Character.toString((char) 169);
                numeroCarta = String.valueOf(i);
                Carta carta = new Carta(numeroCarta, color);
                if (i == 0) {
                    mazo.add(carta);
                    carta = new Carta("+2", color);
                    mazo.add(carta);
                    mazo.add(carta);
                    carta = new Carta("<>", color);
                    mazo.add(carta);
                    mazo.add(carta);
                    carta = new Carta(pasaTurno, color);
                    mazo.add(carta);
                    mazo.add(carta);
                } else {
                    mazo.add(carta);
                    mazo.add(carta);
                }
            }
        }
        this.crearCartasComodin();
    }
    public void crearCartasComodin() {
        Carta carta =new Carta("+4","negro");
        mazo.add(carta);
        mazo.add(carta);
        mazo.add(carta);
        mazo.add(carta);
        carta=new Carta("#","negro");
        mazo.add(carta);
        mazo.add(carta);
        mazo.add(carta);
        mazo.add(carta);
    }
    public void agregarCarta(Carta carta){
        mazo.add(carta);
    }
    public void eliminarUltimaCarta(){
        mazo.remove();
    }
    public void repartirCartas(Jugadores jugadores){
        Jugador jugador;
        Baraja baraja;
        Carta carta;
        for (int j=0;j<7;j++) {
            for (int i = 0; i < 2; i++) {
                jugador = jugadores.getJugadores(i);
                baraja = jugador.getCartasDisponibles();
                carta=mazo.getFirst();
                baraja.agregarCarta(carta);
                jugador.setCartasDisponibles(baraja);
                mazo.remove();
            }
        }
    }
}
