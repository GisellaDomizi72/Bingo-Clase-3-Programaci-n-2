import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("\n\n                                 JUEGO BINGO");
        System.out.println("______________________________________________________________________________");
        System.out.println("                                    CARTONES");

        //Constructor creo un cartones
        Carton carton1 = new Carton("N_0001");
        Carton carton2 = new Carton("N_0002");
        Carton carton3 = new Carton ("N_0003");

        //Imprimo los cartones
        carton1.imprimirCarton();
        carton2.imprimirCarton();
        carton3.imprimirCarton();
        System.out.println("______________________________________________________________________________\n\n");

        //Lista de cartones
        ArrayList <Carton> cartones = new ArrayList<>();
        cartones.add(carton1);
        cartones.add(carton2);
        cartones.add(carton3);

        //Constructor Bolillero
        Bolillero unBolillero = new Bolillero();

        //Constructor Planilla
        Planilla laPlanilla = new Planilla(unBolillero);
        laPlanilla.setCartones(cartones);

        // Bucle para agregar números salidos hasta que haya un cartón lleno
        while (!laPlanilla.hayCartonLleno()) {
            laPlanilla.agregarNumeroSalido();
       
            //Imprimir números marcados en los cartones
            laPlanilla.mostrarMarcados();

            //Alerta de cartones a punto de llenarse
            laPlanilla.SoloFaltaUno();
        }


        // Imprimir mensaje de cartón lleno
        for (Carton carton : cartones) {
            if (carton.cartonLleno()) {
                System.out.println("\n\n");
                System.out.println("¡El cartón " + carton.getIdCarton() + " está lleno!");
            }
        }
  
        //La Planilla muestra todos los números que han salido 
        System.out.println("\n\n\n");
        laPlanilla.imprimirSalieron();
    }
}
