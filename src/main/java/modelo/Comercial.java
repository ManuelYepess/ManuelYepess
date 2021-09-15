package modelo;

import javax.swing.JOptionPane;

public class Comercial extends Empleado {
	
	private double comision;

    public Comercial(double comision, String nombre, int edad, double salario) {
        super(nombre, edad, salario);
        this.comision = comision;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    @Override
    public String toString() {
        System.out.println(super.toString());
        return "," + comision;
    }

    @Override
    public boolean Bono() {
        //si tiene más de 30 años y cobra una comisión de más de 400000 mil pesos
        if (super.getEdad() > 30 && this.comision > 400000) { //la palabra super hace referencia a la super clase
            double nuevoSalario = super.getSalario() + super.Bonificacion;
            super.setSalario(nuevoSalario);
            JOptionPane.showMessageDialog(null, super.getNombre()+ " Se ha añadido la Bonificaion al empleado");
            System.out.println("\nSe ha añadido la Bonificacion al empleado " + super.getNombre());
            return true;
        } else {
            JOptionPane.showMessageDialog(null, super.getNombre()+ " No cumple los requisito para la Bonificaion");
            System.out.println("\nEl empleado no cumple con los requisitos para la Bonificacion . ");
            return false;
        }
    }


	
	
	
	
}
