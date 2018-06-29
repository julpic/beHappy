package entities.gestionFranquicia;

import javax.persistence.*;

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

        if (idProveedor != proveedor.idProveedor) return false;
        if (cuit != proveedor.cuit) return false;
        if (razonSocial != null ? !razonSocial.equals(proveedor.razonSocial) : proveedor.razonSocial != null)
            return false;
        if (eMail != null ? !eMail.equals(proveedor.eMail) : proveedor.eMail != null) return false;
        if (telefonoContacto != null ? !telefonoContacto.equals(proveedor.telefonoContacto) : proveedor.telefonoContacto != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProveedor;
        result = 31 * result + cuit;
        result = 31 * result + (razonSocial != null ? razonSocial.hashCode() : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (telefonoContacto != null ? telefonoContacto.hashCode() : 0);
        return result;
    }
}
