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
    public  void mostrarMiBaraja(LinkedList<Integer> posibilidades) {
        System.out.println("Tus cartas son: ");
        System.out.println();
        for(int  i= 0;i<baraja.size(); i++) {
            if (posibilidades.contains(i)){
                System.out.println("\033[36m"+""+i);
                System.out.println(baraja.get(i).numeroCarta);
                System.out.println(baraja.get(i).color);
            }
            else{
                System.out.println("\033[37m"+""+i);
                System.out.println(baraja.get(i).numeroCarta);
                System.out.println(baraja.get(i).color);
            }
        }
    }

    public void evaluarCarta(Mesa mazoMesa){
        LinkedList<Integer> posibilidades = new LinkedList<Integer>();
        String color;
        String numero;
        String colorMesa=mazoMesa.getPrimera().color;;
        String numeroMesa=mazoMesa.getPrimera().numeroCarta;
        for (int i=0;i<baraja.size();i++){
            numero = baraja.get(i).numeroCarta;
            color = baraja.get(i).color;
            if(color.equals(colorMesa)){
                posibilidades.add(i);
            }
            else
            {
                if(numeroMesa.equals(numero)){
                    posibilidades.add(i);}
                else{
                    if(color.equals("negro")){
                        posibilidades.add(i);}
                }
            }
        }
        mostrarMiBaraja(posibilidades);
    }

}