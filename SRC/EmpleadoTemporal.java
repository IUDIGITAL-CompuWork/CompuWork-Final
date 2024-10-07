import javax.swing.JTextArea;

public class EmpleadoTemporal {
    private String fechaFinalContrato;
    private double tasaPorHora;

    public EmpleadoTemporal(int id, String nombre, int edad, String sexo, String fechaContratacion, String fechaFinalContrato, double tasaPorHora) {
        super(id, nombre, edad, sexo, fechaContratacion);
        this.fechaFinalContrato = fechaFinalContrato;
        this.tasaPorHora = tasaPorHora;
    }

    @Override
    public void mostrarDetalles(JTextArea displayArea) {
        displayArea.append("Empleado Temporal - ID: " + getId() +
                ", Nombre: " + getNombre() +
                ", Edad: " + getEdad() +
                ", Sexo: " + getSexo() +
                ", Fecha de Contratación: " + getFechaContratacion() +
                ", Fecha Final de Contrato: " + fechaFinalContrato +
                ", Tasa por Hora: " + tasaPorHora + "\n");
    }

    public String getFechaFinalContrato() {
        return fechaFinalContrato;
    }

    public void setFechaFinalContrato(String fechaFinalContrato) {
        this.fechaFinalContrato = fechaFinalContrato;
    }

    public double getTasaPorHora() {
        return tasaPorHora;
    }

    public void setTasaPorHora(double tasaPorHora) {
        this.tasaPorHora = tasaPorHora;
    }
}
