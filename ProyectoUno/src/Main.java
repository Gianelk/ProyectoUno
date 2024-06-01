
public class Main {
    public static void crearCartas(String color,LinkedList<Carta> cartas) {
    String numeroCarta;
    for (int i = 0; i < 10; i++) {
        String pasaTurno = Character.toString((char) 169);
        numeroCarta = String.valueOf(i);
        Carta carta = new Carta(numeroCarta, color);
        if (i == 0) {
            cartas.add(carta);
            carta = new Carta("+2", color);
            cartas.add(carta);
            cartas.add(carta);
            carta = new Carta("<>", color);
            cartas.add(carta);
            cartas.add(carta);
            carta = new Carta(pasaTurno, color);
            cartas.add(carta);
            cartas.add(carta);
        } else {
            cartas.add(carta);
            cartas.add(carta);
        }
    }

        public static void crearCartasComodin(LinkedList<Carta> cartas) {
            Carta carta =new Carta("+4","negro");
            cartas.add(carta);
            cartas.add(carta);
            cartas.add(carta);
            cartas.add(carta);
            carta=new Carta("#","negro");
            cartas.add(carta);
            cartas.add(carta);
            cartas.add(carta);
            cartas.add(carta);
        }
        public static void main(String[] args) {
            LinkedList<Carta> cartas = new LinkedList<Carta>();
            crearCartas("azul",cartas);
            crearCartas("verde",cartas);
            crearCartas("rojo",cartas);
            crearCartas("amarillo",cartas);
            crearCartasComodin(cartas);
            Mazo mazo = new Mazo(cartas);
            mazo.mostrarMiLista();
            mazo.barajar();
            mazo.mostrarMiLista();
        }
    }
}