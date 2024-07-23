import java.util.ArrayList;
import java.util.Random;

public class Bolillero {
    private ArrayList <Integer> bolillas;
    private Random aleatorio;


    public Bolillero(){
        //Constructor del Random llamado aleatorio
        aleatorio = new Random();
        //Llamo al método DefinirBolillas
        DefinirBolillas();
    }
    //Este método define un ArrayList llamado bolillas con numeros del 1 al 90 
    public void DefinirBolillas(){
        //Constructor del ArrayLIst
        bolillas = new ArrayList<>();
        for (int i=1;i<=90;i++){
            //coloco los numeros dentro del ArrayList
            bolillas.add(i);
        }
    }

    public int getBolillas() {
        if (bolillas.isEmpty()){
            //En caso de que se acaben las bolillas y salga una excepcion, imprimo:
            throw new IllegalStateException("Ya salieron todas las bolillas");
        }
        //Obtengo un indice aleatorio del ArrayList bolillas
        int i = aleatorio.nextInt(bolillas.size());
        //Obtengo el numero del indice y lo elimino del ArraList
        return bolillas.remove(i);
    }

}
