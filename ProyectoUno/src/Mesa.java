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
    public void mostrarPrimera(){
        System.out.println("La carta que esta en la mesa es:");
        System.out.println(mazoMesa.getFirst().numeroCarta);
        System.out.println(mazoMesa.getFirst().color);
    }
}