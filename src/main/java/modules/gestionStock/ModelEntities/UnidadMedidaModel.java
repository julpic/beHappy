package modules.gestionStock.ModelEntities;

import modules.gestionStock.dbEntities.UnidadMedida;

public class UnidadMedidaModel {
    private long idUnidad;
    private String nombre;

    public UnidadMedidaModel(UnidadMedida um) {
        this.idUnidad = um.getIdUnidad();
        this.nombre = um.getNombre();
    }

    public long getIdUnidad() {
        return idUnidad;
    }

    public UnidadMedida getDBEntity(){
        UnidadMedida um = new UnidadMedida();
        um.setIdUnidad(this.idUnidad);
        um.setNombre(this.nombre);
        return um;
    }
}
