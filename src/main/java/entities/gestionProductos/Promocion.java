package entities.gestionProductos;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Promociones", schema = "BeFruit", catalog = "")
public class Promocion {
    private int idPromocion;
    private int activo;
    private Timestamp fechaVigencia;
    private BigInteger porcentajeDescuento;
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
    public BigInteger getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(BigInteger porcentajeDescuento) {
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
        return idPromocion == promocion.idPromocion &&
                activo == promocion.activo &&
                Objects.equals(fechaVigencia, promocion.fechaVigencia) &&
                Objects.equals(porcentajeDescuento, promocion.porcentajeDescuento) &&
                Objects.equals(requisito, promocion.requisito);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idPromocion, activo, fechaVigencia, porcentajeDescuento, requisito);
    }
}
