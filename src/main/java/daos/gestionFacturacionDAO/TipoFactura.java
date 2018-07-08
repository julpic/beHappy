package entities.gestionFacturacion;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

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
        return idTipo == that.idTipo &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(letra, that.letra);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idTipo, nombre, letra);
    }
}
