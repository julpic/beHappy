package modules.gestionStock.dbEntities;

import javax.persistence.*;

@Entity
@Table(name = "UnidadesMedida", schema = "BeFruit")
public class UnidadMedida {
    private long idUnidad;
    private String nombre;

    public UnidadMedida() {
    }

    @Id
    @Column(name = "idUnidad")
    public long getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(long idUnidad) {
        this.idUnidad = idUnidad;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
