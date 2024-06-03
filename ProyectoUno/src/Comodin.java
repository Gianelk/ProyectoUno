import java.util.Scanner;

public class Comodin extends Carta{
    public Comodin(String numeroCarta, String color) {
        super(numeroCarta, color);
    }
    public void cambiaColor(Mesa mazoMesa){
        Scanner leer=new Scanner(System.in);
        System.out.println("Seleccione el color al que desea cambiar");
        System.out.println(" ");
        System.out.println("[0]" + "\033[31m" + "Rojo" + "\033[00m" + " [1]" + "\033[34m" + "Azul" + "\033[00m" + "\033[00m" + " [2]" + "\033[33m" + "Amarillo" + "\033[00m" + " [3]" + "\033[32m" + "Verde"+"\033[00m");
        int i = leer.nextInt();
        switch(i) {
            case 0:
                mazoMesa.setColorMesa("R");
                break;
            case 1:
                mazoMesa.setColorMesa("B");
                break;

            case 2:
                mazoMesa.setColorMesa("Y");
                break;
            case 3:
                mazoMesa.setColorMesa("G");
                break;
            default:
                throw new IllegalStateException("LOL: " + i);
        }
    }
}
