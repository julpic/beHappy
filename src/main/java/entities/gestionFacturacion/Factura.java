package entities.gestionFacturacion;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "Facturas", schema = "BeFruit", catalog = "")
@IdClass(FacturaPK.class)
public class Factura {
    private int idTipoFactura;
    private int idNumericoSucursal;
    private int idNumericoFactura;
    private Timestamp fechaHora;
    private BigDecimal montoTotal;
    private String eMailCliente;
    private String razonSocialCliente;

    @Id
    @Column(name = "idTipoFactura")
    public int getIdTipoFactura() {
        return idTipoFactura;
    }

    public void setIdTipoFactura(int idTipoFactura) {
        this.idTipoFactura = idTipoFactura;
    }

    @Id
    @Column(name = "idNumericoSucursal")
    public int getIdNumericoSucursal() {
        return idNumericoSucursal;
    }

    public void setIdNumericoSucursal(int idNumericoSucursal) {
        this.idNumericoSucursal = idNumericoSucursal;
    }

    @Id
    @Column(name = "idNumericoFactura")
    public int getIdNumericoFactura() {
        return idNumericoFactura;
    }

    public void setIdNumericoFactura(int idNumericoFactura) {
        this.idNumericoFactura = idNumericoFactura;
    }

    @Basic
    @Column(name = "fechaHora")
    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Basic
    @Column(name = "montoTotal")
    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }

    @Basic
    @Column(name = "eMailCliente")
    public String geteMailCliente() {
        return eMailCliente;
    }

    public void seteMailCliente(String eMailCliente) {
        this.eMailCliente = eMailCliente;
    }

    @Basic
    @Column(name = "razonSocialCliente")
    public String getRazonSocialCliente() {
        return razonSocialCliente;
    }

    public void setRazonSocialCliente(String razonSocialCliente) {
        this.razonSocialCliente = razonSocialCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Factura factura = (Factura) o;

        if (idTipoFactura != factura.idTipoFactura) return false;
        if (idNumericoSucursal != factura.idNumericoSucursal) return false;
        if (idNumericoFactura != factura.idNumericoFactura) return false;
        if (fechaHora != null ? !fechaHora.equals(factura.fechaHora) : factura.fechaHora != null) return false;
        if (montoTotal != null ? !montoTotal.equals(factura.montoTotal) : factura.montoTotal != null) return false;
        if (eMailCliente != null ? !eMailCliente.equals(factura.eMailCliente) : factura.eMailCliente != null)
            return false;
        if (razonSocialCliente != null ? !razonSocialCliente.equals(factura.razonSocialCliente) : factura.razonSocialCliente != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTipoFactura;
        result = 31 * result + idNumericoSucursal;
        result = 31 * result + idNumericoFactura;
        result = 31 * result + (fechaHora != null ? fechaHora.hashCode() : 0);
        result = 31 * result + (montoTotal != null ? montoTotal.hashCode() : 0);
        result = 31 * result + (eMailCliente != null ? eMailCliente.hashCode() : 0);
        result = 31 * result + (razonSocialCliente != null ? razonSocialCliente.hashCode() : 0);
        return result;
    }
}
