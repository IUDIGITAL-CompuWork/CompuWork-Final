import java.util.Date;

public class ReporteDesempeio {
    private Date fechaGeneracion;
    private int puntaje;
    private String observaciones;
    private Empleado empleado;
    private Departamento departamento;

    public ReporteDesempeio(Date fechaGeneracion, int puntaje, String observaciones, Empleado empleado, Departamento departamento) {
        this.fechaGeneracion = fechaGeneracion;
        this.puntaje = puntaje;
        this.observaciones = observaciones;
        this.empleado = empleado;
        this.departamento = departamento;
    }

    ReporteDesempeio(Date date, int puntaje, String observaciones, Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Departamento getDepartamento() {
        return departamento;
    }
}
