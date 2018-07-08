package entities.gestionStock;


import java.util.Date;
import java.util.List;
import java.util.Objects;

public class MovimientoStock {
    private int idMovimientoStock;
    private Date fechaHora;
    private Date fehcaHoraAnulacion;
    private boolean entrada;
    private List<DetalleMovimientoStock> detalles;


    //Constructor

    public MovimientoStock() {
    }

    public MovimientoStock(int idMovimientoStock, Date fechaHora, boolean entrada) {
        this.idMovimientoStock = idMovimientoStock;
        this.fechaHora = fechaHora;
        this.entrada = entrada;
    }


    //Getters y Setters
    public int getIdMovimientoStock() {
        return idMovimientoStock;
    }

    public Date getFechaHora() { return fechaHora; }

    public Date getFehcaHoraAnulacion() { return fehcaHoraAnulacion; }

    public boolean isEntrada() { return entrada; }

    public void setIdMovimientoStock(int idMovimientoStock) {
        this.idMovimientoStock = idMovimientoStock;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setFehcaHoraAnulacion(Date fehcaHoraAnulacion) {
        this.fehcaHoraAnulacion = fehcaHoraAnulacion;
    }

    public void setDetalles(List<DetalleMovimientoStock> detalles) {
        this.detalles = detalles;
    }

    public void setEntrada(boolean entrada) { this.entrada = entrada; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovimientoStock that = (MovimientoStock) o;
        return idMovimientoStock == that.idMovimientoStock &&
                Objects.equals(fehcaHoraAnulacion, that.fehcaHoraAnulacion) &&
                Objects.equals(fechaHora, that.fechaHora) &&
                Objects.equals(entrada,this.entrada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMovimientoStock, fechaHora);
    }

    public void anular(){
        Date date = new Date();
        this.fehcaHoraAnulacion = date;
    }
}
