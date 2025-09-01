public class Celda{
    private boolean barcoEnCelda;
    private boolean yaDisparada;
    public Celda(){
        yaDisparada = false;
        barcoEnCelda = false;
    }
    
    public boolean  anadirBarco(){
        if (barcoEnCelda){ 
            return false;
        }
        else{
            barcoEnCelda = true;
            return true;
        }
    } 
    public boolean disparar(){
        if (yaDisparada){
            return false;
        }
        else{
            yaDisparada = true;
            return true;
        }
    }
    public boolean hundirBarco(){
        return barcoEnCelda;
    }
    public String toString(){
        if (!this.yaDisparada){
            return ".";
        } else {
            return this.barcoEnCelda ? "X" : "O";
        }
    }
}