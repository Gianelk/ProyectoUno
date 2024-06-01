import java.util.LinkedList;
import java.util.Random;

public class Mazo extends LinkedList<Carta>{
    LinkedList<Carta> mazo;

    public Mazo(LinkedList<Carta> mazo) {
        this.mazo = mazo;
    }

    public LinkedList<Carta> getMazo() {
        return mazo;
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
}
