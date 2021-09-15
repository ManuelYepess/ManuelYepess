package controlador;

import static controlador.Comercialcontroller.comercial;
import static controlador.Comercialcontroller.ventana;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.*;
import vista.*;

public class RepartidorController {
    
     private static void guardarArchivo(File archivo) throws IOException {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try{
            fichero = new FileWriter(archivo);
            pw = new PrintWriter(fichero);
            String linea = comercial.toString();
            pw.println(linea);
        }catch(Exception ex){
            ex.printStackTrace();
            
        }finally{
            try{
                if(fichero!=null){
                    fichero.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
       static VistaRepartidor  repartidor =  new VistaRepartidor();
       public static VistaRepartidor ventana = new VistaRepartidor();
       public static void mostrar(){ventana.setVisible(true);}
       public static void ocultar(){ventana.setVisible(false);}
       
       public static void eventoBotonAdd() throws IOException {
        String nombreRepartidor = ventana.getNombrerTextField().getText();
        String Zona = ventana.getZonarTextField().getText();
        double salarioRepartidor = Double.parseDouble(ventana.getSalariorTextField().getText());
        int edadRepartidor = Integer.parseInt(ventana.getEdadrTextField().getText());
        Repartidor repartidor = new Repartidor(Zona ,nombreRepartidor,edadRepartidor,salarioRepartidor);
        repartidor.Bono();
        JFileChooser seleccionarArchivos = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos CSV","csv");
        seleccionarArchivos.setFileFilter(filtro);
        
        int seleccionar = seleccionarArchivos.showOpenDialog(ventana);
        
        if(seleccionar == JFileChooser.APPROVE_OPTION){
            File archivo = seleccionarArchivos.getSelectedFile();
                guardarArchivo(archivo);
        }
        System.out.println(repartidor.toString());
    }
}
