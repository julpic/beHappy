package modules.gestionUsuarios.modelEntities;

import modules.gestionUsuarios.dbEntities.Perfil;

public class PerfilModel {
    private long idPerfil;
    private String nombre;

    public PerfilModel(Perfil p) {
        this.idPerfil = p.getIdPerfil();
        this.nombre = p.getNombre();
    }

    public Perfil getDBEntity() {
        Perfil p = new Perfil();
        p.setIdPerfil(this.idPerfil);
        p.setNombre(this.nombre);
        return p;
    }

    public String getNombre() {
        return nombre;
    }
}
