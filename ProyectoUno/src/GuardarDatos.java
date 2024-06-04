import java.util.LinkedList;
public class GuardarDatos {
    private LinkedList<Carta> barajaJugador;
    private LinkedList<Carta> barajaBot;
    private LinkedList<Carta> mazoMesa;
    private LinkedList<Carta> mazo;
    private String nombreJugador;

    public LinkedList<Carta> getBarajaJugador() {
        return barajaJugador;
    }

    public void setBarajaJugador(LinkedList<Carta> barajaJugador) {
        this.barajaJugador = barajaJugador;
    }

    public LinkedList<Carta> getBarajaBot() {
        return barajaBot;
    }

    public void setBarajaBot(LinkedList<Carta> barajaBot) {
        this.barajaBot = barajaBot;
    }

    public LinkedList<Carta> getMazoMesa() {
        return mazoMesa;
    }

    public void setMazoMesa(LinkedList<Carta> mazoMesa) {
        this.mazoMesa = mazoMesa;
    }

    public LinkedList<Carta> getMazo() {
        return mazo;
    }

    public void setMazo(LinkedList<Carta> mazo) {
        this.mazo = mazo;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }
    public String toString() {
        return "Datos{" +
                "barajaJugador=" + barajaJugador +
                ", barajaBot=" + barajaBot +
                ", mazoMesa=" + mazoMesa +
                ", mazo=" + mazo +
                ", nombre='" + nombreJugador + '\'' +
                '}';
    }
}
