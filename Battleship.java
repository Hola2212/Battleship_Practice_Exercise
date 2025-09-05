
import java.util.ArrayList;

public class Battleship{
    private final Consola consolita;
    private final int n;
    private final int barcos;
    private final int disparosMaximos;
    private Tablero tablerito;
    private int realizados;
    private ArrayList<String> comandosDisponibles = new ArrayList<>();
    public Battleship(){
        this.consolita = new Consola();
        this.n = 5;
        comandosDisponibles.clear();
        this.barcos = 4;
        this.disparosMaximos = 20;
        this.realizados = 0;
        this.tablerito = new Tablero(barcos, n);
        for (int i = 1; i < n+1; i++) {
            for (int e = 1; e <= n+1; e++) {
                comandosDisponibles.add(String.valueOf((char)('A'+i)) + Integer.toString(e));
            }
        }
        comandosDisponibles.add("REVELAR");
        comandosDisponibles.add("SALIR");
    }
    public void reiniciar(){
        comandosDisponibles.clear();
        this.realizados = 0;
        this.tablerito = new Tablero(barcos, n);
    }
    public void jugar(){
        consolita.mostrarBienvenida(n, barcos, disparosMaximos);
        consolita.imprimirTablero(tablerito);
    }
    public void turno(){
        String respuesta = consolita.turnoJuego(tablerito, disparosMaximos, realizados);
        if (comandosDisponibles.contains(respuesta)){
            switch (respuesta) {
                case "REVELAR" -> {
                    for (int i = 0; i < 5; i++) {
                        for (int e = 0; e < 5; e++) {
                            boolean disparado = tablerito.dipararBarco(i,e);
                        }
                    }
                    consolita.imprimirTablero(tablerito);
                    if(consolita.volverAJugar()){
                        reiniciar();
                    }
                }
                case "SALIR" -> {
                }
                default -> {
                    if (disparosMaximos == realizados){
                        consolita.mensajeLimiteDisparos();
                        consolita.imprimirTablero(tablerito);
                        if(consolita.volverAJugar()){
                            reiniciar();
                        }
                    }
                    else {
                        if(tablerito.getBarcosActivos() == 0){
                            consolita.mensajeVictoria();
                            consolita.imprimirTablero(tablerito);
                            if(consolita.volverAJugar()){
                                reiniciar();
                            }
                        }
                        else {
                            char coordenada1Letra = respuesta.charAt(0);
                            int coordenada2 = (int)(respuesta.charAt(1))-1;
                            int coordenada1 = Character.getNumericValue(coordenada1Letra) - Character.getNumericValue('A');
                            boolean hundido = tablerito.dipararBarco(coordenada1, coordenada2);
                            consolita.mensajeResultadoDisparo(hundido, tablerito.getBarcosActivos() ,barcos);
                            turno();
                        }
                    }
                }
            }
        }
    }
}