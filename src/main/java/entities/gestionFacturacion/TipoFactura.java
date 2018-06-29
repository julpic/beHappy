package entities.gestionFacturacion;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TipoFactura {
    private int idTipo;
    private String nombre;
    private String letra;

    @Id
    @Column(name = "idTipo")
    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "letra")
    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoFactura that = (TipoFactura) o;

        if (idTipo != that.idTipo) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (letra != null ? !letra.equals(that.letra) : that.letra != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTipo;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (letra != null ? letra.hashCode() : 0);
        return result;
    }
}
