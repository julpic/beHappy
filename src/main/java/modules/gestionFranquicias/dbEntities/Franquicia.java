package modules.gestionFranquicias.dbEntities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Franquicias", schema = "BeFruit", catalog = "")

public class Franquicia {
    private long idFranquicia;
    private String cuit;
    private String direccion;
    private String nombreDueno;
    private String eMailDueno;
    private String apellidoDueno;
    private boolean alta;

    @Id
    @Column(name = "idFranquicia")
    public long getIdFranquicia() {
        return idFranquicia;
    }

    public void setIdFranquicia(long idFranquicia) {
        this.idFranquicia = idFranquicia;
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
        Franquicia that = (Franquicia) o;
        return idFranquicia == that.idFranquicia &&
                cuit == that.cuit &&
                alta == that.alta &&
                Objects.equals(direccion, that.direccion) &&
                Objects.equals(nombreDueno, that.nombreDueno) &&
                Objects.equals(eMailDueno, that.eMailDueno) &&
                Objects.equals(apellidoDueno, that.apellidoDueno);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idFranquicia, cuit, direccion, nombreDueno, eMailDueno, apellidoDueno, alta);
    }

    public void darDeBaja() {
        this.alta = false;
    }
}
