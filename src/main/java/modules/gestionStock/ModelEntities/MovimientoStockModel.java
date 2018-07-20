package modules.gestionStock.ModelEntities;

import modules.gestionStock.dbEntities.MovimientoStock;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovimientoStockModel {
    private long idMovimientoStock;
    private Long idVenta;
    private Long idTurno;
    private Date fechaHora;
    private Date fechaHoraAnulacion;
    private Boolean entrada;
    private List<DetalleMovimientoStockModel> detalles;

    public MovimientoStockModel(MovimientoStock ms) {
        this.idMovimientoStock = ms.getIdMovimientoStock();

        if (ms.getIdVenta() != null){
            this.idVenta = ms.getIdVenta();
        }

        if (ms.getIdTurno() != null){
            this.idTurno = ms.getIdTurno();
        }

        if (ms.getFechaHoraAnulacion() != null){
            Date date2 = new Date(ms.getFechaHoraAnulacion().getTime());
            this.fechaHoraAnulacion = date2;
        }

        Date date = new Date(ms.getFechaHora().getTime());
        this.fechaHora = date;

        this.entrada = ms.isEntrada();
    }

    public long getIdMovimientoStock() {
        return idMovimientoStock;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setDetalles(List<DetalleMovimientoStockModel> detalles) {
        this.detalles = detalles;
    }

    public Boolean getEntrada() { return entrada; }

    public MovimientoStock getDBEntity(){
        MovimientoStock ms = new MovimientoStock();
        ms.setIdMovimientoStock(this.idMovimientoStock);

        if (idTurno > 0){
            ms.setIdTurno(this.idTurno);
        }else{
            ms.setIdTurno(null);
        }

        if (idVenta > 0){
            ms.setIdVenta(this.idVenta);
        }else{
            ms.setIdVenta(null);
        }

        if (fechaHora!= null){
            Timestamp timestamp = new Timestamp(this.fechaHora.getTime());
            ms.setFechaHora(timestamp);
        }

        if (fechaHoraAnulacion != null){
            Timestamp timestamp2 = new Timestamp(this.fechaHoraAnulacion.getTime());
            ms.setFechaHoraAnulacion(timestamp2);
        }else{
            ms.setFechaHoraAnulacion(null);
        }

            ms.setEntrada(this.entrada);

        return ms;
    }
}
