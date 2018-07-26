package modules.gestionUsuarios.controllers;

import modules.gestionFranquicias.modelEntities.EmpleadoModel;
import modules.gestionUsuarios.dbEntities.Sesion;
import modules.gestionUsuarios.ejb.SesionEJB;
import modules.gestionUsuarios.modelEntities.SesionModel;
import modules.gestionUsuarios.modelEntities.UsuarioModel;
import utilities.AuthParser;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.HttpHeaders;
import java.sql.Timestamp;

@Stateless
public class SesionController {
    @Inject
    SesionEJB sesionEJB;
    @Inject
    AuthParser authParser;
    @Inject
    UsuarioController usuarioController;

    public boolean haySesionIniciada() {
        Sesion tempSesion = sesionEJB.sesionIniciada();
        return tempSesion != null;
    }

    public long create(HttpHeaders header) {
        String[] loginInfo = authParser.
                parse(header.getRequestHeader("Authorization").get(0));
        if (usuarioController.inicioSesionValido(loginInfo[0], loginInfo[1])) {
            if (haySesionIniciada()) {
                return -1;
            } else {
                create(loginInfo[0]);
            }
        } return 0;
    }

    private void create(String s) {
        UsuarioModel u = usuarioController.find(s);
        Sesion temp = new Sesion();
        temp.setIdUsuario(u.getDBEntity().getIdUsuario());
        temp.setIdSesion(sesionEJB.buscarNuevoID());
        temp.setFechaHoraInicio(new Timestamp(System.currentTimeMillis()));
        sesionEJB.create(temp);
    }
    //Para creear una nueva sesion, el controller (no el EJB) tiene que vlaidar que no haya una sesion iniciada y validar que el usuario exista
}
