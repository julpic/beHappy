package entities.gestionFranquicia;

import javax.persistence.*;

@Entity
@Table(name = "Franquicias", schema = "BeFruit", catalog = "")
public class Franquicia {
    private int idFranquicia;
    private int cuit;
    private String direccion;
    private String nombreDueno;
    private String eMailDueno;
    private String apellidoDueno;

    @Id
    @Column(name = "idFranquicia")
    public int getIdFranquicia() {
        return idFranquicia;
    }

    public void setIdFranquicia(int idFranquicia) {
        this.idFranquicia = idFranquicia;
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
    @Column(name = "direccion")
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "nombreDueno")
    public String getNombreDueno() {
        return nombreDueno;
    }

    public void setNombreDueno(String nombreDueno) {
        this.nombreDueno = nombreDueno;
    }

    @Basic
    @Column(name = "eMailDueno")
    public String geteMailDueno() {
        return eMailDueno;
    }

    public void seteMailDueno(String eMailDueno) {
        this.eMailDueno = eMailDueno;
    }

    @Basic
    @Column(name = "apellidoDueno")
    public String getApellidoDueno() {
        return apellidoDueno;
    }

    public void setApellidoDueno(String apellidoDueno) {
        this.apellidoDueno = apellidoDueno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Franquicia that = (Franquicia) o;

        if (idFranquicia != that.idFranquicia) return false;
        if (cuit != that.cuit) return false;
        if (direccion != null ? !direccion.equals(that.direccion) : that.direccion != null) return false;
        if (nombreDueno != null ? !nombreDueno.equals(that.nombreDueno) : that.nombreDueno != null) return false;
        if (eMailDueno != null ? !eMailDueno.equals(that.eMailDueno) : that.eMailDueno != null) return false;
        if (apellidoDueno != null ? !apellidoDueno.equals(that.apellidoDueno) : that.apellidoDueno != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFranquicia;
        result = 31 * result + cuit;
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        result = 31 * result + (nombreDueno != null ? nombreDueno.hashCode() : 0);
        result = 31 * result + (eMailDueno != null ? eMailDueno.hashCode() : 0);
        result = 31 * result + (apellidoDueno != null ? apellidoDueno.hashCode() : 0);
        return result;
    }
}
