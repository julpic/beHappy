package modules.gestionFranquicias.modelEntities;

import modules.gestionFranquicias.dbEntities.Franquicia;

import java.util.List;

public class FranquiciaModel {
    private int idFranquicia;
    private String cuit;
    private String direccion;
    private String nombreDueno;
    private String eMailDueno;
    private String apellidoDueno;
    private boolean alta;
    private List<EmpleadoModel> empleados;

    public FranquiciaModel(Franquicia f, List<EmpleadoModel> empleados) {
        this.idFranquicia = f.getIdFranquicia();
        this.cuit = f.getCuit();
        this.direccion = f.getDireccion();
        this.nombreDueno = f.getNombreDueno();
        this.eMailDueno = f.geteMailDueno();
        this.apellidoDueno = f.getApellidoDueno();
        this.alta = f.getAlta();
        this.empleados = empleados;
    }

    public int getIdFranquicia() {
        return idFranquicia;
    }

    public Franquicia getDBEntity(){
        Franquicia f = new Franquicia();
        f.setIdFranquicia(this.idFranquicia);
        f.setCuit(this.cuit);
        f.setDireccion(this.direccion);
        f.setNombreDueno(this.nombreDueno);
        f.seteMailDueno(this.eMailDueno);
        f.setApellidoDueno(this.apellidoDueno);
        f.setAlta(this.alta);

        return f;
    }
}
