import java.util.LinkedList;

public class Mesa extends LinkedList<Carta>{
    LinkedList<Carta> mazoMesa;

    private String colorMesa;

    public LinkedList<Carta> getMazoMesa() {
        return mazoMesa;
    }

    public void setMazoMesa(LinkedList<Carta> mazoMesa) {
        this.mazoMesa = mazoMesa;
    }

    public String getColorMesa() {
        return colorMesa;
    }

    public void setColorMesa(String colorMesa) {
        this.colorMesa = colorMesa;
    }

    public Mesa() {
        this.mazoMesa = new LinkedList<Carta>();
    }

    public Carta getPrimera() {
        return mazoMesa.getFirst();
    }

    public Comodin getComodin(){
        return (Comodin) mazoMesa.getFirst();
    }

    public Toma2 getToma2(){
        return (Toma2) mazoMesa.getFirst();
    }
    public Toma4 getToma4(){
        return (Toma4) mazoMesa.getFirst();
    }
    public void eliminarCarta(){
        mazoMesa.removeFirst();
    }

    public void iniciarMesa(Mazo mazo){
        Carta primera;
        int i =0;
        primera=mazo.getPrimeraMazo(i);
        while(primera.color == "negro") {
            i++;
            primera=mazo.getPrimeraMazo(i);
        }
        mazoMesa.add(primera);
        mazo.eliminarCarta(i);
    }
    public int  evaluarMesa(){
        if(this.colorMesa.equals("negro")){
            return 1;
        }
        else{
            return 0;
        }
    }

    public void agregarPrimero( Carta carta) {
        mazoMesa.add(0,carta);
        colorMesa= mazoMesa.get(0).color;
    }

    public void mostrarPrimera(){
        System.out.println();
        System.out.print("La carta que esta en la mesa es: ");
        System.out.print(mazoMesa.getFirst().numeroCarta);
        System.out.print(mazoMesa.getFirst().color);
        System.out.println(" ");
    }


}
