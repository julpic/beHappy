package entities.gestionFranquicia;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Proveedores", schema = "BeFruit", catalog = "")
public class Proveedor {
    private int idProveedor;
    private int cuit;
    private String razonSocial;
    private String eMail;
    private Integer telefonoContacto;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proveedor proveedor = (Proveedor) o;
        return idProveedor == proveedor.idProveedor &&
                cuit == proveedor.cuit &&
                Objects.equals(razonSocial, proveedor.razonSocial) &&
                Objects.equals(eMail, proveedor.eMail) &&
                Objects.equals(telefonoContacto, proveedor.telefonoContacto);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idProveedor, cuit, razonSocial, eMail, telefonoContacto);
    }
}
