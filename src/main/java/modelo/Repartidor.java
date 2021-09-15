package modelo;

import javax.swing.JOptionPane;

public class Repartidor extends Empleado {
	
	private String Zona;

    public Repartidor(String zona, String nombre, int edad, double salario) {
        super(nombre, edad, salario);
        this.Zona = zona;
    }

    public String getZona() {
        return Zona;
    }

    public void setZona(String zona) {
        this.Zona = zona;
    }

    @Override
    public String toString() {
        System.out.println(super.toString());
        return "," + Zona;
    }

    @Override
    public boolean Bono() {
        //si tiene menos de 25 y reparte en la “zona 3”
        if (super.getEdad() < 25 && this.Zona.equalsIgnoreCase("zona 3")) {
            double nuevoSalario = super.getSalario() + super.Bonificacion;
            super.setSalario(nuevoSalario);
            JOptionPane.showMessageDialog(null, super.getNombre()+ " Se ha añadido la Bonificaion al empleado");
            System.out.println("\nSe ha añadido la Bonificacion al empleado " + super.getNombre());
            
            return true;
        } else {
            JOptionPane.showMessageDialog(null, super.getNombre()+ " No cumple los requisito para la Bonificaion");
            System.out.println("\nEl empleado no cumple con los requisitos para la Bonificacion");
            return false;
        }
    }
}
	
	

