import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;

public class Baraja extends LinkedList<Carta>{
    private LinkedList<Carta> baraja;

    public Baraja(LinkedList<Carta> baraja) {

        this.baraja = baraja;
    }
    public Baraja() {

        this.baraja = new LinkedList<Carta>();
    }

    public LinkedList<Carta> getBaraja() {

        return baraja;
    }

    public boolean barajaVacia(){
        if (baraja.isEmpty()){
            return true;
        }
        else{
            return false;
        }
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
        System.out.println("                  Tus cartas son: ");
        System.out.println();
        for(int  i= 0;i<baraja.size(); i++) {
            if (posibilidades.contains(i)){
                if (i==0){
                    System.out.print("\033[00m"+"["+i+"] "+baraja.get(i).numeroCarta);
                    System.out.print(baraja.get(i).color);
                }
                else{
                    System.out.print("  "+"\033[00m"+"["+i+"] "+baraja.get(i).numeroCarta);
                    System.out.print(baraja.get(i).color);
                }
            }
            else{
                if (i==0){
                    System.out.print("\033[37m"+"["+i+"] "+baraja.get(i).numeroCarta);
                    System.out.print(baraja.get(i).color);
                }
                else{
                    System.out.print("  "+"\033[37m"+"["+i+"] "+baraja.get(i).numeroCarta);
                    System.out.print(baraja.get(i).color);
                }
            }
        }
        System.out.println("\033[00m");
    }

    public void jugar(LinkedList<Integer>posibilidades,Mesa mazoMesa){
        Scanner leer=new Scanner(System.in);
        int jugada;
        Carta carta;
        int i=0;
        while(i!= 1) {
            System.out.println(" ");
            System.out.println("Indique el indice de la carta que quiere jugar (Indique [-1] para salir)");
            jugada = leer.nextInt();
            if(jugada==-1){
                break;
            }
            if (posibilidades.contains(jugada)) {
                carta = baraja.get(jugada);
                mazoMesa.agregarPrimero(carta);
                mazoMesa.setColorMesa(carta.color);
                baraja.remove(jugada);
                i = 1;
            } else {
                System.out.println("Esta carta no puede ser jugada");
            }
        }
    }
    public void imprimirBot(){
        String carta=Character.toString((char) 219);
        System.out.println("|----------------------------------------------------|");
        System.out.println("                   Cartas del bot        ");
        System.out.println();
        System.out.print("                ");
        for (int i=0;i<baraja.size();i++) {
            System.out.print(carta+"  ");
        }
        System.out.print("     ["+"\033[33m"+baraja.size()+"\033[00m"+"]");
        System.out.println(" ");
    }

    public LinkedList<Integer> evaluarCarta(Mesa mazoMesa){
        LinkedList<Integer> posibilidades = new LinkedList<Integer>();
        String color;
        String numero;
        Carta carta;
        String numeroMesa=mazoMesa.getPrimera().numeroCarta;
        for (int i=0;i<baraja.size();i++){
            numero = baraja.get(i).numeroCarta;
            color = baraja.get(i).color;
            if(color.equals(mazoMesa.getColorMesa())){
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
        return posibilidades;
    }

    public void jugadaJugador(Mesa mazoMesa,Mazo mazo,String nombreJugador) {
        Carta carta;
        LinkedList<Integer>posibilidades= new LinkedList<Integer>();
        posibilidades=this.evaluarCarta(mazoMesa);
        int tamano=baraja.size();
        if(!posibilidades.isEmpty()){
            System.out.println("\033[00m"+"                   Turno: "+"\033[35m"+nombreJugador+"\033[00m");
            this.jugar(posibilidades,mazoMesa);
        }
        else{
            System.out.println("\033[00m"+"          Turno: "+"\033[31m"+"No tienes cartas para jugar");
            System.out.println("\033[32m"+"              Se te agregara una del mazo"+"\033[00m");
            carta=mazo.getPrimeraMazo(0);
            baraja.add(carta);
            mazo.eliminarPrimeraCarta();
        }
    }

    public void jugadaBot(Mesa mazoMesa,Mazo mazo){
        Carta carta;
        LinkedList<Integer>posibilidades= new LinkedList<Integer>();
        posibilidades=this.evaluarCarta(mazoMesa);
        if(!posibilidades.isEmpty()){
            carta=baraja.get(posibilidades.getFirst());
            mazoMesa.agregarPrimero(carta);
            int auxiliar= posibilidades.getFirst();
            baraja.remove(auxiliar);
            System.out.println("\033[00m"+"                   Turno: "+"\033[35m"+"Joselito bot"+"\033[00m");
            System.out.println();
        }
        else{
            System.out.println("\033[31m"+"        El jugador rival no tiene cartas jugables");
            System.out.println("\033[32m"+"               Se le agregara una del mazo"+"\033[00m");
            carta=mazo.getPrimeraMazo(0);
            baraja.add(carta);
            mazo.eliminarPrimeraCarta();
        }
    }
    public int tamanobaraja(){
        return baraja.size();
    }
    public String elegirColor(){
        int R,B,Y,G;
        R=0;
        B=0;
        G=0;
        Y=0;
        for (int i=0;i< baraja.size();i++){
            if(baraja.getFirst().color.equals("R")){
                R++;
            }
            if(baraja.getFirst().color.equals("Y")){
                Y++;
            }
            if(baraja.getFirst().color.equals("G")){
                G++;
            }
            if(baraja.getFirst().color.equals("B")){
                B++;
            }
        }
        if(R>B && R>Y && R>G){
            return "R";
        }
        else{
            if (B>Y&&B>G){
                return "B";
            }else {
                if(Y>G){
                    return "Y";
                }
                else{
                    return "G";
                }
            }
        }
    }
}
