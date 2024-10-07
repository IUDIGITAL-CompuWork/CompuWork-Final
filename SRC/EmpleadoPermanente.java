import javax.swing.JTextArea;

public class EmpleadoPermanente extends Empleado {
    private String beneficios;
    private double salarioBase;

    public EmpleadoPermanente(int id, String nombre, int edad, String sexo, String fechaContratacion, String beneficios, double salarioBase) {
        super(id, nombre, edad, sexo, fechaContratacion);
        this.beneficios = beneficios;
        this.salarioBase = salarioBase;
    }

    @Override
    public void mostrarDetalles(JTextArea displayArea) {
        displayArea.append("Empleado Permanente - ID: " + getId() +
                ", Nombre: " + getNombre() +
                ", Edad: " + getEdad() +
                ", Sexo: " + getSexo() +
                ", Fecha de Contratación: " + getFechaContratacion() +
                ", Beneficios: " + beneficios +
                ", Salario Base: " + salarioBase + "\n");
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
}
