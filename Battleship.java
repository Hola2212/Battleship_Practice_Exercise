
import java.util.ArrayList;

public class Battleship{
    private final Consola consolita;
    private final int n;
    private final int barcos;
    private final int disparosMaximos;
    private final Tablero tablerito;
    private ArrayList<String> comandosDisponibles = new ArrayList<>();
    public Battleship(){
        this.consolita = new Consola();
        this.n = 5;
        this.barcos = 4;
        this.disparosMaximos = 20;
        this.tablerito = new Tablero(barcos, n);
        for (int i = 0; i < n; i++) {
            for (int e = 1; e <= n; e++) {
                comandosDisponibles.add(String.valueOf((char)('A'+i)) + Integer.toString(e));
            }
        }
        comandosDisponibles.add("REVELAR");
        comandosDisponibles.add("SALIR");
    }
    public void jugar(){
        consolita.mostrarBienvenida(n, barcos, disparosMaximos);
        consolita.imprimirTablero(tablerito);

    }
}