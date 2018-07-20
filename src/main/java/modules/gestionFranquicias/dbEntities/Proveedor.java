package modules.gestionFranquicias.dbEntities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Proveedores", schema = "BeFruit", catalog = "")
public class Proveedor {
    private long idProveedor;
    private String cuit;
    private String razonSocial;
    private String eMail;
    private String telefonoContacto;
    private boolean alta;

    @Id
    @Column(name = "idProveedor")
    public long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(long idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Basic
    @Column(name = "CUIT")
    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    @Basic
    @Column(name = "razonSocial")
    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    @Basic
    @Column(name = "eMail")
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Basic
    @Column(name = "telefonoContacto")
    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    @Basic
    @Column(name = "alta")
    public boolean getAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proveedor that = (Proveedor) o;
        return idProveedor == that.idProveedor &&
                cuit == that.cuit &&
                Objects.equals(razonSocial, that.razonSocial) &&
                Objects.equals(eMail, that.eMail) &&
                Objects.equals(telefonoContacto, that.telefonoContacto) &&
                Objects.equals(alta, that.alta);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idProveedor, cuit, razonSocial, eMail, telefonoContacto, alta);
    }
}
