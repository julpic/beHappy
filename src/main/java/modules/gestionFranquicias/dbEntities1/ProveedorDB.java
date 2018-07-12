package modules.gestionFranquicias.dbEntities1;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Proveedores", schema = "BeFruit", catalog = "")
public class ProveedorDB {
    private int idProveedor;
    private int cuit;
    private String razonSocial;
    private String eMail;
    private Integer telefonoContacto;
    private Byte alta;

    @Id
    @Column(name = "idProveedor")
    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Basic
    @Column(name = "CUIT")
    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
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
    public Integer getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(Integer telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    @Basic
    @Column(name = "alta")
    public Byte getAlta() {
        return alta;
    }

    public void setAlta(Byte alta) {
        this.alta = alta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProveedorDB that = (ProveedorDB) o;
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
