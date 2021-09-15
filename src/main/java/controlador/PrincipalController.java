
package controlador;

import vista.*;

public class PrincipalController {
       public static VistaPrincipal ventana = new VistaPrincipal();
       public static void mostrar(){ventana.setVisible(true);}
       public static void ocultar(){ventana.setVisible(false);}
       public static void Salir(){
           ventana.setVisible(false);
       }
       
       public static void eventoBoton1(){
           ocultar();
           Comercialcontroller.mostrar();    
       }
       public static void eventoBoton2(){
           ocultar();
           RepartidorController.mostrar();    
       }
       //public void agregarComercial(Comercial comercial){
           
}

