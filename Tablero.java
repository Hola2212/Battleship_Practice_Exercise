public class Tablero{
    public int maxBarcos;
    public int dimensiones;
    public Celda[][] casillas;
    public int barcosActivos;
    public Tablero(int maximoBarcos, int dimensiones){
        this.maxBarcos = maximoBarcos;
        this.dimensiones = dimensiones;
        this.casillas = new Celda[dimensiones][dimensiones];
        generarCasillas();
    }
    public void generarCasillas(){
        for (int i = 0; i < dimensiones; i++) {
            for (int e = 0; e < dimensiones; e++) {
                casillas[i][e] = new Celda();
            }
        }
    }
    public int getDimensiones(){
        return dimensiones;
    }
    public void generarBarcos(){
        int barcosColocados = 0;
        while (barcosColocados < maxBarcos){
            int coordenada1 = (int)((Math.random() * (dimensiones)));
            int coordenada2 = (int)((Math.random() * (dimensiones)));
            if (casillas[coordenada1][coordenada2].anadirBarco()) {
                barcosColocados = barcosColocados + 1;
            }
        }
        this.barcosActivos = maxBarcos;
    }
    public boolean dipararBarco(int coordenada1, int coordenada2){
        boolean hundido = casillas[coordenada1][coordenada2].disparar();
        if (hundido){
            barcosActivos = barcosActivos - 1;
        }
        return hundido;
    }
    public String getCelda(int r, int c){
        return casillas[r][c].toString();
    }
    public int getMaximoBarcos(){
        return maxBarcos;
    }
    public int getBarcosActivos(){
        return barcosActivos;
    }
}