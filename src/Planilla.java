import java.util.ArrayList;
public class Planilla {
    private ArrayList <Integer> salieron;
    private Bolillero bolillas;
    private ArrayList <Carton> cartones;

    //Constructor
    public Planilla(Bolillero bolillas){
        this.bolillas = bolillas;
        this.salieron = new ArrayList<>();
        this.cartones = new ArrayList<>();
    }

    //Set del ArrayList salieron
    public void setSalieron(ArrayList<Integer> salieron) {
        this.salieron = salieron;
    }

    //Agregar al ArrayList salieron el numero salido del bolillero
    public void agregarNumeroSalido(){
        try {
            int numero = bolillas.getBolillas();
            salieron.add(numero);
            System.out.println("Bolilla número: "+numero);
            VerificarSalido(numero);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    //Método para imprimir los números que han salido
    public void imprimirSalieron(){
        System.out.println("Han salido los números: "+salieron);
    }

    // Método para marcar los números en los cartones
    public void VerificarSalido(int numero) {
        for (Carton carton : cartones) {
            carton.marcarNumero(numero);
        }
    }

    // Método para imprimir los números marcados en los cartones
    public void mostrarMarcados() {
        for (Carton carton : cartones) {
            carton.imprimirMarcados();
        }
    }

    //Método para establecer la lista de cartones
    public void setCartones(ArrayList<Carton> cartones) {
        this.cartones = cartones;
    }

    // Método para verificar si algún cartón está lleno
    public boolean hayCartonLleno() {
        for (Carton carton : cartones) {
            if (carton.cartonLleno()) {
                return true;
            }
        }
        return false;
    }

    //Método alerta falta uno
    public void SoloFaltaUno(){
        for(Carton carton : cartones){
            if(carton.faltaUno()){
                System.out.println("El cartón " + carton.getIdCarton()  + " está a un número de completarse!");
            }
        }
    }
}