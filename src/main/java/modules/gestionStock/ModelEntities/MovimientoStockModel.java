package modules.gestionStock.ModelEntities;

import modules.gestionStock.dbEntities.MovimientoStock;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class MovimientoStockModel {
    private int idMovimientoStock;
    private Integer idVenta;
    private Integer idTurno;
    private Date fechaHora;
    private Date fechaHoraAnulacion;
    private boolean entrada;
    private List<DetalleMovimientoStockModel> detalles;

    public MovimientoStockModel(MovimientoStock ms, List<DetalleMovimientoStockModel> detalles) {
        this.idMovimientoStock = ms.getIdMovimientoStock();
        this.idVenta = ms.getIdVenta();
        this.idTurno = ms.getIdTurno();
        Date date = new Date(ms.getFechaHora().getTime());
        this.fechaHora = date;
        Date date2 = new Date(ms.getFechaHoraAnulacion().getTime());
        this.fechaHoraAnulacion = date2;
        this.entrada = ms.isEntrada();
        this.detalles = detalles;
    }

    public int getIdMovimientoStock() {
        return idMovimientoStock;
    }

    public MovimientoStock getDBEntity(){
        MovimientoStock ms = new MovimientoStock();
        ms.setIdMovimientoStock(this.idMovimientoStock);
        ms.setIdTurno(this.idTurno);
        ms.setIdVenta(this.idVenta);
        Timestamp timestamp = new Timestamp(this.fechaHora.getTime());
        ms.setFechaHora(timestamp);
        Timestamp timestamp2 = new Timestamp(this.fechaHoraAnulacion.getTime());
        ms.setFechaHoraAnulacion(timestamp2);
        ms.setEntrada(this.entrada);
        return ms;
    }
}
