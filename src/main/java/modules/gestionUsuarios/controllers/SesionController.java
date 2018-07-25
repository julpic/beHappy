package modules.gestionUsuarios.controllers;

import modules.gestionUsuarios.dbEntities.Sesion;
import modules.gestionUsuarios.ejb.SesionEJB;
import modules.gestionUsuarios.modelEntities.SesionModel;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class SesionController {
    @Inject
    SesionEJB sesionEJB;

    private boolean haySesionIniciada(){
        Sesion tempSesion = sesionEJB.sesionIniciada();
        return tempSesion != null;
    }

    public long create(SesionModel sesionModel) {
        if (haySesionIniciada()) return -1;
        Sesion s = sesionModel.getDBEntity();
        s.setIdSesion(sesionEJB.buscarNuevoID());
        sesionEJB.create(s);
        return s.getIdSesion();
    }
    //Para creear una nueva sesion, el controller (no el EJB) tiene que vlaidar que no haya una sesion iniciada y validar que el usuario exista
}
