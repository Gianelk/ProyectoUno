public class Carta {
    String numeroCarta;
    String color;

    public Carta(String numeroCarta, String color) {
        this.numeroCarta = numeroCarta;
        this.color = color;
    }

    public Carta() {
    }

    public String getNumeroCarta() {
        return numeroCarta;
    }

    public void setNumeroCarta(String numeroCarta) {
        this.numeroCarta = numeroCarta;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
