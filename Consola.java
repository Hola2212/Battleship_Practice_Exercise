import java.io.PrintStream;
import java.util.Scanner;
public class Consola{
    private final PrintStream Imp;
    private final Scanner sc;
    public Consola(){
        this.Imp = System.out;
        this.sc = new Scanner(System.in);
    }
    public void mostrarBienvenida(int n, int barcos, int disparosMaximos){
        Imp.println("==== 💣𓊝💣 Battleship 💣𓊝💣 ====");
        Imp.printf("Tablero %d X %d.\n",n,n);
        Imp.println("Filas A-"+(char)('A' + (n-1)) + " y columnas 1-" + n + ".");
        Imp.printf("Hay %d barcos ocultos con tamaño 1.\n",barcos);
        Imp.println("Comandos\n\t Coordenadas (B3)\n\tREVELAR para mostrar el tablero\n\tSALIR para reiniciar el juego.");
    }
    public void imprimirTablero(Tablero t){
        int n = t.getDimensiones();
        Imp.print("  ");
        for (int c = 1; c <= n; c++){
            Imp.print(c+" ");
        }
        Imp.println("");
        for (int r = 0; r < n; r++) {
            Imp.print((char)('A' + r) + " ");
            for (int c = 0; c < n; c++) {
                Imp.print(t.getCelda(r, c) + " ");
            }
            Imp.println("");
        }
    }
    public void mostrarMensajeJuego(){
        Imp.println("Comandos\n\tCoordenadas (B3)\n\tREVELAR para mostrar el tablero\n\tSALIR para reiniciar el juego.");
    }
}