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
    public void disparosMaxDisp(int max, int realizados){
        Imp.println("Este es el disparo"+ realizados + " de " + max + ".");
    }
    public void mostrarMensajeJuego(){
        Imp.println("Para continuar, por favor haga su selección.\nComandos\n\tCoordenadas (B3)\n\tREVELAR para mostrar el tablero\n\tSALIR para reiniciar el juego.");
    }
    public String turnoJuego(Tablero t, int max, int realizados){
        Imp.println("");
        disparosMaxDisp(max, realizados);
        imprimirTablero(t);
        mostrarMensajeJuego();
        String respuesta = "";
        while (respuesta == ""){
            respuesta = sc.nextLine();
        }
        return respuesta;
    }
    public void mensajeError(){
        Imp.println("El comando ingresado no esta dentro de los parámetros válidos.");
    }
    public boolean volverAJugar(){
        Imp.println("¿Desea volver a jugar? (Y/N)");
        String respuesta = "";
        while (respuesta != "Y" && respuesta != "N"){
            Imp.println("Debe escribir (Y) o (N).");
            respuesta = sc.nextLine();
        }
        if (respuesta == "Y") { return true;}
        else{ return false;}
    }
    public void mensajeSalida(){
        Imp.println("Gracias por haber jugado \\(◦'⌣'◦)/");
    }
    public void mensajeLimiteDisparos(){
        Imp.println("Has perdido ⊙﹏⊙.\nHa alcanzado el límite de disparos máximos.");
    }
}