public class Toma4 extends Comodin{
    public Toma4(String numeroCarta, String color) {
        super(numeroCarta, color);
    }

    public void tomar4Cartas(Jugador jugador, Mazo mazo){
        Carta carta;
        Baraja baraja;
        baraja=jugador.cartasDisponibles;
        int i=0;
        for (i=0; i<4; i++){
            carta=mazo.getPrimeraMazo(0);
            baraja.agregarCarta(carta);
            mazo.eliminarPrimeraCarta();
        }
    }

}