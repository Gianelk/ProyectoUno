import java.util.Collection;
import java.util.LinkedList;

public class Baraja extends LinkedList<Carta>{
    LinkedList<Carta> baraja;

    public Baraja(LinkedList<Carta> baraja) {

        this.baraja = baraja;
    }
    public Baraja() {

        this.baraja = new LinkedList<Carta>();
    }

    public LinkedList<Carta> getBaraja() {

        return baraja;
    }

    public void setBaraja(LinkedList<Carta> baraja) {

        this.baraja = baraja;
    }
    public void agregarCarta(Carta carta){
        baraja.add(carta);
    }
    public void eliminarUltimaCarta(){
        baraja.remove();
    }

    public  void mostrarMiBaraja() {
        System.out.println("Los Elementos de la lista son: ");
        System.out.println();
        for(int  i= 0;i<baraja.size(); i++) {
            System.out.println(baraja.get(i).numeroCarta);
            System.out.println(baraja.get(i).color);
        }

    }

}