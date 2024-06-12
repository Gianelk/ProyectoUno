public class Toma5 extends Comodin{
    public Toma5(String numeroCarta, String color) {
        super(numeroCarta, color);
    }

    public void tomar5Cartas(Jugador jugador, Mazo mazo){
        Carta carta;
        Baraja baraja;
        baraja=jugador.cartasDisponibles;
        int i=0;
        for (i=0; i<5; i++){
            carta=mazo.getPrimeraMazo(0);
            baraja.agregarCarta(carta);
            mazo.eliminarPrimeraCarta();
        }
    }

}