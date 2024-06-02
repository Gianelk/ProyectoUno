public class Toma2 extends Comodin{
    public Toma2(String numeroCarta, String color) {

        super(numeroCarta, color);
    }

    public void tomar2Cartas(Jugador jugador, Mazo mazo){
        Carta carta;
        Baraja baraja;
        baraja=jugador.cartasDisponibles;
        int i;
        for (i=0; i<2; i++){
            carta = mazo.getPrimeraMazo(0);
            baraja.add(carta);
            mazo.eliminarPrimeraCarta();
        }
    }
}
