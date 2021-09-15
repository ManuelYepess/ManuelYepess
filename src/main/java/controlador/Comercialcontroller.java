package controlador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.Comercial;
import modelo.Empleado;
import vista.VistaComercial;

public class Comercialcontroller {

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

 
    LinkedList<Empleado> empleados = new LinkedList<>();
    
    
    static VistaComercial  comercial =  new VistaComercial();
    
       public static VistaComercial ventana = new VistaComercial();
       public static void mostrar(){ventana.setVisible(true);}
       public static void ocultar(){ventana.setVisible(false);}

       
    public static void eventoBotonadd() throws IOException {
        
        String nombreComercial = ventana.getNombreTextField().getText();
        double salarioComercial = Double.parseDouble(ventana.getSalarioTextField().getText());
        double comision = Double.parseDouble(ventana.getComisionTextField().getText());
        int edadComercial = Integer.parseInt(ventana.getEdadTextField().getText());
        Comercial comercial = new Comercial(comision,nombreComercial,edadComercial,salarioComercial);
        comercial.Bono();
       
        JFileChooser seleccionarArchivos = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos CSV","csv");
        seleccionarArchivos.setFileFilter(filtro);
        
        int seleccionar = seleccionarArchivos.showOpenDialog(ventana);
        
        if(seleccionar == JFileChooser.APPROVE_OPTION){
            File archivo = seleccionarArchivos.getSelectedFile();
                guardarArchivo(archivo);
        }
        
        
      
        
        
        System.out.println(comercial.toString());
    }
      
       
}
