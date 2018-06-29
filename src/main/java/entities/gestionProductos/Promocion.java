package entities.gestionProductos;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "Promociones", schema = "BeFruit", catalog = "")
public class Promocion {
    private int idPromocion;
    private int activo;
    private Timestamp fechaVigencia;
    private BigDecimal porcentajeDescuento;
    private String requisito;

    @Id
    @Column(name = "idPromocion")
    public int getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
    }

    @Basic
    @Column(name = "activo")
    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    @Basic
    @Column(name = "fechaVigencia")
    public Timestamp getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(Timestamp fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    @Basic
    @Column(name = "porcentajeDescuento")
    public BigDecimal getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(BigDecimal porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Basic
    @Column(name = "requisito")
    public String getRequisito() {
        return requisito;
    }

    public void setRequisito(String requisito) {
        this.requisito = requisito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Promocion promocion = (Promocion) o;

        if (idPromocion != promocion.idPromocion) return false;
        if (activo != promocion.activo) return false;
        if (fechaVigencia != null ? !fechaVigencia.equals(promocion.fechaVigencia) : promocion.fechaVigencia != null)
            return false;
        if (porcentajeDescuento != null ? !porcentajeDescuento.equals(promocion.porcentajeDescuento) : promocion.porcentajeDescuento != null)
            return false;
        if (requisito != null ? !requisito.equals(promocion.requisito) : promocion.requisito != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPromocion;
        result = 31 * result + activo;
        result = 31 * result + (fechaVigencia != null ? fechaVigencia.hashCode() : 0);
        result = 31 * result + (porcentajeDescuento != null ? porcentajeDescuento.hashCode() : 0);
        result = 31 * result + (requisito != null ? requisito.hashCode() : 0);
        return result;
    }
}
