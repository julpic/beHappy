package daos.gestionStockDAO.services;

import entities.gestionStock.UnidadMedida;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "UnidadesMedida", schema = "BeFruit", catalog = "")
public class UnidadMedidaDAO {
    private int idUnidad;
    private String nombre;

    public UnidadMedidaDAO(UnidadMedida um, int id) {
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

    public UnidadMedida getUnidadMedida(){
        UnidadMedida um = new UnidadMedida();
        um.setNombre(this.nombre);
        return um;
    }

}
