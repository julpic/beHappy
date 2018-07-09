package modules.gestionStock.dbEntities;

import modules.gestionStock.modelEntities.UnidadMedida;

import javax.persistence.*;

@Entity
@Table(name = "UnidadesMedida", schema = "BeFruit")
public class UnidadMedidaDB {
    private int idUnidad;
    private String nombre;

    public UnidadMedidaDB() {
    }

    public UnidadMedidaDB(UnidadMedida um, int id) {
        this.nombre = um.getNombre();
        this.idUnidad = id;
    }

    @Id
    @Column(name = "idUnidad")
    public int getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(int idUnidad) {
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

    public UnidadMedida createUnidadMedida() {
        UnidadMedida um = new UnidadMedida();
        um.setNombre(this.nombre);
        return um;
    }

}
