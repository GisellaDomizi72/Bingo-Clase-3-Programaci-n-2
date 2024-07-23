import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Carton {
    private ArrayList <Integer> carton;
    private ArrayList <Boolean> marcados;
    private Random random;
    private String id_carton;
    
    //Constructor
    public Carton(String id_carton){
        //Asigno el nombre al carton
        this.id_carton=id_carton;
        //Constructor del random llamado random
        random = new Random();
        //Inicializo el ArrayList carton
        carton=new ArrayList<>();
        //Constructor del ArrayList marcados
        marcados=new ArrayList<>(Collections.nCopies(15, false));
        //Llamo al método DefinirCarton()
        DefinirCarton();
        //Llamo al método OrdenarCarton()
        OrdenarCarton();
    }


    //Este método define un ArrayList llamado carton con 15 números no repetidos entre 1 y 90
    private void DefinirCarton(){
        Set<Integer> numerosUsados = new HashSet<>();
        while (carton.size() < 15) {
            int numero = random.nextInt(90) + 1; // Genera un número entre 1 y 90
            if (!numerosUsados.contains(numero)) {
                carton.add(numero); //Lo agrega al ArrayList carton
                numerosUsados.add(numero); //Lo agrega al ArrayList numerosUsados
            }
        }
    }

    //Método para ordenar los números del cartón de menor a mayor
    private void OrdenarCarton() {
        Collections.sort(carton);
    }

    //Método para obtener el ID del cartón
    public String getIdCarton() {
        return id_carton;
    }

    //Método para obtener los números del cartón
    public ArrayList<Integer> getCarton() {
        return carton;
    }

    //Método para imprimir el cartón
    public void imprimirCarton() {
        System.out.println("Cartón " + id_carton + ": " + carton);
    }

    //Método para verificar y marcar un número del carton
    public void marcarNumero(int numero){
        int index = carton.indexOf(numero);
        if (index != -1) {
            marcados.set(index, true);
        }
    }

    //Método para imprimir los números marcados
    public void imprimirMarcados() {
        System.out.println("Cartón " + id_carton + " (marcados): " + marcados);
    }
    
    //Verifico el carton lleno
    public boolean cartonLleno(){
        for (boolean marcado : marcados){
            if(!marcado) {
                return false;
            }
        }
        return true;
    }

    //Alerta falta uno para el carton lleno
    public boolean faltaUno(){
        int falta = 0;
        for(boolean marcado : marcados){
            if(!marcado){
                falta++;
            }
        }
        return falta == 1;
    }
}
